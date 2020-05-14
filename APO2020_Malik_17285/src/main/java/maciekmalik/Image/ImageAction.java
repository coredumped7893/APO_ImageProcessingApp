/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image;

import maciekmalik.Image.PointOP.Negation;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Operacje na obrazach; punktowe (jedno i wieloargumentowe) wraz z dynamicznym podglądem
 *
 */
public class ImageAction {


    //call here action view template and then create ImageWindow from the result


    private final static HashMap<String, ImageActionMaker> mapList = new HashMap<>(){
        {
            put("Negation",(image, options) -> new Negation(image, options));
        }
    };

    public static BaseAction run(String opType,Image image, Map<Object, Object> options){
        return mapList.get(opType).run(image,options);
    }



}

