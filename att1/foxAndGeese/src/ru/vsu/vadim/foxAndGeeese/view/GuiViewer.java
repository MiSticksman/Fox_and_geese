package ru.vsu.vadim.foxAndGeeese.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GuiViewer extends Application {


    public void start(Stage stage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane.getPane(), 550, 550);
        stage.setScene(scene);
        stage.setTitle("FoxAndGeese");
        stage.show();
    }
}
