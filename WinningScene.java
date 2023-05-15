package com.example.demo3;

import java.io.File;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;

/**
 *
 * @author hassa
 */
public class WinningScene {

    public static Scene createWinningScene(Stage Primary) {
        //Create pane and set the background
        Primary.setResizable(false);
        Image backgroundImage = new Image("win.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(500);
        backgroundImageView.setFitHeight(500);

        Pane winPane = new Pane(backgroundImageView);
        //sound of winning
        Media h2 = new Media(new File("D:\\hover.wav").toURI().toString());
        MediaPlayer hvs = new MediaPlayer(h2);
        Media s1 = new Media(new File("D:\\winsquare-6993.mp3").toURI().toString());
        MediaPlayer m1 = new MediaPlayer(s1);
        m1.play();

        //Buttons and their actions
        Button Play = new Button("Paly Again");
        Play.setLayoutX(190);
        Play.setLayoutY(300);
        Play.setPrefSize(150, 30);
        Play.setFont(Font.font("BankGothic Md BT", 15));
        Play.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        Play.setOnAction(e -> {
            Primary.setScene(LevelScene1.createLevelScene(Primary));

        });

        Button Exit = new Button("Exit");
        Exit.setLayoutX(190);
        Exit.setLayoutY(380);
        Exit.setPrefSize(150, 30);
        Exit.setFont(Font.font("BankGothic Md BT", 15));
        Exit.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        Exit.setOnAction(e -> {
            Primary.close();

        });

        Button Back = new Button("Back to main ");
        Back.setLayoutX(192);
        Back.setLayoutY(460);
        Back.setPrefSize(150, 30);
        Back.setFont(Font.font("BankGothic Md BT", 15));
        Back.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        Back.setOnAction(e -> {

            Primary.setScene(MainScene.CreateScene(Primary));

        });
        //buttons response
        Back.setOnMouseMoved(eh -> {
            Back.setFont(Font.font("BankGothic Md BT", 20));
        });
        Back.setOnMouseExited(eh -> {
            Back.setFont(Font.font("BankGothic Md BT", 15));
        });
        Exit.setOnMouseMoved(eh -> {
            Exit.setFont(Font.font("BankGothic Md BT", 20));
        });
        Exit.setOnMouseExited(eh -> {
            Exit.setFont(Font.font("BankGothic Md BT", 15));
        });
        Play.setOnMouseMoved(eh -> {
            Play.setFont(Font.font("BankGothic Md BT", 20));
        });
        Play.setOnMouseExited(eh -> {
            Play.setFont(Font.font("BankGothic Md BT", 15));
        });
        //buttons sfx
        Back.setOnMouseEntered(e -> {
            hvs.stop();
            hvs.play();
        });
        Exit.setOnMouseEntered(e -> {
            hvs.stop();
            hvs.play();
        });
        Play.setOnMouseEntered(e -> {
            hvs.stop();
            hvs.play();
        });
        //Addin elements in the pane
        winPane.getChildren().addAll(Exit, Play, Back);
        Scene sceneWin = new Scene(winPane, 500, 500);
        return sceneWin;
    }

}
