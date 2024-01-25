package com.mongodb.user;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Viewer extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Canvas canvas = new Canvas();
        canvas.setHeight(512);
        canvas.setWidth(512);

        GraphicsContext g2d = canvas.getGraphicsContext2D();

        g2d.setFill(Color.valueOf("#ff0000"));;
        g2d.fillRect(100,100,200,200);

        g2d.setStroke(Color.valueOf("#0000ff"));;
        g2d.strokeRect(200,200,200,200);

        VBox v = new VBox(canvas);
        Scene scene = new Scene(v);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
