package game.commands.Test1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import game.Match;
import game.cards.Hero;

public class GetPlayerHero {
    public void action(Match match, ArrayNode output, int playerIdx) {
        Hero hero = new Hero(playerIdx == 1 ? match.getPlayer1().getHero() : match.getPlayer2().getHero());
        output.addObject()
                .put("command", "getPlayerHero")
                .put("playerIdx", playerIdx)
                .putPOJO("output", hero);
    }
}
