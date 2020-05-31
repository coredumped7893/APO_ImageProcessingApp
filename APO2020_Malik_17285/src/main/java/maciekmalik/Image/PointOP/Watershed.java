/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image.PointOP;

import maciekmalik.Image.CVAction;
import maciekmalik.Image.Utils;
import maciekmalik.ImageWindow;
import org.opencv.core.*;
import org.opencv.core.Point;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Watershed extends CVAction {


    private void initComponents() {

        jBCancel = new javax.swing.JButton();
        jBOK = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLObjectNumber = new javax.swing.JLabel();

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

        jCheckBox1.setText("Negatyw przed segmentacja");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLObjectNumber.setText("Liczba obiektów: 000");

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
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jCheckBox1)
                                                        .addComponent(jLObjectNumber))
                                                .addGap(0, 137, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jCheckBox1)
                                .addGap(18, 18, 18)
                                .addComponent(jLObjectNumber)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBOK)
                                        .addComponent(jBCancel))
                                .addContainerGap())
        );

        frame.pack();
    }// </editor-fold>


    public Watershed(Image imge) {
        initComponents();
        imageEdited = ImageWindow.getLastFocused();
        imageEditedCopy = imageEdited;
        imageEditedMat  = CVAction.bufferedImg2Mat(Utils.toBufferedImage(imageEdited.getIcon().getImage()));
        imageEditedMat.copyTo(imageEditedMatCopy);
        this.img  = imge;
        frame.setVisible(true);
        this.run(this.img);
        imageEdited.setIcon(new ImageIcon(img,imageEditedCopy.getDescription()));
    }

    @Override
    protected void run(Image imge) {
        LOGGER.warning("Watershed:run");
        imageEditedMatCopy.copyTo(imageEditedMat);//Restore previous data

        this._watershedVer2();

        this.img = CVAction.mat2BufferedImg(imageEditedMat,img.getWidth(frame),img.getHeight(frame));
        imageEdited.setIcon(new ImageIcon(img,imageEditedCopy.getDescription()));
    }

    /**
     * Metoda z pliku .ipynb
     * @see Imgproc#threshold(Mat, Mat, double, double, int) 
     * @see Imgproc#dilate(Mat, Mat, Mat)
     * @see Imgproc#morphologyEx(Mat, Mat, int, Mat)
     * @see Imgproc#distanceTransform(Mat, Mat, int, int)
     * @see Core#normalize(Mat, Mat)
     * @see Core#multiply(Mat, Mat, Mat)
     * @see Imgproc#watershed(Mat, Mat)
     */
    private void _watershedVer2(){
        Mat img = imageEditedMat.clone();
        Imgproc.cvtColor(img,img,Imgproc.COLOR_RGB2GRAY);

        Imgproc.threshold(img,img,0,255,Imgproc.THRESH_BINARY_INV+Imgproc.THRESH_OTSU);
        Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT,new Size(3,3));

        if(jCheckBox1.isSelected()){
            Core.bitwise_not(img,img);
        }

        Mat opening = new Mat();
        Imgproc.morphologyEx(img,opening,Imgproc.MORPH_OPEN,kernel,new Point(-1,-1),1);
        Mat sure_bg = new Mat();
        Imgproc.dilate(opening,sure_bg,kernel,new Point(-1,-1),1);

        Mat dist_transform = new Mat();
        //javadoc: distanceTransform(src, dst, distanceType, maskSize)
        Imgproc.distanceTransform(opening,dist_transform,Imgproc.DIST_L2,5);
        Core.normalize(dist_transform, dist_transform, 0.0, 1.0, Core.NORM_MINMAX);

        Mat sure_fg = new Mat();
        Imgproc.threshold(dist_transform, sure_fg, 0.5, 1, Imgproc.THRESH_BINARY);
        Core.multiply(sure_fg, new Scalar(255), sure_fg);
        sure_fg.convertTo(sure_fg,CvType.CV_8U);

        Mat unknown = new Mat();
        Core.subtract(sure_bg,sure_fg,unknown);
        unknown.convertTo(unknown,CvType.CV_8UC1);

        Mat markers = new Mat();
        int objects = Imgproc.connectedComponents(sure_fg,markers);
        LOGGER.info("Objects: " + (objects-1)+ " + 1 (tło)");
        jLObjectNumber.setText("Liczba obiektów: "+ (objects-1) + " + 1 (tło)");

        markers.convertTo(markers,CvType.CV_32SC1);


        byte[] unknownData = new byte[(int) (unknown.total() * unknown.channels())];
        int[] markersData = new int[(int) (markers.total() * markers.channels())];
        markers.get(0, 0, markersData);
        unknown.get(0, 0, unknownData);
        for (int row=0;row<markers.rows();row++){
            for(int col=0;col<markers.cols();col++){
                markersData[row * markers.cols() + col] += 1;
                if(unknownData[row * markers.cols() + col] == -1){
                    markersData[row * markers.cols() + col] = 0;
                }
            }
        }
        markers.put(0,0,markersData);

        Imgproc.watershed(imageEditedMatCopy,markers);

        Random r = new Random();
        //Generowanie losowych kolorów dla obiektów
        int maxVal = (int) Core.minMaxLoc(markers).maxVal;
        List<Scalar> colors = new ArrayList<>(maxVal);
        for (int i = 0; i < maxVal; i++) {
            int b = r.nextInt(256);
            int g = r.nextInt(256);
            int rr = r.nextInt(256);
            colors.add(new Scalar(b, g, rr));
        }

        Mat dst = Mat.zeros(markers.size(), CvType.CV_8UC3);
        byte[] dstData = new byte[(int) (dst.total() * dst.channels())];
        dst.get(0, 0, dstData);

        unknownData = new byte[(int) (unknown.total() * unknown.channels())];
        markersData = new int[(int) (markers.total() * markers.channels())];
        markers.get(0, 0, markersData);
        unknown.get(0, 0, unknownData);
        for (int row=0;row<markers.rows();row++){
            for(int col=0;col<markers.cols();col++){
                //System.out.print(" "+markersData[row * markers.cols() + col]);
                int index = markersData[row * markers.cols() + col];
                if(markersData[row * markers.cols() + col] == -1){
                    //Granice obiektów jako biała linia
                    dstData[(row * markers.cols() + col) * 3 + 2] = (byte) ((255));
                    dstData[(row * markers.cols() + col) * 3 + 1] = (byte) ((255));
                    dstData[(row * markers.cols() + col) * 3 + 0] = (byte) ((255));
                }else if(index > 1){
                    //Koloruj środki obiektów
                    dstData[(row * markers.cols() + col) * 3 + 0] = (byte) colors.get(index-1).val[0];
                    dstData[(row * markers.cols() + col) * 3 + 1] = (byte) colors.get(index-1).val[1];
                    dstData[(row * markers.cols() + col) * 3 + 2] = (byte) colors.get(index-1).val[2];
                }else{
                    //Inaczej ustaw tło na czarno
                    dstData[(row * markers.cols() + col) * 3 + 0] = (byte) 0;
                    dstData[(row * markers.cols() + col) * 3 + 1] = (byte) 0;
                    dstData[(row * markers.cols() + col) * 3 + 2] = (byte) 0;
                }
            }
            //System.out.println("");
        }
        markers.put(0,0,markersData);
        dst.put(0,0,dstData);

        dst.copyTo(imageEditedMat);

        //Imgproc.applyColorMap(markers,imageEditedMat,Imgproc.COLORMAP_RAINBOW);

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
     * Neguj obraz gdy zaznaczone
     * @param evt
     */
    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.run(this.img);
    }

    /**
     * Pierwsza wersja
     *
     * @deprecated
     */
    private void _watershedVer1(){

        Mat src = imageEditedMat.clone();

        Mat kernel = new Mat(3, 3, CvType.CV_32F);

        float[] kernelData = new float[(int) (kernel.total() * kernel.channels())];
        kernelData[0] = 1; kernelData[1] = 1; kernelData[2] = 1;
        kernelData[3] = 1; kernelData[4] = -8; kernelData[5] = 1;
        kernelData[6] = 1; kernelData[7] = 1; kernelData[8] = 1;
        kernel.put(0, 0, kernelData);

        Mat kernel2 = Imgproc.getStructuringElement
                (Imgproc.MORPH_RECT,new Size(3,3));

        Mat imgLaplacian = new Mat();
        Imgproc.filter2D(src, imgLaplacian, CvType.CV_32F, kernel);
        //imgLaplacian.convertTo(imgLaplacian,CvType.CV_32F);


        Mat sharp = new Mat();
        src.convertTo(sharp, CvType.CV_32F);
        Mat imgResult = new Mat();
        Core.subtract(sharp, imgLaplacian, imgResult);
        // convert back to 8bits gray scale
        imgResult.convertTo(imgResult, CvType.CV_8UC3);
        imgLaplacian.convertTo(imgLaplacian, CvType.CV_8UC3);
        // Create binary image from source image

        imageEditedMat.copyTo(imgResult);
        Mat bw = new Mat();
        Imgproc.cvtColor(imgResult, bw, Imgproc.COLOR_BGR2GRAY);
        Imgproc.threshold(bw, bw, 0, 255, Imgproc.THRESH_BINARY | Imgproc.THRESH_OTSU);
        Core.bitwise_not(bw,bw);

        Imgproc.morphologyEx(bw,bw,Imgproc.MORPH_OPEN,kernel2,new Point(-1,-1),1);
        //Imgproc.dilate(bw,bw,kernel,new Point(-1,-1),1);
        //bw.copyTo(imageEditedMat);

        // Perform the distance transform algorithm
        Mat dist = new Mat();
        Imgproc.distanceTransform(bw, dist, Imgproc.DIST_L2, 5);
        // Normalize the distance image for range = {0.0, 1.0}
        // so we can visualize and threshold it
        Core.normalize(dist, dist, 0.0, 1.0, Core.NORM_MINMAX);
        Mat distDisplayScaled = new Mat();
        Core.multiply(dist, new Scalar(255), distDisplayScaled);
        Mat distDisplay = new Mat();
        distDisplayScaled.convertTo(distDisplay, CvType.CV_8U);
        // Threshold to obtain the peaks
        // This will be the markers for the foreground objects
        Imgproc.threshold(dist, dist, 0.5, 1.0, Imgproc.THRESH_BINARY);
        // Dilate a bit the dist image
        Mat kernel1 = Mat.ones(3, 3, CvType.CV_8U);
        Imgproc.dilate(dist, dist, kernel1);
        Mat distDisplay2 = new Mat();
        dist.convertTo(distDisplay2, CvType.CV_8U);
        Core.multiply(distDisplay2, new Scalar(255), distDisplay2);
        //distDisplay2.copyTo(imageEditedMat);
        // Create the CV_8U version of the distance image
        // It is needed for findContours()
        Mat dist_8u = new Mat();
        dist.convertTo(dist_8u, CvType.CV_8U);
        // Find total markers
        List<MatOfPoint> contours = new ArrayList<>();
        Mat hierarchy = new Mat();
        Imgproc.findContours(dist_8u, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
        // Create the marker image for the watershed algorithm
        Mat markers = Mat.zeros(dist.size(), CvType.CV_32S);
        // Draw the foreground markers
        for (int i = 0; i < contours.size(); i++) {
            Imgproc.drawContours(markers, contours, i, new Scalar(i + 1), -1);
        }
        // Draw the background marker
        Mat markersScaled = new Mat();
        markers.convertTo(markersScaled, CvType.CV_32F);
        Core.normalize(markersScaled, markersScaled, 0.0, 255.0, Core.NORM_MINMAX);
        Imgproc.circle(markersScaled, new Point(5, 5), 3, new Scalar(255, 255, 255), -1);
        Mat markersDisplay = new Mat();
        markersScaled.convertTo(markersDisplay, CvType.CV_8U);
        markersDisplay.copyTo(imageEditedMat);
        Imgproc.circle(markers, new Point(5, 5), 3, new Scalar(255, 255, 255), -1);
        // Perform the watershed algorithm
        Imgproc.watershed(imgResult, markers);
        Mat mark = Mat.zeros(markers.size(), CvType.CV_8U);
        markers.convertTo(mark, CvType.CV_8UC1);
        Core.bitwise_not(mark, mark);
        // Generate random colors
        Random rng = new Random(12345);
        List<Scalar> colors = new ArrayList<>(contours.size());
        for (int i = 0; i < contours.size(); i++) {
            int b = rng.nextInt(256);
            int g = rng.nextInt(256);
            int r = rng.nextInt(256);
            colors.add(new Scalar(b, g, r));
        }
        // Create the result image
        Mat dst = Mat.zeros(markers.size(), CvType.CV_8UC3);
        byte[] dstData = new byte[(int) (dst.total() * dst.channels())];
        dst.get(0, 0, dstData);
        // Fill labeled objects with random colors
        int[] markersData = new int[(int) (markers.total() * markers.channels())];
        markers.get(0, 0, markersData);
        for (int i = 0; i < markers.rows(); i++) {
            for (int j = 0; j < markers.cols(); j++) {
                int index = markersData[i * markers.cols() + j];
                if (index > 0 && index <= contours.size()) {
                    dstData[(i * dst.cols() + j) * 3 + 0] = (byte) colors.get(index - 1).val[0];
                    dstData[(i * dst.cols() + j) * 3 + 1] = (byte) colors.get(index - 1).val[1];
                    dstData[(i * dst.cols() + j) * 3 + 2] = (byte) colors.get(index - 1).val[2];
                } else {
                    dstData[(i * dst.cols() + j) * 3 + 0] = 0;
                    dstData[(i * dst.cols() + j) * 3 + 1] = 0;
                    dstData[(i * dst.cols() + j) * 3 + 2] = 0;
                }
            }
        }
        dst.put(0, 0, dstData);
        dst.copyTo(imageEditedMat);
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBOK;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLObjectNumber;
    // End of variables declaration


}
