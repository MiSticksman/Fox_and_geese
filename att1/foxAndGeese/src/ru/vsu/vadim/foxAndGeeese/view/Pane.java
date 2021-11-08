package ru.vsu.vadim.foxAndGeeese.view;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vsu.vadim.foxAndGeeese.game.GameController;
import ru.vsu.vadim.foxAndGeeese.gameworld.GameField;
import ru.vsu.vadim.foxAndGeeese.piece.Fox;
import ru.vsu.vadim.foxAndGeeese.piece.Guess;
import ru.vsu.vadim.foxAndGeeese.piece.IPiece;


public class Pane {

    private final GridPane gridPane;
    private GameController game;
    private static final Logger log = LoggerFactory.getLogger(Pane.class);

    public Pane() {
        gridPane = new GridPane();
        game = new GameController();

        int number = 0;
        for (int row = game.getGameField().getFieldSizeForGridpane() - 1; row >= 0; row--) {
            for (int col = game.getGameField().getFieldSizeForGridpane() - 1; col >= 0 ; col--) {
                Circle circle = new Circle();
                circle.setFill(Color.WHITE);
                if ((row < 2 || row > 4) && (col > 1 && col < 5) || (row > 1 && row < 5)) {
                    circle.setFill(Color.web("#009999"));
                    if (game.getGameField().getPiece(number) instanceof Guess) {
                        gridPane.add(new ViewNode<IPiece>(game.getGameField().getPiece(number)), col, row);
                        circle.setFill(Color.GRAY);
                    }
                    if (game.getGameField().getPiece(number) instanceof Fox) {
                        gridPane.add(new ViewNode<IPiece>(game.getGameField().getPiece(number)), col, row);
                        circle.setFill(Color.ORANGE);;
                    }
                    number++;
                }

                gridPane.add(circle, col, row);
                circle.radiusProperty().bind(gridPane.widthProperty().divide(2 * game.getGameField().getFieldSizeForGridpane()));
                if (number > game.getGameField().getFieldSize() - 1) {
                    break;
                }
            }
        }
        log.info("The pane was full");
    }

    public GridPane getPane() {
        return gridPane;
    }
}
