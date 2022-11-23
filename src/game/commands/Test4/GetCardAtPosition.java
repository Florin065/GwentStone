package game.commands.Test4;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import game.Board;
import game.Match;
import game.cards.Card;
import game.cards.Minion;

import java.util.ArrayList;

public class GetCardAtPosition {
    public void action(Match match, ArrayNode output, ActionsInput actionsInput, Board board) {
        int x = actionsInput.getX();
        int y = actionsInput.getY();

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        node.put("command", "getCardAtPosition");
        node.put("x", x);
        node.put("y", y);

        if (y >= board.getCards().get(x).size()) {
            node.put("output", "No card available at that position.");
            output.add(node);
            return;
        }

        Minion card = new Minion(board.getCards().get(x).get(y));

        node.putPOJO("output", card);

        output.add(node);
    }
}
