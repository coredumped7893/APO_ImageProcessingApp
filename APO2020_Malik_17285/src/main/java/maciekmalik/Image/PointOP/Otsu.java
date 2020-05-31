/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image.PointOP;

import maciekmalik.Image.CVAction;
import maciekmalik.Image.Utils;
import maciekmalik.ImageWindow;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;
import java.awt.*;

public class Otsu extends CVAction {

    private void initComponents() {

        jBCancel = new javax.swing.JButton();
        jBOK = new javax.swing.JButton();
        jCApplyBlur = new javax.swing.JCheckBox();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBCancel.setText("Anuluj");
        jBCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelActionPerformed(evt);
            }
        });

        jBOK.setText("OK");
        jBOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBOKActionPerformed(evt);
            }
        });

        jCApplyBlur.setText("Wygładź Gaussem przez progowaniem?");
        jCApplyBlur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCApplyBlurActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBCancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBOK)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jCApplyBlur)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(31, Short.MAX_VALUE)
                                .addComponent(jCApplyBlur)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBOK)
                                        .addComponent(jBCancel))
                                .addContainerGap())
        );

        frame.pack();
    }// </editor-fold>



    public Otsu(Image imge) {

        initComponents();
        imageEdited = ImageWindow.getLastFocused();
        imageEditedCopy = imageEdited;
        imageEditedMat  = CVAction.bufferedImg2Mat(Utils.toBufferedImage(imageEdited.getIcon().getImage()));

        /*
         * Konwertowanie na obraz szaroodcieniowy, 1 kanałowy
         * Domyślnie przy ładowaniu obraz wczytywany jest jako RGB 3 kanałowy
         */
        Imgproc.cvtColor(imageEditedMat,imageEditedMat,Imgproc.COLOR_RGB2GRAY);
        imageEditedMat.copyTo(imageEditedMatCopy);
        this.img  = imge;
        frame.setVisible(true);
        this.run(this.img);
        imageEdited.setIcon(new ImageIcon(img,imageEditedCopy.getDescription()));

    }

    /**
     * 
     * @param imge
     *
     * @see Imgproc#GaussianBlur(Mat, Mat, Size, double )
     * @see Imgproc#threshold(Mat, Mat, double, double, int)
     * https://docs.opencv.org/2.4/modules/ocl/doc/image_filtering.html?highlight=gaussianblur#ocl-gaussianblur
     */
    @Override
    protected void run(Image imge) {
        LOGGER.warning("Otsu:run");
        imageEditedMatCopy.copyTo(imageEditedMat);//Restore previous data

        if(jCApplyBlur.isSelected()){
            Imgproc.GaussianBlur(imageEditedMat,imageEditedMat,new Size(3,3),0);
        }


        //javadoc: threshold(src, dst, thresh, maxval, type)
        Imgproc.threshold(imageEditedMat,imageEditedMat,0,255,Imgproc.THRESH_BINARY+Imgproc.THRESH_OTSU);

        this.img = CVAction.mat2BufferedImg(imageEditedMat,img.getWidth(frame),img.getHeight(frame));
        imageEdited.setIcon(new ImageIcon(img,imageEditedCopy.getDescription()));
    }

    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {
        imageEdited.setIcon(imageEditedCopy.getIcon());
        frame.dispose();
    }

    private void jBOKActionPerformed(java.awt.event.ActionEvent evt) {
        imageEdited.saveIconChange(new ImageIcon(this.img,ImageWindow.getLastFocused().getDescription()));
        frame.dispose();
    }

    private void jCApplyBlurActionPerformed(java.awt.event.ActionEvent evt) {
        this.run(this.img);
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBOK;
    private javax.swing.JCheckBox jCApplyBlur;
    // End of variables declaration

}
