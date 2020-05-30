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

public class UniversalLOP extends CVAction {

    private Mat kernel;
    private boolean enableEdit = false;

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCBordertype = new javax.swing.JComboBox<>();
        jBCancel = new javax.swing.JButton();
        jBOK = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTInput = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLError = new javax.swing.JLabel();

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

        jTInput.setModel(new javax.swing.table.DefaultTableModel(
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
        jTInput.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTInputPropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(jTInput);

        jLabel2.setText("Kliknij dwukrotnie w komórke aby edytowac");

        jLError.setText("Zły format danych");
        jLError.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCBordertype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jBCancel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBOK))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLError))
                                                        .addComponent(jLabel2))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLError))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBOK)
                                        .addComponent(jBCancel))
                                .addContainerGap())
        );

        frame.pack();
    }// </editor-fold>


    public UniversalLOP(Image imge) {
        initComponents();
        jLError.setVisible(false);
        imageEdited = ImageWindow.getLastFocused();
        jTInput.setRowSelectionAllowed(true);
        jTInput.setRowSelectionInterval(0,0);
        this.kernel = this._setMat();
        imageEditedCopy = imageEdited;
        imageEditedMat  = CVAction.bufferedImg2Mat(Utils.toBufferedImage(imageEdited.getIcon().getImage()));
        imageEditedMat.copyTo(imageEditedMatCopy);
        this.img  = imge;
        frame.setVisible(true);
        this.run(this.img);
        imageEdited.setIcon(new ImageIcon(img,imageEditedCopy.getDescription()));
        this.enableEdit = true;
    }

    @Override
    protected void run(Image imge) {
        LOGGER.warning("SharpenLaplace:run");
        imageEditedMatCopy.copyTo(imageEditedMat);//Restore previous data

        Imgproc.filter2D(imageEditedMat,imageEditedMat, -1,this.kernel,new Point(-1,-1),0,borderTypes.get(jCBordertype.getSelectedItem()));

        this.img = CVAction.mat2BufferedImg(imageEditedMat,img.getWidth(frame),img.getHeight(frame));
        imageEdited.setIcon(new ImageIcon(img,imageEditedCopy.getDescription()));
    }

    private void jCBordertypeActionPerformed(java.awt.event.ActionEvent evt) {
        this.run(this.img);
    }

    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {
        this.enableEdit = false;
        imageEdited.setIcon(imageEditedCopy.getIcon());
        frame.dispose();
    }

    private void jBOKActionPerformed(java.awt.event.ActionEvent evt) {
        imageEdited.saveIconChange(new ImageIcon(this.img,ImageWindow.getLastFocused().getDescription()));
        frame.dispose();
    }

    private void jTInputPropertyChange(java.beans.PropertyChangeEvent evt) {
        if(!jTInput.isEditing() && this.enableEdit){
            LOGGER.info(jTInput.getValueAt(0,0).toString());
            this.kernel = this._setMat();
            this.run(this.img);
        }
    }

    /**
     * Ustawia wartości w kernelu na podstawie tabeli
     */
    private Mat _setMat(){

        return new Mat(3,3, CvType.CV_32F){
            {
                put(0,0,Integer.parseInt(jTInput.getValueAt(0,0).toString()));
                put(0,1,Integer.parseInt(jTInput.getValueAt(0,1).toString()));
                put(0,2,Integer.parseInt(jTInput.getValueAt(0,2).toString()));

                put(1,0,Integer.parseInt(jTInput.getValueAt(1,0).toString()));
                put(1,1,Integer.parseInt(jTInput.getValueAt(1,1).toString()));
                put(1,2,Integer.parseInt(jTInput.getValueAt(1,2).toString()));

                put(2,0,Integer.parseInt(jTInput.getValueAt(2,0).toString()));
                put(2,1,Integer.parseInt(jTInput.getValueAt(2,1).toString()));
                put(2,2,Integer.parseInt(jTInput.getValueAt(2,2).toString()));
            }
        };


    }

    // Variables declaration - do not modify
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBOK;
    protected javax.swing.JComboBox<String> jCBordertype;
    private javax.swing.JLabel jLError;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTInput;
    // End of variables declaration

}
