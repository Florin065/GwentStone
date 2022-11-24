package game.commands.Test1;

import com.fasterxml.jackson.databind.node.ArrayNode;
import game.Match;
import game.cards.Hero;

public final class GetPlayerHero {
    /**
     *
     * @param match
     * @param output
     * @param playerIdx
     */
    public void action(final Match match, final ArrayNode output, final int playerIdx) {
        Hero hero = new Hero(
                playerIdx == 1 ? match.getPlayer1().getHero() : match.getPlayer2().getHero());
        output.addObject()
                .put("command", "getPlayerHero")
                .put("playerIdx", playerIdx)
                .putPOJO("output", hero);
    }
}
