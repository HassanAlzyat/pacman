package com.example.demo3;

import java.io.File;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class wheel {

    public Scene wheel(Stage Primary) {
        Media whellSound = new Media(new File("D:\\roulette_casino_evianaif-14446.mp3").toURI().toString());
        MediaPlayer wsfx = new MediaPlayer(whellSound);
        Media h2 = new Media(new File("D:\\hover.wav").toURI().toString());
        MediaPlayer hvs = new MediaPlayer(h2);
        final int[] check = {1};
        Pane pane = new Pane();
        Pane arcPane = new Pane();
        int speed = 500;
        // Create a button
        Button BTspin = new Button("spin");
        BTspin.setLayoutX(340);
        BTspin.setLayoutY(450);
        BTspin.setMinSize(150, 30);

        Button Retray = new Button("PayToSpinAgain");
        Retray.setLayoutX(20);
        Retray.setLayoutY(450);
        Retray.setPrefSize(150, 30);
        Button Back = new Button("Back");
        Back.setLayoutX(180);
        Back.setLayoutY(450);
        Back.setPrefSize(150, 30);
        Back.setOnAction(HighEvent -> {
            Primary.setScene(RangeR2.createRangeScene(Primary));

        });
        //setting sfx for the button

        BTspin.setOnMouseEntered(e -> {
            hvs.stop();
            hvs.play();
        });
        Retray.setOnMouseEntered(e -> {
            hvs.stop();
            hvs.play();;
        });
        Back.setOnMouseEntered(e -> {
            hvs.stop();
            hvs.play();
        });
        //setting the style for the buttons
        BTspin.setStyle("-fx-background-color:linear-gradient(to right, #12c2e9, #c471ed, #f64f59);");
        Retray.setStyle("-fx-background-color:linear-gradient(to right, #12c2e9, #c471ed, #f64f59);");
        Back.setStyle("-fx-background-color:linear-gradient(to right, #12c2e9, #c471ed, #f64f59);");
        BTspin.setFont(Font.font("Comic Sans MS", 15));
        Retray.setFont(Font.font("Comic Sans MS", 15));
        Back.setFont(Font.font("Comic Sans MS", 15));
        // buttons response
        BTspin.setOnMouseMoved(e -> {
            BTspin.setStyle("-fx-background-color:linear-gradient(to right, #12c6e9, #c221ed, #fa4f59);");
            BTspin.setFont(Font.font("Comic Sans MS", 20));
        });
        BTspin.setOnMouseExited(e -> {
            BTspin.setStyle("-fx-background-color:linear-gradient(to right, #12c2e9, #c471ed, #f64f59);");
            BTspin.setFont(Font.font("Comic Sans MS", 15));

        });
        Retray.setOnMouseMoved(e -> {
            Retray.setStyle("-fx-background-color:linear-gradient(to right, #12c6e9, #c221ed, #fa4f59);");
            Retray.setFont(Font.font("Comic Sans MS", 20));
        });
        Retray.setOnMouseExited(e -> {
            Retray.setStyle("-fx-background-color:linear-gradient(to right, #12c2e9, #c471ed, #f64f59);");
            Retray.setFont(Font.font("Comic Sans MS", 15));

        });
        Back.setOnMouseMoved(e -> {
            Back.setStyle("-fx-background-color:linear-gradient(to right, #12c6e9, #c221ed, #fa4f59);");
            Back.setFont(Font.font("Comic Sans MS", 20));
        });
        Back.setOnMouseExited(e -> {
            Back.setStyle("-fx-background-color:linear-gradient(to right, #12c2e9, #c471ed, #f64f59);");
            Back.setFont(Font.font("Comic Sans MS", 15));

        });

        // Set the maximum width and height of the wheel
        pane.setMaxHeight(500);
        pane.setMaxWidth(500);

        Retray.setOnAction(e -> {
            Primary.setScene(wheel(Primary));
            if (Integer.parseInt(RangeR2.Score.getText()) > 200 && check[0] > 1) {
                RangeR2.Score.setText(Integer.toString(Integer.parseInt(RangeR2.Score.getText()) - 100));
            }

        });
        // Load an image and create an ImageView to display it
        Image image = new Image("background.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(500);
        imageView.setFitWidth(500);

        // Create a rectangle shape
        Rectangle rectangle = new Rectangle(410, 250, 100, 10);
        rectangle.setStroke(Color.WHITE);
        rectangle.setStrokeWidth(4);

        // Create two circle shapes
        Circle c1 = new Circle(150, 150, 180);
        c1.setFill(Color.GOLD);
        c1.setStroke(Color.RED);
        c1.setStrokeWidth(5);
        c1.centerXProperty().bind(pane.widthProperty().divide(2));
        c1.centerYProperty().bind(pane.heightProperty().divide(2));

        Circle c2 = new Circle(150, 150, 130);
        c2.setFill(Color.WHITE);
        c2.setStroke(Color.RED);
        c2.setStrokeWidth(3);
        c2.centerXProperty().bind(pane.widthProperty().divide(2));
        c2.centerYProperty().bind(pane.heightProperty().divide(2));

        Circle c3 = new Circle(250, 250, 15);
        c3.setFill(Color.BLACK);
        c3.setStroke(Color.BLACK);
        c3.setStrokeWidth(3);
        c3.centerXProperty().bind(pane.widthProperty().divide(2));
        c3.centerYProperty().bind(pane.heightProperty().divide(2));
        Circle c4 = new Circle(250, 250, 10);
        c4.setFill(Color.GOLD);
        c4.setStroke(Color.RED);
        c4.setStrokeWidth(3);
        c4.centerXProperty().bind(pane.widthProperty().divide(2));
        c4.centerYProperty().bind(pane.heightProperty().divide(2));

        // Create an array of Arc objects
        Arc[] arcs = new Arc[4];

        // Create four arcs and add them to the arcPane and arcs array
        for (int i = 0; i < 4; i++) {
            Arc arc = new Arc(250, 250, 165, 165, 360 / 4 * i, 90);
            arc.setType(ArcType.ROUND);
            arcPane.getChildren().addAll(arc);
            arcs[i] = arc;
            arc.centerXProperty().bind(pane.widthProperty().divide(2));
            arc.centerYProperty().bind(pane.heightProperty().divide(2));
        }

        // Set colors for the arcs
        arcs[0].setFill(Color.RED);
        arcs[1].setFill(Color.GREEN);
        arcs[3].setFill(Color.PURPLE);
        arcs[2].setFill(Color.BLUE);

        int[] score1 = {0};
        score1[0] = Integer.parseInt(RangeR2.Score.getText());
        Text t = new Text();
        // cheak before enter wheel
        if (score1[0] >= 200) {

            // Set an action for the button
            BTspin.setOnAction(e -> {
                if (check[0] == 1) {
                    wsfx.play();
                }

                // Create a timeline animation for arcs
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(30), e1 -> {
                    if (check[0] == 1) {

                        for (int i = 0; i < 4; i++) {
                            arcs[i].setStartAngle(arcs[i].getStartAngle() + 10);

                        }
                    }
                }));
                // Set the cycle count of the timeline randomly based on the speed variable
                timeline.setCycleCount((int) (Math.random() * speed));
                timeline.play();

                //////////////////////////////////////////////////////
                // Set an event handler for when the timeline finishes
                timeline.setOnFinished(event -> {
                    if (check[0] == 1) {
                        wsfx.pause();
                    }
                    Bounds r = rectangle.getBoundsInLocal();

                    int score = 0;
                    score = Integer.parseInt(RangeR2.Score.getText());

                    Text t1 = new Text("");
                    t1.setX(10);
                    t1.setY(440);
                    t1.setStyle("-fx-font-weight: bold");
                    t1.setFont(Font.font(28));
                    t1.setFill(Color.GOLD);
                    pane.getChildren().add(t1);

                    if (check[0] == 1) {

                        // Check if any of the arcs intersect with the rectangle
                        if (arcs[0].getBoundsInParent().intersects(r)) {
                            rectangle.setFill(arcs[0].getFill());
                            System.out.println("Selection 1 add 200");
                            RangeR2.Score.setText(Integer.toString(score + 200));
                            t1.setText("add 200");

                        } else if (arcs[1].getBoundsInParent().intersects(r)) {
                            rectangle.setFill(arcs[1].getFill());
                            System.out.println("Selection 2 add 1000");
                            RangeR2.Score.setText(Integer.toString(score + 100));

                            t1.setText("add 100");

                        } else if (arcs[2].getBoundsInParent().intersects(r)) {
                            rectangle.setFill(arcs[2].getFill());
                            System.out.println("Selection 3 sub 50");
                            RangeR2.Score.setText(Integer.toString(score - 50));
                            t1.setText("sub 50");

                        } else if (arcs[3].getBoundsInParent().intersects(r)) {
                            rectangle.setFill(arcs[3].getFill());
                            System.out.println("Selection 4 add 30");
                            RangeR2.Score.setText(Integer.toString(score + 50));
                            t1.setText("add 50");

                        } else {
                            rectangle.setFill(Color.WHITE);
                        }

                        timeline.stop();
                    }
                    check[0]++;
                });
            });
            /////////////////////////////////////////////////////////////
        } else {

            t.setText("there are not enough points ");
            t.setX(10);
            t.setY(440);
            t.setStyle("-fx-font-weight: bold");
            t.setFont(Font.font(28));
            t.setFill(Color.WHITE);

        }

        // Add the ImageView, circles, arcPane, rectangle, and button to the wheel
        pane.getChildren().addAll(imageView, c1, c2, arcPane, rectangle, BTspin, Back, RangeR2.Score, RangeR2.TotalScore, Retray, t, c3,
                 c4);

        Scene scene = new Scene(pane);
        return scene;
    }
}
