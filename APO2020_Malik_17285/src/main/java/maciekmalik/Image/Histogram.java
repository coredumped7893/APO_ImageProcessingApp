/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image;

import de.erichseifert.gral.data.DataSource;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.data.EnumeratedData;
import de.erichseifert.gral.data.statistics.Histogram1D;
import de.erichseifert.gral.data.statistics.Statistics;
import de.erichseifert.gral.graphics.Insets2D;
import de.erichseifert.gral.graphics.Orientation;
import de.erichseifert.gral.plots.BarPlot;
import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.ui.InteractivePanel;
import de.erichseifert.gral.util.GraphicsUtils;
import de.erichseifert.gral.util.MathUtils;
import maciekmalik.ImageWindow;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.*;
import java.lang.Double;

public class Histogram extends JFrame implements ChangeListener {

    /*
    Graph lib:
        jfreechart
        gral
        Xchart


     */
    private static final int SAMPLE_COUNT = 1000;
    protected static final Color COLOR1 = new Color( 55, 170, 200);
    /** Second corporate color used as signal color */
    protected static final Color COLOR2 = new Color(200,  80,  75);

    private Image image;

    public boolean isColor() {
        return isColor;
    }

    private boolean isColor = true;
    private Map<String, int[]> tmoOUT = new HashMap<>();


    private void initComponents() {

        jTabCon = new javax.swing.JTabbedPane();
        jPTabRed = new javax.swing.JPanel();
        jPTabGreen = new javax.swing.JPanel();
        jPTabBlue = new javax.swing.JPanel();
        jLMean = new javax.swing.JLabel();
        jLStdDev = new javax.swing.JLabel();
        jLMedian = new javax.swing.JLabel();
        jLCount = new javax.swing.JLabel();
        jLPercentile = new javax.swing.JLabel();
        jLPixels = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPTabRed.setPreferredSize(new java.awt.Dimension(403, 313));

        javax.swing.GroupLayout jPTabRedLayout = new javax.swing.GroupLayout(jPTabRed);
        jPTabRed.setLayout(jPTabRedLayout);
        jPTabRedLayout.setHorizontalGroup(
                jPTabRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 546, Short.MAX_VALUE)
        );
        jPTabRedLayout.setVerticalGroup(
                jPTabRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 346, Short.MAX_VALUE)
        );

        jTabCon.addTab("Red", jPTabRed);

        javax.swing.GroupLayout jPTabGreenLayout = new javax.swing.GroupLayout(jPTabGreen);
        jPTabGreen.setLayout(jPTabGreenLayout);
        jPTabGreenLayout.setHorizontalGroup(
                jPTabGreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 546, Short.MAX_VALUE)
        );
        jPTabGreenLayout.setVerticalGroup(
                jPTabGreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 346, Short.MAX_VALUE)
        );

        jTabCon.addTab("Green", jPTabGreen);

        javax.swing.GroupLayout jPTabBlueLayout = new javax.swing.GroupLayout(jPTabBlue);
        jPTabBlue.setLayout(jPTabBlueLayout);
        jPTabBlueLayout.setHorizontalGroup(
                jPTabBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 546, Short.MAX_VALUE)
        );
        jPTabBlueLayout.setVerticalGroup(
                jPTabBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 346, Short.MAX_VALUE)
        );

        jTabCon.addTab("Blue", jPTabBlue);

        jLMean.setText("Mean: 0.000");

        jLStdDev.setText("Std dev: 0.000");

        jLMedian.setText("Median: 0.000");

        jLCount.setText("Count: 0000000");

        jLPercentile.setText("Percentile: 000");

        jLPixels.setText("Pixels: 0000000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTabCon)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLMedian)
                                                                        .addComponent(jLStdDev))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLCount)
                                                                        .addComponent(jLPercentile)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLMean)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLPixels)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTabCon, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLMean)
                                        .addComponent(jLPixels))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLCount)
                                        .addComponent(jLStdDev))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLMedian)
                                        .addComponent(jLPercentile))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private javax.swing.JLabel jLCount;
    private javax.swing.JLabel jLMean;
    private javax.swing.JLabel jLMedian;
    private javax.swing.JLabel jLPercentile;
    private javax.swing.JLabel jLPixels;
    private javax.swing.JLabel jLStdDev;
    private javax.swing.JPanel jPTabBlue;
    private javax.swing.JPanel jPTabGreen;
    private javax.swing.JPanel jPTabRed;
    private javax.swing.JTabbedPane jTabCon;





    /**
     * Creates a new, initially invisible <code>Frame</code> with the
     * specified title.
     * <p>
     * This constructor sets the component's locale property to the value
     * returned by <code>JComponent.getDefaultLocale</code>.
     *
     * @param title the title for the frame
     * @throws HeadlessException if GraphicsEnvironment.isHeadless()
     *                           returns true.
     * @see GraphicsEnvironment#isHeadless
     * @see Component#setSize
     * @see Component#setVisible
     * @see JComponent#getDefaultLocale
     */
    private Histogram(String title, Image image) throws HeadlessException {
        super(title);
        this.image = image;

        //this.chartDemos();

        this.initComponents();

        if(image != null){

            this._renderFrame(this._calculateHist(),title);

        }else{
            System.out.println("Image cannot be empty");
        }

    }

    public static void HistogramFrameFabric(String title, Image image){
        java.awt.EventQueue.invokeLater(() -> new Histogram( title,  image).setVisible(true));
    }


    public Histogram() {
    }


    private void _updateStats(Map<String, Double> map){

        jLCount.setText("Count: " + map.get("count"));
        jLMean.setText("Mean" + map.get("mean"));
        jLMedian.setText("Median" + map.get("median"));
        jLPercentile.setText("Percentile" + (int) Math.round(map.get("percentile")));
        jLPixels.setText("Pixels: " + (int) Math.round(map.get("pixels")));
        jLStdDev.setText("Std dev: " + map.get("std_dev"));

    }




    private Map<String, Double> _calculateStats(Map<String, int[]> ch,String channelName){


        Map<String, Double> statsOUT = new HashMap<>();

        BufferedImage buffImg = ImageWindow.toBufferedImage(this.image);
        int[] pixels = ((DataBufferInt) buffImg.getRaster().getDataBuffer()).getData();

        ArrayList sorted = new ArrayList<Double>();


        int sum = 0;
        int sum_std = 0;
        double stddev = 0;
        for ( int i = 0; i < ch.get(channelName).length ;i++ ){

            sum += ch.get(channelName)[i]*i;
            sum_std += ch.get(channelName)[i];
            sorted.add(new Double(ch.get(channelName)[i]));
            //stddev += Math.pow((ch.get("Red")[i] - ((double)sum/(double) ch.get("Red").length) ),2) / ch.get("Red").length;

        }

//        for (int  i = 0; i < pixels.length ;i++ ){
//
//            stddev += Math.pow((double) (ch.get("Red")[i] - ((double)sum/(double) pixels.length) ),2);
//
//        }

        Collections.sort(sorted);

        statsOUT.put("count",(double)sum);
        statsOUT.put("pixels",(double)pixels.length);
        statsOUT.put("percentile",(double)100);
        statsOUT.put("median", (Double) sorted.get(ch.get(channelName).length/2));
        statsOUT.put("mean",(double)sum/pixels.length);
        //statsOUT.put("std_dev",(double)Math.sqrt(stddev/pixels.length));



        return statsOUT;
    }



    private Map<String, int[]> _calculateHist(){

        //TYPE_INT_ARGB

        //ARGBARGBARGB

        BufferedImage buffImg = ImageWindow.toBufferedImage(this.image);

        int[] dataR = new int[256];
        int[] dataG = new int[256];
        int[] dataB = new int[256];

        tmoOUT.put("Red",dataR);
        tmoOUT.put("Green",dataG);
        tmoOUT.put("Blue",dataB);

        //if each channel is the same -> greyscale

        //Get each pixel data as sum of 4 channels in turn (A + R + G + B)
        int[] pixels = ((DataBufferInt) buffImg.getRaster().getDataBuffer()).getData();

        int i,notColor=0;
        //Iterate over whole pixel array (each pixel has 4 bytes)
        for ( i=0; (i+0) < pixels.length ;i+=1 ){
            int r,g,b;

            //A channel can be ommited
            r = ( (pixels[i]) & 0x00ff0000 ) >> 16;
            g = ( (pixels[i]) & 0x0000ff00 ) >> 8;
            b = ( (pixels[i]) & 0x000000ff );

            dataR[ r ]++;
            dataG[ g ]++;
            dataB[ b ]++;

            if(((r == g) && (r == b)  )){
                notColor++;
            }
        }

        if(notColor == pixels.length){
            this.isColor = false;
        }


        this._updateStats(this._calculateStats(tmoOUT,"Red"));


        return tmoOUT;
    }


    private void _renderFrame(Map<String, int[]> dataRGB, String title){


        //----------------------------------------------
        DefaultCategoryDataset datasetR = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetG = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetB = new DefaultCategoryDataset();

        //Set values for given pixel
        for (int yy=0;yy<256;yy++){
            datasetR.setValue(dataRGB.get("Red")[yy],"1",String.valueOf(yy));
            datasetG.setValue(dataRGB.get("Green")[yy],"1",String.valueOf(yy));
            datasetB.setValue(dataRGB.get("Blue")[yy],"1",String.valueOf(yy));
        }

        JFreeChart chartTestR = ChartFactory.createBarChart("",

                "--",

                "-",

                datasetR,

                PlotOrientation.VERTICAL, // orientation
                false,

                true,
                false

        );
        //chartTestR.setBackgroundPaint(Color.RED);//
        CategoryPlot tmpPlotR = (CategoryPlot) chartTestR.getPlot();
        ((BarRenderer)tmpPlotR.getRenderer()).setBarPainter(new StandardBarPainter());
        BarRenderer r = (BarRenderer) chartTestR.getCategoryPlot().getRenderer();
        r.setSeriesPaint(0,Color.RED);

        tmpPlotR.setBackgroundPaint(Color.WHITE);//chart background
        //BarRenderer rnd = (BarRenderer) tmpPlotR.getRenderer();


        JFreeChart chartTestG = ChartFactory.createBarChart("",

                "",

                "",

                datasetG,

                PlotOrientation.VERTICAL, // orientation
                false,

                true,
                false

        );
        CategoryPlot tmpPlotG = (CategoryPlot) chartTestG.getPlot();
        ((BarRenderer)tmpPlotG.getRenderer()).setBarPainter(new StandardBarPainter());
        r = (BarRenderer) chartTestG.getCategoryPlot().getRenderer();
        r.setSeriesPaint(0,Color.GREEN);
        tmpPlotG.setBackgroundPaint(Color.WHITE);

        JFreeChart chartTestB = ChartFactory.createBarChart("",

                "--",

                "-",

                datasetB,

                PlotOrientation.VERTICAL, // orientation
                false,

                true,
                false

        );
        CategoryPlot tmpPlotB = (CategoryPlot) chartTestB.getPlot();
        ((BarRenderer)tmpPlotB.getRenderer()).setBarPainter(new StandardBarPainter());
        r = (BarRenderer) chartTestB.getCategoryPlot().getRenderer();
        r.setSeriesPaint(0,Color.BLUE);
        tmpPlotB.setBackgroundPaint(Color.WHITE);



        /*
        //Create new window to display it
        ChartFrame frameR = new ChartFrame(title + " Red", chartTestR);
        frameR.pack();
        frameR.setVisible(true);

        ChartFrame frameG = new ChartFrame(title + " Green", chartTestG);
        frameG.pack();
        frameG.setVisible(true);

        ChartFrame frameB = new ChartFrame(title + " Blue", chartTestB);
        frameB.pack();
        frameB.setVisible(true);

         */


        //Add charts to tabs

        jPTabRed.setLayout(new BorderLayout());
        jPTabGreen.setLayout(new BorderLayout());
        jPTabBlue.setLayout(new BorderLayout());
        jPTabRed.add(new ChartPanel(chartTestR),BorderLayout.NORTH);
        jPTabGreen.add(new ChartPanel(chartTestG),BorderLayout.NORTH);
        jPTabBlue.add(new ChartPanel(chartTestB),BorderLayout.NORTH);
        jPTabRed.setVisible(true);
        jPTabGreen.setVisible(true);
        jPTabBlue.setVisible(true);
        this.setMinimumSize((jPTabRed.getComponents()[0].getPreferredSize()));
        this.setMinimumSize(new Dimension(getWidth(),this.getHeight()+100));
        jTabCon.addChangeListener(this);


    }




    public void chartDemos(){
        setPreferredSize(new Dimension(300,300));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


//GRAAL styled example


// Create example data
        Random random = new Random();
        DataTable data2 = new DataTable(Double.class);
        for (int i = 0; i < SAMPLE_COUNT; i++) {
            data2.add(random.nextGaussian());
        }

// Create histogram from data


        Histogram1D histogram = new Histogram1D(data2, Orientation.VERTICAL,
                new Number[] {-4.0, -3.2, -2.4, -1.6, -0.8, 0.0, 0.8, 1.6, 2.4, 3.6, 4.0});
// Create a second dimension (x axis) for plotting
        DataSource histogram2d = new EnumeratedData(histogram, (-4.0 + -3.2)/2.0, 0.8);

// Create new bar plot
        BarPlot plot2 = new BarPlot(histogram2d);

// Format plot
        plot2.setInsets(new Insets2D.Double(20.0, 65.0, 50.0, 40.0));
        plot2.getTitle().setText(
                String.format("Distribution of %d random samples", data2.getRowCount()));
        plot2.setBarWidth(0.78);

// Format x axis
        plot2.getAxisRenderer(BarPlot.AXIS_X).setTickAlignment(0.0);
        plot2.getAxisRenderer(BarPlot.AXIS_X).setTickSpacing(0.8);
        plot2.getAxisRenderer(BarPlot.AXIS_X).setMinorTicksVisible(false);
// Format y axis
        plot2.getAxis(BarPlot.AXIS_Y).setRange(0.0,
                MathUtils.ceil(histogram.getStatistics().get(Statistics.MAX)*1.1, 25.0));
        plot2.getAxisRenderer(BarPlot.AXIS_Y).setTickAlignment(0.0);
        plot2.getAxisRenderer(BarPlot.AXIS_Y).setMinorTicksVisible(false);
        plot2.getAxisRenderer(BarPlot.AXIS_Y).setIntersection(-4.4);

// Format bars
        PointRenderer barRenderer = plot2.getPointRenderers(histogram2d).get(0);
        barRenderer.setColor(GraphicsUtils.deriveWithAlpha(COLOR1, 128));
        barRenderer.setValueVisible(true);

// Add plot to Swing component
        InteractivePanel panel = new InteractivePanel(plot2);
        panel.setPannable(false);
        panel.setZoomable(false);
        add(panel);
        pack();

        //----------------------------------------------
        DefaultCategoryDataset dataset33 = new DefaultCategoryDataset();


        double[] value33 = new double[256];
        Random generator33 = new Random();

        for (int yy=-100;yy<=100;yy++){
            dataset33.setValue(Integer.valueOf(0),"1",String.valueOf(yy));
        }


        for (int i=1; i < 5000; i++) {
            value33[generator33.nextInt(256)]++;
            //dataset33.setValue(Integer.valueOf(1),"1",String.valueOf(generator33.nextInt(256)));
            int tmp = (int) (generator33.nextGaussian()*100);
            //System.out.println(tmp);
            if(tmp>=-100 && tmp <= 100){
                dataset33.incrementValue(1,"1",String.valueOf(tmp ));
            }
        }

        JFreeChart chartTest33 = ChartFactory.createBarChart("Bar Chart Demo3333",

                "Category",

                "Value",

                dataset33,

                PlotOrientation.VERTICAL, // orientation
                true,

                true,
                false

        );

        ChartFrame frame33 = new ChartFrame("HistTest3333", chartTest33);
        frame33.pack();
        frame33.setVisible(true);




    }






    /**
     * Invoked when the target of the listener has changed its state.
     *
     * @param e a ChangeEvent object
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
        int selectedIndex = tabbedPane.getSelectedIndex();
        //JOptionPane.showMessageDialog(null, "Selected Index: " + selectedIndex);
        System.out.println("Selected Index: " + tabbedPane.getTitleAt(tabbedPane.getSelectedIndex()));

        this._updateStats(this._calculateStats(tmoOUT,tabbedPane.getTitleAt(tabbedPane.getSelectedIndex())));



    }





}
