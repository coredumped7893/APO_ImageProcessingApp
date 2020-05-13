/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik;


import javax.swing.*;
import java.util.logging.LogManager;

public class App {


    /**
     * Determines the state of logs in console
     */
    private static final boolean isDevMode = true;


    public App(){

        if(!isDevMode){
            LogManager.getLogManager().reset();
        }

        SwingUtilities.invokeLater(() -> new MainGUI().setVisible(true));
    }


    public static void main( String[] args ) {
        System.out.println( "Starting App" );
        new App();
    }
}
