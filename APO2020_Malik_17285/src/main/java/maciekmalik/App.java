/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik;


import javax.swing.*;

public class App {

    public App(){

        SwingUtilities.invokeLater(() -> new MainGUI().setVisible(true));

    }


    public static void main( String[] args ) {
        System.out.println( "Starting App" );
        new App();

    }
}
