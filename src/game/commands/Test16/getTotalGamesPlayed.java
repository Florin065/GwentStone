package game.commands.Test16;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import game.Match;

public class getTotalGamesPlayed {
    public void action(Match match, ArrayNode output) {
        output.addObject()
                .put("command", "getTotalGamesPlayed")
                .put("output", match.getPlayer1().getPlays());
    }
}
