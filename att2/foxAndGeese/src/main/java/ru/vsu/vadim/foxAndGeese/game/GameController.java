package ru.vsu.vadim.foxAndGeese.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vsu.vadim.foxAndGeese.gameworld.GameField;
import ru.vsu.vadim.foxAndGeese.piece.Fox;
import ru.vsu.vadim.foxAndGeese.piece.Guess;
import ru.vsu.vadim.foxAndGeese.piece.IPiece;

import static ru.vsu.vadim.foxAndGeese.game.Move.checkMovesForGeese;

public class GameController {
    //заполняет поле фигурами
    //знает о поле и о том как ходят фигуры
    private final GameField gameField = new GameField();
    private boolean priority = true;

    private static final Logger log = LoggerFactory.getLogger(GameController.class);

    public GameController() {
        for (int i = 0; i < gameField.getFieldSize(); i++) {
            if (i < 14 || i == 19 || i == 20  || i == 26) {
                gameField.addPiece(new Guess(), i);
            }
            if (i == 16) {
                gameField.addPiece(new Fox(), i);
            }
        }
    }

    public IPiece getPiece(int number) {
        return gameField.getPiece(number);
    }

    public void movesFromTo(int index1, int index2) {
        if (priority && (gameField.getPiece(index1) instanceof Fox)) {
            if (checkMovesForGeese(gameField, index1, index2)) {
                gameField.setPiece(index2, gameField.getPiece(index1));
                gameField.setPiece(index1, null);
                priority = false;
                log.info("The fox was rearranged from  " + index1 + " to " + index2);
            }
        } else if ((!priority) && (gameField.getPiece(index1) instanceof Guess)) {
            if (checkMovesForGeese(gameField, index1, index2)) {
                gameField.setPiece(index2, gameField.getPiece(index1));
                gameField.setPiece(index1, null);
                priority = true;
                log.info("The goose was rearranged from  " + index1 + " to " + index2);
            }
        }
    }

}
