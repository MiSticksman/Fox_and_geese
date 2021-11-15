package ru.vsu.vadim.foxAndGeese.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GuiViewer extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        int WIDTH = 800;
        int HEIGHT = 800;
        Scene scene = new Scene(pane.getPane(), WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setTitle("FoxAndGeese");
        stage.setResizable(false);
        stage.show();
    }
}
