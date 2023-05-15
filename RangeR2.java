package com.example.demo3;

import java.io.File;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.RED;
import static javafx.scene.paint.Color.YELLOW;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author hassa
 */
public class RangeR2 {

    public static Text TotalScore = new Text(50, 55, "Total Score :");
    public static Text Score = new Text(250, 55, "0");

    public static Scene createRangeScene(Stage Primary) {
        Media h1 = new Media(new File("D:\\hover.wav").toURI().toString());
        MediaPlayer hvs = new MediaPlayer(h1);

        Primary.setResizable(false);
        TotalScore.setFill(RED);
        TotalScore.setFont(Font.font(30));
        Score.setFill(RED);
        Score.setFont(Font.font(30));
        Score.setStyle("-fx-font-weight: bold");
        TotalScore.setStyle("-fx-font-weight: bold");

        //Animation
        Arc Arc1 = new Arc(450, 50, 40, 40, 215, 300);
        Arc1.setType(ArcType.ROUND);
        Arc1.setFill(YELLOW);
        Arc1.setStroke(YELLOW);

        Arc Arc2 = new Arc(450, 50, 40, 40, 300, 300);
        Arc2.setType(ArcType.ROUND);
        Arc2.setFill(YELLOW);
        Arc2.setStroke(YELLOW);

        Circle circleMove = new Circle(450, 50, 25);
        circleMove.setFill(YELLOW);
        circleMove.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                Color newColor = new Color(Math.random(), Math.random(), Math.random(), 1);
                circleMove.setFill(newColor);
                Arc1.setFill(newColor);
                Arc2.setFill(newColor);
                Arc1.setStroke(newColor);
                Arc2.setStroke(newColor);
            }
            if (e.getButton() == MouseButton.SECONDARY) {
                circleMove.setFill(YELLOW);
                Arc1.setFill(YELLOW);
                Arc1.setStroke(YELLOW);
                Arc2.setFill(YELLOW);
                Arc2.setStroke(YELLOW);
            }

        });

        Polyline path_Circle = new Polyline();
        path_Circle.setStrokeWidth(0);
        path_Circle.getPoints().addAll(450.0, 50.0, 50.0, 50.0, 50.0, 50.0, 50.0,
                450.0, 50.0, 450.0, 450.0, 450.0, 450.0, 450.0, 450.0, 50.0);

        EventHandler event = new EventHandler() {

            @Override
            public void handle(Event event) {

                FadeTransition FD1 = new FadeTransition(Duration.millis(5600), Arc1);
                FD1.setFromValue(1);
                FD1.setToValue(0);
                FD1.setByValue(1);
                FD1.setAutoReverse(true);
                FD1.setCycleCount(FadeTransition.INDEFINITE);
                FD1.play();

                FadeTransition FD2 = new FadeTransition(Duration.millis(5300), Arc2);
                FD2.setFromValue(0);
                FD2.setToValue(1);
                FD2.setByValue(1);
                FD2.setAutoReverse(true);
                FD2.setCycleCount(FadeTransition.INDEFINITE);
                FD2.play();

                PathTransition PArc_3 = new PathTransition(Duration.millis(5250), path_Circle, circleMove);
                PArc_3.setAutoReverse(false);
                PArc_3.setCycleCount(1);
                PArc_3.play();
            }
        };

        Timeline CricleTime = new Timeline(new KeyFrame(Duration.seconds(3), event));
        CricleTime.setAutoReverse(true);
        CricleTime.setCycleCount(Timeline.INDEFINITE);
        CricleTime.play();

        //Buttons 
        Button Low = new Button("Low");
        Low.setLayoutX(180);
        Low.setLayoutY(230);
        Low.setPrefSize(150, 30);
        Button Moderate = new Button("Moderate");
        Moderate.setLayoutX(180);
        Moderate.setLayoutY(280);
        Moderate.setPrefSize(150, 30);
        Button High = new Button("High");
        High.setLayoutX(180);
        High.setLayoutY(330);
        High.setPrefSize(150, 30);

        Button Collect = new Button("Collect Pellets");
        Collect.setLayoutX(180);
        Collect.setLayoutY(380);
        Collect.setPrefSize(150, 30);

        Button Back = new Button("Back");
        Back.setLayoutX(180);
        Back.setLayoutY(430);
        Back.setPrefSize(150, 30);

        Button wheel = new Button("wheel");
        wheel.setLayoutX(400);
        wheel.setLayoutY(450);
        //wheel.setPrefSize(80, 30);

        //buttons styling
        Low.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        Moderate.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        High.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        Collect.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        Back.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        wheel.setStyle("-fx-background-color: linear-gradient(to bottom, #ff8c00, #ffaf00); -fx-text-fill: white;");
        Low.setFont(Font.font("Public Pixel"));
        Moderate.setFont(Font.font("Public Pixel"));
        High.setFont(Font.font("Public Pixel"));
        Collect.setFont(Font.font("Public Pixel", 9));
        Back.setFont(Font.font("Public Pixel"));
        wheel.setFont(Font.font("BankGothic Md BT"));
        //buttons  sound effects
        Low.setOnMouseEntered(ev_in -> {
            hvs.stop();
            hvs.play();
        });
        Moderate.setOnMouseEntered(ev_in -> {
            hvs.stop();
            hvs.play();
        });
        High.setOnMouseEntered(ev_in -> {
            hvs.stop();
            hvs.play();
        });
        Back.setOnMouseEntered(ev_in -> {
            hvs.stop();
            hvs.play();
        });
        wheel.setOnMouseEntered(ev_in -> {
            hvs.stop();
            hvs.play();
        });
        Collect.setOnMouseEntered(ev_in -> {
            hvs.stop();
            hvs.play();
        });
        //buttons rsponde
        Low.setOnMouseMoved(eh -> {
            Low.setFont(Font.font("Public Pixel", 18));
            Low.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1)16%, rgba(241,238,12,1) 30%);");

        });
        Low.setOnMouseExited(eh -> {

            Low.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
            Low.setFont(Font.font("Public Pixel", 15));

        });
        Moderate.setOnMouseMoved(eh -> {
            Moderate.setFont(Font.font("Public Pixel", 18));
            Moderate.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1)16%, rgba(241,238,12,1) 30%);");

        });
        Moderate.setOnMouseExited(eh -> {

            Moderate.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
            Moderate.setFont(Font.font("Public Pixel", 15));

        });
        High.setOnMouseMoved(eh -> {
            High.setFont(Font.font("Public Pixel", 16));
            High.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1)16%, rgba(241,238,12,1) 30%);");

        });
        High.setOnMouseExited(eh -> {

            High.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
            High.setFont(Font.font("Public Pixel", 15));

        });
        Back.setOnMouseMoved(eh -> {
            Back.setFont(Font.font("Public Pixel", 18));
            Back.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1)16%, rgba(241,238,12,1) 30%);");

        });
        Back.setOnMouseExited(eh -> {

            Back.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
            Back.setFont(Font.font("Public Pixel", 15));

        });
        Collect.setOnMouseMoved(eh -> {
            Collect.setFont(Font.font("Public Pixel", 13));
            Collect.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1)16%, rgba(241,238,12,1) 30%);");

        });
        Collect.setOnMouseExited(eh -> {

            Back.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
            Collect.setFont(Font.font("Public Pixel", 9));

        });
        wheel.setOnMouseMoved(eh -> {
            wheel.setFont(Font.font("BankGothic Md BT", 20));
        });
        wheel.setOnMouseExited(eh -> {
            wheel.setFont(Font.font("BankGothic Md BT", 15));
        });

        wheel.setOnAction(e -> {
            wheel wheel1 = new wheel();

            Primary.setScene(wheel1.wheel(Primary));
            if (Integer.parseInt(RangeR2.Score.getText()) > 100) {
                RangeR2.Score.setText(Integer.toString(Integer.parseInt(RangeR2.Score.getText()) - 100));
            }

        });

        //Actions for Buttons
        High.setOnAction(HighEvent -> {
            Ghost.ghostSpeed = 9;
            Primary.setScene(LevelScene1.createLevelScene(Primary));

        });

        Back.setOnAction(HighEvent -> {
            Primary.setScene(MainScene.CreateScene(Primary));

        });
        Low.setOnAction(playEvent -> {
            Ghost.ghostSpeed = 18;
            Primary.setScene(LevelScene1.createLevelScene(Primary));

        });

        Moderate.setOnAction(ModerateEvent -> {
            Ghost.ghostSpeed = 13;
            Primary.setScene(LevelScene1.createLevelScene(Primary));

        });

        Collect.setOnAction(ModerateEvent -> {

            Primary.setScene(LevelcollectPellets.createCollectScene(Primary));

        });
        //Background and pane

        Image backgroundImage = new Image("background.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(500);
        backgroundImageView.setFitHeight(500);

        Pane P = new Pane(backgroundImageView);
        P.getChildren().addAll(Score, TotalScore, High, Low, Moderate, Back, Arc2, Arc1, path_Circle, circleMove, Collect, wheel);
        Scene Range_Scene = new Scene(P, 500, 500);

        return Range_Scene;
    }

}
