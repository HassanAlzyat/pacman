package com.example.demo3;

import static javafx.scene.paint.Color.BLUE;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author hassa
 */
public class WallsDrawing extends Rectangle {

    WallsDrawing() {

    }

    public WallsDrawing(double x, double y, double width, double hight) {
        super(x, y, width, hight);
        this.setFill(BLUE);
    }

}
