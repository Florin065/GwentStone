package game.commands.Test1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import game.Match;

public final class GetPlayerTurn {
    /**
     *
     * @param match
     * @param output
     */
    public void action(final Match match, final ArrayNode output) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        node.put("command", "getPlayerTurn");
        node.put("output", match.getPlayerTurn());

        output.add(node);
    }
}
