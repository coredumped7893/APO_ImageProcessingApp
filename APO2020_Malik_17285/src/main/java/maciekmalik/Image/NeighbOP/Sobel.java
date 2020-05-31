/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image.NeighbOP;

import maciekmalik.Image.CVAction;
import maciekmalik.Image.Utils;
import maciekmalik.ImageWindow;
import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;
import java.awt.*;

/**
 * Wykrywanie krawędzi: Sobel
 */
public class Sobel extends CVAction {


    private void initComponents() {

        jLSize = new javax.swing.JLabel();
        jSSize = new javax.swing.JSlider();
        jBCancel = new javax.swing.JButton();
        jBOK = new javax.swing.JButton();
        jCVertical = new javax.swing.JCheckBox();
        jCHorizontal = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jCBordertype = new javax.swing.JComboBox<>();

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

        jLabel1.setText("Piksele brzegowe:");

        jCBordertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BORDER_DEFAULT", "BORDER_ISOLATED", "BORDER_REFLECT", "BORDER_REPLICATE" }));
        jCBordertype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBordertypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCVertical)
                                        .addComponent(jCHorizontal))
                                .addGap(0, 0, Short.MAX_VALUE))
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
                                                .addComponent(jBOK))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCBordertype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCBordertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
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
            Imgproc.Sobel(horizontalBuff,horizontalBuff,
                    -1/CvType.CV_64F, 1, 0,
                    jSSize.getValue(), 1, 0,borderTypes.get(jCBordertype.getSelectedItem()));
        }else{
            horizontalBuff.setTo(new Scalar(0));
        }
        if(jCVertical.isSelected()){
            imageEditedMatCopy.copyTo(verticalBuff);
            Imgproc.Sobel(verticalBuff,verticalBuff,
                    -1/CvType.CV_64F, 0, 1,
                    jSSize.getValue(), 1, 0,borderTypes.get(jCBordertype.getSelectedItem()));
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

    private void jCBordertypeActionPerformed(java.awt.event.ActionEvent evt) {
        this.run(this.img);
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBOK;
    protected javax.swing.JComboBox<String> jCBordertype;
    private javax.swing.JCheckBox jCHorizontal;
    private javax.swing.JCheckBox jCVertical;
    private javax.swing.JLabel jLSize;
    private javax.swing.JLabel jLabel1;
    protected javax.swing.JSlider jSSize;
    // End of variables declaration

}
