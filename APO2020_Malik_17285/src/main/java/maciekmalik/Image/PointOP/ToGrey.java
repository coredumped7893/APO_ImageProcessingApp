/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image.PointOP;

import maciekmalik.Image.CVAction;
import maciekmalik.Image.Utils;
import maciekmalik.ImageWindow;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;
import java.awt.*;

/**
 * Konwertowanie obrazu na pojedyńczy kanał w skali szarości
 */
public class ToGrey extends CVAction {

    /**
     * Edytuje obraz do skali szarości
     */
    public ToGrey() {
        imageEdited = ImageWindow.getLastFocused();
        imageEditedCopy = imageEdited;
        this.img = imageEdited.getIcon().getImage();
        imageEditedMat  = CVAction.bufferedImg2Mat(Utils.toBufferedImage(imageEdited.getIcon().getImage()));
        Imgproc.cvtColor(imageEditedMat,imageEditedMat,Imgproc.COLOR_RGB2GRAY);
        this.img = CVAction.mat2BufferedImg(imageEditedMat,img.getWidth(frame),img.getHeight(frame));
        imageEdited.setIcon(new ImageIcon(this.img,imageEditedCopy.getDescription()));
        imageEdited.saveIconChange(new ImageIcon(this.img,ImageWindow.getLastFocused().getDescription()));
    }

    /**
     *
     * @param imge
     */
    @Override
    protected void run(Image imge) {
    }
}
