/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBufferInt;
import java.awt.image.WritableRaster;
import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    /**
     * Converts a given Image into a BufferedImage
     *
     * @param img The Image to be converted
     * @return The converted BufferedImage
     */
    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }

    public static int[] getPixelArray(Image image){
        BufferedImage buffImg = Utils.toBufferedImage(image);
        return ((DataBufferInt) buffImg.getRaster().getDataBuffer()).getData();
    }


    public static Map<String,Integer> pixelValue(int pixel){
        Map<String,Integer> tmpM = new HashMap<>();

        int r,g,b;

        //Alpha channel can be ommited
        r = ( (pixel) & 0x00ff0000 ) >> 16;
        g = ( (pixel) & 0x0000ff00 ) >> 8;
        b = ( (pixel) & 0x000000ff );

        tmpM.put("Red",r);
        tmpM.put("Green",g);
        tmpM.put("Blue",b);
        tmpM.put("Luminance",Math.round((float)Utils.pixelToGray(r,g,b)));

        return tmpM;

    }

    public static int pixelToInt(Map<String,Integer> pixel){
        return pixel.get("Blue") + ( pixel.get("Green") << 8 ) + ( pixel.get("Red") << 16 );
    }

    public static Image getImageFromArray(int[] pixels, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        image.setRGB(0,0,width,height,pixels,0,width);
        //WritableRaster raster = (WritableRaster) image.getData();
        //raster.setPixels(0,0,width,height,pixels);
        return image;
    }

    public static Image toGreyScale(Image image){
        //y = 0.2989 * R + 0.5870 * G + 0.1140 * B
        return image;
    }

    public static double pixelToGray(int r, int g, int b){
        return 0.2989 * r + 0.5870 * g + 0.1140 * b;
    }


}
