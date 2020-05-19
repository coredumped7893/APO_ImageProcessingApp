/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image.PointOP;

import maciekmalik.Image.BaseAction;
import maciekmalik.Image.ImageAction;
import maciekmalik.Image.Utils;
import maciekmalik.ImageWindow;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Negation  extends BaseAction {


//    private Image img;
//    private Map<Object, Object> options;
//    private ImageWindow imageEdited;
//    private ImageWindow imageEditedCopy;


    public Negation(Image imge,Map<Object, Object> options) {
        imageEdited  = ImageWindow.getLastFocused();
        imageEditedCopy = imageEdited;
        this.img  = imge;
        this.options = options;
        this.run(imge);
    }

    public Image getImage(){
        return this.img;
    }

    private void run(Image inputIMG){

        int[] pixels = Utils.getPixelArray(inputIMG);

        for(int i=0; i < pixels.length-1; i++){

            Map<String,Integer> p = Utils.pixelValue(pixels[i]);
            p.put("Red",255 - p.get("Red"));
            p.put("Green",255 - p.get("Green"));
            p.put("Blue",255 - p.get("Blue"));
            pixels[i] = Utils.pixelToInt(p);

        }
        this.img = Utils.getImageFromArray(pixels,inputIMG.getWidth(null),inputIMG.getHeight(null));
        imageEdited.setIcon(new ImageIcon(this.img,imageEditedCopy.getDescription()));
        imageEdited.saveIconChange(new ImageIcon(this.img));
    }


}
