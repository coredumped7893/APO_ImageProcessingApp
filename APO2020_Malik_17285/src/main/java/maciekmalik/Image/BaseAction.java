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

public class BaseAction {

    public static final Logger LOGGER = Logger.getLogger(MainGUI.class.getName());
    protected Image img;
    protected Map<Object, Object> options;
    protected JFrame frame = new JFrame();
    protected ImageWindow imageEdited;
    protected ImageWindow imageEditedCopy;
    protected static final int L_MIN = 0;
    protected static final int L_MAX = 255;

}
