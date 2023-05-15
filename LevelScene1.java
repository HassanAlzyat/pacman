
package com.example.demo3;

import java.io.File;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.YELLOW;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author hassan
 */
public class LevelScene1 {

    public static javafx.scene.Scene createLevelScene(Stage Primary) {
        Primary.setResizable(false);
    Media h1=new Media(new File("D:\\hover.wav").toURI().toString());
    MediaPlayer hvs =new MediaPlayer(h1);
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
                Color newColor = new Color(Math.random(), Math.random(), Math.random(),1);
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
       
        //Create Buttons and there action
        Button Create_Level = new Button(" CreateLevel");
        Create_Level.setLayoutX(180);
        Create_Level.setLayoutY(380);
        Create_Level.setPrefSize(150, 30);
        Create_Level.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        Create_Level .setFont(Font.font("BankGothic Md BT"));
        Create_Level.setOnAction(e -> {
            Primary.setScene(CreateLevel.createYourLevel(Primary));

        });

        Button Level_1 = new Button(" Level_1");
        Level_1.setLayoutX(180);
        Level_1.setLayoutY(180);
        Level_1.setPrefSize(150, 30);
        Level_1.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        Level_1 .setFont(Font.font("BankGothic Md BT",15));
        Level_1.setOnAction(e -> {
            Primary.setScene(Level_1_display.createLevel_1_Scene(Primary));
        });
        Button Level_2 = new Button(" Level_2");
        Level_2.setLayoutX(180);
        Level_2.setLayoutY(230);
        Level_2.setPrefSize(150, 30);
        Level_2.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        Level_2 .setFont(Font.font("BankGothic Md BT",15));

        Level_2.setOnAction(e -> {
            Primary.setScene(Level_2_display.createLevel_2_Scene(Primary));
        });
        Button Level_3 = new Button(" Level_3");
        Level_3.setLayoutX(180);
        Level_3.setLayoutY(280);
        Level_3.setPrefSize(150, 30);
        Level_3.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        Level_3 .setFont(Font.font("BankGothic Md BT",15));

        Level_3.setOnAction(e -> {
            Primary.setScene(Level_3_dispaly.createLevel_3_Scene(Primary));
        });
        Button LevelCompete = new Button(" LevelCompete");
        LevelCompete.setLayoutX(180);
        LevelCompete.setLayoutY(330);
        LevelCompete.setPrefSize(150, 30);
        LevelCompete.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        LevelCompete.setFont(Font.font("BankGothic Md BT",15));

        LevelCompete.setOnAction(e -> {
            Primary.setScene(ComputeLevel.CreateComputeLevel(Primary));
        });
        Button Back = new Button(" Back");
        Back.setLayoutX(180);
        Back.setLayoutY(430);
        Back.setPrefSize(150, 30);
        Back.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        Back .setFont(Font.font("BankGothic Md BT",15));

        Back.setOnAction(HighEvent -> {
            Primary.setScene(RangeR2.createRangeScene(Primary));

        });
        //set sfx for buttons
    Level_1.setOnMouseEntered(ev_in -> {
    hvs.stop();
    hvs.play();
});
    Level_2.setOnMouseEntered(ev_in -> {
    hvs.stop();
    hvs.play();
});
    Level_3.setOnMouseEntered(ev_in -> {
    hvs.stop();
    hvs.play();
});  
    Back.setOnMouseEntered(ev_in -> {
    hvs.stop();
    hvs.play();
});
    LevelCompete.setOnMouseEntered(ev_in -> {
    hvs.stop();
    hvs.play();
});  
     Create_Level.setOnMouseEntered(ev_in -> {
    hvs.stop();
    hvs.play();
});  
     
     //buttons responde
      Level_1.setOnMouseMoved(eh->{
           Level_1.setFont(Font.font("BankGothic Md BT",20));
      });
      Level_1.setOnMouseExited(eh->{
                   Level_1.setFont(Font.font("BankGothic Md BT",15));
      });
      Level_2.setOnMouseMoved(eh->{
           Level_2.setFont(Font.font("BankGothic Md BT",20));
      });
      Level_2.setOnMouseExited(eh->{
                   Level_2.setFont(Font.font("BankGothic Md BT",15));
      });  
      Level_3.setOnMouseMoved(eh->{
           Level_3.setFont(Font.font("BankGothic Md BT",20));
      });
      Level_3.setOnMouseExited(eh->{
                   Level_3.setFont(Font.font("BankGothic Md BT",15));
      });     
    Back.setOnMouseMoved(eh->{
           Back.setFont(Font.font("BankGothic Md BT",20));
      });
    Back.setOnMouseExited(eh->{
                   Back.setFont(Font.font("BankGothic Md BT",15));
      });   
    Create_Level.setOnMouseMoved(eh->{
           Create_Level.setFont(Font.font("BankGothic Md BT",20));
      });
    Create_Level.setOnMouseExited(eh->{
                   Create_Level.setFont(Font.font("BankGothic Md BT",15));
      });  
    LevelCompete.setOnMouseMoved(eh->{
           LevelCompete.setFont(Font.font("BankGothic Md BT",20));
      });
    LevelCompete.setOnMouseExited(eh->{
                   LevelCompete.setFont(Font.font("BankGothic Md BT",15));
      });   
        //Create the pane ,set background and addint the elements in the Pane

        Image backgroundImage = new Image("background.jpg");

        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(500);
        backgroundImageView.setFitHeight(500);

        Pane P = new Pane(backgroundImageView);
        P.getChildren().addAll(Level_1, Level_2, Level_3, LevelCompete, Create_Level, Back, Arc2, Arc1, path_Circle, circleMove);
        javafx.scene.Scene Levels_Scene = new javafx.scene.Scene(P, 500, 500);

        return Levels_Scene;
    }

}
