package ru.vsu.vadim.foxAndGeese.utils;

public class GameUtils {
    public static int getOppositeDirection(int i) {
        if (i >= 2) {
            return i - 2;
        } else {
            return i + 2;
        }
    }

}
