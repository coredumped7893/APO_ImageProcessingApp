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
        jMLAB1 = new javax.swing.JMenu();
        jMHistogram = new javax.swing.JMenuItem();
        jMLAB2 = new javax.swing.JMenu();
        jMStreching = new javax.swing.JMenuItem();
        jMEqual = new javax.swing.JMenuItem();
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

        jMLAB2.setText("LAB2");
        jMLAB2.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMLAB2MenuSelected(evt);
            }
        });

        jMStreching.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMStreching.setText("Rozciąganie");
        jMStreching.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMStrechingActionPerformed(evt);
            }
        });
        jMLAB2.add(jMStreching);

        jMEqual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMEqual.setText("Wyrównanie");
        jMEqual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMEqualActionPerformed(evt);
            }
        });
        jMLAB2.add(jMEqual);
        jMLAB2.add(jSeparator5);

        jMNegation.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMNegation.setText("Negacja");
        jMNegation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMNegationActionPerformed(evt);
            }
        });
        jMLAB2.add(jMNegation);

        jMThresholding.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMThresholding.setText("Progowanie");
        jMThresholding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMThresholdingActionPerformed(evt);
            }
        });
        jMLAB2.add(jMThresholding);

        jMPosterize.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMPosterize.setText("Posteryzacja");
        jMPosterize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMPosterizeActionPerformed(evt);
            }
        });
        jMLAB2.add(jMPosterize);

        jMRangeStretch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMRangeStretch.setText("Rozciąganie zakresu");
        jMRangeStretch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMRangeStretchActionPerformed(evt);
            }
        });
        jMLAB2.add(jMRangeStretch);

        jMenuBar1.add(jMLAB2);

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

    private void jMLAB1MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMLAB1MenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_jMLAB1MenuSelected

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

    private void jMRangeStretchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMRangeStretchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMRangeStretchActionPerformed

    private void jMLAB2MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMLAB2MenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_jMLAB2MenuSelected

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
    private javax.swing.JMenuItem jMDuplicate;
    private javax.swing.JMenuItem jMEqual;
    private javax.swing.JMenuItem jMExit;
    private javax.swing.JMenu jMFile;
    private javax.swing.JMenuItem jMHistogram;
    private javax.swing.JMenu jMLAB1;
    private javax.swing.JMenu jMLAB2;
    private javax.swing.JMenu jMLAB3;
    private javax.swing.JMenuItem jMNegation;
    private javax.swing.JMenuItem jMOpenFile;
    private javax.swing.JMenuItem jMPosterize;
    private javax.swing.JMenuItem jMRangeStretch;
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
    // End of variables declaration//GEN-END:variables
}
