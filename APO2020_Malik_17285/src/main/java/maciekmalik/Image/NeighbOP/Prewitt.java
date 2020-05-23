/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image.NeighbOP;

import maciekmalik.Image.CVAction;
import maciekmalik.Image.Utils;
import maciekmalik.ImageWindow;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Prewitt extends CVAction {

    private Mat kernel;


    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jCBordertype = new javax.swing.JComboBox<>();
        jBCancel = new javax.swing.JButton();
        jBOK = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Piksele brzegowe:");

        jCBordertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BORDER_DEFAULT", "BORDER_ISOLATED", "BORDER_REFLECT", "BORDER_REPLICATE" }));
        jCBordertype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBordertypeActionPerformed(evt);
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

        jLabel2.setText("Kierunek:");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setToolTipText("NW");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setToolTipText("N");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setToolTipText("NE");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setToolTipText("W");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setToolTipText("E");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton7);
        jRadioButton7.setToolTipText("SW");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton8);
        jRadioButton8.setToolTipText("SE");
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton9);
        jRadioButton9.setToolTipText("S");
        jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonActionPerformed(evt);
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
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addGap(35, 35, 35)
                                                                .addComponent(jRadioButton1))
                                                        .addComponent(jLabel1)
                                                        .addComponent(jRadioButton4)
                                                        .addComponent(jRadioButton7))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jCBordertype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jRadioButton6)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jRadioButton2)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jRadioButton3))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jRadioButton9)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jRadioButton8)))
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jBCancel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBOK)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCBordertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jRadioButton1)
                                        .addComponent(jRadioButton2)
                                        .addComponent(jRadioButton3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton4)
                                        .addComponent(jRadioButton6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton7)
                                        .addComponent(jRadioButton9)
                                        .addComponent(jRadioButton8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBOK)
                                        .addComponent(jBCancel))
                                .addContainerGap())
        );

        frame.pack();
    }// </editor-fold>

    public Prewitt(Image imge) {
        initComponents();
        jRadioButton3.setSelected(true);//Default for NE direction
        kernel = directionKernels.get("NE");
        imageEdited = ImageWindow.getLastFocused();
        imageEditedCopy = imageEdited;
        imageEditedMat  = CVAction.bufferedImg2Mat(Utils.toBufferedImage(imageEdited.getIcon().getImage()));
        imageEditedMat.copyTo(imageEditedMatCopy);
        this.img  = imge;
        frame.setVisible(true);
        this.run(this.img);
        imageEdited.setIcon(new ImageIcon(img,imageEditedCopy.getDescription()));
    }

    /**
     * @param imge
     * @see CvType#CV_64F
     * @see Prewitt#directionKernels
     * @see Mat
     */
    protected void run(Image imge){
        LOGGER.warning("Prewitt:run");
        imageEditedMatCopy.copyTo(imageEditedMat);//Restore previous data

        Imgproc.filter2D(imageEditedMat,imageEditedMat, -1,kernel,new Point(-1,-1),0,borderTypes.get(jCBordertype.getSelectedItem()));

        this.img = CVAction.mat2BufferedImg(imageEditedMat,img.getWidth(frame),img.getHeight(frame));
        imageEdited.setIcon(new ImageIcon(img,imageEditedCopy.getDescription()));
    }

    private void jCBordertypeActionPerformed(java.awt.event.ActionEvent evt) {
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

    private void jRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {
        JRadioButton tmpR = (JRadioButton) evt.getSource();
        LOGGER.info("Direction: " + tmpR.getToolTipText());
        kernel = directionKernels.get(tmpR.getToolTipText());
        this.run(this.img);
    }

    private static final Map<String,Mat> directionKernels = new HashMap<String, Mat>(){
        {
            put("NW",new Mat(3,3, CvType.CV_32F){
                {
                    put(0,0,1);
                    put(0,1,1);
                    put(0,2,0);

                    put(1,0,1);
                    put(1,1,0);
                    put(1,2,-1);

                    put(2,0,0);
                    put(2,1,-1);
                    put(2,2,-1);
                }
            });
            put("N",new Mat(3,3, CvType.CV_32F){
                {
                    put(0,0,1);
                    put(0,1,1);
                    put(0,2,1);

                    put(1,0,0);
                    put(1,1,0);
                    put(1,2,0);

                    put(2,0,-1);
                    put(2,1,-1);
                    put(2,2,-1);
                }
            });
            put("NE",new Mat(3,3, CvType.CV_32F){
                {
                    put(0,0,0);
                    put(0,1,1);
                    put(0,2,1);

                    put(1,0,-1);
                    put(1,1,0);
                    put(1,2,1);

                    put(2,0,-1);
                    put(2,1,-1);
                    put(2,2,0);
                }
            });
            put("E",new Mat(3,3, CvType.CV_32F){
                {
                    put(0,0,-1);
                    put(0,1,0);
                    put(0,2,1);

                    put(1,0,-1);
                    put(1,1,0);
                    put(1,2,1);

                    put(2,0,-1);
                    put(2,1,0);
                    put(2,2,1);
                }
            });
            put("SE",new Mat(3,3, CvType.CV_32F){
                {
                    put(0,0,-1);
                    put(0,1,-1);
                    put(0,2,0);

                    put(1,0,-1);
                    put(1,1,0);
                    put(1,2,1);

                    put(2,0,0);
                    put(2,1,1);
                    put(2,2,1);
                }
            });
            put("S",new Mat(3,3, CvType.CV_32F){
                {
                    put(0,0,-1);
                    put(0,1,-1);
                    put(0,2,-1);

                    put(1,0,0);
                    put(1,1,0);
                    put(1,2,0);

                    put(2,0,1);
                    put(2,1,1);
                    put(2,2,1);
                }
            });
            put("SW",new Mat(3,3, CvType.CV_32F){
                {
                    put(0,0,0);
                    put(0,1,-1);
                    put(0,2,-1);

                    put(1,0,1);
                    put(1,1,0);
                    put(1,2,-1);

                    put(2,0,1);
                    put(2,1,1);
                    put(2,2,0);
                }
            });
            put("W",new Mat(3,3, CvType.CV_32F){
                {
                    put(0,0,1);
                    put(0,1,0);
                    put(0,2,-1);

                    put(1,0,1);
                    put(1,1,0);
                    put(1,2,-1);

                    put(2,0,1);
                    put(2,1,0);
                    put(2,2,-1);
                }
            });
        }
    };




    // Variables declaration - do not modify
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBOK;
    protected javax.swing.JComboBox<String> jCBordertype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    // End of variables declaration




}
