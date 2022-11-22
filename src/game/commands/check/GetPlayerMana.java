package game.commands.check;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import game.Match;

public class GetPlayerMana {
    public void action(Match match, ArrayNode output, int playerIdx) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("command", "getPlayerMana");
        node.put("playerIdx", playerIdx);
        if (playerIdx == 1) {
            node.put("output", match.getPlayer1().getMana());
        }
        else {
            node.put("output", match.getPlayer2().getMana());
        }
        output.add(node);
    }
}