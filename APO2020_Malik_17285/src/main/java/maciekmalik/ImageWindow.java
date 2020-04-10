/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class ImageWindow extends JFrame implements FocusListener {


    public ImageWindow() throws HeadlessException {
        //Display empty window
        this._initWindow();
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public static ImageWindow getLastFocused() {
        return lastFocused;
    }

    private static ImageWindow lastFocused = null;
    private ImageIcon icon;
    private JLabel imgContainer = new JLabel(icon);


    public ImageWindow(String fileName) throws HeadlessException {

        // @TODO If the same - append number
        super(fileName);

        this._initWindow();
        this.icon = new ImageIcon(fileName);
        this._finishInit();

    }

    public ImageWindow(Image image) throws HeadlessException {

        super(image.toString());

        this._initWindow();
        this.icon = new ImageIcon(image);
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
        //setLayout(null);
        //Closing window doesnt close whole program
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }


    private void _setBorder(){
        getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(41,231,103)));
    }

    private void _finishInit(){


        this.setMinimumSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        this.setAlwaysOnTop(true);

        imgContainer.setIcon(icon);
        imgContainer.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());

        this._setBorder();


        this.add(imgContainer);
        this.pack();
        this.setVisible(true);

    }


    /**
     * Converts a given Image into a BufferedImage
     *
     * @param img The Image to be converted
     * @return The converted BufferedImage
     */
    public static BufferedImage toBufferedImage(Image img)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
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
     */
    @Override
    public void focusGained(FocusEvent e) {

        //Clear border for focus loosing frame
        if(ImageWindow.lastFocused != null){
            ImageWindow.lastFocused.getRootPane().setBorder(null);
        }

        System.out.println("focusGained on:" + this.icon.toString());
        ImageWindow.lastFocused = this;

        // @TODO change frame style on focus gain
        this._setBorder();

    }

    /**
     * Invoked when a component loses the keyboard focus.
     *
     * @param e the event to be processed
     */
    @Override
    public void focusLost(FocusEvent e) {
    }




}
