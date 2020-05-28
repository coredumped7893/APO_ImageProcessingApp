/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik;

import maciekmalik.Image.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;
import java.util.logging.Logger;

public class ImageWindow extends JFrame implements FocusListener {


    public ImageWindow() throws HeadlessException {
        //Display empty window
        this._initWindow();
    }

    public ImageIcon getIcon() {
        return icon;
    }


    /**
     * @return last focused @ImageWindow
     */
    public static ImageWindow getLastFocused() {
        return lastFocused;
    }


    /**
     * Last focused image window
     */
    private static ImageWindow lastFocused = null;

    /**
     * Image to be displayed in frame
     */
    private ImageIcon icon = null;
    private JLabel imgContainer = new JLabel(icon);
    public boolean isColor() {
        return isColor;
    }
    private boolean isColor = true;
    private static final Logger LOGGER = Logger.getLogger(MainGUI.class.getName());


    /**
     * @param fileName
     * @throws HeadlessException
     */
    public ImageWindow(String fileName) throws HeadlessException {

        // @TODO If the same - append number
        super(fileName);

        this._initWindow();

        this.icon = new ImageIcon(fileName);
        this.icon = new ImageIcon(Utils.toBufferedImage(this.icon.getImage()));
        this._checkColor();
        this._finishInit();

    }

    /**
     * @param image
     * @throws HeadlessException
     */
    public ImageWindow(Image image) throws HeadlessException {

        super(image.toString());

        this._initWindow();
        this.icon = new ImageIcon(image,image.toString());
        this.icon = new ImageIcon(Utils.toBufferedImage(this.icon.getImage()));
        this._checkColor();
        this._finishInit();

    }

    private void _initWindow(){

        addFocusListener(this);
        addWindowListener(new WindowAdapter() {

            /**
             * Invoked when a window has been closed.
             *
             * @param e
             */
            @Override
            public void windowClosed(WindowEvent e) {
                ImageWindow.lastFocused = null;
                super.windowClosed(e);
            }
        });


        ImageWindow.lastFocused = this; // Current window
        setMinimumSize(new Dimension(100,100));
        setResizable(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }


    /**
     * Sprawdzenie czy obraz jest kolorowy
     *
     */
    private void _checkColor(){
        int[] pixels = Utils.getPixelArray(this.icon.getImage());

        int i,notColor=0;
        //Iterate over whole pixel array (each pixel has 4 bytes)
        for ( i=0; (i+0) < pixels.length ;i+=1 ){
            Map<String,Integer> pixel = Utils.pixelValue(pixels[i]);
            if(((pixel.get("Red").equals(pixel.get("Green"))) && (pixel.get("Green").equals(pixel.get("Blue")))  )){
                notColor++;
            }//27 - 231
        }
        if(notColor == pixels.length){
            this.isColor = false;
        }else{
            this.isColor = true;
        }
        //LOGGER.info("NOT color: " + notColor + " Pixels: " + (pixels.length));
    }

    /**
     * Update window image currently displayed
     *
     * @param icon
     */
    private void setImgContainer(Icon icon) {
        this.imgContainer.setIcon(icon);
    }

    /**
     * Updates frame`s window
     *
     * @param icon ImageIcon
     */
    public void setIcon(ImageIcon icon) {
        this.setImgContainer(icon);
    }

    /**
     * Zapisuje zamiany na obraz
     *
     */
    public void saveIconChange(ImageIcon icon){
        this.icon = icon;
    }



    private void _setBorder(){
        getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(41,231,103)));
    }

    private void _finishInit(){

        this.setMinimumSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        LOGGER.info("Is Greyscale: " + !this.isColor);
        this.setAlwaysOnTop(true);

        imgContainer.setIcon(icon);
        imgContainer.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());

        this._setBorder();

        this.add(imgContainer);
        this.pack();
        this.setVisible(true);

    }

    public void setDescription(String desc){
        this.icon.setDescription(desc);
        this.setTitle(desc);
    }

    public String getDescription(){
        return this.icon.getDescription();
    }



    /**
     * Invoked when a component gains the keyboard focus.
     *
     * @param e the event to be processed
     * @see ImageWindow
     */
    @Override
    public void focusGained(FocusEvent e) {

        //Clear border for frame loosing focus
        if(ImageWindow.lastFocused != null){
            ImageWindow.lastFocused.getRootPane().setBorder(null);
        }

        System.out.println("focusGained on:" + this.icon.toString());
        ImageWindow.lastFocused = this;
        this._setBorder();

    }

    /**
     * Invoked when a component loses the keyboard focus.
     *
     * @param e the event to be processed
     */
    @Override
    public void focusLost(FocusEvent e) {


        System.out.println("Focus lost" );

    }




}
