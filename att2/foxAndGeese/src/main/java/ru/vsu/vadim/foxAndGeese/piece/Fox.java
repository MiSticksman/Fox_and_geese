package ru.vsu.vadim.foxAndGeese.piece;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import javafx.scene.Node;

import java.io.Serializable;

@JsonAutoDetect
@JsonClassDescription("Fox")
public class Fox  implements IPiece, Serializable {

//    @Override
//    public String toString() {
//        return "Fox{}";
//    }
}
