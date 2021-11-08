package ru.vsu.vadim.foxAndGeeese.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GuiViewer extends Application {
    private final int WIDTH = 800;
    private final int HEIGHT = 800;


    public void start(Stage stage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane.getPane(), WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setTitle("FoxAndGeese");
        stage.setResizable(false);
        stage.show();
    }
}
