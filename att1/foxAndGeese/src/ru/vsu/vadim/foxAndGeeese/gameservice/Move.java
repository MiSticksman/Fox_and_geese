package ru.vsu.vadim.foxAndGeeese.gameservice;

import ru.vsu.vadim.foxAndGeeese.gameworld.GameField;

import java.util.ArrayList;

public class Move  {
    public static boolean checkMovesForGeese(GameField field, int index1, int index2) {
        if (field.getPiece(index1) != null) {
            ArrayList<Integer> list = field.getNeighbours(index1);
            for (Integer a: list) {
                if (a == index2 && field.getPiece(index2) == null) {
                    return true;
                }
            }
        }
        return false;
    }
}
