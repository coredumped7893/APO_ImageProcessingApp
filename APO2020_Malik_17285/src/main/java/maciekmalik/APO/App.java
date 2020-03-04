package maciekmalik.APO;


import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import sun.rmi.rmic.Main;

import javax.swing.*;
import java.util.Random;


/**
 * Hello world!
 *
 */
public class App {

    public App(){

        new MainGUI();


    }



    public static void main( String[] args ) {
        System.out.println( "Starting App" );
        new App();
    }
}
