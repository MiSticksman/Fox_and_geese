package ru.vsu.vadim.foxAndGeeese.gameworld;

import java.util.*;


public class Graph<T> implements Iterable<GraphVertex<T>> {
    protected class GraphNode<T> {
        public GraphVertex<T> value;
        public LinkedList<GraphNode<T>> next;

        public GraphNode(GraphVertex<T> value, LinkedList<GraphNode<T>> next) {
            this.value = value;
            this.next = next;
        }

        public GraphNode(GraphVertex<T> value) {
            this(value, null);
        }

        public GraphNode() {
            this(null);
        }
    }

    private GraphNode<T> head = null;

    public Graph() {
        head = new GraphNode<>();
    }

    public void addVertex(GraphVertex<T> vertex) {
        if(head.next == null) {
            head.next = new LinkedList<>();
        }
        GraphNode newNode = new GraphNode(vertex);
        head.next.addLast(newNode);
    }

    public void removeVertex(GraphVertex<T> vertex) {
        int v = findIndex(vertex);
        head.next.remove(v);
    }

    public void createEdge(GraphVertex<T> vertex1, GraphVertex<T> vertex2) {
        int v1 = findIndex(vertex1);
        int v2 = findIndex(vertex2);
        if(head.next.get(v1).next == null) {
            head.next.get(v1).next = new LinkedList<>();
        }
        if(head.next.get(v2).next == null) {
            head.next.get(v2).next = new LinkedList<>();
        }
        head.next.get(v1).next.add(head.next.get(v2));
        head.next.get(v2).next.add(head.next.get(v1));
    }

    private int findIndex(GraphVertex<T> vertex) {
        for (int i = 0; i <head.next.size(); i++){
            if(vertex.equals(head.next.get(i).value)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEdge(GraphVertex<T> vertex1, GraphVertex<T> vertex2) {

        int v1 = findIndex(vertex1);
        int v2 = findIndex(vertex2);

        if(v1 == -1 || v2 == -1) {
            return false;
        }
        if(head.next.get(v1).next == null || head.next.get(v2).next == null) {
            return false;
        }
        return head.next.get(v1).next.contains(head.next.get(v2));
    }

    public void removeEdge(GraphVertex<T> vertex1, GraphVertex<T> vertex2) {
        int v1 = findIndex(vertex1);
        int v2 = findIndex(vertex2);

        head.next.get(v1).next.remove(head.next.get(v2));
        head.next.get(v2).next.remove(head.next.get(v1));
    }

    public GraphVertex<T> getVertex(int i) {
        return head.next.get(i).value;
    }

    public void replaceVertices(GraphVertex<T> oldVertex, GraphVertex<T> newVertex) throws Exception {
        int v = findIndex(oldVertex);
        if(v < 0)
            throw new Exception("oldVertex is not found");
        head.next.get(v).value = newVertex;
    }


    @Override
    public Iterator<GraphVertex<T>> iterator() {
        class GraphIterator implements Iterator<GraphVertex<T>> {
            ListIterator<GraphNode<T>> iter;

            public GraphIterator(GraphNode<T> head) {
                iter = head.next.listIterator();
            }

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public GraphVertex<T> next() {
                return iter.next().value;
            }
        }

        return new GraphIterator(head);
    }

//    @Override
//    public Iterable<Integer> adjacencies(int v) {
//        return vEdjLists.get(v) == null ? nullIterable : vEdjLists.get(v);
//    }
}
