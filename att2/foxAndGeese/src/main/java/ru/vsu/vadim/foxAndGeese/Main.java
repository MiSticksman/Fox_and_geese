package ru.vsu.vadim.foxAndGeese;

import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vsu.vadim.foxAndGeese.view.GuiViewer;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Application.launch(GuiViewer.class);
        log.info("Application started.");
    }
}
