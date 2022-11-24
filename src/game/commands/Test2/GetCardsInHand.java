package game.commands.Test2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import game.Match;
import game.cards.Card;
import game.cards.Environment;
import game.cards.Minion;

import java.util.ArrayList;

public class GetCardsInHand {
    public void action(Match match, ArrayNode output, int playerIdx) {
        ArrayList<Card> handCopy;

        if (playerIdx == 1) {
            handCopy = new ArrayList<>();
            for (Card card : match.getPlayer1().getCurrentHand()) {
                if (card instanceof Environment)
                    handCopy.add(new Environment(card));
                if (card instanceof Minion)
                    handCopy.add(new Minion((Minion) card));
            }
        }
        else {
            handCopy = new ArrayList<>();
            for (Card card : match.getPlayer2().getCurrentHand()) {
                if (card instanceof Environment)
                    handCopy.add(new Environment(card));
                if (card instanceof Minion)
                    handCopy.add(new Minion((Minion) card));
            }
        }

        output.addObject()
                .put("command", "getCardsInHand")
                .put("playerIdx", playerIdx)
                .putPOJO("output", handCopy);
    }
}
