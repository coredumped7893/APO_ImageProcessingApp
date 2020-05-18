/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image;

import maciekmalik.Image.HistogramOP.HistStretch;
import maciekmalik.Image.PointOP.Negation;
import maciekmalik.Image.PointOP.Posterize;
import maciekmalik.Image.PointOP.Thresholding;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Operacje na obrazach; punktowe (jedno i wieloargumentowe) wraz z dynamicznym podglądem
 *
 */
public class ImageAction {


    //call here action view template and then create ImageWindow from the result


    private final static HashMap<String, ImageActionMaker> mapList = new HashMap<String, ImageActionMaker>(){
        {
            put("Negation",(image, options) -> new Negation(image, options));
            put("Thresholding",(image, options) -> new Thresholding(image, options));
            put("Stretching",(image, options) -> new HistStretch(image, options));
            put("Posterizing",(image, options) -> new Posterize(image, options));
        }
    };

    public static BaseAction run(String opType,Image image, Map<Object, Object> options){
        return mapList.get(opType).run(image,options);
    }



}

