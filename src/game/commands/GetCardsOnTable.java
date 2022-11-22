package game.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import game.Board;

public class GetCardsOnTable {
    public void action(ArrayNode output, Board board) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("command", "getCardsOnTable");
        node.putPOJO("output", board.getCards());
        output.add(node);
    }
}