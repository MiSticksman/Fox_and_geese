package ru.vsu.vadim.foxAndGeese.gameworld;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.vsu.vadim.foxAndGeese.jackson.CellContext;
import ru.vsu.vadim.foxAndGeese.jackson.GraphContext;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@JsonAutoDetect
public class Cell<T>  implements Serializable {


    private int number;
    @JsonProperty
    private T data;
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

    public CellContext context() {
        return new CellContext(number, data, communications);
    }

    @JsonProperty
    public String cells() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 4; i++) {
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
        return "[" + str + "]";
    }
//                '}';
//        return "Cell{" +
//                "number = " + number +
//                ", data = " + data +
//                ", communications = " + "{" + str + "}" +
//                '}';
//    }

}
