package com.example.demo3;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import static javafx.scene.paint.Color.BROWN;
import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.OLIVE;
import static javafx.scene.paint.Color.ORANGE;
import static javafx.scene.paint.Color.PURPLE;
import static javafx.scene.paint.Color.RED;
import static javafx.scene.paint.Color.WHITE;
import static javafx.scene.paint.Color.YELLOW;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author hassan
 */
public class Settingscene {

    public static Scene createSettingScene(Stage Primary) {
        //Button

        VBox Holder = new VBox();
        Holder.setStyle("-fx-background-color:black;");
        Button Back = new Button("Back");
        Back.setLayoutX(250);
        Back.setLayoutY(400);
        Back.setFont(Font.font("BankGothic Md BT", 15));
        Back.setStyle("-fx-background-color:linear-gradient(rgba(124,117,55,1) 2%, rgba(241,238,12,1) 23%);");
        Back.setOnAction(e -> {
            Primary.setScene(MainScene.CreateScene(Primary));
        });
        Back.setPrefSize(150, 50);
        Back.setAlignment(Pos.CENTER);

        //PacMan Color Setting
        HBox HBPacManColor = new HBox();
        Label LPacMan = new Label("PacMan Color :");
        RadioButton R1 = new RadioButton("YELLOW");
        RadioButton R2 = new RadioButton("WHITE");
        RadioButton R3 = new RadioButton("ORANGE");
        RadioButton R4 = new RadioButton("GREEN");
        ToggleGroup PacManGroup = new ToggleGroup();
        R1.setToggleGroup(PacManGroup);
        R2.setToggleGroup(PacManGroup);
        R3.setToggleGroup(PacManGroup);
        R4.setToggleGroup(PacManGroup);
        LPacMan.setStyle("-fx-text-fill:blue;");
        LPacMan.setFont(Font.font(15));

        HBPacManColor.getChildren().addAll(LPacMan, R1, R2, R3, R4);
        HBPacManColor.setSpacing(10);
        HBPacManColor.setPadding(new Insets(50, 10, 50, 10));
        R1.setStyle("-fx-text-fill:YELLOW;");
        R2.setStyle("-fx-text-fill:WHITE;");
        R3.setStyle("-fx-text-fill:ORANGE;");
        R4.setStyle("-fx-text-fill:GREEN;");

        EventHandler event = e -> {
            if (R1.isSelected()) {
                PacManCreating.PacmanColor = YELLOW;
            } else if (R2.isSelected()) {
                PacManCreating.PacmanColor = WHITE;
            } else if (R3.isSelected()) {
                PacManCreating.PacmanColor = ORANGE;
            } else if (R4.isSelected()) {
                PacManCreating.PacmanColor = GREEN;
            }
        };
        R1.setOnAction(event);
        R2.setOnAction(event);
        R3.setOnAction(event);
        R4.setOnAction(event);

        //PacMan Speed Setting
        HBox HBPacManSpeed = new HBox();
        Label LPacManSpeed = new Label("PacMan Speed :");
        RadioButton R5 = new RadioButton("3");
        RadioButton R6 = new RadioButton("5");
        RadioButton R7 = new RadioButton("7");
        RadioButton R8 = new RadioButton("10");
        ToggleGroup PacManGroupSpeed = new ToggleGroup();
        R5.setToggleGroup(PacManGroupSpeed);
        R6.setToggleGroup(PacManGroupSpeed);
        R7.setToggleGroup(PacManGroupSpeed);
        R8.setToggleGroup(PacManGroupSpeed);

        R5.setStyle("-fx-text-fill:white;");
        R6.setStyle("-fx-text-fill:white;");
        R7.setStyle("-fx-text-fill:white;");
        R8.setStyle("-fx-text-fill:white;");
        LPacManSpeed.setStyle("-fx-text-fill:blue;");
        LPacManSpeed.setFont(Font.font(15));

        HBPacManSpeed.getChildren().addAll(LPacManSpeed, R5, R6, R7, R8);
        HBPacManSpeed.setSpacing(20);
        HBPacManSpeed.setPadding(new Insets(50, 50, 50, 10));

        EventHandler event3 = e -> {
            if (R5.isSelected()) {
                PacManCreating.speed = 3;
            } else if (R6.isSelected()) {
                PacManCreating.speed = 5;
            } else if (R7.isSelected()) {
                PacManCreating.speed = 7;
            } else if (R8.isSelected()) {
                PacManCreating.speed = 10;
            }
        };
        R5.setOnAction(event3);
        R6.setOnAction(event3);
        R7.setOnAction(event3);
        R8.setOnAction(event3);

        //Ghosts Color Setting
        HBox HBGhostColor = new HBox();
        Label LGhostColor = new Label(" Ghost Color:");
        RadioButton R9 = new RadioButton("RED");
        RadioButton R10 = new RadioButton("BROWN");
        RadioButton R11 = new RadioButton("PURPLE");
        RadioButton R12 = new RadioButton("OLIVE");
        ToggleGroup GhostColor = new ToggleGroup();
        R9.setToggleGroup(GhostColor);
        R10.setToggleGroup(GhostColor);
        R11.setToggleGroup(GhostColor);
        R12.setToggleGroup(GhostColor);
        R9.setStyle("-fx-text-fill:red;");
        R10.setStyle("-fx-text-fill:BROWN;");
        R11.setStyle("-fx-text-fill:PURPLE;");
        R12.setStyle("-fx-text-fill:OLIVE;");
        LGhostColor.setStyle("-fx-text-fill:blue;");
        LGhostColor.setFont(Font.font(15));

        HBGhostColor.getChildren().addAll(LGhostColor, R9, R10, R11, R12);
        HBGhostColor.setSpacing(20);
        HBGhostColor.setPadding(new Insets(50, 50, 50, 10));

        EventHandler event2 = e -> {
            if (R9.isSelected()) {
                Ghost.GhostColor = RED;
            } else if (R10.isSelected()) {
                Ghost.GhostColor = BROWN;
            } else if (R11.isSelected()) {
                Ghost.GhostColor = PURPLE;
            } else if (R12.isSelected()) {
                Ghost.GhostColor = OLIVE;
            }
        };
        R9.setOnAction(event2);
        R10.setOnAction(event2);
        R11.setOnAction(event2);
        R12.setOnAction(event2);

        //Adding elements in the node
        Holder.getChildren().addAll(HBPacManColor, HBPacManSpeed, HBGhostColor, Back);

        Scene setting = new Scene(Holder, 500, 500);
        return setting;
    }

}
