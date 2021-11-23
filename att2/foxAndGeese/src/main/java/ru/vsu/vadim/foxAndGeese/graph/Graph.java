package ru.vsu.vadim.foxAndGeese.graph;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.vsu.vadim.foxAndGeese.gameworld.Cell;
import ru.vsu.vadim.foxAndGeese.jackson.CellContext;
import ru.vsu.vadim.foxAndGeese.jackson.GraphContext;
import ru.vsu.vadim.foxAndGeese.piece.Fox;
import ru.vsu.vadim.foxAndGeese.piece.Goose;
import ru.vsu.vadim.foxAndGeese.utils.GameUtils;

import java.util.*;

@JsonAutoDetect
public class Graph<T>  {
    @JsonProperty
    private final List<Cell<T>> listVertex = new ArrayList<>();
    int vCount;
    int eCount;

    public Graph() {
    }

    public int getVertexCount() {
        return vCount;
    }


    public int getEdgeCount() {
        return eCount;
    }

    public void addVertex(Cell<T> value) {
        listVertex.add(value);
        vCount++;
    }

    public void removeVertex(Cell<T> value) {
       listVertex.remove(value);
    }

    public boolean isAdj(int v1, int v2) {
        for (Cell<T> adj : getVertex(v1).communications()) {
            if (adj != null && adj.getNumber() == v2) {
                return true;
            }
        }
        return false;
    }

    public void createEdge(int index1, int index2, int direction) {
        int maxV = Math.max(index1, index2);
        for (; vCount <= maxV; vCount++) {
            listVertex.add(new Cell<>(vCount, null));
        }
        if (!isAdj(index1, index2)) {
            listVertex.get(index1).add(listVertex.get(index2), direction);
            listVertex.get(index2).add(listVertex.get(index1), GameUtils.getOppositeDirection(direction));
            eCount++;
        }
    }

    public int getGraphSize() {
        return listVertex.size();
    }

    public Cell<T>  getVertex(int i) {
        return listVertex.get(i);
    }

    public List<Cell<T>> getConnections(int index) {
        return listVertex.get(index).communications();
    }

    public T removeData(int v) {
        T data = listVertex.get(v).getData();
        listVertex.get(v).setData(null);
        return data;
    }

    public int getCountOfVertexes() {
        return listVertex.size();
    }

    public int getCountOfGeese() {
        List<Integer> list = new ArrayList<>();
        for (Cell cell: listVertex) {
            if (cell.getData() instanceof Goose) {
                list.add(cell.getNumber());
            }
        }
        return list.size();
    }
    @JsonIgnore
    public Cell<T> getIndexOfFox() {
        for (Cell<T> cell: listVertex) {
            if (cell.getData() instanceof Fox) {
                return cell;
            }
        }
        return null;
    }

    public GraphContext<T> context() {
        return new GraphContext<>(listVertex, vCount, eCount);
    }

    public void fromContext(GraphContext<T> context) {
        vCount = context.getvCount();
        eCount = context.geteCount();
        for (CellContext<T> vertexContext: context.getListVertex()) {
            Cell<T> vertex = new Cell<>(vertexContext.getNumber(), vertexContext.getData());
            listVertex.add(vertex);
        }
        int i = 0;
        for (CellContext<T> vertexContext: context.getListVertex()) {
            int j = 0;
            for (Integer connected : vertexContext.getCommunications()) {
                if (connected != null) {
                    createEdge(i, connected, j);
                }
                j++;
            }
            i++;
        }
    }
}
