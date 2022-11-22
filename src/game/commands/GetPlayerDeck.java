package game.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import game.Match;

public class GetPlayerDeck {
    public void action(Match match, ArrayNode output, int playerIdx) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("command", "getPlayerDeck");
        node.put("playerIdx", playerIdx);
        if (playerIdx == 1) {
            node.putPOJO("output", match.getPlayer1().getCurrentDeck());
        }
        else {
            node.putPOJO("output", match.getPlayer2().getCurrentDeck());
        }
        output.add(node);
    }
}
