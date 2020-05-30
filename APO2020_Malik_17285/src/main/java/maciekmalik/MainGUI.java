/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik;

import maciekmalik.Image.CVAction;
import maciekmalik.Image.Histogram;
import maciekmalik.Image.HistogramOP.HistStretch;
import maciekmalik.Image.ImageAction;
import maciekmalik.Image.PointOP.Negation;
import maciekmalik.Image.PointOP.Posterize;
import maciekmalik.Image.PointOP.Thresholding;
import maciekmalik.Image.Utils;
import org.apache.commons.io.FilenameUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
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
        jMInfo = new javax.swing.JMenu();
        jMHistogram = new javax.swing.JMenuItem();
        jMColors = new javax.swing.JMenu();
        jMStreching = new javax.swing.JMenuItem();
        jMEqual = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMNegation = new javax.swing.JMenuItem();
        jMThresholding = new javax.swing.JMenuItem();
        jMPosterize = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMToGrey = new javax.swing.JMenuItem();
        jMFilters = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMBlurNorm = new javax.swing.JMenuItem();
        jMBlurGaussian = new javax.swing.JMenuItem();
        jMMedian = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMShLaplace = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMEDSobel = new javax.swing.JMenuItem();
        jMEDLaplace = new javax.swing.JMenuItem();
        jMEDCanny = new javax.swing.JMenuItem();
        jMPrewitt = new javax.swing.JMenuItem();
        jMUnvLOP = new javax.swing.JMenuItem();
        jMFDual = new javax.swing.JMenuItem();
        jMSkelet = new javax.swing.JMenuItem();
        jMOMorph = new javax.swing.JMenuItem();
        jMAbout = new javax.swing.JMenu();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jMInfo.setText("Info");
        jMInfo.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMInfoMenuSelected(evt);
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
        jMInfo.add(jMHistogram);

        jMenuBar1.add(jMInfo);

        jMColors.setText("Colors");
        jMColors.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMColorsMenuSelected(evt);
            }
        });

        jMStreching.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMStreching.setText("Rozciąganie");
        jMStreching.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMStrechingActionPerformed(evt);
            }
        });
        jMColors.add(jMStreching);

        jMEqual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMEqual.setText("Wyrównanie");
        jMEqual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMEqualActionPerformed(evt);
            }
        });
        jMColors.add(jMEqual);
        jMColors.add(jSeparator5);

        jMNegation.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMNegation.setText("Negacja");
        jMNegation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMNegationActionPerformed(evt);
            }
        });
        jMColors.add(jMNegation);

        jMThresholding.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMThresholding.setText("Progowanie");
        jMThresholding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMThresholdingActionPerformed(evt);
            }
        });
        jMColors.add(jMThresholding);

        jMPosterize.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMPosterize.setText("Posteryzacja");
        jMPosterize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMPosterizeActionPerformed(evt);
            }
        });
        jMColors.add(jMPosterize);
        jMColors.add(jSeparator6);

        jMToGrey.setText("Do skali szarości");
        jMToGrey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMToGreyActionPerformed(evt);
            }
        });
        jMColors.add(jMToGrey);

        jMenuBar1.add(jMColors);

        jMFilters.setText("Filters");
        jMFilters.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMFiltersMenuSelected(evt);
            }
        });

        jMenu1.setText("Rozmywanie");

        jMBlurNorm.setText("Blur");
        jMBlurNorm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMBlurNormActionPerformed(evt);
            }
        });
        jMenu1.add(jMBlurNorm);

        jMBlurGaussian.setText("Gaussian");
        jMBlurGaussian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMBlurGaussianActionPerformed(evt);
            }
        });
        jMenu1.add(jMBlurGaussian);

        jMMedian.setText("Median");
        jMMedian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMMedianActionPerformed(evt);
            }
        });
        jMenu1.add(jMMedian);

        jMFilters.add(jMenu1);

        jMenu3.setText("Wyostrzanie");

        jMShLaplace.setText("Laplace");
        jMShLaplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMShLaplaceActionPerformed(evt);
            }
        });
        jMenu3.add(jMShLaplace);

        jMFilters.add(jMenu3);

        jMenu2.setText("Wyk. Krawędzi");

        jMEDSobel.setText("Sobel");
        jMEDSobel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMEDSobelActionPerformed(evt);
            }
        });
        jMenu2.add(jMEDSobel);

        jMEDLaplace.setText("Laplace");
        jMEDLaplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMEDLaplaceActionPerformed(evt);
            }
        });
        jMenu2.add(jMEDLaplace);

        jMEDCanny.setText("Canny");
        jMEDCanny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMEDCannyActionPerformed(evt);
            }
        });
        jMenu2.add(jMEDCanny);

        jMPrewitt.setText("Prewitt");
        jMPrewitt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMPrewittActionPerformed(evt);
            }
        });
        jMenu2.add(jMPrewitt);

        jMFilters.add(jMenu2);

        jMUnvLOP.setText("Uniwersalna Operacja Liniowa");
        jMUnvLOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMULOPActionPerformed(evt);
            }
        });
        jMFilters.add(jMUnvLOP);

        jMFDual.setText("Filtracja dwu etapowa");
        jMFDual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMFDualActionPerformed(evt);
            }
        });
        jMFilters.add(jMFDual);

        jMSkelet.setText("Szkieletyzacja");
        jMSkelet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMSkeletActionPerformed(evt);
            }
        });
        jMFilters.add(jMSkelet);

        jMOMorph.setText("O. Morfologiczne");
        jMOMorph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMOMorphActionPerformed(evt);
            }
        });
        jMFilters.add(jMOMorph);

        jMenuBar1.add(jMFilters);

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
     * Calculate and Display Histogram for focused frame
     *
     * @param evt ActionEvent
     * @see Histogram
     * @see ImageWindow
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

    private void jMColorsMenuSelected(javax.swing.event.MenuEvent evt) {
        this._checkEnabled();
    }

    private void jMInfoMenuSelected(javax.swing.event.MenuEvent evt) {
        this._checkEnabled();
    }

    private void jMFiltersMenuSelected(javax.swing.event.MenuEvent evt) { this._checkEnabled(); }

    private void jMAboutActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jMSaveActionPerformed(java.awt.event.ActionEvent evt) {
        LOGGER.info("Save");
        try {
            String fN = FilenameUtils.removeExtension(ImageWindow.getLastFocused().getDescription());
            File outputfile = new File("file_"+ fN +".png");
            ImageIO.write((RenderedImage) ImageWindow.getLastFocused().getIcon().getImage(), "png", outputfile);
            JOptionPane.showMessageDialog(this, "Plik zapisany  ٩( ๑╹ ꇴ╹)۶", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Błąd przy zapisywaniu (︶︹︶)", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
        }
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
     * @see Utils#deepCopy(BufferedImage)
     */
    private void jMDuplicateActionPerformed(java.awt.event.ActionEvent evt) {
        LOGGER.info("Duplicating image");
        String title = "CopyOf_" + ImageWindow.getLastFocused().getIcon().getDescription();
        java.awt.EventQueue.invokeLater(() ->
                new ImageWindow(ImageWindow.getLastFocused().getIcon().getImage()).setDescription(title));
        ImageWindow.getLastFocused().getRootPane().setBorder(null);
    }


    /**
     * Okno "O programie"
     *
     * @param evt
     * @see About
     */
    private void jMAboutMenuSelected(javax.swing.event.MenuEvent evt) {
        LOGGER.info("About");
        About.AboutFactory().setVisible(true);
    }


    /**
     * Rozciąganie histogramu
     *
     * @param evt
     */
    private void jMStrechingActionPerformed(java.awt.event.ActionEvent evt) {
        ImageAction.run("Stretching", ImageWindow.getLastFocused().getIcon().getImage(), new HashMap<>());
    }

    private void jMEqualActionPerformed(java.awt.event.ActionEvent evt) {
        //@TODO
    }

    /**
     * Negacja
     *
     * @param evt
     * @see ImageAction
     * @see Negation
     */
    private void jMNegationActionPerformed(java.awt.event.ActionEvent evt) {
       ImageAction.run("Negation", ImageWindow.getLastFocused().getIcon().getImage(), new HashMap<>());
    }

    /**
     * Progowanie; operacje na pixelach są robione na obecnie zaznaczonym obrazie
     *
     * @param evt
     * @see ImageWindow#getLastFocused()
     * @see ImageAction
     * @see Thresholding
     */
    private void jMThresholdingActionPerformed(java.awt.event.ActionEvent evt) {
        ImageAction.run("Thresholding", ImageWindow.getLastFocused().getIcon().getImage(), new HashMap<>());
    }

    private void jMPosterizeActionPerformed(java.awt.event.ActionEvent evt) {
        ImageAction.run("Posterizing", ImageWindow.getLastFocused().getIcon().getImage(), new HashMap<>());
    }

    private void jMBlurNormActionPerformed(java.awt.event.ActionEvent evt) {
        ImageAction.run("Blur", ImageWindow.getLastFocused().getIcon().getImage(), new HashMap<>());
    }

    private void jMBlurGaussianActionPerformed(java.awt.event.ActionEvent evt) {
        ImageAction.run("BlurGaussian", ImageWindow.getLastFocused().getIcon().getImage(), new HashMap<>());
    }

    private void jMEDSobelActionPerformed(java.awt.event.ActionEvent evt) {
        ImageAction.run("Sobel", ImageWindow.getLastFocused().getIcon().getImage(), new HashMap<>());
    }

    private void jMEDLaplaceActionPerformed(java.awt.event.ActionEvent evt) {
        ImageAction.run("Laplacian", ImageWindow.getLastFocused().getIcon().getImage(), new HashMap<>());
    }

    private void jMEDCannyActionPerformed(java.awt.event.ActionEvent evt) {
        ImageAction.run("Canny", ImageWindow.getLastFocused().getIcon().getImage(), new HashMap<>());
    }

    private void jMPrewittActionPerformed(java.awt.event.ActionEvent evt) {
        ImageAction.run("Prewitt", ImageWindow.getLastFocused().getIcon().getImage(), new HashMap<>());
    }

    private void jMMedianActionPerformed(java.awt.event.ActionEvent evt) {
        ImageAction.run("Median", ImageWindow.getLastFocused().getIcon().getImage(), new HashMap<>());
    }

    private void jMShLaplaceActionPerformed(java.awt.event.ActionEvent evt) {
        ImageAction.run("SharpLaplace", ImageWindow.getLastFocused().getIcon().getImage(), new HashMap<>());
    }

    private void jMULOPActionPerformed(java.awt.event.ActionEvent evt) {
        ImageAction.run("UniversalLOP", ImageWindow.getLastFocused().getIcon().getImage(), new HashMap<>());
    }

    private void jMFDualActionPerformed(java.awt.event.ActionEvent evt) {
        ImageAction.run("DualAction", ImageWindow.getLastFocused().getIcon().getImage(), new HashMap<>());
    }

    private void jMSkeletActionPerformed(java.awt.event.ActionEvent evt) {
        ImageAction.run("Skeleton", ImageWindow.getLastFocused().getIcon().getImage(), new HashMap<>());
    }

    private void jMToGreyActionPerformed(java.awt.event.ActionEvent evt) {
        ImageAction.run("ToGrey", ImageWindow.getLastFocused().getIcon().getImage(), new HashMap<>());
    }

    private void jMOMorphActionPerformed(java.awt.event.ActionEvent evt) {
        ImageAction.run("BasicMorph", ImageWindow.getLastFocused().getIcon().getImage(), new HashMap<>());
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
            jMSaveAs.setEnabled(false);//@TODO
            jMDuplicate.setEnabled(false);
            jMStreching.setEnabled(false);
            jMEqual.setEnabled(false);
            jMNegation.setEnabled(false);
            jMThresholding.setEnabled(false);
            jMPosterize.setEnabled(false);
            jMSave.setEnabled(false);
            jMBlurNorm.setEnabled(false);
            jMBlurGaussian.setEnabled(false);
            jMEDCanny.setEnabled(false);
            jMEDLaplace.setEnabled(false);
            jMEDSobel.setEnabled(false);
            jMPrewitt.setEnabled(false);
            jMMedian.setEnabled(false);
            jMShLaplace.setEnabled(false);
            jMUnvLOP.setEnabled(false);
            jMFDual.setEnabled(false);
            jMSkelet.setEnabled(false);
            jMToGrey.setEnabled(false);
            jMOMorph.setEnabled(false);
        }else{
            jMHistogram.setEnabled(true);
            jMSave.setEnabled(true);
            //jMSaveAs.setEnabled(true);//@TODO
            jMDuplicate.setEnabled(true);
            jMStreching.setEnabled(true);
            //jMEqual.setEnabled(true);//@TODO
            jMNegation.setEnabled(true);
            jMThresholding.setEnabled(true);
            jMPosterize.setEnabled(true);
            jMBlurNorm.setEnabled(true);
            jMBlurGaussian.setEnabled(true);
            jMEDCanny.setEnabled(true);
            jMEDLaplace.setEnabled(true);
            jMEDSobel.setEnabled(true);
            jMPrewitt.setEnabled(true);
            jMMedian.setEnabled(true);
            jMShLaplace.setEnabled(true);
            jMUnvLOP.setEnabled(true);
            jMFDual.setEnabled(true);
            jMSkelet.setEnabled(true);
            jMToGrey.setEnabled(true);
            jMOMorph.setEnabled(true);
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
                    (new ImageWindow(chooser.getSelectedFile().getAbsolutePath()))
                            .setDescription(chooser.getSelectedFile().getName()) );

        }else{
            //Cancel - NOP
        }


    }

    // Variables declaration - do not modify
    private javax.swing.JMenu jMAbout;
    private javax.swing.JMenuItem jMBlurGaussian;
    private javax.swing.JMenuItem jMBlurNorm;
    private javax.swing.JMenu jMColors;
    private javax.swing.JMenuItem jMDuplicate;
    private javax.swing.JMenuItem jMEDCanny;
    private javax.swing.JMenuItem jMEDLaplace;
    private javax.swing.JMenuItem jMEDSobel;
    private javax.swing.JMenuItem jMEqual;
    private javax.swing.JMenuItem jMExit;
    private javax.swing.JMenuItem jMFDual;
    private javax.swing.JMenu jMFile;
    private javax.swing.JMenu jMFilters;
    private javax.swing.JMenuItem jMHistogram;
    private javax.swing.JMenu jMInfo;
    private javax.swing.JMenuItem jMMedian;
    private javax.swing.JMenuItem jMNegation;
    private javax.swing.JMenuItem jMOMorph;
    private javax.swing.JMenuItem jMOpenFile;
    private javax.swing.JMenuItem jMPosterize;
    private javax.swing.JMenuItem jMPrewitt;
    private javax.swing.JMenuItem jMSave;
    private javax.swing.JMenuItem jMSaveAs;
    private javax.swing.JMenuItem jMShLaplace;
    private javax.swing.JMenuItem jMSkelet;
    private javax.swing.JMenuItem jMStreching;
    private javax.swing.JMenuItem jMThresholding;
    private javax.swing.JMenuItem jMToGrey;
    private javax.swing.JMenuItem jMUnvLOP;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    // End of variables declaration

}
