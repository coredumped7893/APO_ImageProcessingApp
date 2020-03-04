package maciekmalik.pl.APO;


import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App {

    public App(){

        XYSeries series1 = new XYSeries("2014");
        series1.add(18, 530);
        series1.add(20, 580);
        series1.add(25, 740);
        series1.add(30, 901);
        series1.add(40, 1300);
        series1.add(50, 2219);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Average salary per age",
                "Age",
                "Salary (€)",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );


        /*
        try {
            ChartUtilities.saveChartAsPNG(new File("line_chart.png"), chart, 450, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }


         */

        /*
        JFrame mainFrame  = new JFrame("Maciek Malik APO LAB1");
        JLabel label = new JLabel();
        mainFrame.add(label);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(100,100);

        mainFrame.setVisible(true);

         */
        //label.setIcon(new ImageIcon());
        //mainFrame.add();
        ChartFrame f = new ChartFrame("XY Chart",chart);
        f.setSize(600,600);
        f.setVisible(true);
        f.pack();

        //---------------------


        double[] value = new double[100];
        Random generator = new Random();
        for (int i=1; i < 100; i++) {
            value[i] = generator.nextDouble();
        }
            int number = 10;
            HistogramDataset dataset2 = new HistogramDataset();
            dataset2.setType(HistogramType.RELATIVE_FREQUENCY);
            dataset2.addSeries("Histogram", value, number);
            String plotTitle = "Histogram";
            String xaxis = "number";
            String yaxis = "value";
            PlotOrientation orientation = PlotOrientation.VERTICAL;
            boolean show = false;
            boolean toolTips = false;
            boolean urls = false;
            JFreeChart chart2 = ChartFactory.createHistogram(plotTitle, xaxis, yaxis,
                    dataset2, orientation, show, toolTips, urls);



            ChartFrame f2 = new ChartFrame("Example Histogram",chart2);
            f2.setSize(600,600);
            f2.setVisible(true);

            f2.pack();





    }



    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        new App();

    }
}
