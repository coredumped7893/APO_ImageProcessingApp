/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image.NeighbOP;

/**
 * Klasa bazowa dla wygładzania
 * Definiuje okno dla parametrów
 *
 */
public class BlurAction {

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jBOK = new javax.swing.JButton();
        jBCancel = new javax.swing.JButton();
        jLSize = new javax.swing.JLabel();
        jSSize = new javax.swing.JSlider();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLSigX = new javax.swing.JLabel();
        jLSigY = new javax.swing.JLabel();
        jSSigX = new javax.swing.JSlider();
        jSSigY = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Blur");
        setMinimumSize(new java.awt.Dimension(322, 221));

        jBOK.setText("OK");

        jBCancel.setText("Anuluj");

        jLSize.setText("Size: 5 ");

        jSSize.setMajorTickSpacing(1);
        jSSize.setMaximum(10);
        jSSize.setMinimum(2);
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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BORDER_ISOLATED", "BORDER_REFLECT", "BORDER_REPLICATE" }));

        jLabel1.setText("Piksele brzegowe:");

        jLSigX.setText("Sigma X: 000");

        jLSigY.setText("Sigma Y: 000");

        jSSigX.setMajorTickSpacing(5);
        jSSigX.setMaximum(1000);
        jSSigX.setValue(15);
        jSSigX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSSigXStateChanged(evt);
            }
        });
        jSSigX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSSigXMouseReleased(evt);
            }
        });

        jSSigY.setMajorTickSpacing(5);
        jSSigY.setMaximum(1000);
        jSSigY.setValue(15);
        jSSigY.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSSigYStateChanged(evt);
            }
        });
        jSSigY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSSigYMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jBCancel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBOK)
                                                .addGap(6, 6, 6))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jComboBox1, 0, 173, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLSize)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLSigX)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSSigX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLSigY)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSSigY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGap(6, 6, 6))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLSize)
                                        .addComponent(jSSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLSigX)
                                        .addComponent(jSSigX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLSigY)
                                        .addComponent(jSSigY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBOK)
                                        .addComponent(jBCancel))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void jSSizeMouseReleased(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jSSizeStateChanged(javax.swing.event.ChangeEvent evt) {
        // TODO add your handling code here:
    }

    private void jSSigXMouseReleased(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jSSigXStateChanged(javax.swing.event.ChangeEvent evt) {
        // TODO add your handling code here:
    }

    private void jSSigYMouseReleased(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jSSigYStateChanged(javax.swing.event.ChangeEvent evt) {
        // TODO add your handling code here:
    }



    // Variables declaration - do not modify
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBOK;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLSigX;
    private javax.swing.JLabel jLSigY;
    private javax.swing.JLabel jLSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSlider jSSigX;
    private javax.swing.JSlider jSSigY;
    private javax.swing.JSlider jSSize;
    // End of variables declaration


}


