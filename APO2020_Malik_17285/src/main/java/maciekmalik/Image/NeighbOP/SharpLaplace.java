/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image.NeighbOP;

import maciekmalik.Image.CVAction;
import maciekmalik.Image.Utils;
import maciekmalik.ImageWindow;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class SharpLaplace extends CVAction {


    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jCBordertype = new javax.swing.JComboBox<>();
        jBCancel = new javax.swing.JButton();
        jBOK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {"-1", "-1", "-1"},
                        {"-1", "8", "-1"},
                        {"-1", "-1", "-1"}
                },
                new String [] {
                        "", "", ""
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setEnabled(false);
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {"0", "-1", "0"},
                        {"-1", "4", "-1"},
                        {"0", "-1", "0"}
                },
                new String [] {
                        "", "", ""
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setEnabled(false);
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {"1", "-2", "1"},
                        {"-2", "4", "-2"},
                        {"1", "-2", "1"}
                },
                new String [] {
                        "", "", ""
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable3.setEnabled(false);
        jScrollPane3.setViewportView(jTable3);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("A");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("B");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("C");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
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
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jBCancel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBOK))
                                        .addComponent(jCBordertype, 0, 188, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jRadioButton3))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jRadioButton1))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jRadioButton2)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCBordertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jRadioButton1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jRadioButton2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jRadioButton3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBOK)
                                        .addComponent(jBCancel))
                                .addContainerGap())
        );

        frame.pack();
    }// </editor-fold>



    public SharpLaplace(Image imge) {
        initComponents();
        imageEdited = ImageWindow.getLastFocused();
        jRadioButton1.setSelected(true);
        selectedMask = masks.get("A");
        imageEditedCopy = imageEdited;
        imageEditedMat  = CVAction.bufferedImg2Mat(Utils.toBufferedImage(imageEdited.getIcon().getImage()));
        imageEditedMat.copyTo(imageEditedMatCopy);
        this.img  = imge;
        frame.setVisible(true);
        this.run(this.img);
        imageEdited.setIcon(new ImageIcon(img,imageEditedCopy.getDescription()));
    }

    @Override
    protected void run(Image imge) {
        LOGGER.warning("SharpenLaplace:run");
        imageEditedMatCopy.copyTo(imageEditedMat);//Restore previous data

        Imgproc.filter2D(imageEditedMat,imageEditedMat, -1,selectedMask,new Point(-1,-1),0,borderTypes.get(jCBordertype.getSelectedItem()));

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
        selectedMask = masks.get(tmpR.getText());
        this.run(this.img);
    }

    private Mat selectedMask;
    private static final Map<String, Mat> masks = new HashMap<String, Mat>(){
        {
            put("A",new Mat(3,3, CvType.CV_32F){
                {
                    put(0,0,0);
                    put(0,1,-1);
                    put(0,2,0);

                    put(1,0,-1);
                    put(1,1,4);
                    put(1,2,-1);

                    put(2,0,0);
                    put(2,1,-1);
                    put(2,2,0);
                }
            });
            put("B",new Mat(3,3, CvType.CV_32F){
                {
                    put(0,0,-1);
                    put(0,1,-1);
                    put(0,2,-1);

                    put(1,0,-1);
                    put(1,1,8);
                    put(1,2,-1);

                    put(2,0,-1);
                    put(2,1,-1);
                    put(2,2,-1);
                }
            });
            put("C",new Mat(3,3, CvType.CV_32F){
                {
                    put(0,0,1);
                    put(0,1,-2);
                    put(0,2,1);

                    put(1,0,-2);
                    put(1,1,4);
                    put(1,2,-2);

                    put(2,0,1);
                    put(2,1,-2);
                    put(2,2,1);
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
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration


}
