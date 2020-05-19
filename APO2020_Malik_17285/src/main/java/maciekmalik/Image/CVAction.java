/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;

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
        System.out.println("Welcome to OpenCV " + Core.VERSION);
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

}
