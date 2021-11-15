package ru.vsu.vadim.foxAndGeese.gameworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vsu.vadim.foxAndGeese.graph.Graph;
import ru.vsu.vadim.foxAndGeese.piece.IPiece;
import ru.vsu.vadim.foxAndGeese.utils.GameUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameField {

    private Graph<IPiece> graph; // настоящая реализация - граф из 33 вершин: 17 гусей, 1 лис

    private final int [][]  connections = new int[][] {
            {1, 3, -1, -1}, {2, 4, 0, -1}, {-1, 5, 1, -1}, {4, 8, -1, 0}, {5, 9, 3, 1},
            {-1, 10, 4, 2}, {7, 13, -1, -1}, {8, 14, 6, -1}, {9, 15, 7, 3}, {10, 16, 8, 4},
            {11, 17, 9, 5}, {12, 18, 10, -1}, {-1, 19, 11, -1}, {14, 20, -1, 6}, {15, 21, 13, 7},
            {16, 22, 14, 8}, {17, 23, 15, 9}, {18, 24, 16, 10}, {19, 25, 17, 11}, {-1, 26, 18, 12},
            {21, -1, -1, 13}, {22, -1, 20, 14}, {23, 27, 21, 15}, {24, 28, 22, 16}, {25, 29, 23, 17},
            {26, -1, 24, 18}, {-1, -1, 25, 19}, {28, 30, -1, 22}, {29, 31, 27, 23},
            {-1, 32, 28, 24}, {31, -1, -1, 27}, {32, -1, 30, 28}, {-1, -1, 31, 29},
    };

    private static final Logger log = LoggerFactory.getLogger(GameField.class);

    public GameField() {
        graph = new Graph<>();
        for (int i = 0; i < 33; i++) {
            graph.addVertex(new Cell<>(i, null));
        }
        addConnections();
        log.info("The field has been created");
    }

    public void addPiece(IPiece piece, int number) {
        graph.getVertex(number).setData(piece);
    }

    private void addConnections() {
        for (int i = 0; i < connections.length; i++) {
            for (int j = 0; j < connections[i].length; j++) {
                if (connections[i][j] != -1)
                    graph.createEdge(i, connections[i][j], j);
            }
        }
    }

    public int getFieldSize() {
        return graph.getCountOfVertexes();
    }


    public IPiece getPiece(int index) {
        return graph.getVertex(index).getData();
    }

    public void setPiece(int index, IPiece piece) {
        graph.getVertex(index).setData(piece);
    }

    public boolean isConnected(int place1, int place2) {
        return graph.isAdj(place1, place2) && graph.getVertex(place2).getData() == null;
    }

    public int indexOfConnectedAcrossOne(int from, int to) throws Exception {
        try {
            Cell<IPiece> piece1 = graph.getVertex(from);
            Cell<IPiece> piece2 = graph.getVertex(to);
            for (int i = 0; i < 4; i++) {
                Cell<IPiece> connected1 = piece1.connectedOn(i);
                Cell<IPiece> connected2 = piece2.connectedOn(GameUtils.getOppositeDirection(i));
                if (connected1 != null && connected2 != null && connected1.getData() != null && connected1.equals(connected2)) {
                    return connected1.getNumber();
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return -1;
    }

    public List<Integer> getNeighbours(int index) {
        return graph.getConnections(index).stream().filter(Objects::nonNull)
                .map(Cell::getNumber)
                .collect(Collectors.toList());
    }
}
