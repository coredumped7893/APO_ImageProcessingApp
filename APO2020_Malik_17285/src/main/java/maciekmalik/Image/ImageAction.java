/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image;

import maciekmalik.Image.HistogramOP.HistStretch;
import maciekmalik.Image.ImgAnalysis.ObjectProperties;
import maciekmalik.Image.ImgAnalysis.SVM;
import maciekmalik.Image.MorphOP.BasicMorph;
import maciekmalik.Image.MorphOP.Skeleton;
import maciekmalik.Image.NeighbOP.*;
import maciekmalik.Image.PointOP.*;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Operacje na obrazach; punktowe (jedno i wieloargumentowe) wraz z dynamicznym podglądem
 *
 */
public class ImageAction {


    /**
     * Lista dostępnych operacji
     */
    private final static HashMap<String, ImageActionMaker> mapList = new HashMap<String, ImageActionMaker>(){
        {
            put("Negation",(image, options) -> new Negation(image, options));
            put("Thresholding",(image, options) -> new Thresholding(image, options));
            put("Stretching",(image, options) -> new HistStretch(image, options));
            put("Posterizing",(image, options) -> new Posterize(image, options));
            put("Blur",(image, options) -> new Blur(image));
            put("BlurGaussian",(image, options) -> new BlurGaussian(image));
            put("Laplacian",(image, options) -> new Laplacian(image));
            put("Sobel",(image, options) -> new Sobel(image));
            put("Canny",(image, options) -> new Canny(image));
            put("Prewitt",(image, options) -> new Prewitt(image));
            put("Median",(image, options) -> new Median(image));
            put("SharpLaplace",(image, options) -> new SharpLaplace(image));
            put("UniversalLOP",(image, options) -> new UniversalLOP(image));
            put("DualAction",(image, options) -> new DualAction(image));
            put("Skeleton",(image, options) -> new Skeleton(image));
            put("ToGrey",(image, options) -> new ToGrey());
            put("BasicMorph",(image, options) -> new BasicMorph(image));
            put("AdaptiveThresholding",(image,options) -> new AdaptiveThresholding(image));
            put("Otsu",(image,options) -> new Otsu(image));
            put("Watershed",(image,options) -> new Watershed(image));
            put("ObjectProperties",(image,options) -> new ObjectProperties(image));
            put("SVM",(image,options) -> new SVM(image));
            put("TwoArgument",(image,options) -> new TwoArgument(image));
        }
    };

    /**
     * Fabryka oeracji na obrazach
     */
    public static BaseAction run(String opType,Image image, Map<Object, Object> options){
        return mapList.get(opType).run(image,options);
    }

}


