package ru.vsu.vadim.foxAndGeeese.gameworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vsu.vadim.foxAndGeeese.graph.Graph;
import ru.vsu.vadim.foxAndGeeese.piece.IPiece;

import java.util.ArrayList;

public class GameField {

    private Graph<Cell<IPiece>> graph;
    private static final int FIELD_SIZE = 33;
    private int [][]  connections = new int[][] {
            {1, 3},
            {0, 2, 4},
            {1, 5},
            {0, 4, 8},
            {1, 3, 5, 9}, {3, 4, 10},
            {7, 13}, {6, 8, 14},{3, 7, 9, 15}, {4, 8, 10, 16}, {9, 11, 17},
            {10, 12, 18}, {11, 19}, {6, 14, 20}, {7, 13, 15, 21},
            {8, 14, 16, 22}, {9, 15, 17, 23}, {10, 16, 18, 24}, {11, 17, 19, 25},
            {12, 18, 26}, {13, 21}, {14, 20, 22}, {15, 21, 23, 27}, {16, 22, 24, 28},
            {17, 23, 25, 29}, {18, 24, 26}, {19, 25}, {22, 28, 30}, {23, 27, 29, 31},
            {24, 28, 32}, {27, 31}, {28, 30, 32}, {29, 31},
    };
    private static final int FIELD_SIZE_FOR_GRIDPANE = 7;

    private static final Logger log = LoggerFactory.getLogger(GameField.class);

    public GameField() {
        graph = new Graph<>();
        for (int i = 0; i < FIELD_SIZE; i++) {
            graph.addVertex(new Cell<>(i, null));
        }
        addConenections();
        log.info("The field has been created");
    }

    public void addPiece(IPiece piece, int number) {
        graph.getVertex(number).setData(piece);
    }

    public void addConenections() {
        for (int i = 0; i < connections.length; i++) {
            for (int j = 0; j < connections[i].length; j++) {
                    graph.createEdge(i, connections[i][j]);
            }
        }
    }

    public int getFieldSize() {
        return FIELD_SIZE;
    }

    public int getFieldSizeForGridpane() {
        return FIELD_SIZE_FOR_GRIDPANE;
    }

    public IPiece getPiece(int index) {
        return graph.getVertex(index).getData();
    }

    public void setPiece(int index, IPiece piece) {
        graph.getVertex(index).setData(piece);
    }

    public ArrayList<Integer> getNeighbours(int index) {
        ArrayList<Integer> list = new ArrayList<>(graph.getConnections(index));
        return list;
    }
}
