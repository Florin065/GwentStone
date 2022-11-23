package game.commands.Test2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import game.Board;
import game.cards.Minion;

import java.util.ArrayList;

public class GetCardsOnTable {
    public void action(ArrayNode output, Board board) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        node.put("command", "getCardsOnTable");

        ArrayList<ArrayList<Minion>> cards = new ArrayList<>(board.getCards());
        node.putPOJO("output", cards);

        output.add(node);
    }
}