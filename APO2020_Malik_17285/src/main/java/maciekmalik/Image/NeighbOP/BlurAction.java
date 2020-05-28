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
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Core;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * Klasa bazowa dla wygładzania
 * Definiuje okno dla parametrów
 *
 * @see CVAction
 * @see org.opencv.imgproc.Imgproc#blur(Mat, Mat, Size, Point, int)
 * @see org.opencv.imgproc.Imgproc#GaussianBlur(Mat, Mat, Size, double, double, int)
 */
public abstract class BlurAction extends CVAction {

    /**
     * Rozmiar kernela (domyślny)
     *
     * @see Mat
     */
    protected boolean isGaussian = false;



    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jBOK = new javax.swing.JButton();
        jBCancel = new javax.swing.JButton();
        jLSize = new javax.swing.JLabel();
        jSSize = new javax.swing.JSlider();
        jCBordertype = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLSigX = new javax.swing.JLabel();
        jLSigY = new javax.swing.JLabel();
        jSSigX = new javax.swing.JSlider();
        jSSigY = new javax.swing.JSlider();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frame.setTitle("Blur");
        frame.setMinimumSize(new java.awt.Dimension(322, 221));

        jBOK.setText("OK");
        jBOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBOKActionPerformed(evt);
            }
        });

        jBCancel.setText("Anuluj");
        jBCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelActionPerformed(evt);
            }
        });

        jLSize.setText("Size: 5 ");

        jSSize.setMajorTickSpacing(1);
        jSSize.setMaximum(30);
        jSSize.setMinimum(2);
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

        jCBordertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BORDER_DEFAULT","BORDER_ISOLATED", "BORDER_REFLECT", "BORDER_REPLICATE" }));
        jCBordertype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBordertypeActionPerformed(evt);
            }
        });

        jLabel1.setText("Piksele brzegowe:");

        jLSigX.setText("Sigma X: 1.50");

        jLSigY.setText("Sigma Y: 1.50");

        jSSigX.setMajorTickSpacing(5);
        jSSigX.setMaximum(1000);
        jSSigX.setValue(15);
        jSSigX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSSigXStateChanged(evt);
            }
        });
        jSSigX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSSigXMouseReleased(evt);
            }
        });

        jSSigY.setMajorTickSpacing(5);
        jSSigY.setMaximum(1000);
        jSSigY.setValue(15);
        jSSigY.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSSigYStateChanged(evt);
            }
        });
        jSSigY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSSigYMouseReleased(evt);
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
                                                .addComponent(jBOK)
                                                .addGap(6, 6, 6))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jCBordertype, 0, 173, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLSize)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLSigX)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSSigX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLSigY)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSSigY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGap(6, 6, 6))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLSize)
                                        .addComponent(jSSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCBordertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLSigX)
                                        .addComponent(jSSigX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLSigY)
                                        .addComponent(jSSigY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBOK)
                                        .addComponent(jBCancel))
                                .addContainerGap())
        );

        frame.pack();
    }// </editor-fold>




    public BlurAction(Image imge) {
        initComponents();

        imageEdited = ImageWindow.getLastFocused();
        imageEditedCopy = imageEdited;
        imageEditedMat  = CVAction.bufferedImg2Mat(Utils.toBufferedImage(imageEdited.getIcon().getImage()));
        imageEditedMat.copyTo(imageEditedMatCopy);
        this.img  = imge;
        this.run(imge);
        frame.setVisible(true);
    }



    /**
     * Wybrany został nowy rozmiar,
     * przelicz i ustaw nowy podgląd
     *
     * @param evt
     */
    private void jSSizeMouseReleased(java.awt.event.MouseEvent evt) {
        size = new Size(jSSize.getValue(),jSSize.getValue());
        this.run(this.img);
    }

    /**
     * Aktualizuj wartość tekstową
     *
     * @param evt
     */
    private void jSSizeStateChanged(javax.swing.event.ChangeEvent evt) {
        jLSize.setText("Size: " + jSSize.getValue() );
    }

    /**
     * recalculate if gaussian
     *
     * @param evt
     */
    private void jSSigXMouseReleased(java.awt.event.MouseEvent evt) {
        this.run(this.img);
    }

    private void jSSigXStateChanged(javax.swing.event.ChangeEvent evt) {
        jLSigX.setText("Sigma X: " + String.format("%03.1f",(jSSigX.getValue()/10.0)) );
    }

    /**
     * recalculate if gaussian
     *
     * @param evt
     */
    private void jSSigYMouseReleased(java.awt.event.MouseEvent evt) {
        this.run(this.img);
    }

    private void jSSigYStateChanged(javax.swing.event.ChangeEvent evt) {
        jLSigY.setText("Sigma X: " + String.format("%03.1f",(jSSigY.getValue()/10.0)) );
    }
    private void jBOKActionPerformed(java.awt.event.ActionEvent evt) {
        imageEdited.saveIconChange(new ImageIcon(this.img,ImageWindow.getLastFocused().getDescription()));
        frame.dispose();
    }

    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {
        imageEdited.setIcon(imageEditedCopy.getIcon());
        frame.dispose();
    }

    private void jCBordertypeActionPerformed(java.awt.event.ActionEvent evt) {
        this.run(this.img);
    }


    public static Map<String, Integer> getBorderTypes() {
        return borderTypes;
    }

    public JComboBox<String> getjCBordertype() {
        return jCBordertype;
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBOK;
    protected javax.swing.JComboBox<String> jCBordertype;
    protected javax.swing.JLabel jLSigX;
    protected javax.swing.JLabel jLSigY;
    private javax.swing.JLabel jLSize;
    private javax.swing.JLabel jLabel1;
    protected javax.swing.JSlider jSSigX;
    protected javax.swing.JSlider jSSigY;
    protected javax.swing.JSlider jSSize;
    // End of variables declaration


}


