package ru.vsu.vadim.foxAndGeese.graph;

import ru.vsu.vadim.foxAndGeese.gameworld.Cell;
import ru.vsu.vadim.foxAndGeese.utils.GameUtils;

import java.util.*;

public class Graph<T>  {

    //private List<LinkedList<Integer>> listConnections = new ArrayList<>();
    private List<Cell<T>> listVertex = new ArrayList<>();
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

}
