package ru.vsu.vadim.foxAndGeese.view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


import java.awt.*;

public class GuiViewer extends Application {
    private static GuiViewer viewer;
    private Pane pane;
    private BorderPane borderPane;

    @Override
    public void start(Stage stage) {
        viewer = this;
        pane = new Pane();
        borderPane = new BorderPane();
        int WIDTH = 800;
        int HEIGHT = 800;
        createMenu();
        pane.getPane().setAlignment(Pos.CENTER);
        borderPane.setCenter(pane.getPane());
        stage.setScene(new Scene(borderPane, WIDTH, HEIGHT));
        stage.setTitle("FoxAndGeese");
        stage.setResizable(false);
        stage.show();
    }
    public void createMenu() {
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("Parameters");
        Menu baseScenario = new Menu("Scenario");
        baseScenario.setOnAction(actionEvent -> {
            //todo место для вызова сценария
        });
        MenuItem newGameItem = new MenuItem("New game");
        newGameItem.setOnAction(actionEvent -> {
            pane.newGame();
        });
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });

        menuBar.getMenus().addAll(fileMenu, baseScenario);
        borderPane.setTop(menuBar);
        fileMenu.getItems().addAll(newGameItem, exitItem);
    }

}
