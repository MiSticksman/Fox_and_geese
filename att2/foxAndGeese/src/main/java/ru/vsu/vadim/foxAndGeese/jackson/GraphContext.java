package ru.vsu.vadim.foxAndGeese.jackson;

import ru.vsu.vadim.foxAndGeese.gameworld.Cell;

import java.util.ArrayList;
import java.util.List;

public class GraphContext<T> {
    private List<CellContext<T>> listVertex;
    private int vCount;
    private int eCount;

    public GraphContext(List<Cell<T>> listVertex, int vCount, int eCount) {
        this.listVertex = new ArrayList<>();
        for (Cell<T> vertex : listVertex) {
            CellContext<T> vertexContext = vertex.context();
            this.listVertex.add(vertexContext);
        }
        this.vCount = vCount;
        this.eCount = eCount;
    }

    public GraphContext() {

    }

    public List<CellContext<T>> getListVertex() {
        return listVertex;
    }

    public int getvCount() {
        return vCount;
    }

    public int geteCount() {
        return eCount;
    }
}
