package ru.vsu.vadim.foxAndGeeese.gameworld;

import ru.vsu.vadim.foxAndGeeese.piece.IPiece;

import java.util.*;


public class Graph<T>  {

    private ArrayList<LinkedList<Integer>> listConnections = new ArrayList<>();
    private ArrayList<T> listVertex = new ArrayList<>();

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

//    private int findIndex(GraphVertex<T> vertex) {
//        for (int i = 0; i <head.next.size(); i++){
//            if(vertex.equals(head.next.get(i).value)) {
//                return i;
//            }
//        }
//        return -1;
//    }

//    public boolean isEdge(GraphVertex<T> vertex1, GraphVertex<T> vertex2) {
//
//        int v1 = findIndex(vertex1);
//        int v2 = findIndex(vertex2);
//
//        if(v1 == -1 || v2 == -1) {
//            return false;
//        }
//        if(head.next.get(v1).next == null || head.next.get(v2).next == null) {
//            return false;
//        }
//        return head.next.get(v1).next.contains(head.next.get(v2));
//    }

    public void removeEdge(int vertex1, int vertex2) {
        listConnections.get(vertex1).remove(vertex2);
    }

    public T getVertex(int i) {
        return listVertex.get(i);
    }

   /* public void replaceVertices(GraphVertex<T> oldVertex, GraphVertex<T> newVertex) throws Exception {
        int v = findIndex(oldVertex);
        if(v < 0)
            throw new Exception("oldVertex is not found");
        head.next.get(v).value = newVertex;
    }*/
}
