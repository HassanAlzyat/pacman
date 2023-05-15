package com.example.demo3;

import java.io.File;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author hassan
 */
public class LoseScene {

    public static Scene createLoseScene(Stage Primary, int level) {
        //Creating the pane ,background and buttons
        Primary.setResizable(false);
        Media h2 = new Media(new File("D:\\hover.wav").toURI().toString());
        MediaPlayer hvs = new MediaPlayer(h2);
        Media sLose = new Media(new File("D:\\8-bit-video-game-lose-sound-version-4-145477.mp3").toURI().toString());
        MediaPlayer mLose = new MediaPlayer(sLose);
        mLose.play();
        Image backgroundImage = new Image("gameover.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(500);
        backgroundImageView.setFitHeight(500);
        Pane losePane = new Pane(backgroundImageView);

        Button Retray = new Button("Retray");
        Retray.setLayoutX(270);
        Retray.setLayoutY(50);
        Retray.setPrefSize(150, 30);
        Retray.setFont(Font.font("BankGothic Md BT", 15));
        Retray.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        Retray.setOnAction(e -> {
            //Checking which level we gonna to retry
            if (level == 1) {
                Primary.setScene(Level_1_display.createLevel_1_Scene(Primary));
            } else if (level == 2) {
                Primary.setScene(Level_2_display.createLevel_2_Scene(Primary));
            } else if (level == 3) {
                Primary.setScene(Level_3_dispaly.createLevel_3_Scene(Primary));
            } else if (level == 4) {
                Primary.setScene(LevelcollectPellets.createCollectScene(Primary));
            } else if (level == 5) {
                Primary.setScene(ComputeLevel.CreateComputeLevel(Primary));

            } else if (level == 6) {
                Primary.setScene(CreateLevel.createYourLevel(Primary));

            }

        });

        Button Exit = new Button("Exit");
        Exit.setLayoutX(180);
        Exit.setLayoutY(450);
        Exit.setPrefSize(150, 30);
        Exit.setFont(Font.font("BankGothic Md BT", 15));
        Exit.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        Exit.setOnAction(e -> {
            Primary.close();

        });

        Button Back = new Button("Back");
        Back.setLayoutX(100);
        Back.setLayoutY(50);
        Back.setPrefSize(150, 30);
        Back.setFont(Font.font("BankGothic Md BT", 15));
        Back.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        Back.setOnAction(e -> {
            Primary.setScene(LevelScene1.createLevelScene(Primary));

        });
        //buttons sfx
        //setting sfx for the button 

        Exit.setOnMouseEntered(e -> {
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
        //buttons response
        Back.setOnMouseMoved(eh -> {
            Back.setFont(Font.font("BankGothic Md BT", 20));
        });
        Back.setOnMouseExited(eh -> {
            Back.setFont(Font.font("BankGothic Md BT", 15));
        });
        Retray.setOnMouseMoved(eh -> {
            Retray.setFont(Font.font("BankGothic Md BT", 20));
        });
        Retray.setOnMouseExited(eh -> {
            Retray.setFont(Font.font("BankGothic Md BT", 15));
        });
        Exit.setOnMouseMoved(eh -> {
            Exit.setFont(Font.font("BankGothic Md BT", 20));
        });
        Exit.setOnMouseExited(eh -> {
            Exit.setFont(Font.font("BankGothic Md BT", 15));
        });

        //Adding elements to the pane
        losePane.getChildren().addAll(Exit, Back, Retray);

        Scene loseScene = new Scene(losePane, 500, 500);
        return loseScene;
    }

}
