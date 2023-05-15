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
import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.RED;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author hassan
 */
public class Level_3_dispaly {

    public static int Score_3 = 0;
    public static Text Textscore_3 = new Text(250, 18, "Score:" + Score_3);

    public static Scene createLevel_3_Scene(Stage Primary) {
        Media h2 = new Media(new File("D:\\hover.wav").toURI().toString());
        MediaPlayer hvs = new MediaPlayer(h2);
        //Reset score ,Style text,Ceateing image 
        Primary.setResizable(false);
        Score_3 = 0;
        Textscore_3.setFill(RED);
        Textscore_3.setFont(Font.font(20));
        Textscore_3.setText("Score:" + Score_3);

        //PacMan Creating
        PacManCreating PacMan = new PacManCreating(450, 200, 8, 8, 215, 300);

        //Buttons
        Button Back = new Button("Back");
        Back.setFont(Font.font("BankGothic Md BT", 15));
        Back.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        Back.setOnAction(HighEvent -> {
            PacMan.setCenterX(50000);
            PacMan.setCenterY(50000);
            Primary.setScene(LevelScene1.createLevelScene(Primary));

        }
        );
        Button spin = new Button("spin");
        spin.setLayoutX(150);
        spin.setLayoutY(0);
        Button Retray = new Button("Retray");
        Retray.setLayoutX(80);
        Retray.setLayoutY(0);
        Retray.setFont(Font.font("BankGothic Md BT", 15));
        Retray.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");

        //button sfx
        Retray.setOnMouseEntered(e -> {
            hvs.stop();
            hvs.play();;
        });
        Back.setOnMouseEntered(e -> {
            hvs.stop();
            hvs.play();
        });

        Retray.setOnAction(HighEvent -> {
            PacMan.setCenterX(5000000);
            PacMan.setCenterY(5000000);

            Primary.setScene(Level_3_dispaly.createLevel_3_Scene(Primary));
        }
        );
        Pane P = new Pane();
        P.setStyle("-fx-background-color:black;");

        //creating pellets
        List<Node> pelletGroup = new ArrayList<>();
        for (int x = 75; x < 1170; x = x + 15) {
            if (x == 585 || x == 600 || x == 750 || x == 110 || (x > 315 && x < 465) || (x > 975 && x < 1125)) {
                continue;
            }
            for (int y = 75; y < 600; y += 15) {
                if (y == 210 || y == 225 || y == 375 || y == 390 || y == 405 || y == 570 || y == 555) {
                    continue;
                } else {
                    PelletDrawing pellet1 = new PelletDrawing(x, y, 3);
                    P.getChildren().add(pellet1);
                    pelletGroup.add(pellet1);

                }

            }
        }

        // Creaing Maze
        WallsDrawing wall_1 = new WallsDrawing(0, 30, 1180, 15);
        WallsDrawing wall_2 = new WallsDrawing(0, 30, 15, 600);
        WallsDrawing wall_3 = new WallsDrawing(1180, 30, 15, 600);
        WallsDrawing wall_4 = new WallsDrawing(0, 630, 1195, 15);
        WallsDrawing wall_5 = new WallsDrawing(100, 225, 15, 150);
        WallsDrawing wall_6 = new WallsDrawing(100, 210, 150, 15);
        WallsDrawing wall_7 = new WallsDrawing(100, 375, 150, 15);
        WallsDrawing wall_8 = new WallsDrawing(235, 225, 15, 40);
        WallsDrawing wall_9 = new WallsDrawing(235, 345, 15, 40);
        WallsDrawing wall_10 = new WallsDrawing(585, 110, 15, 460);
        WallsDrawing wall_11 = new WallsDrawing(585, 110, 350, 15);
        WallsDrawing wall_12 = new WallsDrawing(585, 555, 350, 15);
        WallsDrawing wall_13 = new WallsDrawing(750, 280, 125, 125);
        WallsDrawing wall_14 = new WallsDrawing(360, 100, 50, 50);
        WallsDrawing wall_15 = new WallsDrawing(360, 500, 50, 50);

        Circle C2 = new Circle(1050, 342.5, 60);
        Circle C1 = new Circle(385, 300, 60);
        C1.setFill(BLUE);
        C2.setFill(BLUE);

        //Adding walls in a list of node
        List<Node> wallGroup = new ArrayList<>();
        wallGroup.add(wall_1);
        wallGroup.add(wall_2);
        wallGroup.add(wall_3);
        wallGroup.add(wall_4);
        wallGroup.add(wall_5);
        wallGroup.add(wall_6);
        wallGroup.add(wall_7);
        wallGroup.add(wall_8);
        wallGroup.add(wall_9);
        wallGroup.add(wall_10);
        wallGroup.add(wall_11);
        wallGroup.add(wall_12);
        wallGroup.add(wall_13);
        wallGroup.add(wall_14);
        wallGroup.add(wall_15);
        wallGroup.add(C1);
        wallGroup.add(C2);

        P.getChildren().addAll(wallGroup);

        //Moving PacMac
        PacMan.move(PacMan, wallGroup);
        //Collection detection way to avoid exception
        Timeline t = new Timeline(new KeyFrame(Duration.millis(1), event -> {
            List<Node> pelletsToRemove = new ArrayList<>();
            for (Node x : pelletGroup) {
                if (pelletEarn.isCollected(PacMan, x)) {
                    Score_3 += 2;
                    Textscore_3.setText("Score:" + Score_3);
                    pelletsToRemove.add(x);
                    x.setVisible(false);
                }
            }
            pelletGroup.removeAll(pelletsToRemove);
        }));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();

        // creating ghost
        Ghost ghost1 = new Ghost(200, 100, 15, 15, wallGroup);
        Ghost ghost2 = new Ghost(200, 300, 15, 15, wallGroup);
        Ghost ghost3 = new Ghost(650, 50, 15, 15, wallGroup);
        Ghost ghost4 = new Ghost(600, 300, 15, 15, wallGroup);
        Ghost ghost5 = new Ghost(420, 100, 15, 15, wallGroup);
        Ghost ghost6 = new Ghost(390, 400, 15, 15, wallGroup);
        Ghost ghost7 = new Ghost(70, 300, 15, 15, wallGroup);
        Ghost ghost8 = new Ghost(70, 350, 15, 15, wallGroup);
        Ghost ghost9 = new Ghost(600, 200, 15, 15, wallGroup);
        Ghost ghost10 = new Ghost(100, 500, 15, 15, wallGroup);

        Ghost ghost11 = new Ghost(1050, 200, 15, 15, wallGroup);
        Ghost ghost12 = new Ghost(1050, 430, 15, 15, wallGroup);
        Ghost ghost13 = new Ghost(730, 300, 15, 15, wallGroup);
        Ghost ghost14 = new Ghost(730, 500, 15, 15, wallGroup);
        Ghost ghost15 = new Ghost(1100, 200, 15, 15, wallGroup);
        Ghost ghost16 = new Ghost(3, 500, 15, 15, wallGroup);

        //collosion detection for ghosts and pac man
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
        ghostGroup.add(ghost11);
        ghostGroup.add(ghost12);
        ghostGroup.add(ghost13);
        ghostGroup.add(ghost14);
        ghostGroup.add(ghost15);

        //checking death
        Timeline timeLose = new Timeline(new KeyFrame(Duration.millis(0.1), event -> {
            boolean lose = CollisionDetection.isCollieded(PacMan, ghostGroup);
            if (lose) {
                PacMan.setCenterX(5000000);
                PacMan.setCenterY(5000000);

                Primary.setScene(LoseScene.createLoseScene(Primary, 3));
                lose = false;

            }

        }));
        timeLose.setCycleCount(Timeline.INDEFINITE);
        timeLose.play();

        //Cheaking wining
        Timeline timeWin = new Timeline(new KeyFrame(Duration.millis(1), event -> {
            if (Score_3 == 200) {//2750
                PacMan.setCenterX(5000000);
                PacMan.setCenterY(5000000);
                Primary.setScene(WinningScene.createWinningScene(Primary));
                Score_3 = 3000;
            }

        }));
        timeWin.setCycleCount(Timeline.INDEFINITE);
        timeWin.play();

        //Update the total score
        Timeline timeScore = new Timeline(new KeyFrame(Duration.millis(1000), event -> {
            if (Score_3 == 3000) {
                int lastScore = Integer.parseInt(String.valueOf(RangeR2.Score.getText()));
                RangeR2.Score.setText((String.valueOf((2750 + lastScore))));
                Score_3 = 0;
            }
        }));
        timeScore.setCycleCount(Timeline.INDEFINITE);
        timeScore.play();

        //Adding nodes in the pane
        P.getChildren().addAll(Back, Retray, PacMan, Textscore_3);
        P.getChildren().addAll(ghostGroup);

        Scene sceneLevel_3 = new Scene(P, 1200, 650);
        PacMan.requestFocus();
        return sceneLevel_3;

    }

}
