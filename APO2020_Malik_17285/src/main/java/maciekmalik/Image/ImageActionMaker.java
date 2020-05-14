/*
 * Copyright (c) 2020. Maciek Malik
 */

package maciekmalik.Image;

import java.awt.*;
import java.util.Map;

public interface ImageActionMaker{
    public BaseAction run(Image image, Map<Object, Object> options);
}
