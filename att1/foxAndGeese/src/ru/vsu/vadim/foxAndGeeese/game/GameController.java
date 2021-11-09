package ru.vsu.vadim.foxAndGeeese.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vsu.vadim.foxAndGeeese.gameworld.GameField;
import ru.vsu.vadim.foxAndGeeese.piece.Fox;
import ru.vsu.vadim.foxAndGeeese.piece.Guess;
import ru.vsu.vadim.foxAndGeeese.piece.IPiece;

import static ru.vsu.vadim.foxAndGeeese.game.Move.checkMovesForGeese;

public class GameController {
    //заполняет поле фигурами
    //знает о поле и о том как ходят фигуры
    private final GameField gameField = new GameField();

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
        if (checkMovesForGeese(gameField, index1, index2)) {
            gameField.setPiece(index2, gameField.getPiece(index1));
            gameField.setPiece(index1, null);
            log.info("The figure was rearranged from  " + index1 + " to " + index2);
        }
    }
}
