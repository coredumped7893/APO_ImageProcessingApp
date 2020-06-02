/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image.ImgAnalysis;

import maciekmalik.Image.CVAction;
import maciekmalik.Image.Utils;
import maciekmalik.ImageWindow;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.TermCriteria;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.ml.Ml;

import javax.swing.*;
import java.awt.*;

/**
 * Klasyfikacja obiektu na podstawie danych uczących i zdefiniowanego wektora cech
 */
public class SVM extends CVAction {

    public SVM(Image imge) {
        //initComponents();
        imageEdited = ImageWindow.getLastFocused();
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

        // Set up training data
        //! [setup1]
        int[] labels = { 1, -1, -1, -1 };
        float[] trainingData = { 501, 10, 255, 10, 501, 255, 10, 501 };
        //! [setup1]
        //! [setup2]
        Mat trainingDataMat = new Mat(4, 2, CvType.CV_32FC1);
        trainingDataMat.put(0, 0, trainingData);
        Mat labelsMat = new Mat(4, 1, CvType.CV_32SC1);
        labelsMat.put(0, 0, labels);
        //! [setup2]

        // Train the SVM
        //! [init]
        org.opencv.ml.SVM svm = org.opencv.ml.SVM.create();
        svm.setType(org.opencv.ml.SVM.C_SVC);
        svm.setKernel(org.opencv.ml.SVM.LINEAR);
        svm.setTermCriteria(new TermCriteria(TermCriteria.MAX_ITER, 100, 1e-6));
        //! [init]
        //! [train]
        svm.train(trainingDataMat, Ml.ROW_SAMPLE, labelsMat);
        //! [train]

        // Data for visual representation
        int width = 512, height = 512;
        Mat image = Mat.zeros(height, width, CvType.CV_8UC3);

        // Show the decision regions given by the SVM
        //! [show]
        byte[] imageData = new byte[(int) (image.total() * image.channels())];
        Mat sampleMat = new Mat(1, 2, CvType.CV_32F);
        float[] sampleMatData = new float[(int) (sampleMat.total() * sampleMat.channels())];
        for (int i = 0; i < image.rows(); i++) {
            for (int j = 0; j < image.cols(); j++) {
                sampleMatData[0] = j;
                sampleMatData[1] = i;
                sampleMat.put(0, 0, sampleMatData);
                float response = svm.predict(sampleMat);

                if (response == 1) {
                    imageData[(i * image.cols() + j) * image.channels()] = 0;
                    imageData[(i * image.cols() + j) * image.channels() + 1] = (byte) 255;
                    imageData[(i * image.cols() + j) * image.channels() + 2] = 0;
                } else if (response == -1) {
                    imageData[(i * image.cols() + j) * image.channels()] = (byte) 255;
                    imageData[(i * image.cols() + j) * image.channels() + 1] = 0;
                    imageData[(i * image.cols() + j) * image.channels() + 2] = 0;
                }
            }
        }
        image.put(0, 0, imageData);
        //! [show]

        // Show the training data
        //! [show_data]
        int thickness = -1;
        int lineType = Imgproc.LINE_8;
        Imgproc.circle(image, new org.opencv.core.Point(501, 10), 5, new Scalar(0, 0, 0), thickness, lineType, 0);
        Imgproc.circle(image, new org.opencv.core.Point(255, 10), 5, new Scalar(255, 255, 255), thickness, lineType, 0);
        Imgproc.circle(image, new org.opencv.core.Point(501, 255), 5, new Scalar(255, 255, 255), thickness, lineType, 0);
        Imgproc.circle(image, new org.opencv.core.Point(10, 501), 5, new Scalar(255, 255, 255), thickness, lineType, 0);
        //! [show_data]

        // Show support vectors
        //! [show_vectors]
        thickness = 2;
        Mat sv = svm.getUncompressedSupportVectors();
        float[] svData = new float[(int) (sv.total() * sv.channels())];
        sv.get(0, 0, svData);
        for (int i = 0; i < sv.rows(); ++i) {
            Imgproc.circle(image, new Point(svData[i * sv.cols()], svData[i * sv.cols() + 1]), 6,
                    new Scalar(128, 128, 128), thickness, lineType, 0);
        }
        //! [show_vectors]

        //Imgcodecs.imwrite("result.png", image); // save the image


        this.img = CVAction.mat2BufferedImg(image,image.cols(),image.rows());
        imageEdited.setIcon(new ImageIcon(img,imageEditedCopy.getDescription()));


    }
}
