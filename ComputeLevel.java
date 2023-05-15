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
 * @author hassa
 */
public class ComputeLevel {

    public static int Score = 0;
    public static Text Tscore = new Text(250, 18, "Score:" + Score);
    public static int timeCount = 60;
    public static Text TimeScore = new Text(350, 18, "Time Left:" + timeCount);

    public static Scene CreateComputeLevel(Stage Primary) {
        Media h2 = new Media(new File("D:\\hover.wav").toURI().toString());
        MediaPlayer hvs = new MediaPlayer(h2);
        //Creating background ,Reset Scores and ext style
        Score = 0;
        timeCount = 60;
        Tscore.setText("Score:" + Score);
        Primary.setResizable(false);
        Tscore.setFill(RED);
        Tscore.setFont(Font.font(20));
        TimeScore.setFill(RED);
        TimeScore.setFont(Font.font(20));

        //Creating PacMan
        PacManCreating PacMan = new PacManCreating(450, 60, 8, 8, 215, 300);

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

        //Buttons Action 
        Back.setOnMouseEntered(e -> {
            hvs.stop();
            hvs.play();
        });
        Retray.setOnMouseEntered(e -> {
            hvs.stop();
            hvs.play();
        });
        Back.setOnAction(e -> {
            PacMan.setCenterX(50000);
            PacMan.setCenterY(50000);
            Primary.setScene(LevelScene1.createLevelScene(Primary));

        });

        Retray.setOnAction(e -> {
            PacMan.setCenterX(50000);
            PacMan.setCenterY(50000);
            Primary.setScene(ComputeLevel.CreateComputeLevel(Primary));

        });

        // Creaing Maze
        Pane P = new Pane();
        P.setStyle("-fx-background-color:black;");

        WallsDrawing wall_1 = new WallsDrawing(0, 30, 1180, 15);
        WallsDrawing wall_2 = new WallsDrawing(0, 30, 15, 600);
        WallsDrawing wall_3 = new WallsDrawing(1180, 30, 15, 600);
        WallsDrawing wall_4 = new WallsDrawing(0, 630, 1195, 15);

        //Adding walls as a list of nodes
        List<Node> wallGroup = new ArrayList<>();
        wallGroup.add(wall_1);
        wallGroup.add(wall_2);
        wallGroup.add(wall_3);
        wallGroup.add(wall_4);

        P.getChildren().addAll(wallGroup);

        //Moving PacMac
        PacMan.move(PacMan, wallGroup);

        //creating pellets
        List<Node> pelletGroup = new ArrayList<>();
        for (int x = 40; x < 1160; x += 30) {

            for (int y = 75; y < 630; y += 30) {

                PelletDrawing pellet1 = new PelletDrawing(x, y, 3);
                P.getChildren().add(pellet1);
                pelletGroup.add(pellet1);

            }
        }

        //Collection detection way to avoid exception
        Timeline t = new Timeline(new KeyFrame(Duration.millis(1), event -> {
            List<Node> pelletsToRemove = new ArrayList<>();
            for (Node x : pelletGroup) {
                if (pelletEarn.isCollected(PacMan, x)) {
                    Score += 2;
                    Tscore.setText("Score:" + Score);
                    pelletsToRemove.add(x);
                    x.setVisible(false);
                }
            }
            pelletGroup.removeAll(pelletsToRemove);
        }));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
        //Checking wining

        Timeline decreaseTime = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            timeCount -= 1;
            TimeScore.setText("Time Left:" + timeCount);

        }));
        decreaseTime.setCycleCount(Timeline.INDEFINITE);
        decreaseTime.play();

        Timeline CheckWin = new Timeline(new KeyFrame(Duration.millis(1), event -> {

            if (timeCount == 0 || Score == 2774) {//2774
                if (Score == 2774) {
                    PacMan.setCenterX(5000000);
                    PacMan.setCenterY(5000000);
                    Primary.setScene(WinningScene.createWinningScene(Primary));

                    Score = 10000;
                } else {
                    PacMan.setCenterX(5000000);
                    PacMan.setCenterY(5000000);
                    Score = 0;

                    Primary.setScene(LoseScene.createLoseScene(Primary, 5));
                }
            }

        }));
        CheckWin.setCycleCount(Timeline.INDEFINITE);
        CheckWin.play();

        //Update the total score1
        Timeline timeScore = new Timeline(new KeyFrame(Duration.millis(1000), event -> {
            if (Score == 10000) {
                int lastScore = Integer.parseInt(String.valueOf(RangeR2.Score.getText()));
                RangeR2.Score.setText((String.valueOf((2774 + lastScore))));
                Score = 0;
            }
        }));
        timeScore.setCycleCount(Timeline.INDEFINITE);
        timeScore.play();

        // creating ghost
        Ghost ghost1 = new Ghost(200, 200, 15, 15, wallGroup);
        Ghost ghost2 = new Ghost(200, 330, 15, 15, wallGroup);
        Ghost ghost3 = new Ghost(650, 50, 15, 15, wallGroup);
        Ghost ghost4 = new Ghost(50, 200, 15, 15, wallGroup);
        Ghost ghost5 = new Ghost(50, 400, 15, 15, wallGroup);
        Ghost ghost6 = new Ghost(390, 400, 15, 15, wallGroup);
        Ghost ghost7 = new Ghost(70, 300, 15, 15, wallGroup);
        Ghost ghost8 = new Ghost(70, 350, 15, 15, wallGroup);
        Ghost ghost9 = new Ghost(600, 200, 15, 15, wallGroup);
        Ghost ghost10 = new Ghost(100, 500, 15, 15, wallGroup);

        // Adding ghosts in a list of nodes
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

        //check death
        Timeline timeLose = new Timeline(new KeyFrame(Duration.millis(3), event -> {
            if (CollisionDetection.isCollieded(PacMan, ghostGroup)) {
                PacMan.setCenterX(50000);
                PacMan.setCenterY(50000);

                Primary.setScene(LoseScene.createLoseScene(Primary, 5));
            }

        }));
        timeLose.setCycleCount(Timeline.INDEFINITE);
        timeLose.play();

        //Adding elements in the pane
        P.getChildren().addAll(Back, Retray, PacMan, Tscore, TimeScore);
        P.getChildren().addAll(ghostGroup);

        Scene LevelCompute = new Scene(P, 1200, 650);

        PacMan.requestFocus();

        return LevelCompute;

    }

}
