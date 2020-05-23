/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik;

import javax.swing.*;


public class About extends JFrame {

    private About() {
        initComponents();
        this.setAlwaysOnTop(true);
    }

    private static final About instance = new About();
    public static About AboutFactory(){
        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTAbout = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("O Programie");
        setName("aboutFrame"); // NOI18N

        jTAbout.setEditable(false);
        jTAbout.setColumns(10);
        jTAbout.setRows(5);
        jTAbout.setText("Maciek Malik\nAPO 2020\nv.0.13.4\n\n* Histogram\n* Rozciąganie hist.\n* Wyrównanie hist.\n* Negacja\n* Progowanie\n* Posteryzacja\n* Rozmywanie\n    * Blur\n    * Gaussian\n    * Median\n* Wykrywanie krawędzi\n    * Sobel\n    * Laplace\n    * Prewitt\n    * Canny\n\n\n\n\n\n\n\n\n\n\n\n");
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
