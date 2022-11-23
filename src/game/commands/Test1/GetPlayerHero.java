package game.commands.Test1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import game.Match;

public class GetPlayerHero {
    public void action(Match match, ArrayNode output, int playerIdx) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        node.put("command", "getPlayerHero");
        node.put("playerIdx", playerIdx);

        if (playerIdx == 1) {
            node.putPOJO("output", match.getPlayer1().getHero());
        }
        else {
            node.putPOJO("output", match.getPlayer2().getHero());
        }

        output.add(node);
    }
}
