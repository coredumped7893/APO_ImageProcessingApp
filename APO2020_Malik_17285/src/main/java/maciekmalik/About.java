/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik;

import javax.swing.*;

public class About extends JFrame {


    public About() {
        initComponents();
        this.setAlwaysOnTop(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTAbout = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("O Programie");
        setName("aboutFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(200, 400));

        jTAbout.setEditable(false);
        jTAbout.setColumns(10);
        jTAbout.setRows(5);
        jTAbout.setText("Maciek Malik\nAPO 2020\nv.0.1\n\n* Histogram\n*\n*\n*\n*\n");
        jTAbout.setToolTipText("");
        jScrollPane1.setViewportView(jTAbout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>



    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAbout;

}
