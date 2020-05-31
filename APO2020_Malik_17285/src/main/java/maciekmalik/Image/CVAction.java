/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image;

import maciekmalik.Image.NeighbOP.BlurAction;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Loader do biblioteki OpenCV
 * Powinien załadować odpowiednią biblioteke na podstawie wykrytego systemu
 * Pododuje tymczasowy jej zapis na dysk
 *
 * {@link} https://github.com/openpnp/opencv
 */
public abstract class CVAction extends BaseAction{


    protected Size size = new Size(5,5);
    protected Mat imageEditedMat = new Mat();
    protected Mat imageEditedMatCopy = new Mat();


    static {
        LOGGER.fine("Trying to load OCV lib");
        nu.pattern.OpenCV.loadLocally();
        System.out.println("OpenCV loaded: " + Core.VERSION);
    }


    /**
     * Ładowanie obrazu prze openCV
     *
     * @see Imgcodecs#imread(String)
     * @see Mat
     * @see Imgcodecs#imread(java.lang.String)
     * @param filename 
     * @return Mat
     * {@link} https://docs.opencv.org/3.2.0/d3/d63/classcv_1_1Mat.html#details
     */
    public static Mat loadImage(String filename){
        return Imgcodecs.imread(filename);
    }

    /**
     * Test działania/wczytania sie OpenCV
     * @see Mat
     */
    public static void testOCV(){
        Mat m = new Mat(5, 10, CvType.CV_8UC1, new Scalar(0));
        System.out.println("OpenCV Mat: " + m);
        Mat mr1 = m.row(1);
        mr1.setTo(new Scalar(1));
        Mat mc5 = m.col(5);
        mc5.setTo(new Scalar(5));
        System.out.println("OpenCV Mat data:\n" + m.dump());
    }

    /**
     * @param imge
     */
    protected abstract void run(Image imge);


    /**
     * Statyczna mapa predefiniowanych warunków brzegowych pikseli
     * @see BlurAction
     * @see Imgproc#blur(org.opencv.core.Mat, org.opencv.core.Mat, org.opencv.core.Size)
     * @see Core#BORDER_REPLICATE
     * @see Core#BORDER_DEFAULT
     * @see Core#BORDER_REFLECT
     * @see org.opencv.core.Core#BORDER_ISOLATED
     */
    protected static Map<String,Integer> borderTypes = new HashMap<String, Integer>(){
        {
            put("BORDER_DEFAULT",Core.BORDER_DEFAULT);
            put("BORDER_REPLICATE",Core.BORDER_REPLICATE);
            put("BORDER_REFLECT",Core.BORDER_REFLECT);
            put("BORDER_ISOLATED",Core.BORDER_ISOLATED);
        }
    };

    /**
     * Statyczna mapa sposobów liczenia progów
     * @see maciekmalik.Image.PointOP.AdaptiveThresholding
     */
    protected static Map<String, Integer> adaptiveMethod = new HashMap<String, Integer>(){
        {
            put("ADAPTIVE_THRESH_MEAN_C",Imgproc.ADAPTIVE_THRESH_MEAN_C);
            put("ADAPTIVE_THRESH_GAUSSIAN_C",Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C);
        }
    };

    /**
     * Statyczna mapa typów progowania
     * @see maciekmalik.Image.PointOP.AdaptiveThresholding
     */
    protected static Map<String, Integer> thresholdingTypes = new HashMap<String, Integer>(){
        {
            put("THRESH_BINARY",Imgproc.THRESH_BINARY);
            put("THRESH_BINARY_INV",Imgproc.THRESH_BINARY_INV);
        }
    };



    /**
     * @param in
     * @return
     * @deprecated
     * @see Utils#toBufferedImageType(java.awt.Image, int)
     * @see BufferedImage
     * @see DataBufferInt
     */
    public static Mat bufferConvert(Image in){
        BufferedImage buff = Utils.toBufferedImageType(in,BufferedImage.TYPE_INT_ARGB);
        Mat tmpM = new Mat(buff.getHeight(null),buff.getWidth(null),CvType.CV_32SC4);
        int[] pixels = ((DataBufferInt) buff.getRaster().getDataBuffer()).getData();
        tmpM.put(0,0, pixels  );
        return tmpM;
    }

    /**
     * @param in
     * @param width
     * @param heigth
     * @deprecated
     * @return Image
     * @see Mat
     * @see Utils#getImageFromArray(int[], int, int)
     */
    public static Image matConvert(Mat in,int width,int heigth){
        int[] data = new int[ (int) (in.total() * in.channels()) ];
        in.get(0,  0, data);
        return Utils.getImageFromArray(data,width,heigth);
    }

    /**
     * Zamiana z Mat na Bufferedimage
     *
     * @see BufferedImage
     * @see Mat
     * @param in
     * @param width
     * @param heigth
     * @return
     */
    public static BufferedImage mat2BufferedImg(Mat in,int width,int heigth) {
        BufferedImage out;
        byte[] data = new byte[width * heigth * (int) in.elemSize()];
        int type;
        in.get(0, 0, data);
        if (in.channels() == 1) {
            type = BufferedImage.TYPE_BYTE_GRAY;
        } else {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        out = new BufferedImage(width, heigth, type);
        out.getRaster().setDataElements(0, 0, width, heigth, data);
        out = Utils.toBufferedImage(out);
        return out;
    }


    /**
     * Zamiana z bufferedImage na Mat
     *
     * @see BufferedImage
     * @see Mat
     * @param in
     * @return
     */
    public static Mat bufferedImg2Mat(BufferedImage in) {
        Mat out;
        byte[] data;
        int r, g, b;

        if (in.getType() == BufferedImage.TYPE_INT_RGB) {
            out = new Mat(in.getHeight(), in.getWidth(), CvType.CV_8UC3);
            data = new byte[in.getHeight()*in.getWidth() * (int) out.elemSize()];
            int[] dataBuff = in.getRGB(0, 0, in.getWidth(), in.getHeight(), null, 0, in.getWidth());
            for (int i = 0; i < dataBuff.length; i++) {
                data[i * 3] = (byte) ((dataBuff[i] >> 16) & 0xFF);
                data[i * 3 + 1] = (byte) ((dataBuff[i] >> 8) & 0xFF);
                data[i * 3 + 2] = (byte) ((dataBuff[i] >> 0) & 0xFF);
            }
        } else {
            out = new Mat(in.getHeight(), in.getWidth(), CvType.CV_8UC1);
            data = new byte[in.getHeight()*in.getWidth() * (int) out.elemSize()];
            int[] dataBuff = in.getRGB(0, 0, in.getWidth(), in.getHeight(), null, 0, in.getWidth());
            for (int i = 0; i < dataBuff.length; i++) {
                r = (byte) ((dataBuff[i] >> 16) & 0xFF);
                g = (byte) ((dataBuff[i] >> 8) & 0xFF);
                b = (byte) ((dataBuff[i] >> 0) & 0xFF);
                //data[i] = (byte) ((0.21 * r) + (0.71 * g) + (0.07 * b)); // luminosity
                data[i] = (byte) Utils.pixelToGrey(r,g,b);
            }
        }
        out.put(0, 0, data);
        return out;
    }

    /**
     * Takes an image (grey-levels) and a kernel and a position,
     * applies the convolution at that position and returns the
     * new pixel value.
     *
     * @param input The 2D double array representing the image.
     * @param x The x coordinate for the position of the convolution.
     * @param y The y coordinate for the position of the convolution.
     * @param k The 2D array representing the kernel.
     * @param kernelWidth The width of the kernel.
     * @param kernelHeight The height of the kernel.
     * @return The new pixel value after the convolution.
     */
    public static double singlePixelConvolution(double[][] input,
                                                int x, int y,
                                                double[][] k,
                                                int kernelWidth,
                                                int kernelHeight) {
        double output = 0;
        for (int i = 0; i < kernelWidth; ++i) {
            for (int j = 0; j < kernelHeight; ++j) {
                output = output + (input[x + i][y + j] * k[i][j]);
            }
        }
        return output;
    }

    /**
     * Takes a 2D array of grey-levels and a kernel and applies the convolution
     * over the area of the image specified by width and height.
     *
     * @param input the 2D double array representing the image
     * @param width the width of the image
     * @param height the height of the image
     * @param kernel the 2D array representing the kernel
     * @param kernelWidth the width of the kernel
     * @param kernelHeight the height of the kernel
     * @return the 2D array representing the new image
     */
    public static double[][] convolution2D(double[][] input,
       int width, int height,
       double[][] kernel,
       int kernelWidth,
       int kernelHeight) {

        int smallWidth = width - kernelWidth + 1;
        int smallHeight = height - kernelHeight + 1;
        double[][] output = new double[smallWidth][smallHeight];
        for (int i = 0; i < smallWidth; ++i) {
            for (int j = 0; j < smallHeight; ++j) {
                output[i][j] = 0;
            }
        }
        for (int i = 0; i < smallWidth; ++i) {
            for (int j = 0; j < smallHeight; ++j) {
                output[i][j] = singlePixelConvolution(input, i, j, kernel,
                        kernelWidth, kernelHeight);
            }
        }
        return output;

    }




//    public static BufferedImage Mat2BufferedImage(Mat mat) throws IOException {
//        //Encoding the image
//
//        MatOfByte matOfByte = new MatOfByte();
//        Imgcodecs.imencode(".png", mat, matOfByte);
//        //Storing the encoded Mat in a byte array
//        byte[] byteArray = matOfByte.toArray();
//        //Preparing the Buffered Image
//        InputStream in = new ByteArrayInputStream(byteArray);
//        BufferedImage bufImage = ImageIO.read(in);
//        return bufImage;
//    }
//    public Image toBufferedImage(Mat matrix){
//        int type = BufferedImage.TYPE_BYTE_GRAY;
//        if ( matrix.channels() > 1 ) {
//            type = BufferedImage.TYPE_3BYTE_BGR;
//        }
//        int bufferSize = matrix.channels()*matrix.cols()*matrix.rows();
//        byte [] buffer = new byte[bufferSize];
//        matrix.get(0,0,buffer); // get all the pixels
//        BufferedImage image = new BufferedImage(matrix.cols(),matrix.rows(), type);
//        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
//        System.arraycopy(buffer, 0, targetPixels, 0, buffer.length);
//        return image;
//    }


}
