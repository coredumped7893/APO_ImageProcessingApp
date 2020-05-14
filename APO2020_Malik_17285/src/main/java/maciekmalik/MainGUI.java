/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik;

import maciekmalik.Image.Histogram;
import maciekmalik.Image.ImageAction;
import maciekmalik.Image.PointOP.Negation;
import maciekmalik.Image.PointOP.Thresholding;
import maciekmalik.Image.Utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


public class MainGUI extends JFrame  {

    private static final Logger LOGGER = Logger.getLogger(MainGUI.class.getName());


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    //Generated with NetBeans 11
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMFile = new javax.swing.JMenu();
        jMOpenFile = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMDuplicate = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMSave = new javax.swing.JMenuItem();
        jMSaveAs = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMExit = new javax.swing.JMenuItem();
        jMLAB1 = new javax.swing.JMenu();
        jMHistogram = new javax.swing.JMenuItem();
        jMRozciaganie = new javax.swing.JMenu();
        jMStreching = new javax.swing.JMenuItem();
        jMEqual = new javax.swing.JMenuItem();
        jMEqualization = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMNegation = new javax.swing.JMenuItem();
        jMThresholding = new javax.swing.JMenuItem();
        jMPosterize = new javax.swing.JMenuItem();
        jMRangeStretch = new javax.swing.JMenuItem();
        jMLAB3 = new javax.swing.JMenu();
        jMAbout = new javax.swing.JMenu();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1800, 1000));

        jMFile.setText("Plik");
        jMFile.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMFileMenuSelected(evt);
            }
        });

        jMOpenFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMOpenFile.setText("Otwórz");
        jMOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMOpenFileActionPerformed(evt);
            }
        });
        jMFile.add(jMOpenFile);
        jMFile.add(jSeparator4);

        jMDuplicate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMDuplicate.setText("Duplicate");
        jMDuplicate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMDuplicateActionPerformed(evt);
            }
        });
        jMFile.add(jMDuplicate);
        jMFile.add(jSeparator3);

        jMSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMSave.setText("Save");
        jMSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMSaveActionPerformed(evt);
            }
        });
        jMFile.add(jMSave);

        jMSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMSaveAs.setText("Save As");
        jMSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMSaveAsActionPerformed(evt);
            }
        });
        jMFile.add(jMSaveAs);
        jMFile.add(jSeparator2);

        jMExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMExit.setText("Zamknij");
        jMExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMExitActionPerformed(evt);
            }
        });
        jMFile.add(jMExit);

        jMenuBar1.add(jMFile);

        jMLAB1.setText("LAB1");
        jMLAB1.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMLAB1MenuSelected(evt);
            }
        });

        jMHistogram.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMHistogram.setText("Histogram");
        jMHistogram.setEnabled(false);
        jMHistogram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMHistogramActionPerformed(evt);
            }
        });
        jMLAB1.add(jMHistogram);

        jMenuBar1.add(jMLAB1);

        jMRozciaganie.setText("LAB2");

        jMStreching.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMStreching.setText("Rozciąganie");
        jMStreching.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMStrechingActionPerformed(evt);
            }
        });
        jMRozciaganie.add(jMStreching);

        jMEqual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMEqual.setText("Wyrównanie");
        jMEqual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMEqualActionPerformed(evt);
            }
        });
        jMRozciaganie.add(jMEqual);

        jMEqualization.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMEqualization.setText("Wyrównanie przez equalizacje");
        jMEqualization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMEqualizationActionPerformed(evt);
            }
        });
        jMRozciaganie.add(jMEqualization);
        jMRozciaganie.add(jSeparator5);

        jMNegation.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMNegation.setText("Negacja");
        jMNegation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMNegationActionPerformed(evt);
            }
        });
        jMRozciaganie.add(jMNegation);

        jMThresholding.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMThresholding.setText("Progowanie");
        jMThresholding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMThresholdingActionPerformed(evt);
            }
        });
        jMRozciaganie.add(jMThresholding);

        jMPosterize.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMPosterize.setText("Posteryzacja");
        jMPosterize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMPosterizeActionPerformed(evt);
            }
        });
        jMRozciaganie.add(jMPosterize);

        jMRangeStretch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMRangeStretch.setText("Rozciąganie zakresu");
        jMRangeStretch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMRangeStretchActionPerformed(evt);
            }
        });
        jMRozciaganie.add(jMRangeStretch);

        jMenuBar1.add(jMRozciaganie);

        jMLAB3.setText("LAB3");
        jMLAB3.setEnabled(false);
        jMenuBar1.add(jMLAB3);

        jMAbout.setText("O Programie");
        jMAbout.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMAboutMenuSelected(evt);
            }
        });
        jMAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMAboutActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMAbout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(431, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(148, 148, 148))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>


    /**
     *
     */
    public MainGUI() {

        this.initComponents();

        //Window init - Setting for full screen
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.pack();

    }

    /**
     * @param evt
     */
    private void jMOpenFileActionPerformed(java.awt.event.ActionEvent evt) {
        LOGGER.info("Opening Image");
        this._loadImage();
    }


    /**
     * Calculate & Display Histogram for focused frame
     *
     * @param evt ActionEvent
     */
    private void jMHistogramActionPerformed(java.awt.event.ActionEvent evt) {
        LOGGER.info(evt.getActionCommand());
        LOGGER.info(ImageWindow.getLastFocused().toString());
        LOGGER.info(ImageWindow.getLastFocused().getIcon().getDescription());

        Histogram.HistogramFrameFabric(
            "Histogram:["+ImageWindow.getLastFocused().getIcon().getDescription()+"]",
                ImageWindow.getLastFocused().getIcon().getImage());

    }

    private void jMFileMenuSelected(javax.swing.event.MenuEvent evt) {
        this._checkEnabled();
    }

    private void jMLAB1MenuSelected(javax.swing.event.MenuEvent evt) {
        this._checkEnabled();
    }

    private void jMAboutActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jMSaveActionPerformed(java.awt.event.ActionEvent evt) {
        LOGGER.info("Save");
    }

    private void jMSaveAsActionPerformed(java.awt.event.ActionEvent evt) {
        LOGGER.info("SaveAs");
    }

    private void jMExitActionPerformed(java.awt.event.ActionEvent evt) {
        LOGGER.info("Exiting");
        System.exit(0);
    }

    /**
     * Kopiuje obraz z obecnie zaznaczonej ramki i tworzy nową
     *
     * @param evt
     */
    private void jMDuplicateActionPerformed(java.awt.event.ActionEvent evt) {
        LOGGER.info("Duplicating image");
        String title = "CopyOf_" + ImageWindow.getLastFocused().getIcon().getDescription();
        ImageWindow iw = new ImageWindow(
                (Image) Utils.deepCopy(
                        Utils.toBufferedImage(
                                ImageWindow.getLastFocused().getIcon().getImage())));
        iw.setDescription(title);
    }


    private void jMAboutMenuSelected(javax.swing.event.MenuEvent evt) {
        LOGGER.info("About");
        About.AboutFactory().setVisible(true);
    }


    private void jMStrechingActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jMEqualActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jMEqualizationActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jMNegationActionPerformed(java.awt.event.ActionEvent evt) {
        Negation neg = (Negation) ImageAction.run("Negation", ImageWindow.getLastFocused().getIcon().getImage(), new HashMap<>());
        SwingUtilities.invokeLater(()->
        new ImageWindow(neg.getImage()));
    }

    private void jMThresholdingActionPerformed(java.awt.event.ActionEvent evt) {
        Thresholding neg = (Thresholding) ImageAction.run("Thresholding", ImageWindow.getLastFocused().getIcon().getImage(), new HashMap<>());
//        SwingUtilities.invokeLater(()->
//                new ImageWindow(neg.getImage()));
    }

    private void jMPosterizeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jMRangeStretchActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    /**
     * Sprawdza czy przyciski na pasku menu mogą być aktywowane
     *
     */
    private void _checkEnabled(){
        LOGGER.info("Checking image frames");
        if(ImageWindow.getLastFocused() == null){
            jMHistogram.setEnabled(false);
            jMSave.setEnabled(false);
            jMSaveAs.setEnabled(false);
            jMDuplicate.setEnabled(false);
        }else{
            jMHistogram.setEnabled(true);
            jMSave.setEnabled(true);
            jMSaveAs.setEnabled(true);
            jMDuplicate.setEnabled(true);
        }
    }

    /**
     * Okno wyboru pliku i utworzenie okna z plikiem po jego otwarciu
     */
    private void _loadImage(){
        JFileChooser chooser = new JFileChooser(Paths.get(".").toAbsolutePath().normalize().toString()+"/src/main/java/maciekmalik/Resources"){
            @Override
            protected JDialog createDialog(Component parent) throws HeadlessException {
                // intercept the dialog created by JFileChooser
                JDialog dialog = super.createDialog(parent);
                dialog.setAlwaysOnTop(true); // In case of other imageWindows was opened before
                return dialog;
            }
        };
        //Show only image file extensions
        chooser.addChoosableFileFilter(new FileNameExtensionFilter(
                "Graphics", ImageIO.getReaderFileSuffixes()));
        chooser.setAcceptAllFileFilterUsed(false);

        int t = chooser.showOpenDialog(null);


        if(t == JFileChooser.APPROVE_OPTION){
            //Create new window for selected image
            SwingUtilities.invokeLater(() ->
                    (new ImageWindow(chooser.getSelectedFile().getAbsolutePath())).setDescription(chooser.getSelectedFile().getName()) );
        }else{
            //Cancel - NOP
        }


    }

    private javax.swing.JMenu jMAbout;
    private javax.swing.JMenuItem jMDuplicate;
    private javax.swing.JMenuItem jMEqual;
    private javax.swing.JMenuItem jMEqualization;
    private javax.swing.JMenuItem jMExit;
    private javax.swing.JMenu jMFile;
    private javax.swing.JMenuItem jMHistogram;
    private javax.swing.JMenu jMLAB1;
    private javax.swing.JMenu jMLAB3;
    private javax.swing.JMenuItem jMNegation;
    private javax.swing.JMenuItem jMOpenFile;
    private javax.swing.JMenuItem jMPosterize;
    private javax.swing.JMenuItem jMRangeStretch;
    private javax.swing.JMenu jMRozciaganie;
    private javax.swing.JMenuItem jMSave;
    private javax.swing.JMenuItem jMSaveAs;
    private javax.swing.JMenuItem jMStreching;
    private javax.swing.JMenuItem jMThresholding;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;

}
