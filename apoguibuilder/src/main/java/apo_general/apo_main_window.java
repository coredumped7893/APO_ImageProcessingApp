package apo_general;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author coredumped7893
 */
public class apo_main_window extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public apo_main_window() {
        initComponents();
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
    }// </editor-fold>//GEN-END:initComponents

    private void jMOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMOpenFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMOpenFileActionPerformed

    private void jMHistogramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMHistogramActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMHistogramActionPerformed

    private void jMFileMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMFileMenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_jMFileMenuSelected

    private void jMInfoMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMInfoMenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_jMInfoMenuSelected

    private void jMAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMAboutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMAboutActionPerformed

    private void jMAboutMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMAboutMenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_jMAboutMenuSelected

    private void jMSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMSaveActionPerformed

    private void jMSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMSaveAsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMSaveAsActionPerformed

    private void jMExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMExitActionPerformed

    private void jMDuplicateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMDuplicateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMDuplicateActionPerformed

    private void jMStrechingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMStrechingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMStrechingActionPerformed

    private void jMEqualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMEqualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMEqualActionPerformed

    private void jMNegationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMNegationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMNegationActionPerformed

    private void jMThresholdingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMThresholdingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMThresholdingActionPerformed

    private void jMPosterizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMPosterizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMPosterizeActionPerformed

    private void jMColorsMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMColorsMenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_jMColorsMenuSelected

    private void jMBlurNormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMBlurNormActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMBlurNormActionPerformed

    private void jMBlurGaussianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMBlurGaussianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMBlurGaussianActionPerformed

    private void jMEDSobelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMEDSobelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMEDSobelActionPerformed

    private void jMEDLaplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMEDLaplaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMEDLaplaceActionPerformed

    private void jMEDCannyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMEDCannyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMEDCannyActionPerformed

    private void jMPrewittActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMPrewittActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMPrewittActionPerformed

    private void jMMedianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMMedianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMMedianActionPerformed

    private void jMShLaplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMShLaplaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMShLaplaceActionPerformed

    private void jMULOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMULOPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMULOPActionPerformed

    private void jMFiltersMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMFiltersMenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_jMFiltersMenuSelected

    private void jMFDualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMFDualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMFDualActionPerformed

    private void jMSkeletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMSkeletActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMSkeletActionPerformed

    private void jMToGreyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMToGreyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMToGreyActionPerformed

    private void jMOMorphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMOMorphActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMOMorphActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(apo_main_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(apo_main_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(apo_main_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(apo_main_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new apo_main_window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    // End of variables declaration//GEN-END:variables
}
