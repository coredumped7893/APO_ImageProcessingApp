package maciekmalik.APO;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class MainGUI extends  JFrame implements ActionListener {



    private JMenu menu;
    private JMenuBar menuBar;
    private JPanel panel1;
    private JLabel label;
    List<JFrame> framesCreated;

    public MainGUI() {

        //Window init
        setSize(500,500);
        setMinimumSize(new Dimension(500,500));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this._initMenu();

        label = new JLabel("-------- Loading --------");  // construct a JLabel
        add( label );
        framesCreated = new ArrayList<JFrame>();


        framesCreated.add(this);


        this.pack();
        this.setVisible(true);


    }

    private void _initMenu(){
        menuBar = new JMenuBar();
        menu = new JMenu("LAB1");
        JMenuItem i1 = new JMenuItem("Load Image");
        JMenuItem i2 = new JMenuItem("Generate Histogram");
        menu.add(i1);
        menuBar.add(menu);
        i1.addActionListener(this);
        i2.addActionListener(this);
        this.setJMenuBar(menuBar);
    }


    private void _menuClick(String name){

        switch (name){
            case "Load Image":
                this._loadImage();
                break;
            case "Generate Histogram":
                //

                break;
            default:
                return;


        }

    }


    private void _loadImage(){
        JFileChooser chooser = new JFileChooser(Paths.get(".").toAbsolutePath().normalize().toString()+"/src/main/java/maciekmalik/APO/Resources");

        //Wyświetlaj tylko pasujące formaty plików
        chooser.addChoosableFileFilter(new FileNameExtensionFilter(
                "Graphics", ImageIO.getReaderFileSuffixes()));
        chooser.setAcceptAllFileFilterUsed(false);

        int t = chooser.showOpenDialog(null);


        if(t == JFileChooser.APPROVE_OPTION){
            //File Selected
            label.setText(chooser.getSelectedFile().getAbsolutePath());

            framesCreated.add(new ImageWindow(chooser.getSelectedFile().getAbsolutePath()));
        }else{
            //Cancel
        }


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem tmp = (JMenuItem) e.getSource();
        System.out.println("| "+ tmp.getText());
        this._menuClick(tmp.getText());
    }
}
