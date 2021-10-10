package ru.vsu.vadim.foxAndGeeese;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Main extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        Group root = new Group();
        Canvas canvas = new Canvas(500, 500);
        root.getChildren().add(canvas);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
