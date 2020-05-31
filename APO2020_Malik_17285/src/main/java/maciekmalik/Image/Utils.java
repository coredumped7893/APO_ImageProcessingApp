/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image;

import java.awt.*;
import java.awt.image.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Różne pomocniczne metody do operacaji na pojedynczych pikselach:
 * zamiana piksela RGB na szaro odcieniowy,
 * konwertowanie piksela RGB na wartości konkretnych kanałów i w drugą stronę
 * generowanie obrazu z tablicy wartośći pikseli
 * generowanie tablicy wartości z obiektu obrazu
 */
public class Utils {

    public static BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    public static BufferedImage toBufferedImage(Image img) {
        return Utils.toBufferedImageType(img,BufferedImage.TYPE_INT_RGB);
    }

    /**
     * Converts a given Image into a BufferedImage
     *
     * @param img The Image to be converted
     * @return The converted BufferedImage
     */
    public static BufferedImage toBufferedImageType(Image img, int type) {
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), type);
        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        // Return the buffered image
        return bimage;
    }

    /**
     * Zwraca tablice pixeli jako int (RGB)
     *
     * @param image
     * @return tablica pixeli jako int
     */
    public static int[] getPixelArray(Image image){
        BufferedImage buffImg = Utils.toBufferedImage(image);
        return ((DataBufferInt) buffImg.getRaster().getDataBuffer()).getData();
    }


    /**
     * Maps s from set a1,a2 to set b1,b2
     *
     *
     * @param a1
     * @param a2
     * @param b1
     * @param b2
     * @param s
     * @return mapped value to b1,b2
     */
    public static double mapRange(double a1, double a2, double b1, double b2, double s){
        //return s;
        return b1 + ((s - a1)*(b2 - b1))/(a2 - a1);
    }

    public static int mapImage(double c){
        int cI = (int) Math.round(c);
        if(cI > 255){
            return 255;
        }else if(cI < 0){
            return 0;
        }else{
            return cI;
        }
    }

    /**
     * Rozdziela piksel RGB na pojedyńcze kanały, wylicza wartośc luminancji i zwrata to jako mapę
     * @param pixel
     * @return Map
     */
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
        tmpM.put("Luminance",Math.round((float)Utils.pixelToGrey(r,g,b)));

        return tmpM;

    }

    /**
     * Konwertuje mapę piksela do pojedyńczej wartości int (4 bajtowej)
     * @param pixel
     * @return int
     */
    public static int pixelToInt(Map<String,Integer> pixel){
        return pixel.get("Blue") + ( pixel.get("Green") << 8 ) + ( pixel.get("Red") << 16 );
    }

    /**
     * Generuje obraz na podstawie tablicy wartości
     * @param pixels
     * @param width
     * @param height
     * @return Image
     */
    public static Image getImageFromArray(int[] pixels, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        image.setRGB(0,0,width,height,pixels,0,width);
        return image;
    }

    public static Image toGreyScale(Image image){
        //y = 0.2989 * R + 0.5870 * G + 0.1140 * B
        return image;
    }

    /**
     * Konwersja wartości RGB na pojedyńczy kanał luminancji
     * @param r
     * @param g
     * @param b
     * @return double
     */
    public static double pixelToGrey(int r, int g, int b){
        return 0.2989 * r + 0.5870 * g + 0.1140 * b;
    }

}
