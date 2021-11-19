package ru.vsu.vadim.foxAndGeese.game;

import ru.vsu.vadim.foxAndGeese.gameworld.GameField;

import java.util.List;

public class Move  {
    public static boolean checkMovesForGeese(GameField field, int from, int to) {
        if (field.getPiece(from) != null) {
            List<Integer> list = field.getIndexesOfConnections(from);
            for (Integer a: list) {
                if (a == to && field.getPiece(to) == null) {
                    return true;
                }
            }
        }
        return false;
    }


}
