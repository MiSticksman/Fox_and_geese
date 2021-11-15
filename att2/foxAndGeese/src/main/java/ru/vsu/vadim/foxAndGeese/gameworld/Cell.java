package ru.vsu.vadim.foxAndGeese.gameworld;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Cell<T>  {

    private int number;
    private T data;
    private Cell<T>[] communications;

    public Cell(int number, T data) {
        this.number = number;
        this.data = data;
        this.communications = new Cell[4];
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

    public List<Cell<T>> communications() {
        return Arrays.asList(communications);
    }

    public Cell<T> connectedOn(int direction) throws Exception {
        if (direction < 0 || direction > 3) {
            throw new Exception("Wrong direction " + direction);
        }
        return communications[direction];
    }

    public void add(Cell<T> vertex, int direction) {
        if (direction > 3) {
            System.out.println("it is not ok");
        }
        communications[direction] = vertex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell<T> cell = (Cell<T>) o;
        return number == cell.number;
    }

}
