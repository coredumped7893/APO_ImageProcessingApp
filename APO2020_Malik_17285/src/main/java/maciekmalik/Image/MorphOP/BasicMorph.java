/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image.MorphOP;

import maciekmalik.Image.CVAction;
import maciekmalik.Image.Utils;
import maciekmalik.ImageWindow;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class BasicMorph extends CVAction {


    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCBordertype = new javax.swing.JComboBox<>();
        jLSize = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jCSElement = new javax.swing.JComboBox<>();
        jBCancel = new javax.swing.JButton();
        jBOK = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jCOperationType = new javax.swing.JComboBox<>();
        jLIterations = new javax.swing.JLabel();
        jSIterations = new javax.swing.JSlider();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Piksele brzegowe:");

        jCBordertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BORDER_DEFAULT", "BORDER_ISOLATED", "BORDER_REFLECT", "BORDER_REPLICATE" }));
        jCBordertype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBordertypeActionPerformed(evt);
            }
        });

        jLSize.setText("Rozmiar [3x3]:");

        jSlider1.setMajorTickSpacing(2);
        jSlider1.setMaximum(21);
        jSlider1.setMinimum(3);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setToolTipText("");
        jSlider1.setValue(3);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jSlider1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSlider1MouseReleased(evt);
            }
        });

        jLabel2.setText("Element Strukturalny:");

        jCSElement.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kwadrat", "Romb" }));
        jCSElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCSElementActionPerformed(evt);
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

        jLabel3.setText("Typ Operacji:");

        jCOperationType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Erozja", "Dylatacja", "Otwarcie", "Zamknięcie" }));
        jCOperationType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCOperationTypeActionPerformed(evt);
            }
        });

        jLIterations.setText("Iteracje [1]:");

        jSIterations.setMajorTickSpacing(1);
        jSIterations.setMaximum(20);
        jSIterations.setPaintTicks(true);
        jSIterations.setSnapToTicks(true);
        jSIterations.setValue(1);
        jSIterations.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSIterationsStateChanged(evt);
            }
        });
        jSIterations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSIterationsMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLSize)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCBordertype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jBCancel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBOK))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLIterations)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSIterations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCSElement, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCOperationType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCBordertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLSize)
                                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLIterations)
                                        .addComponent(jSIterations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jCSElement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jCOperationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBOK)
                                        .addComponent(jBCancel))
                                .addContainerGap())
        );

        frame.pack();
    }// </editor-fold>



    public BasicMorph(Image imge) {
        initComponents();
        imageEdited = ImageWindow.getLastFocused();
        jCBordertype.setEnabled(false);
        imageEditedCopy = imageEdited;
        imageEditedMat  = CVAction.bufferedImg2Mat(Utils.toBufferedImage(imageEdited.getIcon().getImage()));

        /*
         * Konwertowanie na obraz szaroodcieniowy, 1 kanałowy
         * Domyślnie przy ładowaniu obraz wczytywany jest jako RGB 3 kanałowy
         */
        Imgproc.cvtColor(imageEditedMat,imageEditedMat,Imgproc.COLOR_RGB2GRAY);

        imageEditedMat.copyTo(imageEditedMatCopy);
        this.img  = imge;
        frame.setVisible(true);
        this.run(this.img);
        imageEdited.setIcon(new ImageIcon(img,imageEditedCopy.getDescription()));
    }

    @Override
    protected void run(Image imge) {
        LOGGER.warning("BasicMorph:run");
        imageEditedMatCopy.copyTo(imageEditedMat);//Restore previous data
        Mat kernel;
        //Square
        if(jCSElement.getSelectedIndex() == 0){
            kernel = Imgproc.getStructuringElement
                    (Imgproc.MORPH_RECT,new Size(jSlider1.getValue(),jSlider1.getValue()));
        }else{
            kernel = _getRomb(jSlider1.getValue());
        }

        if(jCOperationType.getSelectedIndex() == 0){
            //Erozja
            Imgproc.erode(imageEditedMat,imageEditedMat,kernel,new Point(-1,-1),jSIterations.getValue());
        }else if(jCOperationType.getSelectedIndex() == 1){
            //Dylatacja
            Imgproc.dilate(imageEditedMat,imageEditedMat,kernel,new Point(-1,-1),jSIterations.getValue());
        }else if(jCOperationType.getSelectedIndex() == 2){
            //Otwarcie
            Imgproc.morphologyEx(imageEditedMat,imageEditedMat,Imgproc.MORPH_OPEN,kernel,new Point(-1,-1),jSIterations.getValue());
        }else if(jCOperationType.getSelectedIndex() == 3){
            //Zamkniecie
            Imgproc.morphologyEx(imageEditedMat,imageEditedMat,Imgproc.MORPH_CLOSE,kernel,new Point(-1,-1),jSIterations.getValue());
        }
        this.img = CVAction.mat2BufferedImg(imageEditedMat,img.getWidth(frame),img.getHeight(frame));
        imageEdited.setIcon(new ImageIcon(img,imageEditedCopy.getDescription()));
    }

    /**
     * Zmiana warunku brzegowego pikseli
     * @param evt
     */
    private void jCBordertypeActionPerformed(java.awt.event.ActionEvent evt) {
        this.run(this.img);
    }

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {
        jLSize.setText("Rozmiar ["+ jSlider1.getValue() +"x"+ jSlider1.getValue() +"]:");
    }

    private void jSlider1MouseReleased(java.awt.event.MouseEvent evt) {
        this.run(this.img);
    }

    /**
     * Wybór elementu strukturalnego
     * @param evt
     */
    private void jCSElementActionPerformed(java.awt.event.ActionEvent evt) {
        this.run(this.img);
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

    private void jCOperationTypeActionPerformed(java.awt.event.ActionEvent evt) {
        this.run(this.img);
    }

    private void jSIterationsMouseReleased(java.awt.event.MouseEvent evt) {
        this.run(this.img);
    }

    private void jSIterationsStateChanged(javax.swing.event.ChangeEvent evt) {
        jLIterations.setText("Iteracje ["+jSIterations.getValue()+"]");
    }

    /**
     * Generowanie rombu dla opencv
     *
     * @param size
     */
    private static Mat _getRomb(int size){
        Mat out = new Mat(size,size, CvType.CV_8U);
        size = (size / 2) + 1;
        int spaces,j,i,col,row=0;
        for(i=1;i<=size;i++) {
            col=0;
            for(spaces=size-i;spaces>0;spaces--) {
                //System.out.print("{["+row+':'+col+"]0}");
                System.out.print("0");
                out.put(row,col,0);
                col++;
            }
            int jj = i;
            for(j=2*i-1;j>0;j--){
                //System.out.print("{["+row+':'+col+"]1}");
                System.out.print("1");
                out.put(row,col,1);
                col++;
            }
            for(spaces=size-jj;spaces>0;spaces--) {
                //System.out.print("{["+row+':'+col+"]0}");
                System.out.print("0");
                out.put(row,col,0);
                col++;
            }
            System.out.print('\n');
            row++;
        }
        for(i=size-1;i>0;i--) {
            col=0;
            for(spaces=0;spaces<size-i;spaces++) {
                //System.out.print("{["+row+':'+col+"]0}");
                System.out.print("0");
                out.put(row,col,0);
                col++;
            }
            int jj = i;
            for(j=0;j<2*i-1;j++){
                //System.out.print("{["+row+':'+col+"]1}");
                System.out.print("1");
                out.put(row,col,1);
                col++;
            }
            for(spaces=size-jj;spaces>0;spaces--) {
                //System.out.print("{["+row+':'+col+"]0}");
                System.out.print("0");
                out.put(row,col,0);
                col++;
            }
            System.out.print('\n');
            row++;
        }
        return out;
    }


    private static final Map<Integer, Integer> shape = new HashMap<Integer, Integer>(){
        {
            put(0,Imgproc.MORPH_RECT);
            put(1,Imgproc.MORPH_ELLIPSE);
        }
    };


    // Variables declaration - do not modify
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBOK;
    protected javax.swing.JComboBox<String> jCBordertype;
    private javax.swing.JComboBox<String> jCOperationType;
    private javax.swing.JComboBox<String> jCSElement;
    private javax.swing.JLabel jLIterations;
    private javax.swing.JLabel jLSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSlider jSIterations;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration
}
