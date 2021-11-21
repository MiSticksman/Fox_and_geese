package ru.vsu.vadim.foxAndGeese.gameworld;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@JsonAutoDetect
public class Cell<T>  implements Serializable {

    @JsonIgnore
    private int number;
    @JsonIgnore
    private T data;
    @JsonIgnore
    private Cell<T>[] communications;

    public Cell(int number, T data) {
        this.number = number;
        this.data = data;
        this.communications = new Cell[4];
    }
    public Cell(){}

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

    @JsonProperty
    public String cells() {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < 4; i++) {
            Cell<T> cell = communications[i];
            if (i != 3) {
                if (cell != null) {
                    str.append(cell.getNumber()).append(", ");
                } else {
                    str.append("-1, ");
                }
            } else {
                if (cell != null) {
                    str.append(cell.getNumber());
                } else {
                    str.append("-1");
                }
            }
        }
        return "Cell{" +
                "number= " + number +
                ", data= " + (data == null? "null" : data) +
                ", communications= " + "{" + str + "}" +
                '}';
    }
}
