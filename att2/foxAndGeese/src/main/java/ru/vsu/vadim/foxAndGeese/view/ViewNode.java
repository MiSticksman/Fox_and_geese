package ru.vsu.vadim.foxAndGeese.view;

import javafx.scene.shape.Circle;
import ru.vsu.vadim.foxAndGeese.piece.IPiece;


public class ViewNode<T> extends Circle {

    private IPiece node;
    private int number;

    public ViewNode(IPiece node, int number) {
        this.node = node;
        this.number = number;
    }

    public IPiece getNode() {
        return node;
    }

    public void setNode(IPiece node) {
        this.node = node;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
