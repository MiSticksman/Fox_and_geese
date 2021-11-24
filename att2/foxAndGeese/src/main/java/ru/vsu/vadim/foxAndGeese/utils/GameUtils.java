package ru.vsu.vadim.foxAndGeese.utils;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class GameUtils {
    public static int getOppositeDirection(int i) {
        if (i >= 2) {
            return i - 2;
        } else {
            return i + 2;
        }
    }

    public static Path getAbsolutePathOfSavesDirectory() {
        return FileSystems.getDefault().getPath("saves").toAbsolutePath();
    }

}
