package game.commands.check;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import game.Match;

public class GetCardsInHand {
    public void action(Match match, ArrayNode output, int playerIdx) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("command", "getCardsInHand");
        node.put("playerIdx", playerIdx);
        if (playerIdx == 1) {
            node.putPOJO("output", match.getPlayer1().getCurrentHand());
        }
        else {
            node.putPOJO("output", match.getPlayer2().getCurrentHand());
        }
        output.add(node);
    }
}
