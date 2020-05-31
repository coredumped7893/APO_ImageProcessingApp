/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image.MorphOP;

import maciekmalik.Image.CVAction;
import maciekmalik.Image.Utils;
import maciekmalik.ImageWindow;
import org.opencv.core.*;
import org.opencv.core.Point;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Wyznaczanie szkieletów obrazów binarnych
 */
public class Skeleton extends CVAction {



    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jBCancel = new javax.swing.JButton();
        jBOK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jCBordertype = new javax.swing.JComboBox<>();
        jLSize = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jCSElement = new javax.swing.JComboBox<>();
        jLProgress = new javax.swing.JLabel();
        jPProgress = new javax.swing.JProgressBar();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel1.setText("Piksele brzegowe:");

        jCBordertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BORDER_DEFAULT", "BORDER_ISOLATED", "BORDER_REFLECT", "BORDER_REPLICATE" }));
        jCBordertype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBordertypeActionPerformed(evt);
            }
        });

        jLSize.setText("Rozmiar [3x3]:");

        jSlider1.setMajorTickSpacing(1);
        jSlider1.setMaximum(11);
        jSlider1.setMinimum(2);
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

        jCSElement.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kwadrat", "Prostokąt(2xROZMIAR)", "Elipsa", "Krzyż" }));
        jCSElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCSElementActionPerformed(evt);
            }
        });

        jLProgress.setText("Postępy [0/000000]:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jBCancel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBOK))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCBordertype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLSize)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCSElement, 0, 1, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLProgress)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jPProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCBordertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLSize)
                                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jCSElement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLProgress)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBOK)
                                        .addComponent(jBCancel))
                                .addContainerGap())
        );

        frame.pack();
    }// </editor-fold>

    public Skeleton(Image imge) {
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
        LOGGER.warning("SharpenLaplace:run");
        imageEditedMatCopy.copyTo(imageEditedMat);//Restore previous data

        Mat kernel = Imgproc.getStructuringElement
                (shape.get(jCSElement.getSelectedIndex()),new Size(jSlider1.getValue(),jSlider1.getValue()));


        Mat baseSkeleton = new Mat(imge.getHeight(null),imge.getWidth(null), CvType.CV_8UC1,new Scalar(0));
        Mat tmpCopy = new Mat();
        Mat imgOpened = new Mat();
        Mat imgSub = new Mat();
        imageEditedMat.copyTo(tmpCopy);
        //imageEditedMat.copyTo(imgOpened);
        int count = 0;
        int size = imageEditedMat.rows() * imageEditedMat.cols();
        jPProgress.setMaximum(size);

        LOGGER.info("imageEditedMat: " + imageEditedMat.channels());
        LOGGER.info("baseSkeleton: " + baseSkeleton.channels());
        LOGGER.info("imageEditedMatCopy: " + imageEditedMatCopy.channels());

        while(true){

            /*
             * morphologyEx(Mat src, Mat dst, int op, Mat kernel, Point anchor, int iterations, int borderType, Scalar borderValue)
             * nie można podać Bordertype bo potrzeba też BorderValue, morphologyDefaultBorderValue() nie jest mapowane do javy
             *
             * Otwarcie na obiekcie oryginalnym
             */
            Imgproc.morphologyEx(tmpCopy,imgOpened,Imgproc.MORPH_OPEN,kernel);

            //Odjęcie powyższego wyniku od obrazu oryginalnego
            Core.subtract(tmpCopy,imgOpened,imgSub);

            //Erozja
            Imgproc.erode(tmpCopy,tmpCopy,kernel);

            //Aktualizacja szkieletu
            Core.bitwise_or(baseSkeleton,imgSub,baseSkeleton);

            //Informacja o postepach
            if((count % 1000) == 0){
                LOGGER.warning("Count: " + count + " Size: " + size);
                jLProgress.setText("Postępy ["+count+"/"+size+"]:");
                jPProgress.setValue(count);
            }

            //Przerwij pętlę jeśli nie ma już obiektów w obrazie lub jeżeli przekroczymy max liczbe wykonań
            if(Core.countNonZero(tmpCopy) == 0 || count > size){
                break;
            }
            ++count;

        }

        this.img = CVAction.mat2BufferedImg(baseSkeleton,img.getWidth(frame),img.getHeight(frame));
        imageEdited.setIcon(new ImageIcon(img,imageEditedCopy.getDescription()));

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
     * Zmiana warunku brzegowego pikseli
     * @param evt
     */
    private void jCBordertypeActionPerformed(java.awt.event.ActionEvent evt) {
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
     * Zmiana rozmiaru E.S.
     * @param evt
     */
    private void jSlider1MouseReleased(java.awt.event.MouseEvent evt) {
        this.run(this.img);
    }

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {
        jLSize.setText("Rozmiar ["+ jSlider1.getValue() +"x"+ jSlider1.getValue() +"]:");
    }


    /**
     * Statyczna lista dostępnych kształtóœ
     */
    private static final Map<Integer, Integer> shape = new HashMap<Integer, Integer>(){
        {
            put(0,Imgproc.MORPH_RECT);
            put(1,Imgproc.MORPH_RECT);
            put(2,Imgproc.MORPH_ELLIPSE);
            put(3,Imgproc.MORPH_CROSS);
        }
    };


    // Variables declaration - do not modify
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBOK;
    protected javax.swing.JComboBox<String> jCBordertype;
    private javax.swing.JComboBox<String> jCSElement;
    private javax.swing.JLabel jLProgress;
    private javax.swing.JLabel jLSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jPProgress;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration

}
