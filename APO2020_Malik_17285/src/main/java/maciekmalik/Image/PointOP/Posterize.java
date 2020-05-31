/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image.PointOP;

import maciekmalik.Image.BaseAction;
import maciekmalik.Image.ImageAction;
import maciekmalik.Image.Utils;
import maciekmalik.ImageWindow;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Redukcja poziomów szarości
 */
public class Posterize extends BaseAction {


    private void initComponents() {

        jBOK = new javax.swing.JButton();
        jBCancel = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);

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

        jLabel1.setText("Liczba poziomów:");

        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jBCancel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBOK)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBOK)
                                        .addComponent(jBCancel))
                                .addContainerGap())
        );


        frame.pack();
    }// </editor-fold>


    public Posterize(Image imge,Map<Object, Object> options) {
        initComponents();
        imageEdited  = ImageWindow.getLastFocused();
        imageEditedCopy = imageEdited;
        this.img  = imge;
        this.options = options;
        jSpinner1.setValue(2);
        this.run(imge,options);
        frame.setVisible(true);
        imageEdited.setIcon(new ImageIcon(this.img,imageEditedCopy.getDescription()));
    }

    private void run(Image inputIMG, Map<Object, Object> options) {
        LOGGER.info("Posterize action");
        int[] pixels = Utils.getPixelArray(inputIMG);
        int postLevels = Integer.parseInt(jSpinner1.getValue().toString());

        int[] levelValues = new int[postLevels+1];
        int l;
        for(l = 0;l<postLevels-1;l++){
            levelValues[l] = l * (255/postLevels);
        }
        levelValues[l] = 255;
        levelValues[++l] = 255;

        for(int i=0; i < pixels.length-1; i++){
            Map<String,Integer> pixel = Utils.pixelValue(pixels[i]);
            pixel.put("Red",levelValues[(int)Math.floor((pixel.get("Red")/(255.0/postLevels)))]);
            pixel.put("Green",levelValues[(int)Math.floor((pixel.get("Green")/(255.0/postLevels)))]);
            pixel.put("Blue",levelValues[(int)Math.floor((pixel.get("Blue")/(255.0/postLevels)))]);
            pixels[i] = Utils.pixelToInt(pixel);
        }
        this.img = Utils.getImageFromArray(pixels,inputIMG.getWidth(null),inputIMG.getHeight(null));
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
     * Zatwierdź edycje
     *
     * @param evt
     */
    private void jBOKActionPerformed(java.awt.event.ActionEvent evt) {
        imageEdited.saveIconChange(new ImageIcon(this.img,ImageWindow.getLastFocused().getDescription()));
        frame.dispose();
    }

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {
        //Limit values
        if(Integer.parseInt(jSpinner1.getValue().toString()) < 2){
            jSpinner1.setValue(2);
        }
        if(Integer.parseInt(jSpinner1.getValue().toString()) > 64){
            jSpinner1.setValue(64);
        }

        LOGGER.info("Spinner val:" + jSpinner1.getValue());
        this.img = this.imageEditedCopy.getIcon().getImage();
        this.run(img,options);
        imageEdited.setIcon(new ImageIcon(this.img,imageEditedCopy.getDescription()));
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration

}


