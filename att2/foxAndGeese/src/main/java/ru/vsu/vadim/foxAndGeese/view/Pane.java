package ru.vsu.vadim.foxAndGeese.view;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vsu.vadim.foxAndGeese.game.*;
import ru.vsu.vadim.foxAndGeese.gameworld.GameField;
import ru.vsu.vadim.foxAndGeese.piece.*;
import javafx.scene.image.Image;


public class Pane {

    private final GridPane gridPane;
    private GameController game;
    private static final Logger log = LoggerFactory.getLogger(Pane.class);
    private Integer posClicked = null;
    private Button btn = new Button("EndJump");
    private static final String foxURL = "file:images\\fox.png";
    private static final String geeseURL = "file:images\\geese.png";
    private GuiViewer guiViewer = new GuiViewer();


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

    public void setGame(GameController game) {
        this.game = game;
    }

    public void draw() {
        int number = 0;
        for (int row = 6; row >= 0; row--) {
            for (int col = 0; col <= 6 ; col++) {
                if ((row < 2 || row > 4) && (col > 1 && col < 5) || (row > 1 && row < 5)) {
                    IPiece figure = game.getPiece(number);
                    Circle circle = new ViewNode<IPiece>(figure, number);
                    circle.setFill(Color.web("#009999"));
                    if (figure instanceof Goose) {
                        circle.setFill(new ImagePattern(new Image(geeseURL)));
                    }
                    if (figure instanceof Fox) {
                        circle.setFill(new ImagePattern(new Image(foxURL)));
                    }
                    final int finalNumber = number;
                    circle.setOnMouseClicked(e -> {
                        if (posClicked == null) {
                            posClicked = finalNumber;
                        } else {
                            try {
                                game.movesFromTo(posClicked, finalNumber);
                                if (game.getGameStates() == GameStates.WINFOX || game.getGameStates() == GameStates.WINGEESE)
                                this.endGame();
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

    public void endGame() {
        Group group = new Group();
        Stage stage = new Stage(StageStyle.UTILITY);
        stage.setResizable(false);
        Button button = new Button("Exit");
        button.setLayoutX(110);
        button.setLayoutY(100);
        button.setPrefWidth(80);
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> System.exit(0));
        Text text = new Text();
        text.setFont(new Font("Arial", 30));
        text.setFill(Color.RED);
            if (game.getGameStates() == GameStates.WINFOX) {
                text.setText("Fox WON");
            }
            if (game.getGameStates() == GameStates.WINGEESE) {
                text.setText("Geese WON");
            }
        stage.centerOnScreen();
        text.setX(70);
        text.setY(70);
        group.getChildren().addAll(text, button);
        stage.setScene(new Scene(group, 300, 150));
        stage.show();
    }

    private void repaint() {
        btn.setVisible(game.getIsJump());
        for (Node node : gridPane.getChildren()) {
            if (node instanceof ViewNode) {
                ViewNode viewNode = (ViewNode) node;
                int n = viewNode.getNumber();
                viewNode.setFill(Color.web("#009999"));
                if (game.getPiece(n) instanceof Goose) {
                    viewNode.setFill(new ImagePattern(new Image(geeseURL)));;
                }
                if (game.getPiece(n) instanceof Fox) {
                    viewNode.setFill(new ImagePattern(new Image(foxURL)));
                }
            }
        }
    }

    public GridPane getPane() {
        return gridPane;
    }

    public GameField getField() {
        return game.getGameField();
    }

    public GameController getGame() {
        return game;
    }
}
