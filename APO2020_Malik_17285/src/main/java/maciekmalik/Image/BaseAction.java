/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image;

import maciekmalik.ImageWindow;
import maciekmalik.MainGUI;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Definicje bazowych pól
 */
public class BaseAction {



    /**
     * @deprecated
     */
    protected Map<Object, Object> options;

    public static final Logger LOGGER = Logger.getLogger(MainGUI.class.getName());
    protected Image img;

    /**
     * Okno z ustawieniami / wyborem parametrów
     */
    protected JFrame frame = new JFrame();

    /**
     * Obecnie edytowany obraz (okno)
     */
    protected ImageWindow imageEdited;

    /**
     * Kopia edytowanego obrazu,
     * Przy anulowaniu zmian, wartość obrazu przywracane jest z tej wartości
     */
    protected ImageWindow imageEditedCopy;

    /**
     * Minimalna wartosć piksela w obrazie w danym kanale
     */
    protected static final int L_MIN = 0;


    /**
     * Maksymalna wartosć piksela w obrazie w danym kanale
     */
    protected static final int L_MAX = 255;

}
