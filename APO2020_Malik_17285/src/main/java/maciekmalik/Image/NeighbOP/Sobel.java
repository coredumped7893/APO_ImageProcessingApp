/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image.NeighbOP;

import maciekmalik.Image.CVAction;
import maciekmalik.Image.Utils;
import maciekmalik.ImageWindow;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Sobel extends CVAction {


    private void initComponents() {

        jLSize = new javax.swing.JLabel();
        jSSize = new javax.swing.JSlider();
        jBCancel = new javax.swing.JButton();
        jBOK = new javax.swing.JButton();
        jCVertical = new javax.swing.JCheckBox();
        jCHorizontal = new javax.swing.JCheckBox();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLSize.setText("Size: 5 ");

        jSSize.setMajorTickSpacing(2);
        jSSize.setMaximum(31);
        jSSize.setMinimum(1);
        jSSize.setToolTipText("");
        jSSize.setValue(5);
        jSSize.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSSizeStateChanged(evt);
            }
        });
        jSSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSSizeMouseReleased(evt);
            }
        });

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

        jCVertical.setText("Vertical");
        jCVertical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCVerticalActionPerformed(evt);
            }
        });

        jCHorizontal.setText("Horizontal");
        jCHorizontal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCHorizontalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLSize)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSSize, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jBCancel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBOK)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCVertical)
                                        .addComponent(jCHorizontal))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLSize)
                                        .addComponent(jSSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCVertical)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCHorizontal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBOK)
                                        .addComponent(jBCancel))
                                .addContainerGap())
        );

        frame.pack();
    }// </editor-fold>



    public Sobel(Image imge) {
        initComponents();
        imageEdited = ImageWindow.getLastFocused();
        imageEditedCopy = imageEdited;
        imageEditedMat  = CVAction.bufferedImg2Mat(Utils.toBufferedImage(imageEdited.getIcon().getImage()));
        imageEditedMat.copyTo(imageEditedMatCopy);
        this.img  = imge;

        jSSize.setValue(-1);
        jSSize.setMinimum(-1);
        jSSize.setMaximum(31);
        jSSize.setMajorTickSpacing(2);
        jSSize.setSnapToTicks(true);

        frame.setVisible(true);
        this.run(this.img);
        imageEdited.setIcon(new ImageIcon(img,imageEditedCopy.getDescription()));
    }

    /**
     * @param imge
     * @see CvType#CV_64F
     * @see Imgproc#Sobel(org.opencv.core.Mat, org.opencv.core.Mat, int, int, int, int, double, double)
     * @see Sobel#jCHorizontal
     * @see Sobel#jCVertical
     */
    protected void run(Image imge){
        LOGGER.warning("Sobel:run");
        imageEditedMatCopy.copyTo(imageEditedMat);//Restore previous data
        Mat horizontalBuff = new Mat(imge.getHeight(null),imge.getWidth(null),CvType.CV_8UC3);
        Mat verticalBuff = new Mat(imge.getHeight(null),imge.getWidth(null),CvType.CV_8UC3);
        Mat out = new Mat(imge.getHeight(null),imge.getWidth(null),CvType.CV_8UC3);

        if(jCHorizontal.isSelected()){
            imageEditedMatCopy.copyTo(horizontalBuff);
            Imgproc.Sobel(horizontalBuff,horizontalBuff, -1/CvType.CV_64F, 1, 0, jSSize.getValue(), 1, 0);
        }else{
            horizontalBuff.setTo(new Scalar(0));
        }
        if(jCVertical.isSelected()){
            imageEditedMatCopy.copyTo(verticalBuff);
            Imgproc.Sobel(verticalBuff,verticalBuff, -1/CvType.CV_64F, 0, 1, jSSize.getValue(), 1, 0);
        }else{
            verticalBuff.setTo(new Scalar(0));
        }
        Core.add(horizontalBuff,verticalBuff,out);
        //@TODO fix for BW images
//        Core.rotate(horizontalBuff,horizontalBuff,Core.ROTATE_180);
//        Core.rotate(verticalBuff,verticalBuff,Core.ROTATE_180);
//        Core.add(horizontalBuff,verticalBuff,out);
        //Imgproc.Sobel(imageEditedMat,out, -1/CvType.CV_64F, 0, 1, jSSize.getValue(), 1, 0);
//        imageEditedMat.convertTo(imageEditedMat,CvType.CV_8UC3);
//        this.img = toBufferedImage(imageEditedMat);

        //Clear view if nothing is selected
//        if(!jCVertical.isSelected() && !jCHorizontal.isSelected()){
//            out.setTo(new Scalar(0));
//        }

        this.img = CVAction.mat2BufferedImg(out,img.getWidth(frame),img.getHeight(frame));
        imageEdited.setIcon(new ImageIcon(img,imageEditedCopy.getDescription()));
    }




    private void jSSizeStateChanged(javax.swing.event.ChangeEvent evt) {
        jLSize.setText("Size: " + jSSize.getValue() );
    }

    private void jSSizeMouseReleased(java.awt.event.MouseEvent evt) {
        size = new Size(jSSize.getValue(),jSSize.getValue());
        this.run(this.img);
    }

    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {
        imageEdited.setIcon(imageEditedCopy.getIcon());
        frame.dispose();
    }

    private void jBOKActionPerformed(java.awt.event.ActionEvent evt) {
        imageEdited.saveIconChange(new ImageIcon(this.img,ImageWindow.getLastFocused().getDescription()));
        frame.dispose();
    }

    private void jCVerticalActionPerformed(java.awt.event.ActionEvent evt) {
        this.run(img);
    }

    private void jCHorizontalActionPerformed(java.awt.event.ActionEvent evt) {
        this.run(img);
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBOK;
    private javax.swing.JCheckBox jCHorizontal;
    private javax.swing.JCheckBox jCVertical;
    private javax.swing.JLabel jLSize;
    protected javax.swing.JSlider jSSize;
    // End of variables declaration

}
