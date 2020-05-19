/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image.NeighbOP;

import maciekmalik.Image.CVAction;
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
    }

    /**
     * @param imge
     */
    @Override
    void run(Image imge) {
        LOGGER.warning("Blur:run");
        imageEditedMatCopy.copyTo(imageEditedMat);//Restore previous data
        Imgproc.blur(imageEditedMat,imageEditedMat,this.size);

//        Imgcodecs.imwrite("outtest.jpg",imageEditedMat);
//
//        try {
//            File outputfile = new File("saved.png");
//            ImageIO.write(CVAction.mat2BufferedImg(imageEditedMat,512,512), "png", outputfile);
//        } catch (IOException e) {
//        }

        this.img = CVAction.mat2BufferedImg(imageEditedMat,imge.getWidth(frame),imge.getHeight(frame));
        imageEdited.setIcon(new ImageIcon(img,imageEditedCopy.getDescription()));

    }





}
