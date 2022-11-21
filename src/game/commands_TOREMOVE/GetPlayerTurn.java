package game.commands_TOREMOVE;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import game.Match;
import lombok.Getter;
import lombok.Setter;

public class GetPlayerTurn {
    public void execute(Match match, ArrayNode output) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("command", "getPlayerTurn");
        node.put("output", match.getPlayerTurn());
        output.add(node);
    }
}
