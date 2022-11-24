package game.commands.Test16;

import com.fasterxml.jackson.databind.node.ArrayNode;
import game.Match;


public final class GetTotalGamesPlayed {
    /**
     *
     * @param match
     * @param output
     */
    public void action(final Match match, final ArrayNode output) {
        output.addObject()
                .put("command", "getTotalGamesPlayed")
                .put("output", match.getPlayer1().getPlays());
    }
}
