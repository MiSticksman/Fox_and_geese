package ru.vsu.vadim.foxAndGeese.jackson;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

import ru.vsu.vadim.foxAndGeese.game.GameController;;
import ru.vsu.vadim.foxAndGeese.gameworld.GameField;
import ru.vsu.vadim.foxAndGeese.graph.Graph;
import ru.vsu.vadim.foxAndGeese.piece.IPiece;

import java.io.IOException;

public class GameJsonDeserializer extends JsonDeserializer<GameController> {

    @Override
    public GameController deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        GameController game = new GameController();
        GameField gameField = game.getGameField();
        Graph<IPiece> graph = gameField.getGraph();
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        TreeNode treeNode = jsonParser.readValueAsTree();
//        for (int i = 0; i < gameField.getFieldSize(); i++) {
//            Cell<IPiece> cell = graph.getVertex(i);
//            TextNode node = (TextNode) jsonNode.get(String.valueOf(cell.getData()));
//            String str = jsonNode.get("cells").asText();
//            str = str.replaceAll("[^0-9]", "");
//            String[] a = str.split(" ");
//            int[] arr = new int[4];
//            for (int j = 0; j < arr.length; j++) {
//                arr[j] = Integer.parseInt(a[j]);
//                if (arr[j] != -1) {
//                    graph.createEdge(i, arr[j], j);
//                }
//            }
//        }
        for (int i = 0; i < treeNode.size(); i++) {
            TextNode textNode = (TextNode) treeNode.get("cells");

        }
        return game;
    }
}
