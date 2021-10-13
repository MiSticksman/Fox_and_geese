package ru.vsu.vadim.foxAndGeeese.view;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vsu.vadim.foxAndGeeese.gameworld.GameField;


public class Pane {

    private final GridPane gridPane;
    private GameField gameField;
    private static final Logger log = LoggerFactory.getLogger(Pane.class);

    public Pane() {
        gameField = new GameField();
        gridPane = new GridPane();
        for (int i = 0; i < gameField.getFieldSizeForGridpane(); i++) {
            for (int j = gameField.getFieldSizeForGridpane() - 1; j >=0; j--) {
                Circle circle = new Circle();
                circle.setFill(Color.WHITE);
                if (!((i < 2 || i > 4) && (j < 2 || j > 4))) {
                    //проверка на гуся
                    circle.setFill(Color.GRAY);
                }
                if (i == 3 && j == 3) {
                    //проверка на лису
                    circle.setFill(Color.ORANGE);
                }
                gridPane.add(circle, i, j);
                circle.radiusProperty().bind(gridPane.widthProperty().divide(2* gameField.getFieldSizeForGridpane()));
            }
        }
        log.info("The pane was full");
    }

    public GridPane getPane() {
        return gridPane;
    }
}
