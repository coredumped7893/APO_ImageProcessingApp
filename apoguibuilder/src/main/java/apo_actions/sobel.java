/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apo_actions;

/**
 *
 * @author Maciek Malik
 */
public class sobel extends javax.swing.JFrame {

    /**
     * Creates new form sobel
     */
    public sobel() {
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

        jLSize = new javax.swing.JLabel();
        jSSize = new javax.swing.JSlider();
        jBCancel = new javax.swing.JButton();
        jBOK = new javax.swing.JButton();
        jCVertical = new javax.swing.JCheckBox();
        jCHorizontal = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jCBordertype = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLSize.setText("Size: 5 ");

        jSSize.setMajorTickSpacing(2);
        jSSize.setMaximum(31);
        jSSize.setMinimum(1);
        jSSize.setToolTipText("");
        jSSize.setValue(5);
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

        jCVertical.setText("Vertical");
        jCVertical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCVerticalActionPerformed(evt);
            }
        });

        jCHorizontal.setText("Horizontal");
        jCHorizontal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCHorizontalActionPerformed(evt);
            }
        });

        jLabel1.setText("Piksele brzegowe:");

        jCBordertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BORDER_DEFAULT", "BORDER_ISOLATED", "BORDER_REFLECT", "BORDER_REPLICATE" }));
        jCBordertype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBordertypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCVertical)
                    .addComponent(jCHorizontal))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLSize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSSize, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBOK))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBordertype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLSize)
                    .addComponent(jSSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCVertical)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCHorizontal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBordertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBOK)
                    .addComponent(jBCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSSizeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSSizeStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jSSizeStateChanged

    private void jSSizeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSSizeMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jSSizeMouseReleased

    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCancelActionPerformed

    private void jBOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBOKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBOKActionPerformed

    private void jCVerticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCVerticalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCVerticalActionPerformed

    private void jCHorizontalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCHorizontalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCHorizontalActionPerformed

    private void jCBordertypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBordertypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBordertypeActionPerformed

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
            java.util.logging.Logger.getLogger(sobel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sobel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sobel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sobel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sobel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBOK;
    protected javax.swing.JComboBox<String> jCBordertype;
    private javax.swing.JCheckBox jCHorizontal;
    private javax.swing.JCheckBox jCVertical;
    private javax.swing.JLabel jLSize;
    private javax.swing.JLabel jLabel1;
    protected javax.swing.JSlider jSSize;
    // End of variables declaration//GEN-END:variables
}
