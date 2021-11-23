package ru.vsu.vadim.foxAndGeese.jackson;

import ru.vsu.vadim.foxAndGeese.graph.Graph;
import ru.vsu.vadim.foxAndGeese.piece.IPiece;

public class GameFieldContext {
    private GraphContext<IPiece> field;

    public GameFieldContext(Graph<IPiece> field) {
        this.field = field.context();
    }

    public GameFieldContext() {
    }

    public GraphContext<IPiece> getField() {
        return field;
    }
}
