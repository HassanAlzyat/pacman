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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author hassan
 */
public class Level_1_display {

    public static int Score_1;
    public static Text Textscore_1 = new Text(250, 18, "Score:" + Score_1);

    public static Scene createLevel_1_Scene(Stage Primary) {
        Media h2 = new Media(new File("D:\\hover.wav").toURI().toString());
        MediaPlayer hvs = new MediaPlayer(h2);
        //Create the Pane ,Reset Score ,backgroung,and text style
        Primary.setResizable(false);
        Score_1 = 0;
        Textscore_1.setFill(RED);
        Textscore_1.setFont(Font.font(20));
        Textscore_1.setText("Score:" + Score_1);

        //Creating PacMan
        PacManCreating PacMan = new PacManCreating(390, 60, 8, 8, 215, 300);

        //Buttons
        Button Back = new Button("back");
        Back.setLayoutX(0);
        Back.setLayoutY(0);
        Back.setFont(Font.font("BankGothic Md BT", 15));
        Back.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        Button Retray = new Button("Retray");
        Retray.setLayoutX(125);
        Retray.setLayoutY(0);
        Retray.setFont(Font.font("BankGothic Md BT", 15));
        Retray.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");

        //buttons sfx
        Retray.setOnMouseEntered(e -> {
            hvs.stop();
            hvs.play();;
        });
        Back.setOnMouseEntered(e -> {
            hvs.stop();
            hvs.play();
        });

        //Buttons Action 
        Back.setOnAction(e -> {
            PacMan.setCenterX(50000);
            PacMan.setCenterY(50000);

            Primary.setScene(LevelScene1.createLevelScene(Primary));

        });

        Retray.setOnAction(e -> {
            PacMan.setCenterX(50000);
            PacMan.setCenterY(50000);

            Primary.setScene(Level_1_display.createLevel_1_Scene(Primary));

        });
        Pane P = new Pane();
        P.setStyle("-fx-background-color:black;");

        //creating maze
        WallsDrawing wall_2 = new WallsDrawing(0, 30, 700, 10);
        WallsDrawing wall_3 = new WallsDrawing(0, 30, 10, 500);
        WallsDrawing wall_4 = new WallsDrawing(0, 490, 700, 10);
        WallsDrawing wall_5 = new WallsDrawing(690, 30, 10, 500);
        WallsDrawing wall_6 = new WallsDrawing(50, 100, 650, 10);
        WallsDrawing wall_7 = new WallsDrawing(50, 300, 650, 10);

        //Adding walls to a list of Nodes
        List<Node> wallGroup = new ArrayList<>();

        wallGroup.add(wall_2);
        wallGroup.add(wall_3);
        wallGroup.add(wall_4);
        wallGroup.add(wall_5);
        wallGroup.add(wall_6);
        wallGroup.add(wall_7);

        P.getChildren().addAll(wallGroup);

        //Moving PacMac
        PacMan.move(PacMan, wallGroup);

        //creating pellets
        List<Node> pelletGroup = new ArrayList<>();
        for (int x = 20; x < 680; x = x + 15) {
            if (x == 380 || x == 395 || x == 20) {
                continue;
            }
            for (int y = 60; y < 470; y += 15) {
                if (y == 105 || y == 300 || y == 315 || y == 165) {

                } else {
                    PelletDrawing pellet1 = new PelletDrawing(x, y, 3);
                    P.getChildren().add(pellet1);
                    pelletGroup.add(pellet1);

                }

            }
        }

        //Collection detection way to avoid exception
        Timeline t = new Timeline(new KeyFrame(Duration.millis(1), event -> {
            List<Node> pelletsToRemove = new ArrayList<>();
            for (Node x : pelletGroup) {
                if (pelletEarn.isCollected(PacMan, x)) {
                    Score_1 += 2;
                    Textscore_1.setText("Score:" + Score_1);
                    pelletsToRemove.add(x);
                    x.setVisible(false);
                }
            }
            pelletGroup.removeAll(pelletsToRemove);
        }));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();

        // creating ghost
        Ghost ghost1 = new Ghost(200, 200, 15, 15, wallGroup);
        Ghost ghost2 = new Ghost(200, 330, 15, 15, wallGroup);
        Ghost ghost3 = new Ghost(650, 200, 15, 15, wallGroup);
        Ghost ghost4 = new Ghost(50, 200, 15, 15, wallGroup);
        Ghost ghost5 = new Ghost(50, 400, 15, 15, wallGroup);
        Ghost ghost6 = new Ghost(390, 400, 15, 15, wallGroup);
        Ghost ghost7 = new Ghost(100, 430, 15, 15, wallGroup);

        //Adding ghosts as a list of node
        List<Node> ghostGroup = new ArrayList<>();
        ghostGroup.add(ghost1);
        ghostGroup.add(ghost2);
        ghostGroup.add(ghost3);
        ghostGroup.add(ghost4);
        ghostGroup.add(ghost5);
        ghostGroup.add(ghost6);
        ghostGroup.add(ghost7);

        //check death
        Timeline timeLose = new Timeline(new KeyFrame(Duration.millis(0.1), event -> {
            boolean lose = CollisionDetection.isCollieded(PacMan, ghostGroup);
            if (lose) {
                PacMan.setCenterX(5000000);
                PacMan.setCenterY(5000000);
                Primary.setScene(LoseScene.createLoseScene(Primary, 1));
                lose = false;

            }

        }));
        timeLose.setCycleCount(Timeline.INDEFINITE);
        timeLose.play();

        //checking winning
        Timeline timeWin = new Timeline(new KeyFrame(Duration.millis(1), event -> {

            if (Score_1 == 1968) {
                PacMan.setCenterX(10000);
                PacMan.setCenterY(10000);

                Primary.setScene(WinningScene.createWinningScene(Primary));
                Score_1 = 3000;

            }

        }));
        timeWin.setCycleCount(Timeline.INDEFINITE);
        timeWin.play();

        //Update the total Score
        Timeline timeScore = new Timeline(new KeyFrame(Duration.millis(1000), event -> {
            if (Score_1 == 3000) {
                int lastScore = Integer.parseInt(String.valueOf(RangeR2.Score.getText()));
                RangeR2.Score.setText((String.valueOf((1968 + lastScore))));
                Score_1 = 0;
            }
        }));
        timeScore.setCycleCount(Timeline.INDEFINITE);
        timeScore.play();

        //Adding nodes to the pane
        P.getChildren().addAll(Textscore_1, Back, Retray, PacMan);
        P.getChildren().addAll(ghostGroup);

        Scene sceneLevel_1 = new Scene(P, 700, 500);
        PacMan.requestFocus();

        return sceneLevel_1;

    }

}
