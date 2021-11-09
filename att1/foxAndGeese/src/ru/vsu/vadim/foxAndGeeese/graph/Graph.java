package ru.vsu.vadim.foxAndGeeese.graph;

import java.util.*;

public class Graph<T>  {

    private ArrayList<LinkedList<Integer>> listConnections = new ArrayList<>();
    private ArrayList<T> listVertex = new ArrayList<>();
    // сделать связи по направлениям

    public Graph() {
    }

    public void addVertex(T value) {
        listVertex.add(value);
        listConnections.add(new LinkedList<>());
    }

    public void removeVertex(T value) {
       listVertex.remove(value);
    }

    public void createEdge(int index1, int index2) {
        listConnections.get(index1).add(index2);
    }

    public void removeEdge(int vertex1, int vertex2) {
        listConnections.get(vertex1).remove(vertex2);
    }

    public T getVertex(int i) {
        return listVertex.get(i);
    }

    public List<Integer> getConnections(int index) {
        return listConnections.get(index);
    }

    public int getCountOfVertexes() {
        return listVertex.size();
    }

}
