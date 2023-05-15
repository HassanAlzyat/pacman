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
public class Level_2_display {

    private static int Score_2 = 0;
    public static Text Textscore_2 = new Text(250, 18, "Score:" + Score_2);

    public static Scene createLevel_2_Scene(Stage Primary) {
        Media h2 = new Media(new File("D:\\hover.wav").toURI().toString());
        MediaPlayer hvs = new MediaPlayer(h2);

        // background ,Pane , Score Reset,Score Style
        Primary.setResizable(false);
        Score_2 = 0;
        Textscore_2.setFill(RED);
        Textscore_2.setFont(Font.font(20));
        Textscore_2.setText("Score:" + Score_2);

        Pane P = new Pane();
        P.setStyle("-fx-background-color:black;");

        //Creating PacMan
        PacManCreating PacMan = new PacManCreating(450, 245, 8, 8, 215, 300);

        //Buttons
        Button spin = new Button("spin");
        spin.setLayoutX(250);
        spin.setLayoutY(0);

        Button Back = new Button("Back");
        Back.setLayoutX(0);
        Back.setFont(Font.font("BankGothic Md BT", 15));
        Back.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        Back.setOnAction(HighEvent -> {
            PacMan.setCenterX(50000);
            PacMan.setCenterY(50000);
            Primary.setScene(LevelScene1.createLevelScene(Primary));
        }
        );
        Button Retray = new Button("Retray");
        Retray.setLayoutX(80);
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

        Retray.setOnAction(HighEvent -> {
            PacMan.setCenterX(50000);
            PacMan.setCenterY(50000);

            Primary.setScene(Level_2_display.createLevel_2_Scene(Primary));
        }
        );

        // Creaing Maze
        WallsDrawing wall_1 = new WallsDrawing(50, 80, 80, 50);
        WallsDrawing wall_2 = new WallsDrawing(300, 80, 80, 50);
        WallsDrawing wall_3 = new WallsDrawing(550, 80, 80, 50);
        WallsDrawing wall_4 = new WallsDrawing(50, 400, 80, 50);
        WallsDrawing wall_5 = new WallsDrawing(300, 400, 80, 50);
        WallsDrawing wall_6 = new WallsDrawing(550, 400, 80, 50);
        WallsDrawing wall_8 = new WallsDrawing(300, 165, 80, 200);
        WallsDrawing wall_9 = new WallsDrawing(0, 30, 700, 10);
        WallsDrawing wall_10 = new WallsDrawing(0, 30, 10, 500);
        WallsDrawing wall_11 = new WallsDrawing(0, 490, 700, 10);
        WallsDrawing wall_12 = new WallsDrawing(690, 30, 10, 500);

        //Adding walls to a list of Nodes
        List<Node> wallGroup = new ArrayList<>();
        wallGroup.add(wall_1);
        wallGroup.add(wall_2);
        wallGroup.add(wall_3);
        wallGroup.add(wall_4);
        wallGroup.add(wall_5);
        wallGroup.add(wall_6);
        wallGroup.add(wall_8);
        wallGroup.add(wall_9);
        wallGroup.add(wall_10);
        wallGroup.add(wall_11);
        wallGroup.add(wall_12);

        //Moving PacMac
        PacMan.move(PacMan, wallGroup);

        //creating pellets
        List<Node> pelletGroup = new ArrayList<>();
        for (int x = 20; x < 680; x = x + 15) {
            if (x == 50 || x == 305 || x == 530 || x == 380 | x == 635 || x == 545) {
                continue;
            }
            for (int y = 30; y < 470; y += 15) {
                if (y == 30 || y == 45 || y == 75 || y == 165 || y == 135 || y == 240 || y == 450 || y == 255) {

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
                    Score_2 += 2;
                    Textscore_2.setText("Score:" + Score_2);
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
        Ghost ghost2 = new Ghost(200, 300, 15, 15, wallGroup);
        Ghost ghost3 = new Ghost(650, 50, 15, 15, wallGroup);
        Ghost ghost4 = new Ghost(600, 300, 15, 15, wallGroup);
        Ghost ghost5 = new Ghost(390, 100, 15, 15, wallGroup);
        Ghost ghost6 = new Ghost(390, 400, 15, 15, wallGroup);
        Ghost ghost7 = new Ghost(100, 300, 15, 15, wallGroup);
        Ghost ghost8 = new Ghost(100, 350, 15, 15, wallGroup);
        Ghost ghost9 = new Ghost(600, 200, 15, 15, wallGroup);
        Ghost ghost10 = new Ghost(100, 500, 15, 15, wallGroup);

        //Adding Ghosts as a list of Nodes 
        List<Node> ghostGroup = new ArrayList<>();
        ghostGroup.add(ghost1);
        ghostGroup.add(ghost2);
        ghostGroup.add(ghost3);
        ghostGroup.add(ghost4);
        ghostGroup.add(ghost5);
        ghostGroup.add(ghost6);
        ghostGroup.add(ghost7);
        ghostGroup.add(ghost8);
        ghostGroup.add(ghost9);
        ghostGroup.add(ghost10);

        //checking death
        Timeline timeLose = new Timeline(new KeyFrame(Duration.millis(0.1), event -> {
            boolean lose = CollisionDetection.isCollieded(PacMan, ghostGroup);
            if (lose) {
                PacMan.setCenterX(5000000);
                PacMan.setCenterY(5000000);
                Primary.setScene(LoseScene.createLoseScene(Primary, 2));
                lose = false;

            }

        }));
        timeLose.setCycleCount(Timeline.INDEFINITE);
        timeLose.play();

        //checking Winning
        Timeline timeWin = new Timeline(new KeyFrame(Duration.millis(0.1), event -> {
            if (Score_2 == 200) {//1422
                PacMan.setCenterX(5000000);
                PacMan.setCenterY(5000000);
                Primary.setScene(WinningScene.createWinningScene(Primary));
                Score_2 = 3000;
            }

        }));
        timeWin.setCycleCount(Timeline.INDEFINITE);
        timeWin.play();

        //Update the total Score
        Timeline timeScore = new Timeline(new KeyFrame(Duration.millis(1000), event -> {
            if (Score_2 == 3000) {
                int lastScore = Integer.parseInt(String.valueOf(RangeR2.Score.getText()));
                RangeR2.Score.setText((String.valueOf((1422 + lastScore))));
                Score_2 = 0;
            }
        }));
        timeScore.setCycleCount(Timeline.INDEFINITE);
        timeScore.play();

        //Adding Nodes ang sets to the Pane
        P.getChildren().addAll(Textscore_2, PacMan, Back, Retray);
        P.getChildren().addAll(ghostGroup);
        P.getChildren().addAll(wallGroup);

        Scene sceneLevel_2 = new Scene(P, 700, 500);
        PacMan.requestFocus();
        return sceneLevel_2;

    }

}
