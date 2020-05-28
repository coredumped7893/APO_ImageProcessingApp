/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image.NeighbOP;

import maciekmalik.Image.CVAction;
import org.opencv.core.Point;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;
import java.awt.*;

public class BlurGaussian extends BlurAction{

    public BlurGaussian(Image imge) {
        super(imge);
        isGaussian = true;
        jSSize.setValue(5);
        jSSize.setMinimum(1);
        jSSize.setMaximum(31);
        jSSize.setMajorTickSpacing(2);
        jSSize.setSnapToTicks(true);
    }

    /**
     * @param imge
     */
    @Override
    protected void run(Image imge) {
        LOGGER.warning("BlurGaussian:run");
        imageEditedMatCopy.copyTo(imageEditedMat);//Restore previous data
        int borderType = getBorderTypes().get(getjCBordertype().getSelectedItem().toString());
        Imgproc.GaussianBlur(imageEditedMat,imageEditedMat,this.size,jSSigX.getValue()/10.0,jSSigY.getValue()/10.0,borderType);
        this.img = CVAction.mat2BufferedImg(imageEditedMat,imge.getWidth(frame),imge.getHeight(frame));
        imageEdited.setIcon(new ImageIcon(img,imageEditedCopy.getDescription()));
    }



}
