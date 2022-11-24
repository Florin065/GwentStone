package game.commands.Test2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import game.Match;

public final class GetPlayerMana {
    /**
     *
     * @param match
     * @param output
     * @param playerIdx
     */
    public void action(final Match match, final ArrayNode output, final int playerIdx) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        node.put("command", "getPlayerMana");
        node.put("playerIdx", playerIdx);

        if (playerIdx == 1) {
            node.put("output", match.getPlayer1().getMana());
        } else {
            node.put("output", match.getPlayer2().getMana());
        }

        output.add(node);
    }
}
