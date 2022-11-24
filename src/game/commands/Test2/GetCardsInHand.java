package game.commands.Test2;

import com.fasterxml.jackson.databind.node.ArrayNode;
import game.Match;
import game.cards.Card;
import game.cards.Environment;
import game.cards.Minion;

import java.util.ArrayList;

public final class GetCardsInHand {
    /**
     *
     * @param match
     * @param output
     * @param playerIdx
     */
    public void action(final Match match, final ArrayNode output, final int playerIdx) {
        ArrayList<Card> handCopy;

        if (playerIdx == 1) {
            handCopy = new ArrayList<>();
            for (Card card : match.getPlayer1().getCurrentHand()) {
                if (card instanceof Environment) {
                    handCopy.add(new Environment(card));
                }
                if (card instanceof Minion) {
                    handCopy.add(new Minion((Minion) card));
                }
            }
        } else {
            handCopy = new ArrayList<>();
            for (Card card : match.getPlayer2().getCurrentHand()) {
                if (card instanceof Environment) {
                    handCopy.add(new Environment(card));
                }
                if (card instanceof Minion) {
                    handCopy.add(new Minion((Minion) card));
                }
            }
        }

        output.addObject()
                .put("command", "getCardsInHand")
                .put("playerIdx", playerIdx)
                .putPOJO("output", handCopy);
    }
}
