package ru.vsu.vadim.foxAndGeese.view;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vsu.vadim.foxAndGeese.commands.Command;
import ru.vsu.vadim.foxAndGeese.game.GameController;
import ru.vsu.vadim.foxAndGeese.game.GameStates;
import ru.vsu.vadim.foxAndGeese.jackson.GameContext;
import ru.vsu.vadim.foxAndGeese.jackson.GameJsonDeserializer;
import ru.vsu.vadim.foxAndGeese.utils.GameUtils;

import java.io.File;
import java.io.IOException;

public class GuiViewer extends Application {
    private Pane pane;
    private BorderPane borderPane;
    private static final Logger log = LoggerFactory.getLogger(GuiViewer.class);


    @Override
    public void start(Stage stage) {
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
        Menu menu = new Menu("Params");
        MenuItem newGameItem = new MenuItem("New game");
        newGameItem.setOnAction(actionEvent -> {
            pane.newGame();
        });
        MenuItem saveFileItem = new MenuItem("Save game");
        saveFileItem.setOnAction(actionEvent -> {
            FileChooser fileOpener = new FileChooser();
            fileOpener.setTitle("Select file");
            File savesDir = GameUtils.getAbsolutePathOfSavesDirectory().toFile();
            if (savesDir.mkdir()) {
                fileOpener.setInitialDirectory(savesDir);
            } else {
                File file = new File(savesDir.getAbsolutePath());
                fileOpener.setInitialDirectory(file);
            }
            fileOpener.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON", ".json"));
            try {
                //pane.getGame().serialization(fileOpener.showSaveDialog(new Stage()), pane.getGame());
                GameContext gameContext = pane.getGame().context();
                gameContext.save(fileOpener.showSaveDialog(new Stage()), gameContext);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        MenuItem loadFileItem = new MenuItem("Load game");
        loadFileItem.setOnAction(actionEvent -> {
            FileChooser fileOpener = new FileChooser();
            fileOpener.setTitle("Select file");
            fileOpener.setInitialDirectory(new File("saves"));
            fileOpener.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files", "*.json"));
            //deserialization(fileOpener.showOpenDialog(new Stage()));
            try {
                GameContext gameContext1 = new GameContext();
                GameContext gameContext = gameContext1.read(fileOpener.showOpenDialog(new Stage()));
                pane.getGame().fromContext(gameContext);
                pane.draw();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        MenuItem scenario = new MenuItem("demo");
        scenario.setOnAction(actionEvent -> {
            //todo место для вызова сценария
        });
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(actionEvent -> {
            Platform.exit();
            log.info("The game was completed by the user");
            System.exit(0);
        });

        menuBar.getMenus().addAll(menu);
        borderPane.setTop(menuBar);
        menu.getItems().addAll(newGameItem,saveFileItem, loadFileItem, scenario, exitItem);
    }


//    private void deserialization(File file) {
//        ObjectMapper mapper = new ObjectMapper();
//        SimpleModule simpleModule = new SimpleModule();
//        simpleModule.addDeserializer(GameController.class, new GameJsonDeserializer());
//        mapper.registerModule(simpleModule);
//        try {
//            pane.setGame(mapper.readValue(file, GameController.class));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
