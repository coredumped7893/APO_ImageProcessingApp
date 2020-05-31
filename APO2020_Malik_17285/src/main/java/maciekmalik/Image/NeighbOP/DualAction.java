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

/**
 * Filtracja dwu i jedno etapowa
 */
public class DualAction extends CVAction {


    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jBCancel = new javax.swing.JButton();
        jBOK = new javax.swing.JButton();
        jCBordertype = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jRDualAction = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();

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

        jCBordertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BORDER_DEFAULT", "BORDER_ISOLATED", "BORDER_REFLECT", "BORDER_REPLICATE" }));
        jCBordertype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBordertypeActionPerformed(evt);
            }
        });

        jLabel1.setText("Piksele brzegowe:");

        buttonGroup1.add(jRDualAction);
        buttonGroup1.add(jRadioButton1);
        jRDualAction.setText("Dwu etapowa 3x3");
        jRDualAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRDualActionActionPerformed(evt);
            }
        });

        jRadioButton1.setText("5x5");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(jBCancel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jBOK))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jCBordertype, 0, 183, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jRDualAction)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jRadioButton1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCBordertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addComponent(jRDualAction)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBOK)
                                        .addComponent(jBCancel))
                                .addContainerGap())
        );

        frame.pack();
    }// </editor-fold>



    public DualAction(Image imge) {
        initComponents();
        this.jRadioButton1.setSelected(true);//Defaultowo wykonywać się będzie filtracja z maską 5x5
        imageEdited = ImageWindow.getLastFocused();
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
        LOGGER.warning("DualFiltration:run");
        imageEditedMatCopy.copyTo(imageEditedMat);//Restore previous data

        if(this.dualF){
            Imgproc.filter2D(imageEditedMat,imageEditedMat, -1,masks.get("3_smooth"),
                    new Point(-1,-1),0,borderTypes.get(jCBordertype.getSelectedItem()));
            Imgproc.filter2D(imageEditedMat,imageEditedMat, -1,masks.get("3_sharp"),
                    new Point(-1,-1),0,borderTypes.get(jCBordertype.getSelectedItem()));
        }else{
            Imgproc.filter2D(imageEditedMat,imageEditedMat, -1,masks.get("5_conv"),
                    new Point(-1,-1),0,borderTypes.get(jCBordertype.getSelectedItem()));
        }

        this.img = CVAction.mat2BufferedImg(imageEditedMat,img.getWidth(frame),img.getHeight(frame));
        imageEdited.setIcon(new ImageIcon(img,imageEditedCopy.getDescription()));
    }


    /**
     * Anuluj zmiany, przywróć początkowy obraz
     * @param evt
     */
    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {
        imageEdited.setIcon(imageEditedCopy.getIcon());
        frame.dispose();
    }

    /**
     * Zatwierdzenie zmian
     * @param evt
     */
    private void jBOKActionPerformed(java.awt.event.ActionEvent evt) {
        imageEdited.saveIconChange(new ImageIcon(this.img,ImageWindow.getLastFocused().getDescription()));
        frame.dispose();
    }

    /**
     * Zmiana warunku brzegowego pikseli
     * @param evt
     */
    private void jCBordertypeActionPerformed(java.awt.event.ActionEvent evt) {
        this.run(this.img);
    }


    /**
     * Wybór filtrowania dwuetapowego 3x3 i 3x3
     * @param evt
     */
    private void jRDualActionActionPerformed(java.awt.event.ActionEvent evt) {
        this.dualF = true;
        this.run(this.img);
    }

    /**
     * Wybór filtrowania z jedną maską 5x5
     * @param evt
     */
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dualF = false;
        this.run(this.img);
    }

    /**
     * Predefiniowane maski
     */
    private static final Map<String, Mat> masks = new HashMap<String, Mat>(){
        {
            put("3_smooth",new Mat(3,3, CvType.CV_32F){
                {
                    put(0,0,1);
                    put(0,1,1);
                    put(0,2,1);

                    put(1,0,1);
                    put(1,1,1);
                    put(1,2,1);

                    put(2,0,1);
                    put(2,1,1);
                    put(2,2,1);
                }
            });
            put("3_sharp",new Mat(3,3, CvType.CV_32F){
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
            put("5_conv",new Mat(5,5, CvType.CV_32F){
                {
                    put(0,0,1.);
                    put(0,1,-1.);
                    put(0,2,0.);
                    put(0,2,-1.);
                    put(0,2,1.);

                    put(1,0,-1.);
                    put(1,1,1.);
                    put(1,2,0.);
                    put(0,2,1.);
                    put(0,2,-1.);

                    put(2,0,0.);
                    put(2,1,0.);
                    put(2,2,0.);
                    put(0,2,0.);
                    put(0,2,0.);

                    put(3,0,-1.);
                    put(3,1,1.);
                    put(3,2,0.);
                    put(0,2,1.);
                    put(0,2,-1.);

                    put(4,0,1.);
                    put(4,1,-1.);
                    put(4,2,0.);
                    put(0,2,-1.);
                    put(0,2,1.);
                }
            });
        }
    };



    private boolean dualF = false;

    // Variables declaration - do not modify
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBOK;
    protected javax.swing.JComboBox<String> jCBordertype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRDualAction;
    private javax.swing.JRadioButton jRadioButton1;
    // End of variables declaration

}
