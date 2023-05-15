package com.example.demo3;

import javafx.application.Application;
import javafx.stage.Stage;

public class PacManGameV1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("PacMAn");
        primaryStage.setScene(MainScene.CreateScene(primaryStage));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
