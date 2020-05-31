/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image.PointOP;

import maciekmalik.Image.BaseAction;
import maciekmalik.Image.CVAction;
import maciekmalik.Image.Histogram;
import maciekmalik.Image.Utils;
import maciekmalik.ImageWindow;
import org.jfree.chart.ChartPanel;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.List;

public class AdaptiveThresholding extends CVAction implements ChangeListener {


    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTabCon = new javax.swing.JTabbedPane();
        jPTabLuminance = new javax.swing.JPanel();
        jPTabRed = new javax.swing.JPanel();
        jPTabGreen = new javax.swing.JPanel();
        jPTabBlue = new javax.swing.JPanel();
        jBOK = new javax.swing.JButton();
        jBCancel = new javax.swing.JButton();
        jSMaxValue = new javax.swing.JSlider();
        jLMaxValue = new javax.swing.JLabel();
        jBReset = new javax.swing.JButton();
        jLSize = new javax.swing.JLabel();
        jSSize = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jCMethod = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jCType = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jSConstMinus = new javax.swing.JSlider();

        jLabel2.setText("jLabel2");

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jSMaxValue.setMajorTickSpacing(1);
        jSMaxValue.setMaximum(255);
        jSMaxValue.setToolTipText("");
        jSMaxValue.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSMaxValueStateChanged(evt);
            }
        });
        jSMaxValue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSMaxValueMouseReleased(evt);
            }
        });

        jLMaxValue.setText("Wybrana max. wartość [255]:");

        jBReset.setText("Reset");
        jBReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBResetActionPerformed(evt);
            }
        });

        jLSize.setText("Rozmiar bloku [11]:");

        jSSize.setMajorTickSpacing(2);
        jSSize.setMaximum(99);
        jSSize.setMinimum(3);
        jSSize.setPaintTicks(true);
        jSSize.setSnapToTicks(true);
        jSSize.setToolTipText("");
        jSSize.setValue(11);
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

        jLabel3.setText("Metoda:");

        jCMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADAPTIVE_THRESH_MEAN_C", "ADAPTIVE_THRESH_GAUSSIAN_C" }));
        jCMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCMethodActionPerformed(evt);
            }
        });

        jLabel4.setText("Typ progowania:");

        jCType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "THRESH_BINARY", "THRESH_BINARY_INV" }));
        jCType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTypeActionPerformed(evt);
            }
        });

        jLabel5.setText("Stała odejmowana [5]:");

        jSConstMinus.setMajorTickSpacing(1);
        jSConstMinus.setMaximum(254);
        jSConstMinus.setSnapToTicks(true);
        jSConstMinus.setValue(5);
        jSConstMinus.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSConstMinusStateChanged(evt);
            }
        });
        jSConstMinus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSConstMinusMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabCon)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSMaxValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jBReset)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBCancel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBOK))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLSize)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCMethod, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLMaxValue)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSConstMinus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jTabCon, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSMaxValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLMaxValue)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLSize)
                                        .addComponent(jSSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jCMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jCType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(jSConstMinus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBOK)
                                        .addComponent(jBCancel)
                                        .addComponent(jBReset))
                                .addContainerGap())
        );

        frame.pack();
    }// </editor-fold>


    public AdaptiveThresholding(Image imge) {
        this.frame = new JFrame();
        this.initComponents();
        imageEdited  = ImageWindow.getLastFocused();
        //System.out.println("Last Focused:" + imageEdited.getDescription());
        imageEditedCopy = imageEdited;
        jSMaxValue.setValue(255);

        Histogram hist = new Histogram(imge);
        List<ChartPanel> cpL =  hist.renderFrame(hist.calculateHist(),"Thresholding: " + ImageWindow.getLastFocused().getIcon().getDescription());

        imageEditedMat  = CVAction.bufferedImg2Mat(Utils.toBufferedImage(imageEdited.getIcon().getImage()));

        /*
         * Konwertowanie na obraz szaroodcieniowy, 1 kanałowy
         * Domyślnie przy ładowaniu obraz wczytywany jest jako RGB 3 kanałowy
         */
        Imgproc.cvtColor(imageEditedMat,imageEditedMat,Imgproc.COLOR_RGB2GRAY);

        imageEditedMat.copyTo(imageEditedMatCopy);

        jPTabLuminance.setLayout(new BorderLayout());
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
        this.run(imge);
        this.frame.setVisible(true);
        imageEdited.setIcon(new ImageIcon(this.img,imageEditedCopy.getDescription()));

    }

    @Override
    protected void run(Image imge) {
        LOGGER.warning("AdaptiveThresholding:run");
        imageEditedMatCopy.copyTo(imageEditedMat);//Restore previous data

        //javadoc: adaptiveThreshold(src, dst, maxValue, adaptiveMethod, thresholdType, blockSize, C)
        Imgproc.adaptiveThreshold(imageEditedMat,imageEditedMat,
                jSMaxValue.getValue(),
                adaptiveMethod.get(jCMethod.getSelectedItem().toString()),
                thresholdingTypes.get(jCType.getSelectedItem().toString()),
                jSSize.getValue(),
                jSConstMinus.getValue());

        //Set image preview
        this.img = CVAction.mat2BufferedImg(imageEditedMat,img.getWidth(frame),img.getHeight(frame));

        this._updateHist();

        imageEdited.setIcon(new ImageIcon(img,imageEditedCopy.getDescription()));
    }


    private void _updateHist(){
        //Update histogram view ------------------------------------
        Histogram hist = new Histogram(this.img);
        List<ChartPanel> cpL =  hist.renderFrame(hist.calculateHist(),
                "Thresholding: " + ImageWindow.getLastFocused().getIcon().getDescription());
        jPTabLuminance.removeAll();
        jPTabLuminance.add(cpL.get(3),BorderLayout.NORTH);
        jPTabLuminance.revalidate();
        jTabCon.revalidate();
        //END update histogramn view -------------------------------
    }

    private void jSMaxValueStateChanged(javax.swing.event.ChangeEvent evt) {
        jLMaxValue.setText("Wybrana max. wartość ["+jSMaxValue.getValue()+"]:");
    }

    /**
     * Zmiana wartości progu
     *
     * @param evt
     */
    private void jSMaxValueMouseReleased(java.awt.event.MouseEvent evt) {
        this.run(this.img);
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
     * Anuluj zmiany, przywróć początkowy obraz
     * @param evt
     */
    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {
        imageEdited.setIcon(imageEditedCopy.getIcon());
        frame.dispose();
    }

    /**
     * Resetowanie działań do początkowego obrazu
     * @param evt
     */
    private void jBResetActionPerformed(java.awt.event.ActionEvent evt) {
        imageEdited.setIcon(imageEditedCopy.getIcon());
        this.img = imageEditedCopy.getIcon().getImage();
        this._updateHist();
    }

    /**
     * Zmiana stałej odejmowanej od średniej
     * @param evt
     */
    private void jSConstMinusMouseReleased(java.awt.event.MouseEvent evt) {
        this.run(this.img);
    }

    private void jSConstMinusStateChanged(javax.swing.event.ChangeEvent evt) {
        jLabel5.setText("Stała odejmowana ["+jSConstMinus.getValue()+"]:");
    }

    /**
     * Zmiana wielkości bloku
     * @param evt
     */
    private void jSSizeMouseReleased(java.awt.event.MouseEvent evt) {
        this.run(this.img);
    }

    private void jSSizeStateChanged(javax.swing.event.ChangeEvent evt) {
        jLSize.setText("Rozmiar bloku ["+jSSize.getValue()+"]:");
    }

    /**
     * Zmiana sposobu liczenia progu: średnia/średnia ważona
     * @param evt
     */
    private void jCMethodActionPerformed(java.awt.event.ActionEvent evt) {
        this.run(this.img);
    }

    /**
     * Typ progowania: wprost/z inwersją
     * @param evt
     */
    private void jCTypeActionPerformed(java.awt.event.ActionEvent evt) {
        this.run(this.img);
    }


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

    // Variables declaration - do not modify
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBOK;
    private javax.swing.JButton jBReset;
    private javax.swing.JComboBox<String> jCMethod;
    private javax.swing.JComboBox<String> jCType;
    private javax.swing.JLabel jLMaxValue;
    private javax.swing.JLabel jLSize;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPTabBlue;
    private javax.swing.JPanel jPTabGreen;
    private javax.swing.JPanel jPTabLuminance;
    private javax.swing.JPanel jPTabRed;
    private javax.swing.JSlider jSConstMinus;
    private javax.swing.JSlider jSMaxValue;
    private javax.swing.JSlider jSSize;
    private javax.swing.JTabbedPane jTabCon;
    // End of variables declaration

}
