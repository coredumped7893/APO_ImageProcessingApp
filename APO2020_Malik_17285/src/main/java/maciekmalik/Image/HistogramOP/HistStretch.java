/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image.HistogramOP;

import maciekmalik.Image.Histogram;
import maciekmalik.Image.HistogramAction;
import maciekmalik.Image.Utils;
import maciekmalik.ImageWindow;
import maciekmalik.MainGUI;
import org.jfree.chart.ChartPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Rozciąganie histogramu
 *
 */
public class HistStretch  extends HistogramAction {


    private Image img;
    private Map<Object, Object> options;
    private JFrame frame = new JFrame();
    private static final int L_MIN = 0;
    private static final int L_MAX = 255;
    private int V_MIN = 0;
    private int V_MAX = 255;
    private ImageWindow imageEdited;
    private ImageWindow imageEditedCopy;
    private Histogram hist;

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBOK = new javax.swing.JButton();
        jBCancel = new javax.swing.JButton();
        jSL2 = new javax.swing.JSlider();
        jSL1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCHistUpdate = new javax.swing.JCheckBox();
        jBAuto = new javax.swing.JButton();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frame.setTitle("Rozciąganie histogramu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 450, Short.MAX_VALUE)
        );

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

        jSL2.setMajorTickSpacing(1);
        jSL2.setMaximum(255);
        jSL2.setToolTipText("");
        jSL2.setValue(255);
        jSL2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSL2StateChanged(evt);
            }
        });
        jSL2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSL2MouseReleased(evt);
            }
        });

        jSL1.setMajorTickSpacing(1);
        jSL1.setMaximum(255);
        jSL1.setToolTipText("");
        jSL1.setValue(0);
        jSL1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSL1StateChanged(evt);
            }
        });
        jSL1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSL1MouseReleased(evt);
            }
        });

        jLabel1.setText("L1:");

        jLabel2.setText("L2:");

        jCHistUpdate.setText("Aktualizuj Histogram");

        jBAuto.setText("Auto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jCHistUpdate)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jBAuto))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSL1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jSL2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jBCancel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBOK)))
                                .addContainerGap())
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCHistUpdate)
                                        .addComponent(jBAuto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jSL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jSL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(18, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jBOK)
                                                        .addComponent(jBCancel))
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );

        frame.pack();
    }// </editor-fold>




    public HistStretch(Image imge,Map<Object, Object> options){

        initComponents();
        imageEdited  = ImageWindow.getLastFocused();
        imageEditedCopy = imageEdited;
        hist = new Histogram(imge);
        List<ChartPanel> cpL =  hist.renderFrame(hist.calculateHist(),"Thresholding: " + ImageWindow.getLastFocused().getIcon().getDescription());
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(cpL.get(3), BorderLayout.NORTH);
        this.img  = imge;
        this.options = options;
        this.run(imge,options);
        frame.setVisible(true);
        imageEdited.setIcon(new ImageIcon(this.img,imageEditedCopy.getDescription()));

    }

    /**
     * Przelicza LUT na nowe wartości
     *
     * @param pixel
     * @return
     */
    private Map<String,Integer> _calculate(Map<String,Integer> pixel){
        Map<String,Integer> tmp = new HashMap<>();//kopia mapy
        tmp.put("Red",Math.round( (float) Utils.mapImage(((float)L_MAX/(V_MAX - V_MIN))*(pixel.get("Red") - V_MIN))));
        tmp.put("Green",Math.round( (float) Utils.mapImage(((float)L_MAX/(V_MAX - V_MIN))*(pixel.get("Green") - V_MIN))));
        tmp.put("Blue",Math.round( (float) Utils.mapImage(((float)L_MAX/(V_MAX - V_MIN))*(pixel.get("Blue") - V_MIN))));
        return tmp;
    }


    /**
     * Przelicza wartości na podstawie wczesniej generowanego LUT.
     * Dla obrazów RGB każdy kanał przelicza osobno (na podstawie tych samych min,max)
     *
     * @param inputIMG
     * @param options
     */
    private void run(Image inputIMG, Map<Object, Object> options) {

        LOGGER.info("Hist Stretching");
        int[] pixels = Utils.getPixelArray(inputIMG);
        LinkedList<Map<String,Integer>> LUT = new LinkedList<>();

        for (int val = 0; val < (L_MAX+1); val++){
            Map<String,Integer> pixel = new HashMap<>();
            LUT.add(new HashMap<>());
            pixel.put("Red",val);
            pixel.put("Green",val);
            pixel.put("Blue",val);
            pixel = _calculate(pixel);
            LUT.get(val).put("Red",pixel.get("Red"));
            LUT.get(val).put("Green",pixel.get("Green"));
            LUT.get(val).put("Blue",pixel.get("Blue"));
        }

        for(int i=0; i < pixels.length-1; i++){
            Map<String,Integer> pixel = Utils.pixelValue(pixels[i]);
            pixel.put("Red",LUT.get(pixel.get("Red")).get("Red"));
            pixel.put("Green",LUT.get(pixel.get("Green")).get("Green"));
            pixel.put("Blue",LUT.get(pixel.get("Blue")).get("Blue"));
            pixels[i] = Utils.pixelToInt(pixel);
        }
        this.img = Utils.getImageFromArray(pixels,inputIMG.getWidth(null),inputIMG.getHeight(null));
    }


    private void jBOKActionPerformed(java.awt.event.ActionEvent evt) {
        imageEdited.saveIconChange(new ImageIcon(this.img));
        frame.dispose();
    }

    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {
        imageEdited.setIcon(imageEditedCopy.getIcon());
        frame.dispose();
    }

    private void jSL1MouseReleased(java.awt.event.MouseEvent evt) {
        this.V_MIN = jSL1.getValue();
        this.img = this.imageEditedCopy.getIcon().getImage();
        this.run(img,options);
        _updateHistView(this.img);
        imageEdited.setIcon(new ImageIcon(this.img,imageEditedCopy.getDescription()));
    }

    private void jSL2MouseReleased(java.awt.event.MouseEvent evt) {
        this.V_MAX = jSL2.getValue();
        this.img = this.imageEditedCopy.getIcon().getImage();
        this.run(img,options);
        _updateHistView(this.img);
        imageEdited.setIcon(new ImageIcon(this.img,imageEditedCopy.getDescription()));
    }

    private void jSL2StateChanged(javax.swing.event.ChangeEvent evt) {
    }
    private void jSL1StateChanged(javax.swing.event.ChangeEvent evt) {
    }

    private void _updateHistView(Image img){
        if(jCHistUpdate.isSelected()){
            hist = new Histogram(img);
            List<ChartPanel> cpL =  hist.renderFrame(hist.calculateHist(),"Thresholding: " + ImageWindow.getLastFocused().getIcon().getDescription());
            jPanel1.removeAll();
            jPanel1.add(cpL.get(3), BorderLayout.NORTH);
            jPanel1.revalidate();
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JButton jBAuto;
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBOK;
    private javax.swing.JCheckBox jCHistUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSL1;
    private javax.swing.JSlider jSL2;
    // End of variables declaration


}
