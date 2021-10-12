package ru.vsu.vadim.foxAndGeeese;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vsu.vadim.foxAndGeeese.gameservice.Logic;

public class Main extends Application {

    private static final Logger logger = LoggerFactory.getLogger(
           Main.class);

    private static final String FILENAME = "/file/does/not/exist";

    public static void main(String[] args) {
        logger.info("Just a log message.");
        logger.debug("Message for debug level.");
        try {
            Files.readAllBytes(Paths.get(FILENAME));
        } catch (IOException ioex) {
            logger.error("Failed to read file {}.", FILENAME, ioex);
        }
        //Slf4jLogbackCommonsLoggingExample.logCommonsLogging();

        Logic logic = new Logic();
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
