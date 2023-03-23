package org.example;
import com.formdev.flatlaf.FlatDarculaLaf;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        /**
         * Hiermit wird der Farbton im Maven hinterlegt
         */
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf()
            );
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        /** Hiermit wird der Konstruktor aufgerufen
         */
          ControllerZeitrechner controllerZeitrechner = new ControllerZeitrechner();

    }
}