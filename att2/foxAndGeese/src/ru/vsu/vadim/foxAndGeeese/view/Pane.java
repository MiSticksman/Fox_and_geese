package ru.vsu.vadim.foxAndGeeese.view;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vsu.vadim.foxAndGeeese.game.GameController;
import ru.vsu.vadim.foxAndGeeese.piece.Fox;
import ru.vsu.vadim.foxAndGeeese.piece.Guess;
import ru.vsu.vadim.foxAndGeeese.piece.IPiece;


public class Pane {

    private GridPane gridPane;
    private GameController game;
    private static final Logger log = LoggerFactory.getLogger(Pane.class);
    private Integer posClicked = null;

    public Pane() {
        gridPane = new GridPane();
        game = new GameController();
        draw();
    }

    public void draw() {
        int number = 0;
        for (int row = 6; row >= 0; row--) {
            for (int col = 0; col <= 6 ; col++) {
                if ((row < 2 || row > 4) && (col > 1 && col < 5) || (row > 1 && row < 5)) {
                    IPiece figure = game.getPiece(number);
                    Circle circle = new ViewNode<IPiece>(figure, number);
                    circle.setFill(Color.web("#009999"));
                    if (figure instanceof Guess) {
                        circle.setFill(Color.GRAY.darker());
                    }
                    if (figure instanceof Fox) {
                        circle.setFill(Color.ORANGE);
                    }
                    final int finalNumber = number; // проверка на ViewNode
                    circle.setOnMouseClicked(e -> {
                        if (posClicked == null) {
                            posClicked = finalNumber;
                        } else {
                            game.movesFromTo(posClicked, finalNumber);
                            repaint();
                            posClicked = null;
                        }
                    });
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

    private void repaint() {
        for (Node node : gridPane.getChildren()) {
            ViewNode viewNode = (ViewNode) node;
            int n = viewNode.getNumber();
            viewNode.setFill(Color.web("#009999"));
            if (game.getPiece(n) instanceof Guess) {
                viewNode.setFill(Color.GRAY.darker());
            }
            if (game.getPiece(n) instanceof Fox) {
                viewNode.setFill(Color.ORANGE);
            }
        }
    }



    public GridPane getPane() {
        return gridPane;
    }
}
