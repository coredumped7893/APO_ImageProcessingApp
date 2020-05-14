/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image;

import maciekmalik.ImageWindow;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.*;
import java.lang.Double;
import java.util.List;


public class Histogram extends JFrame implements ChangeListener {


    private Image image;
    public boolean isColor() {
        return isColor;
    }
    private boolean isColor = true;
    private boolean removeAxis = false;
    private Map<String, int[]> tmoOUT = new HashMap<>();

    // Variables declaration - do not modify
    private javax.swing.JLabel jLCount;
    private javax.swing.JLabel jLMean;
    private javax.swing.JLabel jLMedian;
    private javax.swing.JLabel jLPercentile;
    private javax.swing.JLabel jLPixels;
    private javax.swing.JLabel jLStdDev;
    private javax.swing.JPanel jPTabBlue;
    private javax.swing.JPanel jPTabGreen;
    private javax.swing.JPanel jPTabLuminance;
    private javax.swing.JPanel jPTabRed;
    private javax.swing.JTabbedPane jTabCon;
    // End of variables declaration


    public JTabbedPane getjTabCon() {
        return jTabCon;
    }

    private void initComponents() {

        jTabCon = new javax.swing.JTabbedPane();
        jPTabLuminance = new javax.swing.JPanel();
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

        javax.swing.GroupLayout jPTabLuminanceLayout = new javax.swing.GroupLayout(jPTabLuminance);
        jPTabLuminance.setLayout(jPTabLuminanceLayout);
        jPTabLuminanceLayout.setHorizontalGroup(
                jPTabLuminanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 546, Short.MAX_VALUE)
        );
        jPTabLuminanceLayout.setVerticalGroup(
                jPTabLuminanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 346, Short.MAX_VALUE)
        );

        jTabCon.addTab("Luminance", jPTabLuminance);

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
                                .addComponent(jTabCon)
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

    /**
     *
     * @param title tytuł ramki/okna
     * @param image obraz z którego będzie generowany histogram
     * @param edit czy używany jest jako ustawienia dla edycji
     * @throws HeadlessException if GraphicsEnvironment.isHeadless() returns true.
     * @see Image
     * @see ImageWindow#toBufferedImage(Image)
     */
    public Histogram(String title, Image image) throws HeadlessException {
        super(title);
        this.image = image;

        this.initComponents();

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        if(image != null){

            List<ChartPanel> cpL =  this._renderFrame(this._calculateHist(),title);
            jPTabRed.setLayout(new BorderLayout());
            jPTabGreen.setLayout(new BorderLayout());
            jPTabBlue.setLayout(new BorderLayout());
            jPTabLuminance.setLayout(new BorderLayout());
            jPTabLuminance.add(cpL.get(3),BorderLayout.NORTH);
            jPTabRed.add(cpL.get(0),BorderLayout.NORTH);
            jPTabGreen.add(cpL.get(1),BorderLayout.NORTH);
            jPTabBlue.add(cpL.get(2),BorderLayout.NORTH);
            jPTabRed.setVisible(true);
            jPTabGreen.setVisible(true);
            jPTabBlue.setVisible(true);
            jPTabLuminance.setVisible(true);
            this.setMinimumSize((jPTabRed.getComponents()[0].getPreferredSize()));
            this.setMinimumSize(new Dimension(getWidth(),this.getHeight()+100));
            jTabCon.addChangeListener(this);
            jTabCon.setSelectedIndex(0);

        }else{
            System.out.println("Image cannot be empty");
        }

    }

    /**
     * Constructs a new frame that is initially invisible.
     * <p>
     * This constructor sets the component's locale property to the value
     * returned by <code>JComponent.getDefaultLocale</code>.
     *
     * @throws HeadlessException if GraphicsEnvironment.isHeadless()
     *                           returns true.
     * @see GraphicsEnvironment#isHeadless
     * @see Component#setSize
     * @see Component#setVisible
     * @see JComponent#getDefaultLocale
     */
    public Histogram(Image image) throws HeadlessException {
        this.initComponents();
        this.removeAxis = true;
        this.image = image;
    }

    public static void HistogramFrameFabric(String title, Image image){
        java.awt.EventQueue.invokeLater(() -> new Histogram( title,  image).setVisible(true));
    }


    /**
     * Ustawia statystyki w oknie
     *
     * @param map
     */
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

        int[] pixels = Utils.getPixelArray(this.image);

        ArrayList sorted = new ArrayList<Double>();


        int sum = 0;
        int sum_std = 0;
        double stddev = 0;
        for ( int i = 0; i < ch.get(channelName).length ;i++ ){

            sum += ch.get(channelName)[i]*i;
            sum_std += ch.get(channelName)[i];
            sorted.add(new Double(ch.get(channelName)[i]));
            //@TODO fix stddev
            stddev += Math.pow((ch.get("Red")[i] - ((double)sum/(double) ch.get("Red").length) ),2) / ch.get("Red").length;

        }

        Collections.sort(sorted);

        statsOUT.put("count",(double)sum);
        statsOUT.put("pixels",(double)pixels.length);
        statsOUT.put("percentile",(double)100);
        statsOUT.put("median", (Double) sorted.get(ch.get(channelName).length/2));
        statsOUT.put("mean",(double)sum/pixels.length);
        statsOUT.put("std_dev",(double)Math.sqrt(stddev/pixels.length));

        return statsOUT;
    }


    /**
     * Liczy ilość wystąpień jasności każdego z kanałów
     *
     * @return Map<String, int[]>
     * @see Utils#getPixelArray(Image) 
     * @see Utils#pixelValue(int) 
     * @see Histogram#_calculateStats(Map, String)
     */
    public Map<String, int[]> _calculateHist(){

        //TYPE_INT_ARGB

        //ARGBARGBARGB

        int[] dataR = new int[256];
        int[] dataG = new int[256];
        int[] dataB = new int[256];
        int[] dataL = new int[256];

        tmoOUT.put("Red",dataR);
        tmoOUT.put("Green",dataG);
        tmoOUT.put("Blue",dataB);
        tmoOUT.put("Luminance",dataL);

        //if each channel is the same -> greyscale

        //Get each pixel data as sum of 4 channels in turn (A + R + G + B)
        int[] pixels = Utils.getPixelArray(this.image);

        int i,notColor=0;
        //Iterate over whole pixel array (each pixel has 4 bytes)
        for ( i=0; (i+0) < pixels.length ;i+=1 ){
            Map<String,Integer> pixel = Utils.pixelValue(pixels[i]);

            dataR[ pixel.get("Red") ]++;
            dataG[ pixel.get("Green") ]++;
            dataB[ pixel.get("Blue") ]++;
            dataL[ pixel.get("Luminance") ]++;

            if(((pixel.get("Red") == pixel.get("Green")) && (pixel.get("Red") == pixel.get("Blue"))  )){
                notColor++;
            }
        }

        if(notColor == pixels.length){
            this.isColor = false;
        }


        this._updateStats(this._calculateStats(tmoOUT,"Luminance"));


        return tmoOUT;
    }


    public List<ChartPanel> _renderFrame(Map<String, int[]> dataRGB, String title){


        //----------------------------------------------
        DefaultCategoryDataset datasetR = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetG = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetB = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetL = new DefaultCategoryDataset();

        //Set values for given pixel
        for (int yy=0;yy<256;yy++){
            datasetR.setValue(dataRGB.get("Red")[yy],"1",String.valueOf(yy));
            datasetG.setValue(dataRGB.get("Green")[yy],"1",String.valueOf(yy));
            datasetB.setValue(dataRGB.get("Blue")[yy],"1",String.valueOf(yy));
            datasetL.setValue(dataRGB.get("Luminance")[yy],"1",String.valueOf(yy));
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




        JFreeChart chartTestL = ChartFactory.createBarChart("",

                "--",

                "-",

                datasetL,

                PlotOrientation.VERTICAL, // orientation
                false,

                true,
                false

        );
        //chartTestR.setBackgroundPaint(Color.RED);//
        CategoryPlot tmpPlotL = (CategoryPlot) chartTestL.getPlot();
        ((BarRenderer)tmpPlotL.getRenderer()).setBarPainter(new StandardBarPainter());
        BarRenderer l = (BarRenderer) chartTestL.getCategoryPlot().getRenderer();
        l.setSeriesPaint(0,Color.GRAY);







        //Add charts to tabs
        ChartPanel cpR,cpG,cpB,cpL;
        cpR = new ChartPanel(chartTestR);
        cpG = new ChartPanel(chartTestG);
        cpB = new ChartPanel(chartTestB);
        cpL = new ChartPanel(chartTestL);

        cpR.setDomainZoomable(false);
        cpR.setRangeZoomable(false);
        cpG.setDomainZoomable(false);
        cpG.setRangeZoomable(false);
        cpB.setDomainZoomable(false);
        cpB.setRangeZoomable(false);
        cpL.setDomainZoomable(false);
        cpL.setRangeZoomable(false);



        if(this.removeAxis){
            tmpPlotR.setOutlinePaint(null);
            tmpPlotG.setOutlinePaint(null);
            tmpPlotB.setOutlinePaint(null);
            tmpPlotL.setOutlinePaint(null);
            tmpPlotR.getRangeAxis().setVisible(false);
            tmpPlotG.getRangeAxis().setVisible(false);
            tmpPlotB.getRangeAxis().setVisible(false);
            tmpPlotL.getRangeAxis().setVisible(false);
            cpR.getChart().setPadding(new RectangleInsets(0,0,0,0));
            cpG.getChart().setPadding(new RectangleInsets(0,0,0,0));
            cpB.getChart().setPadding(new RectangleInsets(0,0,0,0));
            cpL.getChart().setPadding(new RectangleInsets(0,0,0,0));
            tmpPlotR.getDomainAxis().setLowerMargin(0.01);
            tmpPlotR.getDomainAxis().setUpperMargin(0.01);
            tmpPlotG.getDomainAxis().setLowerMargin(0.01);
            tmpPlotG.getDomainAxis().setUpperMargin(0.01);
            tmpPlotB.getDomainAxis().setLowerMargin(0.01);
            tmpPlotB.getDomainAxis().setUpperMargin(0.01);
            tmpPlotL.getDomainAxis().setLowerMargin(0.01);
            tmpPlotL.getDomainAxis().setUpperMargin(0.01);
        }





        List<ChartPanel> listOut = new ArrayList<>();
        listOut.add(cpR);
        listOut.add(cpG);
        listOut.add(cpB);
        listOut.add(cpL);

        return listOut;

        /*
        jPTabRed.setLayout(new BorderLayout());
        jPTabGreen.setLayout(new BorderLayout());
        jPTabBlue.setLayout(new BorderLayout());
        jPTabRed.add(cpR,BorderLayout.NORTH);
        jPTabGreen.add(cpG,BorderLayout.NORTH);
        jPTabBlue.add(cpB,BorderLayout.NORTH);
        jPTabRed.setVisible(true);
        jPTabGreen.setVisible(true);
        jPTabBlue.setVisible(true);
        this.setMinimumSize((jPTabRed.getComponents()[0].getPreferredSize()));
        this.setMinimumSize(new Dimension(getWidth(),this.getHeight()+100));
        jTabCon.addChangeListener(this);

         */


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
