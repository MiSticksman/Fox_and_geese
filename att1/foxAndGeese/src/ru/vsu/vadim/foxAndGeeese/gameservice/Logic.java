package ru.vsu.vadim.foxAndGeeese.gameservice;

import ru.vsu.vadim.foxAndGeeese.gameworld.GameField;
import ru.vsu.vadim.foxAndGeeese.piece.Fox;
import ru.vsu.vadim.foxAndGeeese.piece.Guess;

public class Logic {
    //заполняет поле фигурами
    //знает о поле и о том как ходят фигуры
    private GameField gameField = new GameField();

    public Logic() {
        for (int i = 0; i < gameField.getFieldSize(); i++) {
            if (i < 14 || i == 19 || i == 20  || i == 26) {
                gameField.addPiece(new Guess(), i);
            }
            if (i == 16) {
                gameField.addPiece(new Fox(), i);
            }
        }
    }


}
