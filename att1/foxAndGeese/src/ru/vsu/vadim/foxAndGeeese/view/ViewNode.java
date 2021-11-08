package ru.vsu.vadim.foxAndGeeese.view;

import javafx.scene.Node;
import javafx.scene.shape.Circle;
import ru.vsu.vadim.foxAndGeeese.piece.IPiece;

public class ViewNode<T> extends Circle {

    private IPiece node;

    public ViewNode(IPiece node) {
        this.node = node;
    }

    public IPiece getNode() {
        return node;
    }

    public void setNode(IPiece node) {
        this.node = node;
    }

}
