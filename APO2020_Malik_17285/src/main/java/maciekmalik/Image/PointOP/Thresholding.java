/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image.PointOP;

import maciekmalik.Image.BaseAction;
import maciekmalik.Image.Histogram;
import maciekmalik.Image.Utils;
import maciekmalik.ImageWindow;
import maciekmalik.MainGUI;
import org.jfree.chart.ChartPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


public class Thresholding  extends BaseAction implements ChangeListener {

    private static final Logger LOGGER = Logger.getLogger(MainGUI.class.getName());
    private Image img;
    private Map<Object, Object> options;
    private JFrame frame;
    private static final int L_MIN = 0;
    private static final int L_MAX = 255;
    private ImageWindow imageEdited;
    private ImageWindow imageEditedCopy;


    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTabCon = new javax.swing.JTabbedPane();
        jPTabLuminance = new javax.swing.JPanel();
        jPTabRed = new javax.swing.JPanel();
        jPTabGreen = new javax.swing.JPanel();
        jPTabBlue = new javax.swing.JPanel();
        jBOK = new javax.swing.JButton();
        jBCancel = new javax.swing.JButton();
        jSValueSelect = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLSelectedValue = new javax.swing.JLabel();
        jBReset = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPTabLuminanceLayout = new javax.swing.GroupLayout(jPTabLuminance);
        jPTabLuminance.setLayout(jPTabLuminanceLayout);
        jPTabLuminanceLayout.setHorizontalGroup(
                jPTabLuminanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 548, Short.MAX_VALUE)
        );
        jPTabLuminanceLayout.setVerticalGroup(
                jPTabLuminanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 366, Short.MAX_VALUE)
        );

        jTabCon.addTab("Luminance", jPTabLuminance);

        jPTabRed.setPreferredSize(new java.awt.Dimension(403, 313));

        javax.swing.GroupLayout jPTabRedLayout = new javax.swing.GroupLayout(jPTabRed);
        jPTabRed.setLayout(jPTabRedLayout);
        jPTabRedLayout.setHorizontalGroup(
                jPTabRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 548, Short.MAX_VALUE)
        );
        jPTabRedLayout.setVerticalGroup(
                jPTabRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 366, Short.MAX_VALUE)
        );

        jTabCon.addTab("Red", jPTabRed);

        javax.swing.GroupLayout jPTabGreenLayout = new javax.swing.GroupLayout(jPTabGreen);
        jPTabGreen.setLayout(jPTabGreenLayout);
        jPTabGreenLayout.setHorizontalGroup(
                jPTabGreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 548, Short.MAX_VALUE)
        );
        jPTabGreenLayout.setVerticalGroup(
                jPTabGreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 366, Short.MAX_VALUE)
        );

        jTabCon.addTab("Green", jPTabGreen);

        javax.swing.GroupLayout jPTabBlueLayout = new javax.swing.GroupLayout(jPTabBlue);
        jPTabBlue.setLayout(jPTabBlueLayout);
        jPTabBlueLayout.setHorizontalGroup(
                jPTabBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 548, Short.MAX_VALUE)
        );
        jPTabBlueLayout.setVerticalGroup(
                jPTabBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 366, Short.MAX_VALUE)
        );

        jTabCon.addTab("Blue", jPTabBlue);

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

        jSValueSelect.setMajorTickSpacing(1);
        jSValueSelect.setMaximum(255);
        jSValueSelect.setToolTipText("");
        jSValueSelect.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSValueSelectStateChanged(evt);
            }
        });
        jSValueSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSValueSelectMouseReleased(evt);
            }
        });

        jLabel1.setText("Wybrana wartość:");

        jLSelectedValue.setText("50");

        jBReset.setText("Reset");
        jBReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabCon)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSValueSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLSelectedValue)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jBReset)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBCancel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBOK)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jTabCon, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSValueSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBCancel)
                                        .addComponent(jBOK)
                                        .addComponent(jLabel1)
                                        .addComponent(jLSelectedValue)
                                        .addComponent(jBReset))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        frame.pack();
    }// </editor-fold>


    public Thresholding(Image imge,Map<Object, Object> options) {

        imageEdited  = ImageWindow.getLastFocused();
        imageEditedCopy = imageEdited;
        this.frame = new JFrame();
        this.initComponents();
        Histogram hist = new Histogram(imge);
        List<ChartPanel> cpL =  hist._renderFrame(hist._calculateHist(),"Thresholding: " + ImageWindow.getLastFocused().getIcon().getDescription());

        jPTabRed.setLayout(new BorderLayout());
        jPTabGreen.setLayout(new BorderLayout());
        jPTabBlue.setLayout(new BorderLayout());
        jPTabLuminance.setLayout(new BorderLayout());
        jPTabRed.add(cpL.get(0),BorderLayout.NORTH);
        jPTabGreen.add(cpL.get(1),BorderLayout.NORTH);
        jPTabBlue.add(cpL.get(2),BorderLayout.NORTH);
        jPTabLuminance.add(cpL.get(3),BorderLayout.NORTH);
        jPTabRed.setVisible(true);
        jPTabGreen.setVisible(true);
        jPTabBlue.setVisible(true);
        jPTabLuminance.setVisible(true);
        jTabCon.addChangeListener(this);
        jTabCon.setEnabledAt(1,false);
        jTabCon.setEnabledAt(2,false);
        jTabCon.setEnabledAt(3,false);
        jTabCon.setSelectedIndex(0);

        this.img  = imge;
        this.options = options;
        this.run(imge,options);
        this.frame.setVisible(true);

    }

    public Image getImage(){
        return this.img;
    }

    /**
     * zdjęcie obecnie edytowane moze miec tylko jedno okno edycji
     *
     *
     */



    private void jBOKActionPerformed(java.awt.event.ActionEvent evt) {
        frame.dispose();
    }

    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {
        imageEdited.setIcon(imageEditedCopy.getIcon());
        frame.dispose();
    }

    private void jSValueSelectStateChanged(javax.swing.event.ChangeEvent evt) {
        jLSelectedValue.setText(String.valueOf(jSValueSelect.getValue()));
    }

    private void jBResetActionPerformed(java.awt.event.ActionEvent evt) {
        imageEdited.setIcon(imageEditedCopy.getIcon());
    }

    private void jSValueSelectMouseReleased(java.awt.event.MouseEvent evt) {
        LOGGER.info("Mouse released, new value:" + jSValueSelect.getValue());
        jLSelectedValue.setText(String.valueOf(jSValueSelect.getValue()));
        this.run(imageEdited.getIcon().getImage(),options);
        imageEdited.setIcon(new ImageIcon(this.img,imageEditedCopy.getDescription()));
    }

    private void run(Image inputIMG,Map<Object, Object> options){
        LOGGER.info("running");
        int[] pixels = Utils.getPixelArray(inputIMG);

        //y = 0.2989 * R + 0.5870 * G + 0.1140 * B
        for(int i=0; i < pixels.length-1; i++){
            Map<String,Integer> pixel = Utils.pixelValue(pixels[i]);
            int lumin = Math.round((float)0.2989*pixel.get("Red") + (float)0.5870*pixel.get("Green") + (float)0.1140*pixel.get("Blue"));
            if(lumin <= jSValueSelect.getValue()){
                pixel.put("Red",L_MIN);
                pixel.put("Green",L_MIN);
                pixel.put("Blue",L_MIN);
            }else{
                pixel.put("Red",L_MAX);
                pixel.put("Green",L_MAX);
                pixel.put("Blue",L_MAX);
            }
            pixels[i] = Utils.pixelToInt(pixel);
        }
        this.img = Utils.getImageFromArray(pixels,inputIMG.getWidth(null),inputIMG.getHeight(null));

    }



    // Variables declaration - do not modify
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBOK;
    private javax.swing.JButton jBReset;
    private javax.swing.JLabel jLSelectedValue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPTabBlue;
    private javax.swing.JPanel jPTabGreen;
    private javax.swing.JPanel jPTabLuminance;
    private javax.swing.JPanel jPTabRed;
    private javax.swing.JSlider jSValueSelect;
    private javax.swing.JTabbedPane jTabCon;
    // End of variables declaration



    /**
     * Invoked when the target of the listener has changed its state.
     *
     * @param e a ChangeEvent object
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
        int selectedIndex = tabbedPane.getSelectedIndex();
        //JOptionPane.showMessageDialog(null, "Selected Index: " + selectedIndex);
        System.out.println("Selected Index: " + tabbedPane.getTitleAt(tabbedPane.getSelectedIndex()));

        //frame._updateStats(frame._calculateStats(tmoOUT,tabbedPane.getTitleAt(tabbedPane.getSelectedIndex())));

    }


}
