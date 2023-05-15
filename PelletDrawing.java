package com.example.demo3;

import static javafx.scene.paint.Color.YELLOW;
import javafx.scene.shape.Circle;

/**
 *
 * @author hassan
 */
public class PelletDrawing extends Circle {

    public PelletDrawing(double x, double y, double radius) {
        super(x, y, radius);
        this.setFill(YELLOW);

    }

}
