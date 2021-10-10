package ru.vsu.vadim.foxAndGeeese.gameworld;

public class GraphVertex<T> {

    public GraphVertex(int number, T data) {
        this.number = number;
        this.data = data;
    }

    private int number;
    private T data;

    public int getNumber() {
        return number;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
