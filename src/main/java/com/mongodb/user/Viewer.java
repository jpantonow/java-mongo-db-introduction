package com.mongodb.user;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Viewer extends Application {
    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage){
        Label label = new Label("App");
        Scene scene = new Scene(new Pane(label),300,250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
