/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.paint.Color.RED;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author hassan
 */
public class PlayLevelCreated {

    public static int Score = 0;
    public static Text score = new Text(250, 18, "Score:" + Score);

    public static Scene create_Level_Created_Scene(Stage Primary, List Walls, List Pellets, List GhostCollection, int numOfPellets) {
        Media h2 = new Media(new File("D:\\hover.wav").toURI().toString());
        MediaPlayer hvs = new MediaPlayer(h2);
        //Creating the pane ,Reset Score,Text Style
        Score = 0;
        score.setFill(RED);
        score.setFont(Font.font(20));

        Pane P = new Pane();
        P.setStyle("-fx-background-color:black;");

        //Adding the walls and the Pellets to the Pane
        P.getChildren().addAll(Walls);
        P.getChildren().addAll(Pellets);

        //Creating PcMan
        PacManCreating PacMan = new PacManCreating(50, 70, 8, 8, 215, 300);
        //Moving PacMan
        PacMan.move(PacMan, Walls);

        // Changing from object type to node type
        //النقاط هنا من نوع object
        List<Node> pelletGroup = new ArrayList<>();
        for (int i = 0; i < Pellets.size(); i++) {
            pelletGroup.add((Node) Pellets.get(i));

        }

        List<Node> ghostGroup = new ArrayList<>();

        ArrayList<Rectangle> GhostsCreate = new ArrayList();

        for (int i = 0; i < GhostCollection.size(); i++) {
            GhostsCreate.add((Rectangle) GhostCollection.get(i));

        }

        //Creating ghosts with the same coordinates as send in ghost list using the second constructor
        for (Rectangle R : GhostsCreate) {
            Ghost ghost1 = new Ghost(R, Walls);
            P.getChildren().add(ghost1);
            ghostGroup.add(ghost1);
        }

        //check death
        Timeline timeLose = new Timeline(new KeyFrame(Duration.millis(3), event -> {
            boolean lose = CollisionDetection.isCollieded(PacMan, ghostGroup);
            if (lose) {
                PacMan.setCenterX(5000000);
                PacMan.setCenterY(5000000);
                Primary.setScene(LoseScene.createLoseScene(Primary, 6));
                lose = false;

            }

        }));
        timeLose.setCycleCount(Timeline.INDEFINITE);
        timeLose.play();

        //Collection detection way to avoid exception
        Timeline t = new Timeline(new KeyFrame(Duration.millis(1), event -> {
            List<Node> pelletsToRemove = new ArrayList<>();
            for (Node x : pelletGroup) {
                if (pelletEarn.isCollected(PacMan, x)) {
                    Score += 2;
                    score.setText("Score:" + Score);
                    pelletsToRemove.add(x);
                    x.setVisible(false);
                }
            }
            pelletGroup.removeAll(pelletsToRemove);
        }));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
        //Checking win
        Timeline timeWin = new Timeline(new KeyFrame(Duration.millis(1), event -> {
            if (Score == (numOfPellets * 2)) {
                PacMan.setCenterX(5000000);
                PacMan.setCenterY(5000000);
                Primary.setScene(WinningScene.createWinningScene(Primary));
                Score = 100000;
            }

        }));
        timeWin.setCycleCount(Timeline.INDEFINITE);
        timeWin.play();

        //Update the total Score
        Timeline timeScore = new Timeline(new KeyFrame(Duration.millis(1000), event -> {
            if (Score == 100000) {
                int lastScore = Integer.parseInt(String.valueOf(RangeR2.Score.getText()));
                RangeR2.Score.setText((String.valueOf((numOfPellets * 2 + lastScore))));
                Score = 0;
            }
        }));
        timeScore.setCycleCount(Timeline.INDEFINITE);
        timeScore.play();

        //Buttons 
        Button Back = new Button("Back");
        Back.setLayoutX(50);
        Back.setLayoutY(0);
        Back.setFont(Font.font("BankGothic Md BT", 15));
        Back.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");

        Back.setOnAction(e -> {
            PacMan.setCenterX(5000000);
            PacMan.setCenterY(5000000);

            Primary.setScene(LevelScene1.createLevelScene(Primary));

        });
        Back.setOnMouseEntered(e -> {
            hvs.stop();
            hvs.play();
        });

        //Adding elements to the pane 
        P.getChildren().addAll(PacMan, score, Back);

        Scene scene = new Scene(P, 1200, 650);
        PacMan.requestFocus();
        return scene;
    }

}
