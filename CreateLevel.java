package com.example.demo3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.RED;
import static javafx.scene.paint.Color.YELLOW;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author hassan
 */
public class CreateLevel {

    static int numOfPellets = 0;

    public static Scene createYourLevel(Stage Primary) {
        Media h2 = new Media(new File("D:\\hover.wav").toURI().toString());
        MediaPlayer hvs = new MediaPlayer(h2);
        //Reset the num of pellets ,create the pane and add background to it
        numOfPellets = 0;
        Pane P = new Pane();
        P.setStyle("-fx-background-color:black;");

        // observable lists to add or remove the nodes to the pane
        ObservableList<Node> CirclesCollection = P.getChildren();
        ObservableList<Node> RectangleCollection = P.getChildren();
        ObservableList<Node> PelletsCollection = P.getChildren();
        ObservableList<Node> GhostCollection = P.getChildren();
        //Lists for walls,pellets.ghosts to send it as parameters to the function
        List<Node> wallGroup = new ArrayList<>();
        List<Node> pelletGroup = new ArrayList<>();
        List<Node> GhostGroup = new ArrayList<>();
        List<Node> removedNodes = new ArrayList<>();

        //Creating Buttons
        Button Back = new Button("Back");
        Back.setLayoutX(50);
        Back.setLayoutY(0);
        Back.setFont(Font.font("BankGothic Md BT", 15));
        Back.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        Button Reset = new Button("Reset");
        Reset.setLayoutX(150);
        Reset.setLayoutY(0);
        Reset.setFont(Font.font("BankGothic Md BT", 15));
        Reset.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");

        Button Play = new Button("Play");
        Play.setLayoutX(250);
        Play.setLayoutY(0);
        Play.setFont(Font.font("BankGothic Md BT", 15));
        Play.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");

        //Buttons Actions
        Back.setOnMouseEntered(e -> {
            hvs.stop();
            hvs.play();
        });
        Reset.setOnMouseEntered(e -> {
            hvs.stop();
            hvs.play();
        });
        Play.setOnMouseEntered(e -> {
            hvs.stop();
            hvs.play();
        });
        Back.setOnAction(e -> {

            Primary.setScene(LevelScene1.createLevelScene(Primary));

        });
        Reset.setOnAction(e -> {

            Primary.setScene(CreateLevel.createYourLevel(Primary));

        });

        //Creating Borders
        WallsDrawing wall_1 = new WallsDrawing(0, 30, 1180, 15);
        WallsDrawing wall_2 = new WallsDrawing(0, 30, 15, 600);
        WallsDrawing wall_3 = new WallsDrawing(1180, 30, 15, 600);
        WallsDrawing wall_4 = new WallsDrawing(0, 630, 1195, 15);

        //Adding walls as a List because there is functions take parameter as a set of shape
        wallGroup.add(wall_1);
        wallGroup.add(wall_2);
        wallGroup.add(wall_3);
        wallGroup.add(wall_4);

        //creating PacMan
        PacManCreating PacMan = new PacManCreating(50, 70, 8, 8, 215, 300);

        //Creating combo list
        String S[] = {"Rectangle 50x50", "Rectangle 200X30", "Rectangle 30X200", "Rectangle 80X200", "Rectangle 200X80", "Circle 50", "Circle 100", "Ghost", "Pellet", "non"};
        ObservableList Choices = FXCollections.observableArrayList(S);

        ComboBox CB = new ComboBox(Choices);
        CB.setLayoutX(600);
        CB.setLayoutY(5);
        CB.setVisibleRowCount(3);
        CB.setValue("non");
        //Adding elements

        CB.setOnAction(e -> {

            if (CB.getValue().equals("Circle 50")) {
                P.setOnMouseClicked(event -> {

                    if (event.getButton() == MouseButton.PRIMARY) {

                        Circle C1 = new Circle(event.getX(), event.getY(), 50);
                        C1.setFill(BLUE);
                        wallGroup.add(C1);

                        CirclesCollection.add(C1);
                    }
                    if (event.getButton() == MouseButton.SECONDARY) {
                        for (Node x : CirclesCollection) {
                            if (x.contains(event.getX(), event.getY())) {
                                removedNodes.add(x);
                                wallGroup.remove(x);

                            }

                        }
                        CirclesCollection.removeAll(removedNodes);

                    }
                });
            }
            if (CB.getValue().equals("Circle 100")) {
                P.setOnMouseClicked(event -> {

                    if (event.getButton() == MouseButton.PRIMARY) {

                        Circle C1 = new Circle(event.getX(), event.getY(), 100);
                        C1.setFill(BLUE);
                        wallGroup.add(C1);

                        CirclesCollection.add(C1);
                    }
                    if (event.getButton() == MouseButton.SECONDARY) {
                        for (Node x : CirclesCollection) {
                            if (x.contains(event.getX(), event.getY())) {
                                removedNodes.add(x);
                                wallGroup.remove(x);

                            }

                        }
                        CirclesCollection.removeAll(removedNodes);
                    }
                });
            }

            if (CB.getValue().equals("Rectangle 50x50")) {
                P.setOnMouseClicked(event -> {
                    if (event.getButton() == MouseButton.PRIMARY) {

                        Rectangle R = new Rectangle(event.getX(), event.getY(), 50, 50);
                        R.setFill(BLUE);
                        RectangleCollection.add(R);
                        wallGroup.add(R);

                    }
                    if (event.getButton() == MouseButton.SECONDARY) {
                        for (Node x : RectangleCollection) {
                            if (x.contains(event.getX(), event.getY())) {

                                removedNodes.add(x);
                                wallGroup.remove(x);

                            }

                        }
                        RectangleCollection.removeAll(removedNodes);
                    }
                });
            }
            if (CB.getValue().equals("Rectangle 80X200")) {
                P.setOnMouseClicked(event -> {
                    if (event.getButton() == MouseButton.PRIMARY) {

                        Rectangle R = new Rectangle(event.getX(), event.getY(), 80, 200);
                        R.setFill(BLUE);
                        RectangleCollection.add(R);
                        wallGroup.add(R);

                    }
                    if (event.getButton() == MouseButton.SECONDARY) {
                        for (Node x : RectangleCollection) {
                            if (x.contains(event.getX(), event.getY())) {

                                removedNodes.add(x);
                                wallGroup.remove(x);

                            }

                        }
                        RectangleCollection.removeAll(removedNodes);
                    }
                });
            }
            if (CB.getValue().equals("Rectangle 200X80")) {
                P.setOnMouseClicked(event -> {
                    if (event.getButton() == MouseButton.PRIMARY) {

                        Rectangle R = new Rectangle(event.getX(), event.getY(), 200, 80);
                        R.setFill(BLUE);
                        RectangleCollection.add(R);
                        wallGroup.add(R);

                    }
                    if (event.getButton() == MouseButton.SECONDARY) {
                        for (Node x : RectangleCollection) {
                            if (x.contains(event.getX(), event.getY())) {

                                removedNodes.add(x);
                                wallGroup.remove(x);

                            }

                        }
                        RectangleCollection.removeAll(removedNodes);
                    }
                });
            }

            if (CB.getValue().equals("Rectangle 200X30")) {
                P.setOnMouseClicked(event -> {
                    if (event.getButton() == MouseButton.PRIMARY) {

                        Rectangle R = new Rectangle(event.getX(), event.getY(), 200, 30);
                        R.setFill(BLUE);
                        RectangleCollection.add(R);
                        wallGroup.add(R);

                    }
                    if (event.getButton() == MouseButton.SECONDARY) {
                        for (Node x : RectangleCollection) {
                            if (x.contains(event.getX(), event.getY())) {

                                removedNodes.add(x);
                                wallGroup.remove(x);

                            }

                        }
                        RectangleCollection.removeAll(removedNodes);
                    }
                });
            }
            if (CB.getValue().equals("Rectangle 30X200")) {
                P.setOnMouseClicked(event -> {
                    if (event.getButton() == MouseButton.PRIMARY) {

                        Rectangle R = new Rectangle(event.getX(), event.getY(), 30, 200);
                        R.setFill(BLUE);
                        RectangleCollection.add(R);
                        wallGroup.add(R);

                    }
                    if (event.getButton() == MouseButton.SECONDARY) {
                        for (Node x : RectangleCollection) {
                            if (x.contains(event.getX(), event.getY())) {
                                wallGroup.remove(x);

                                removedNodes.add(x);
                            }

                        }
                        RectangleCollection.removeAll(removedNodes);
                    }
                });
            }

            if (CB.getValue().equals("Pellet")) {
                P.setOnMouseClicked(event -> {
                    if (event.getButton() == MouseButton.PRIMARY) {
                        Circle C = new Circle(event.getX(), event.getY(), 5);
                        C.setFill(YELLOW);
                        PelletsCollection.add(C);
                        pelletGroup.add(C);
                        numOfPellets++;

                    }
                    if (event.getButton() == MouseButton.SECONDARY) {
                        for (Node x : PelletsCollection) {
                            if (x.contains(event.getX(), event.getY())) {
                                removedNodes.add(x);
                                pelletGroup.remove(x);
                                numOfPellets--;
                            }

                        }
                        PelletsCollection.removeAll(removedNodes);
                    }
                });
            }

            if (CB.getValue().equals("Ghost")) {
                P.setOnMouseClicked(event -> {
                    if (event.getButton() == MouseButton.PRIMARY) {
                        Rectangle R = new Rectangle(event.getX(), event.getY(), 15, 15);
                        R.setFill(RED);
                        GhostCollection.add(R);
                        GhostGroup.add(R);

                    }
                    if (event.getButton() == MouseButton.SECONDARY) {
                        for (Node x : GhostCollection) {
                            if (x.contains(event.getX(), event.getY())) {
                                removedNodes.add(x);
                                GhostGroup.add(x);

                            }

                        }
                        GhostCollection.removeAll(removedNodes);
                    }
                });
            }

            if (CB.getValue().equals("non")) {
                P.setOnMouseClicked(event -> {
                    if (event.getButton() == MouseButton.PRIMARY) {

                    }
                    if (event.getButton() == MouseButton.SECONDARY) {

                    }
                });
            }

        });
        //Adding nodes to the pane

        P.getChildren().addAll(wallGroup);

        P.getChildren().addAll(CB, PacMan, Play, Reset, Back);
        //Button play Action
        Play.setOnAction(e -> {

            Primary.setScene(PlayLevelCreated.create_Level_Created_Scene(Primary, wallGroup, pelletGroup, GhostGroup, numOfPellets));

        });

        Scene CreateScene = new Scene(P, 1200, 650);
        return CreateScene;
    }
}
