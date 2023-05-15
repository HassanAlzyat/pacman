package com.example.demo3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author hassa
 */
public class Ghost extends Rectangle {

    Timeline time;
    public static double ghostSpeed = 13;

    private double dx, dy;
    private List<Node> obstacles = new ArrayList<>();
    Random random = new Random();

    public static Color GhostColor = Color.RED;

    //Constructor to create the ghosts 
    public Ghost(double x, double y, double width, double length, List<Node> obstacles) {

        super(x, y, width, length);

        this.obstacles = obstacles;
        this.setFill(GhostColor);
        dx = 1;
        dy = 1;
        time = new Timeline(new KeyFrame(Duration.millis(ghostSpeed), event -> {
            move();
            checkCollisions();

        }));
        time.setCycleCount(Timeline.INDEFINITE);
        time.play();
    }
    //another constructor to create the ghosts

    public Ghost(Rectangle ghost, List<Node> obstacles) {

        super(ghost.getX(), ghost.getY(), ghost.getWidth(), ghost.getHeight());

        this.obstacles = obstacles;
        this.setFill(GhostColor);
        dx = 1;
        dy = 1;
        time = new Timeline(new KeyFrame(Duration.millis(ghostSpeed), event -> {
            move();
            checkCollisions();

        }));
        time.setCycleCount(Timeline.INDEFINITE);
        time.play();

    }

    private void move() {
        this.setTranslateX(this.getTranslateX() + dx);
        this.setTranslateY(this.getTranslateY() + dy);

    }

    private void checkCollisions() {
        for (Node x : obstacles) {
            if (x.getBoundsInParent().intersects(this.getBoundsInParent())) {
                for (int i = 0; i < 15; i++) {
                    dy = -dy;
                    dx = -dx;
                    move();
                }
                changeDirection();

            }
        }
    }

    private void changeDirection() {

        double angle = random.nextDouble() * Math.PI * 2;
        dx = Math.cos(angle);
        dy = Math.sin(angle);

    }

}
