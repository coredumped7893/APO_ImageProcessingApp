package maciekmalik.APO;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

public class ImageWindow extends JFrame implements MouseInputListener {


    public ImageWindow() throws HeadlessException {
        //Display empty window
        this._initWindow();
    }


    public ImageWindow(String fileName) throws HeadlessException {
        super(fileName);
        this._initWindow();
        ImageIcon icon = new ImageIcon(fileName);
        JLabel imgPH = new JLabel(icon);
        imgPH.setSize(this.getWidth(),this.getHeight());
        this.setMinimumSize(new Dimension(icon.getIconWidth(),icon.getIconHeight()));

        this.add(imgPH);
        System.out.println(JFrame.getFrames().length);
        System.out.println(JFrame.getWindows().length);



    }

    private void _initWindow(){
        setMinimumSize(new Dimension(300,300));

        //Zamknięcie okna nie zamyka całego programu
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {



    }

    @Override
    public void mouseMoved(MouseEvent e) {


    }
}
