package game.commands.Test4;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import game.Board;
import game.Match;

public class GetCardAtPosition {
    public void action(Match match, ArrayNode output, ActionsInput actionsInput, Board board) {
        int x = actionsInput.getX();
        int y = actionsInput.getY();

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        node.put("command", "getCardAtPosition");
        node.put("x", x);
        node.put("y", y);
        node.putPOJO("output", board.getCards().get(x).get(y));

        output.add(node);
    }
}
