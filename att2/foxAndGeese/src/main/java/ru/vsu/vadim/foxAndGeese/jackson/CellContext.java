package ru.vsu.vadim.foxAndGeese.jackson;

import ru.vsu.vadim.foxAndGeese.gameworld.Cell;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CellContext<T> {

    private int number;
    private T data;
    private Integer[] communications;

    public int getNumber() {
        return number;
    }

    public T getData() {
        return data;
    }

    public Integer[] getCommunications() {
        return communications;
    }

    public CellContext(int number, T data, Cell<T>[] communications) {
        this.number = number;
        this.data = data;
        this.communications = new Integer[communications.length];
        Arrays.stream(communications)
                .map(x -> {
                    if (x != null) {
                        return x.getNumber();
                    }
                    return null;
                })
                .collect(Collectors.toList())
                .toArray(this.communications);
    }

    public CellContext() {
    }
}
