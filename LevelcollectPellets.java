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
public class LevelcollectPellets {

    private static int Score_Collect = 0;
    public static Text Textscore_Collect = new Text(250, 18, "Score:" + Score_Collect);
    static boolean update = false;

    public static Scene createCollectScene(Stage Primary) {
        Media h2 = new Media(new File("D:\\hover.wav").toURI().toString());
        MediaPlayer hvs = new MediaPlayer(h2);
        //Reset Score ,Pane Creating ,background and text Style
        Score_Collect = 0;
        Primary.setResizable(false);
        Textscore_Collect.setFill(RED);
        Textscore_Collect.setFont(Font.font(20));
        Textscore_Collect.setText("Score:" + Score_Collect);

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

        //Creating PacMan
        PacManCreating PacMan = new PacManCreating(385, 60, 8, 8, 215, 300);

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
            Primary.setScene(LevelcollectPellets.createCollectScene(Primary));

        });

        // Creaing Maze
        Pane P = new Pane();
        P.setStyle("-fx-background-color:black;");

        WallsDrawing wall_2 = new WallsDrawing(0, 30, 700, 10);
        WallsDrawing wall_3 = new WallsDrawing(0, 30, 10, 500);
        WallsDrawing wall_4 = new WallsDrawing(0, 490, 700, 10);
        WallsDrawing wall_5 = new WallsDrawing(690, 30, 10, 500);

        // adding walls in a list of node
        List<Node> wallGroup = new ArrayList<>();

        wallGroup.add(wall_2);
        wallGroup.add(wall_3);
        wallGroup.add(wall_4);
        wallGroup.add(wall_5);

        P.getChildren().addAll(wallGroup);

        //Moving PacMac
        PacMan.move(PacMan, wallGroup);

        //creating pellets for the first time
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
        //Recreate pellets every minute
        Timeline timePellet = new Timeline(new KeyFrame(Duration.seconds(60), event -> {

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
        }));
        timePellet.setCycleCount(Timeline.INDEFINITE);
        timePellet.play();

        //Collection detection way to avoid exception
        Timeline t = new Timeline(new KeyFrame(Duration.millis(1), event -> {
            List<Node> pelletsToRemove = new ArrayList<>();
            for (Node x : pelletGroup) {
                if (pelletEarn.isCollected(PacMan, x)) {
                    Score_Collect += 2;
                    Textscore_Collect.setText("Score:" + Score_Collect);
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
        Ghost ghost3 = new Ghost(650, 50, 15, 15, wallGroup);
        Ghost ghost4 = new Ghost(50, 200, 15, 15, wallGroup);
        Ghost ghost5 = new Ghost(50, 400, 15, 15, wallGroup);
        Ghost ghost6 = new Ghost(390, 400, 15, 15, wallGroup);
        Ghost ghost7 = new Ghost(100, 430, 15, 15, wallGroup);

        // Adding ghosts in alist of node
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

                update = true;
                Primary.setScene(LoseScene.createLoseScene(Primary, 4));
                lose = false;
                PacMan.setCenterX(500000);
                PacMan.setCenterY(500000);

            }

        }));
        timeLose.setCycleCount(Timeline.INDEFINITE);
        timeLose.play();
        //update total Score
        Timeline timeUpdate = new Timeline(new KeyFrame(Duration.millis(1000), event -> {
            if (update) {
                int lastScore = Integer.parseInt(String.valueOf(RangeR2.Score.getText()));
                RangeR2.Score.setText((String.valueOf((Score_Collect + lastScore))));
                update = false;
            }

        }));
        timeUpdate.setCycleCount(Timeline.INDEFINITE);
        timeUpdate.play();

        P.getChildren().addAll(Back, Retray, PacMan, Textscore_Collect);
        P.getChildren().addAll(ghostGroup);

        Scene sceneLevelCollect = new Scene(P, 700, 500);
        PacMan.requestFocus();
        return sceneLevelCollect;

    }
}
