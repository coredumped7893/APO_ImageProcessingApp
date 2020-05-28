/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image.NeighbOP;

import maciekmalik.Image.CVAction;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Blur  extends BlurAction{


    public Blur(Image imge) {
        super(imge);
        //Ten blur tego nie używa
        jSSigX.setEnabled(false);
        jSSigX.setVisible(false);
        jSSigY.setEnabled(false);
        jSSigY.setVisible(false);
        jLSigX.setVisible(false);
        jLSigY.setVisible(false);
        //-----------------------
    }

    /**
     * @param imge
     */
    @Override
    protected void run(Image imge) {
        LOGGER.warning("Blur:run");
        imageEditedMatCopy.copyTo(imageEditedMat);//Restore previous data
        int borderType = getBorderTypes().get(getjCBordertype().getSelectedItem().toString());
        Imgproc.blur(imageEditedMat,imageEditedMat,this.size,new Point(-1,-1),borderType);
        this.img = CVAction.mat2BufferedImg(imageEditedMat,imge.getWidth(frame),imge.getHeight(frame));
        imageEdited.setIcon(new ImageIcon(img,imageEditedCopy.getDescription()));
    }

}
