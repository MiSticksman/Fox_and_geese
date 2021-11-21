package ru.vsu.vadim.foxAndGeese.piece;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import javafx.scene.Node;

import java.io.Serializable;

@JsonAutoDetect
public class Goose implements IPiece, Serializable {

    @Override
    public String toString() {
        return "Goose{}";
    }
}
