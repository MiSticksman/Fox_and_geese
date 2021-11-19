package ru.vsu.vadim.foxAndGeese.view;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vsu.vadim.foxAndGeese.game.*;
import ru.vsu.vadim.foxAndGeese.gameworld.GameField;
import ru.vsu.vadim.foxAndGeese.piece.*;


public class Pane {

    private final GridPane gridPane;
    private GameController game;
    private static final Logger log = LoggerFactory.getLogger(Pane.class);
    private Integer posClicked = null;
    private Button btn = new Button("EndJump");



    public Pane() {
        gridPane = new GridPane();
        game = new GameController();
        btn.setPrefWidth(70);
        btn.setTextFill(Color.RED);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                game.changePriority();
                repaint();
            }
        });
        btn.setVisible(false);
        gridPane.add(btn, 0, 0);
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
                            try {
                                game.movesFromTo(posClicked, finalNumber);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            repaint();
                            posClicked = null;
                        }
                    });
                    gridPane.add(circle, col, row);
                    circle.radiusProperty().bind(Bindings.min(gridPane.widthProperty().divide(15),
                            gridPane.heightProperty().divide(15)));
                    number++;
                }
                if (number > 32) {
                    break;
                }
            }
        }
        log.info("The pane is full");
    }

    public void newGame() {
        game.newGame();
        draw();
    }

    private void repaint() {
        btn.setVisible(game.getIsJump());
        for (Node node : gridPane.getChildren()) {
            if (node instanceof ViewNode) {
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
    }

    public GridPane getPane() {
        return gridPane;
    }
}
