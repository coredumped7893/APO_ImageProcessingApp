/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Loader do biblioteki OpenCV
 * Powinien załadować odpowiednią biblioteke na podstawie wykrytego systemu
 * Pododuje tymczasowy jej zapis na dysk
 *
 * @link https://github.com/openpnp/opencv
 */
public class CVAction extends BaseAction{

    static {
        LOGGER.fine("Trying to load OCV lib");
        nu.pattern.OpenCV.loadLocally();
        System.out.println("OpenCV loaded: " + Core.VERSION);
    }


    /**
     * @see Imgcodecs#imread(String)
     * @see Mat
     * @param filename 
     * @return Mat
     * @link https://docs.opencv.org/3.2.0/d3/d63/classcv_1_1Mat.html#details
     */
    public static Mat loadImage(String filename){
        return Imgcodecs.imread(filename);
    }

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
     * @param in
     * @return
     * @deprecated
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
     * @return
     */
    public static Image matConvert(Mat in,int width,int heigth){
        int[] data = new int[ (int) (in.total() * in.channels()) ];
        in.get(0,  0, data);
        return Utils.getImageFromArray(data,width,heigth);
    }

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




}
