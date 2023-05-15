/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo3;

import java.io.File;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.paint.Color.RED;
import static javafx.scene.paint.Color.YELLOW;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author hassa
 */
public class MainScene {

    public static int buttonClicked;

    public static Scene CreateScene(Stage Primary) {
        //loading the font to the ide
        Font f_game = Font.loadFont("file:///D:\\PublicPixel.ttf", 15);

// the font when the mouse is in 
        Font fin = Font.loadFont("file:///D:\\PublicPixel.ttf", 20);
        Media h1 = new Media(new File("D:\\hover.wav").toURI().toString());
        MediaPlayer hvs = new MediaPlayer(h1);
        //Create Buttons
        Primary.setResizable(false);
        Button Play = new Button("Play");
        Play.setLayoutX(180);
        Play.setLayoutY(230);
        Play.setPrefSize(150, 30);
        Button Setting = new Button("Setting");
        Setting.setLayoutX(180);
        Setting.setLayoutY(280);
        Setting.setPrefSize(150, 30);
        Button Exit = new Button("Exit");
        Exit.setLayoutX(180);
        Exit.setLayoutY(330);
        Exit.setPrefSize(150, 30);
        //setting button style
        Play.setFont(f_game);
        Play.setStyle("-fx-background-color:linear-gradient(to right, #00d2ff 0%, #3a7bd5  51%, #00d2ff  100%);"
                + "-fx-border-radius:20;"
                + " -fx-text-fill:#ffec14;");
        //setting button style
        Setting.setFont(f_game);
        Setting.setStyle("-fx-background-color:linear-gradient(to right, #00d2ff 0%, #3a7bd5  51%, #00d2ff  100%);"
                + "-fx-border-radius:20;"
                + " -fx-text-fill:#ffec14;");
        //setting button style
        Exit.setFont(f_game);
        Exit.setStyle("-fx-background-color:linear-gradient(to right, #00d2ff 0%, #3a7bd5  51%, #00d2ff  100%);"
                + "-fx-border-radius:20;"
                + " -fx-text-fill:#ffec14;");

        //Buttons actions
        Play.setOnAction(playEvent -> {
            Primary.setScene(RangeR2.createRangeScene(Primary));

        });
        Exit.setOnAction(e -> {
            Primary.close();

        });
        Setting.setOnAction(e -> {
            Primary.setScene(Settingscene.createSettingScene(Primary));

        });
        //setting mouse events for the buttons    
        Play.setOnMouseMoved(eh -> {

            Play.setFont(fin);

            Play.setStyle("-fx-background-color:linear-gradient(to left, #02d2ff 0%, #3a7cd5  51%, #0012ff  100%);" + " -fx-text-fill:#ffec14;");
        });
        Play.setOnMouseExited(eh -> {
            Play.setFont(f_game);
            Play.setStyle("-fx-background-color:linear-gradient(to right, #00d2ff 0%, #3a7bd5  51%, #00d2ff  100%);"
                    + " -fx-text-fill:#ffec14;");

        });
        Play.setOnMouseEntered(event -> {
            hvs.stop();
            hvs.play();
        });
        Setting.setOnMouseMoved(eh -> {

            Setting.setFont(fin);

            Setting.setStyle("-fx-background-color:linear-gradient(to left, #02d2ff 0%, #3a7cd5  51%, #0012ff  100%);" + " -fx-text-fill:#ffec14;");
        });
        Setting.setOnMouseExited(eh -> {
            Setting.setFont(f_game);
            Setting.setStyle("-fx-background-color:linear-gradient(to right, #00d2ff 0%, #3a7bd5  51%, #00d2ff  100%);"
                    + " -fx-text-fill:#ffec14;");

        });
        Setting.setOnMouseEntered(event -> {
            hvs.stop();
            hvs.play();
        });
        Exit.setOnMouseMoved(eh -> {

            Exit.setFont(fin);

            Exit.setStyle("-fx-background-color:linear-gradient(to left, #02d2ff 0%, #3a7cd5  51%, #0012ff  100%);" + " -fx-text-fill:#ffec14;");
        });
        Exit.setOnMouseExited(eh -> {
            Exit.setFont(f_game);
            Exit.setStyle("-fx-background-color:linear-gradient(to right, #00d2ff 0%, #3a7bd5  51%, #00d2ff  100%);"
                    + " -fx-text-fill:#ffec14;");

        });
        Exit.setOnMouseEntered(event -> {
            hvs.stop();
            hvs.play();
        });

        //Creating background
        Image backgroundImage = new Image("background.jpg");

        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(500);
        backgroundImageView.setFitHeight(500);

        //Creating Animation
        Text T1 = new Text("Pac Man Game");
        T1.setFill(RED);
        T1.setFont(f_game);
        Arc Arc1 = new Arc(450, 50, 40, 40, 215, 300);
        Arc1.setType(ArcType.ROUND);
        Arc1.setFill(YELLOW);
        Arc1.setStroke(YELLOW);

        Circle C1 = new Circle(600, 20, 3);
        C1.setFill(RED);
        Circle C2 = new Circle(700, 20, 3);
        C2.setFill(RED);
        Circle C3 = new Circle(700, 20, 3);
        C3.setFill(RED);

        Line L1 = new Line(500, 50, 100, 50);
        Line L2 = new Line(550, 53, 215, 53);
        Line L3 = new Line(550, 53, 225, 53);
        Line L4 = new Line(550, 53, 235, 53);
        PathTransition PT1 = new PathTransition(Duration.millis(3000), L1, T1);
        PT1.setAutoReverse(true);
        PT1.setCycleCount(1);
        PT1.play();

        PathTransition PT2 = new PathTransition(Duration.millis(4000), L2, C1);
        PT2.setAutoReverse(true);
        PT2.setCycleCount(1);
        PT2.play();
        PathTransition PT3 = new PathTransition(Duration.millis(4500), L3, C2);
        PT3.setAutoReverse(true);
        PT3.setCycleCount(1);
        PT3.play();

        PathTransition PT4 = new PathTransition(Duration.millis(5000), L4, C3);
        PT4.setAutoReverse(true);
        PT4.setCycleCount(1);
        PT4.play();

        FadeTransition FT1 = new FadeTransition(Duration.millis(3000), T1);
        FT1.setFromValue(0);
        FT1.setToValue(1);
        FT1.setByValue(0.1);
        FT1.setAutoReverse(true);
        FT1.setCycleCount(1);
        FT1.play();

        FadeTransition FT2 = new FadeTransition(Duration.millis(4000), C1);
        FT2.setFromValue(0);
        FT2.setToValue(1);
        FT2.setByValue(0.1);
        FT2.setAutoReverse(true);
        FT2.setCycleCount(1);
        FT2.play();

        FadeTransition FT3 = new FadeTransition(Duration.millis(4500), C2);
        FT3.setFromValue(0);
        FT3.setToValue(1);
        FT3.setByValue(0.1);
        FT3.setAutoReverse(true);
        FT3.setCycleCount(1);
        FT3.play();

        FadeTransition FT4 = new FadeTransition(Duration.millis(5000), C3);
        FT4.setFromValue(0);
        FT4.setToValue(1);
        FT4.setByValue(0.1);
        FT4.setAutoReverse(true);
        FT4.setCycleCount(1);
        FT4.play();

        //Creating the pane ,set the background and add the elements to the pane
        Pane P = new Pane(backgroundImageView);
        P.setPrefSize(backgroundImage.getWidth(), backgroundImage.getHeight());
        P.getChildren().addAll(T1, C1, C2, C3, Play, Setting, Exit, Arc1);

        Scene scene_main = new Scene(P, 500, 500);

        return scene_main;

    }

}
