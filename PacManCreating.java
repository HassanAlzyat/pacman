package com.example.demo3;

import java.util.Collection;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.scene.Node;
import static javafx.scene.input.KeyCode.A;
import static javafx.scene.input.KeyCode.D;
import static javafx.scene.input.KeyCode.S;
import static javafx.scene.input.KeyCode.W;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;

/**
 *
 * @author hassan
 */
public class PacManCreating extends Arc {

    public static int speed = 5;
    public static Timeline t;
    public static Color PacmanColor = Color.YELLOW;

    public PacManCreating(double centerX, double centerY, double radiusX, double radiusY, double startAngle, double length) {
        super(centerX, centerY, radiusX, radiusY, startAngle, length);
        this.setType(ArcType.ROUND);
        this.setFill(PacmanColor);
        this.setStroke(PacmanColor);

    }
    //PacMan moving with controles

    public void move(Node pacman, Collection<Node> nodes) {
        t = new Timeline(new KeyFrame(Duration.millis(0.1), event -> {
            this.setOnKeyPressed(e -> {
                //Cheking collision 
                boolean collided = CollisionDetection.isCollieded(pacman, nodes);
                if (collided) {
                    if (e.getCode() == W) {
                        this.setCenterY(this.getCenterY() + 10);

                    } else if (e.getCode() == S) {
                        this.setCenterY(this.getCenterY() - 10);

                    } else if (e.getCode() == A) {
                        this.setCenterX(this.getCenterX() + 10);

                    } else if (e.getCode() == D) {
                        this.setCenterX(this.getCenterX() - 10);

                    }

                } else {

                    if (e.getCode() == A) {
                        this.setCenterX(this.getCenterX() - speed);
                        this.setRotate(0);

                    }
                    if (e.getCode() == D) {
                        this.setCenterX(this.getCenterX() + speed);
                        this.setRotate(180);

                    }

                    if (e.getCode() == S) {
                        this.setCenterY(this.getCenterY() + speed);
                        this.setRotate(270);

                    }
                    if (e.getCode() == W) {
                        this.setCenterY(this.getCenterY() - speed);
                        this.setRotate(90);

                    }
                    if (e.getCode() == A && e.getCode() == S) {
                        this.setCenterX(this.getCenterX());
                        this.setCenterY(this.getCenterY());

                    }

                }
            });
            this.setOnKeyReleased(e -> {
                boolean collided = CollisionDetection.isCollieded(pacman, nodes);
                if (collided) {
                    if (e.getCode() == W) {
                        this.setCenterY(this.getCenterY() + 10);

                    } else if (e.getCode() == S) {
                        this.setCenterY(this.getCenterY() - 10);

                    } else if (e.getCode() == A) {
                        this.setCenterX(this.getCenterX() + 10);

                    } else if (e.getCode() == D) {
                        this.setCenterX(this.getCenterX() - 10);

                    }
                }
            });

        }));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
        this.requestFocus();

    }
}
