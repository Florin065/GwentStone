package game.commands.Test17;

import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.ActionsInput;
import game.Match;

public final class GetPlayerWins {
    /**
     *
     * @param match
     * @param output
     * @param actionsInput
     */
    public void action(
            final Match match, final ArrayNode output, final ActionsInput actionsInput) {
        if (actionsInput.getCommand().equals("getPlayerOneWins")) {
            output.addObject()
                    .put("command", "getPlayerOneWins")
                    .put("output", match.getPlayer1().getWins());
        } else {
            output.addObject()
                    .put("command", "getPlayerTwoWins")
                    .put("output", match.getPlayer2().getWins());
        }
    }
}
