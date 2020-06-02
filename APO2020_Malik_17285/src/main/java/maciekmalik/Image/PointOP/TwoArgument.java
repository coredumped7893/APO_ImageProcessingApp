/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image.PointOP;

import maciekmalik.Image.CVAction;
import maciekmalik.Image.Histogram;
import maciekmalik.Image.Utils;
import maciekmalik.ImageWindow;
import org.jfree.chart.ChartPanel;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Operacje dwuargumentowe: dodawanie, mieszanie (blending), operacje logiczne - bitwise AND, OR, NOT,
 * and XOR.
 * Oba argumenty powinny mieć taką samą liczbę kanałów
 */
public class TwoArgument extends CVAction implements ChangeListener, FocusListener {


    private void initComponents() {

        jBReset = new javax.swing.JButton();
        jBCancel = new javax.swing.JButton();
        jBOK = new javax.swing.JButton();
        jTabCon = new javax.swing.JTabbedPane();
        jPTabRed = new javax.swing.JPanel();
        jPTabGreen = new javax.swing.JPanel();
        jPTabBlue = new javax.swing.JPanel();
        jPTabLuminance = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCSizeMatch = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jCOpName = new javax.swing.JComboBox<>();
        jPArgFirst = new javax.swing.JPanel();
        jPArgSecond = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLAlpha = new javax.swing.JLabel();
        jSAlpha = new javax.swing.JSlider();
        jLBeta = new javax.swing.JLabel();
        jSBeta = new javax.swing.JSlider();
        jLGamma = new javax.swing.JLabel();
        jSGamma = new javax.swing.JSlider();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frame.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        frame.addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jBReset.setText("Reset");
        jBReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBResetActionPerformed(evt);
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

        jPTabRed.setPreferredSize(new java.awt.Dimension(403, 313));

        javax.swing.GroupLayout jPTabRedLayout = new javax.swing.GroupLayout(jPTabRed);
        jPTabRed.setLayout(jPTabRedLayout);
        jPTabRedLayout.setHorizontalGroup(
                jPTabRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 498, Short.MAX_VALUE)
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
                        .addGap(0, 498, Short.MAX_VALUE)
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
                        .addGap(0, 498, Short.MAX_VALUE)
        );
        jPTabBlueLayout.setVerticalGroup(
                jPTabBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 366, Short.MAX_VALUE)
        );

        jTabCon.addTab("Blue", jPTabBlue);

        javax.swing.GroupLayout jPTabLuminanceLayout = new javax.swing.GroupLayout(jPTabLuminance);
        jPTabLuminance.setLayout(jPTabLuminanceLayout);
        jPTabLuminanceLayout.setHorizontalGroup(
                jPTabLuminanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 498, Short.MAX_VALUE)
        );
        jPTabLuminanceLayout.setVerticalGroup(
                jPTabLuminanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 366, Short.MAX_VALUE)
        );

        jTabCon.addTab("Luminance", jPTabLuminance);

        jLabel1.setText("Dopasowanie rozmiarów:");

        jCSizeMatch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Resize", "Padding" }));
        jCSizeMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCSizeMatchActionPerformed(evt);
            }
        });

        jLabel2.setText("Typ operacji:");

        jCOpName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dodawanie", "Blending(mieszanie)", "AND", "OR", "XOR" }));
        jCOpName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCOpNameActionPerformed(evt);
            }
        });

        jPArgFirst.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 255, 153), null, null, new java.awt.Color(102, 255, 102)));

        javax.swing.GroupLayout jPArgFirstLayout = new javax.swing.GroupLayout(jPArgFirst);
        jPArgFirst.setLayout(jPArgFirstLayout);
        jPArgFirstLayout.setHorizontalGroup(
                jPArgFirstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPArgFirstLayout.setVerticalGroup(
                jPArgFirstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        jPArgSecond.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 0, 102), null, null, new java.awt.Color(102, 0, 102)));

        javax.swing.GroupLayout jPArgSecondLayout = new javax.swing.GroupLayout(jPArgSecond);
        jPArgSecond.setLayout(jPArgSecondLayout);
        jPArgSecondLayout.setHorizontalGroup(
                jPArgSecondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPArgSecondLayout.setVerticalGroup(
                jPArgSecondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Nie wybrano drugiego obrazu, kliknij na niego i wróć tutaj");

        jLAlpha.setText("Alpha [0.5]:");

        jSAlpha.setMajorTickSpacing(10);
        jSAlpha.setEnabled(false);
        jSAlpha.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSAlphaStateChanged(evt);
            }
        });
        jSAlpha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSAlphaMouseReleased(evt);
            }
        });

        jLBeta.setText("Beta [0.5]:");

        jSBeta.setMajorTickSpacing(10);
        jSBeta.setEnabled(false);
        jSBeta.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSBetaStateChanged(evt);
            }
        });
        jSBeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSBetaMouseReleased(evt);
            }
        });

        jLGamma.setText("Gamma [-100]:");

        jSGamma.setMajorTickSpacing(1);
        jSGamma.setMaximum(255);
        jSGamma.setMinimum(-255);
        jSGamma.setValue(-100);
        jSGamma.setEnabled(false);
        jSGamma.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSGammaStateChanged(evt);
            }
        });
        jSGamma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSGammaMouseReleased(evt);
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
                                                .addComponent(jBReset)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBCancel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBOK))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLGamma)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jSGamma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel2)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jCOpName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jTabCon, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(jPArgSecond, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jPArgFirst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                                .addComponent(jLabel3)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                .addComponent(jLBeta)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jSBeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                .addComponent(jLAlpha)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jSAlpha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                .addComponent(jLabel1)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jCSizeMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGap(0, 0, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jTabCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(jPArgFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPArgSecond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jCSizeMatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jCOpName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLAlpha)
                                        .addComponent(jSAlpha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLBeta)
                                        .addComponent(jSBeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLGamma)
                                        .addComponent(jSGamma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBOK)
                                        .addComponent(jBCancel)
                                        .addComponent(jBReset))
                                .addContainerGap())
        );

        frame.pack();
    }// </editor-fold>

    private ImageWindow secondImg = null;
    private Mat secondImgMat = new Mat();
    private boolean run = true;

    public TwoArgument(Image imge) {

        this.frame = new JFrame();
        this.initComponents();
        jSAlpha.setMaximum(10);
        jSBeta.setMaximum(10);
        this.frame.addFocusListener(this);
        imageEdited  = ImageWindow.getLastFocused();//Pierwszy argument
        //System.out.println("Last Focused:" + imageEdited.getDescription());
        imageEditedCopy = imageEdited;

        Histogram hist = new Histogram(imge);
        List<ChartPanel> cpL =  hist.renderFrame(hist.calculateHist(),"Thresholding: " + ImageWindow.getLastFocused().getIcon().getDescription());

        imageEditedMat  = CVAction.bufferedImg2Mat(Utils.toBufferedImage(imageEdited.getIcon().getImage()));

        this._setIconPanel(jPArgFirst,imageEdited.getIcon().getImage());

//        /*
//         * Konwertowanie na obraz szaroodcieniowy, 1 kanałowy
//         * Domyślnie przy ładowaniu obraz wczytywany jest jako RGB 3 kanałowy
//         */
//        Imgproc.cvtColor(imageEditedMat,imageEditedMat,Imgproc.COLOR_RGB2GRAY);

        imageEditedMat.copyTo(imageEditedMatCopy);

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
//        jTabCon.setEnabledAt(1,false);
//        jTabCon.setEnabledAt(2,false);
//        jTabCon.setEnabledAt(3,false);
        //jTabCon.setSelectedIndex(3);
        jTabCon.repaint();
        jTabCon.revalidate();

        this.img  = imge;
        this.run(imge);
        this.frame.setVisible(true);
        imageEdited.setIcon(new ImageIcon(this.img,imageEditedCopy.getDescription()));

    }

    private void _setIconPanel(JPanel target,Image image){
        JLabel imgLabel = new JLabel();
        target.removeAll();
        imgLabel.setIcon(new ImageIcon(_rescale(target,image)));
        imgLabel.setBounds(0,0,target.getHeight(),target.getHeight());
        target.add(imgLabel,BorderLayout.NORTH);
        imgLabel.revalidate();
        target.repaint();
        target.revalidate();
        this.frame.pack();
        this.frame.revalidate();
    }


    private Image _rescale(JPanel panel,Image image){
        BufferedImage tmpImg = (BufferedImage) image;
        return tmpImg.getScaledInstance(panel.getHeight(),panel.getHeight(),Image.SCALE_SMOOTH);
    }


    @Override
    protected void run(Image imge) {
        if(this.secondImg == null) return; //Drugi obraz nie został wybrany
        jLabel3.setVisible(false);
        LOGGER.warning("BasicMorph:run");
        imageEditedMatCopy.copyTo(imageEditedMat);//Restore previous data

        //Sprawdzanie rozmiarów obu obrazów
        if(
                imge.getWidth(null) != secondImg.getIcon().getImage().getWidth(null) ||
                imge.getHeight(null) != secondImg.getIcon().getImage().getHeight(null)
        ){
            //Obrazy nie mają równych rozmiarów
            if (jCSizeMatch.getSelectedIndex() == 0){
                //Resize second image
                Imgproc.resize(secondImgMat,secondImgMat,new Size(imageEditedMat.cols(),imageEditedMat.rows()));
            }else{
                //Padding
                if(secondImgMat.cols() > imageEditedMat.cols() || secondImgMat.rows() > imageEditedMat.rows()){

//                    JOptionPane.showMessageDialog(frame,
//                            "Drugi obraz musi być mniejszy niż piwerwszy. Użyty zostanie Resize",
//                            "ODarg: Rozmiar obrazu",
//                            JOptionPane.WARNING_MESSAGE);
                    jLabel3.setText("Drugi obraz musi być mniejszy niż piwerwszy. Użyty zostanie Resize");
                    jLabel3.setVisible(true);
                    Imgproc.resize(secondImgMat,secondImgMat,new Size(imageEditedMat.cols(),imageEditedMat.rows()));

                }else{
                    Core.copyMakeBorder(secondImgMat,secondImgMat,0,
                            imageEditedMat.rows()-secondImgMat.rows(),0,
                            imageEditedMat.cols()-secondImgMat.cols(),Core.BORDER_DEFAULT);
                }
            }
        }
        _setSliders(false);
        if(jCOpName.getSelectedIndex() == 0){
            //Dodawanie
            Core.add(imageEditedMat,secondImgMat,imageEditedMat);
        }else if(jCOpName.getSelectedIndex() == 1){
            //Blendowanie
            _setSliders(true);
            Core.addWeighted(imageEditedMat,(float)jSAlpha.getValue()/10,secondImgMat,

                    (float)jSBeta.getValue()/10,jSGamma.getValue(),imageEditedMat);
        }else if(jCOpName.getSelectedIndex() == 2){
            //AND
            Core.bitwise_and(imageEditedMat,secondImgMat,imageEditedMat);
        }else if(jCOpName.getSelectedIndex() == 3){
            //OR
            Core.bitwise_or(imageEditedMat,secondImgMat,imageEditedMat);
        }else if(jCOpName.getSelectedIndex() == 4){
            //XOR
            Core.bitwise_xor(imageEditedMat,secondImgMat,imageEditedMat);
        }

        this.img = CVAction.mat2BufferedImg(imageEditedMat,img.getWidth(frame),img.getHeight(frame));

        this._updateHist();

        this.frame.pack();
        this.frame.revalidate();

        imageEdited.setIcon(new ImageIcon(img,imageEditedCopy.getDescription()));
    }


    private void _setSliders(boolean state){
        jSAlpha.setEnabled(state);
        jSBeta.setEnabled(state);
        jSGamma.setEnabled(state);
    }


    /**
     * Aktualizacja widoku histogramu
     */
    private void _updateHist(){
        //Update histogram view ------------------------------------
        Histogram hist = new Histogram(this.img);
        List<ChartPanel> cpL =  hist.renderFrame(hist.calculateHist(),
                "" + ImageWindow.getLastFocused().getIcon().getDescription());
        jPTabLuminance.removeAll();
        jPTabLuminance.add(cpL.get(3),BorderLayout.NORTH);
        jPTabLuminance.revalidate();

        jPTabRed.removeAll();
        jPTabRed.add(cpL.get(0),BorderLayout.NORTH);
        jPTabRed.revalidate();

        jPTabGreen.removeAll();
        jPTabGreen.add(cpL.get(1),BorderLayout.NORTH);
        jPTabGreen.revalidate();

        jPTabBlue.removeAll();
        jPTabBlue.add(cpL.get(2),BorderLayout.NORTH);
        jPTabBlue.revalidate();

        jTabCon.revalidate();
        //END update histogramn view -------------------------------
    }



    /**
     * Resetowanie zmian do obrazu początkowego
     * @param evt
     */
    private void jBResetActionPerformed(java.awt.event.ActionEvent evt) {
        imageEdited.setIcon(imageEditedCopy.getIcon());
        this.img = imageEditedCopy.getIcon().getImage();
        this._updateHist();
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
     * Wybór metody dopasowania rozmiarów
     * @param evt
     */
    private void jCSizeMatchActionPerformed(java.awt.event.ActionEvent evt) {
        this.run(this.img);
    }


    /**
     * Wybór operacji na obrazach:
     * dodawanie, blending, AND, OR, XOR
     * @param evt
     */
    private void jCOpNameActionPerformed(java.awt.event.ActionEvent evt) {
        this.run(this.img);
    }

    /**
     * @param evt
     * @deprecated
     */
    private void formFocusLost(java.awt.event.FocusEvent evt) {
    }

    /**
     *
     *
     * @see TwoArgument#secondImg
     * @see ImageWindow
     * @param evt
     * @deprecated
     */
    private void formFocusGained(java.awt.event.FocusEvent evt) {
        //LOGGER.warning("F: " + this.img.toString());
    }

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {
        //LOGGER.warning("FWF: " + this.img.toString());
    }

    private void jSAlphaMouseReleased(java.awt.event.MouseEvent evt) {
        this.run(this.img);
    }

    private void jSBetaMouseReleased(java.awt.event.MouseEvent evt) {
        this.run(this.img);
    }

    private void jSGammaMouseReleased(java.awt.event.MouseEvent evt) {
        this.run(this.img);
    }

    private void jSAlphaStateChanged(javax.swing.event.ChangeEvent evt) {
       jLAlpha.setText("Alpha ["+ String.format("%03.1f",(jSAlpha.getValue()/10.0)) +"]:");
    }

    private void jSBetaStateChanged(javax.swing.event.ChangeEvent evt) {
        jLBeta.setText("Beta ["+ String.format("%03.1f",(jSBeta.getValue()/10.0)) +"]:");
    }

    private void jSGammaStateChanged(javax.swing.event.ChangeEvent evt) {
        jLGamma.setText("Gamma ["+ jSGamma.getValue() +"]:");
    }



    private void formWindowActivated(java.awt.event.WindowEvent evt) {
        if(!this._firstActivation){
            if(this.img != ImageWindow.getLastFocused().getIcon().getImage()){
                this.secondImg = ImageWindow.getLastFocused();//Obecnie zaznaczony drugi argument
                secondImgMat  = CVAction.bufferedImg2Mat(Utils.toBufferedImage(secondImg.getIcon().getImage()));
                LOGGER.info("Setting second image to: " + this.secondImg.getDescription());
                this._setIconPanel(jPArgSecond,secondImg.getIcon().getImage());
                jLabel3.setVisible(false);
                this.secondImg.getRootPane()
                        .setBorder(
                                BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(90, 5, 239)));

                if(this.run) this.run(this.img);
            }
        }
        this._firstActivation = false;
    }




    private boolean _firstActivation = true;


    // Variables declaration - do not modify
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBOK;
    private javax.swing.JButton jBReset;
    private javax.swing.JComboBox<String> jCOpName;
    private javax.swing.JComboBox<String> jCSizeMatch;
    private javax.swing.JLabel jLAlpha;
    private javax.swing.JLabel jLBeta;
    private javax.swing.JLabel jLGamma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPArgFirst;
    private javax.swing.JPanel jPArgSecond;
    private javax.swing.JPanel jPTabBlue;
    private javax.swing.JPanel jPTabGreen;
    private javax.swing.JPanel jPTabLuminance;
    private javax.swing.JPanel jPTabRed;
    private javax.swing.JSlider jSAlpha;
    private javax.swing.JSlider jSBeta;
    private javax.swing.JSlider jSGamma;
    private javax.swing.JTabbedPane jTabCon;
    // End of variables declaration

    /**
     * @param e
     * @deprecated
     */
    @Override
    public void stateChanged(ChangeEvent e) {
    }


    /**
     * Sprawdzamy czy wybrany został nowy argument, jeżeli tak, zapisujemy go do pola
     * @param e
     * @deprecated
     */
    @Override
    public void focusGained(FocusEvent e) {

    }

    /**
     * @param e
     * @deprecated
     */
    @Override
    public void focusLost(FocusEvent e) {

    }
}
