package game.commands.Test17;

import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.ActionsInput;
import game.Match;

public class getPlayerWins {
    public void action(Match match, ArrayNode output, ActionsInput actionsInput) {
        if (actionsInput.getCommand().equals("getPlayerOneWins"))
            output.addObject()
                    .put("command", "getPlayerOneWins")
                    .put("output", match.getPlayer1().getWins());
        else
            output.addObject()
                    .put("command", "getPlayerTwoWins")
                    .put("output", match.getPlayer2().getWins());
    }
}
