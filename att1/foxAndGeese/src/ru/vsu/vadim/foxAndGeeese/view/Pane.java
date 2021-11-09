package ru.vsu.vadim.foxAndGeeese.view;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
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

import java.awt.*;


public class Pane {

    private GridPane gridPane;
    private GameController game;
    private static final Logger log = LoggerFactory.getLogger(Pane.class);
    private Integer lastClicked = null;

    public Pane() {
        gridPane = new GridPane();
        gridPane.layout();
        game = new GameController();
        draw();
    }

    public void draw() {
        int number = 0;
        for (int row = 6; row >= 0; row--) {
            for (int col = 6; col >= 0 ; col--) {
                if ((row < 2 || row > 4) && (col > 1 && col < 5) || (row > 1 && row < 5)) {
                    IPiece figure = game.getPiece(number);
                    Circle circle = new ViewNode<IPiece>(figure);
                    circle.setFill(Color.web("#009999"));
                    if (figure instanceof Guess) {
                        circle.setFill(Color.GRAY);
                    }
                    if (figure instanceof Fox) {
                        circle.setFill(Color.ORANGE);;
                    }
//                    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
//                        @Override
//                        public void handle(MouseEvent e) {
//                            if (lastClicked == null) {
//                                lastClicked = finalNumber;
//                            } else {
//                                game.movesFromTo(lastClicked, finalNumber);
//                                lastClicked = null;
//                            }
//                        }
//                    };

                    int finalNumber = number;
                    circle.setOnMouseClicked(e -> {
                        if (lastClicked == null) {
                            lastClicked = finalNumber;
                        } else {
                            game.movesFromTo(lastClicked, finalNumber);
                            lastClicked = null;
                        }
                        gridPane.layout();
                    });

                    //circle.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
                    gridPane.add(circle, col, row);
                    circle.radiusProperty().bind(gridPane.widthProperty().divide(2 * 7));
                    number++;
                }

                if (number > 32) {
                    break;
                }
            }
        }
        log.info("The pane is full");

    }

    public GridPane getPane() {
        return gridPane;
    }
}
