package ru.vsu.vadim.foxAndGeeese.gameworld;

public class GameField {

    private Graph<piece.IPiece> graph;
    private static final int FIELD_SIZE = 33;

    public GameField() {
        graph = new Graph<>();
        for (int i = 0; i < FIELD_SIZE; i++) {
            graph.addVertex(new GraphVertex<>(i, null));
        }
    }

    public void addPiece(piece.IPiece piece, int number) {
        graph.getVertex(number).setData(piece);
    }

//    public Graph<piece.IPiece> getGraph() {
//        return graph;
//    }

    public int getFieldSize() {
        return FIELD_SIZE;
    }
}
