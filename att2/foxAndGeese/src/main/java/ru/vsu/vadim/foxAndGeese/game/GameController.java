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
    private GameField gameField;
    private GameStates gameStates;
    private boolean priority = true;
    private boolean isJump = false;

    private static final Logger log = LoggerFactory.getLogger(GameController.class);

    public GameController() {
        initialFillingOfTheField();
    }

    private void initialFillingOfTheField() {
        gameField = new GameField();
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

    public void movesFromTo(int from, int to) throws Exception {
        int countOfGeese = gameField.getCountOfGeese();
        if (priority && from != to && (gameField.getPiece(from) instanceof Fox)) {
            int acrossOne = gameField.indexOfConnectedAcrossOne(from, to);
            if (acrossOne != -1  && (!(gameField.getPiece(to) instanceof Guess))) {
                gameField.setPiece(to, gameField.getPiece(from));
                gameField.setPiece(from, null);
                gameField.setPiece(acrossOne, null);
                countOfGeese--;
                isJump = true;
                log.info("The fox was jumped from  " + from + " to " + to);
            }
            if (!isJump && checkMovesForGeese(gameField, from, to)) {
                gameField.setPiece(to, gameField.getPiece(from));
                gameField.setPiece(from, null);
                isJump = false;
                changePriority();
                log.info("The fox was rearranged from  " + from + " to " + to);
            }
        } else if ((!priority) && (gameField.getPiece(from) instanceof Guess)) {
            if (checkMovesForGeese(gameField, from, to)) {
                gameField.setPiece(to, gameField.getPiece(from));
                gameField.setPiece(from, null);
                changePriority();
                log.info("The goose was rearranged from  " + from + " to " + to);
            }
        }
            checkWinner(countOfGeese);
    }

    public void checkWinner(int countOfGeese) throws Exception {
        if (countOfGeese < 5 && !priority) {
            log.info("The fox won");
            gameStates = GameStates.END;
        }
        if (gameField.loseOfFOx()) {
            log.info("The geese won");
            gameStates = GameStates.END;
        }
    }

    public void newGame() {
        priority = true;
        isJump = false;
        initialFillingOfTheField();
        gameStates = GameStates.PLAYING;
        log.info("Game restarted");
    }

    public void changePriority() {
       priority = !priority;
       if (!priority) {
           isJump = false;
       }
    }

    public boolean getIsJump() {
        return isJump;
    }

    public boolean getPriority() {
        return priority;
    }
}
