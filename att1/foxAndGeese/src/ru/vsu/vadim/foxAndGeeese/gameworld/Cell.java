package ru.vsu.vadim.foxAndGeeese.gameworld;

public class Cell<T>  {

    private int number;
    private T data;

    public Cell(int number, T data) {
        this.number = number;
        this.data = data;
    }

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
