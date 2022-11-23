package game.commands.check;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import game.Board;
import game.cards.Minion;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class GetCardsOnTable {
    @Getter @Setter
    private ArrayList<ArrayList<Minion>> cards;

    public void action(ArrayNode output, Board board) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        node.put("command", "getCardsOnTable");
        cards = new ArrayList<ArrayList<Minion>>(board.getCards());
        node.putPOJO("output", cards);

        output.add(node);
    }
}