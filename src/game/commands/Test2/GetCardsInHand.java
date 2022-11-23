package game.commands.Test2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import game.Match;
import game.cards.Card;

import java.util.ArrayList;

public class GetCardsInHand {
    public void action(Match match, ArrayNode output, int playerIdx) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        node.put("command", "getCardsInHand");
        node.put("playerIdx", playerIdx);

        ArrayList<Card> handCopy;

        if (playerIdx == 1) {
            handCopy = new ArrayList<>(match.getPlayer1().getCurrentHand());
            node.putPOJO("output", handCopy);
        }
        else {
            handCopy = new ArrayList<>(match.getPlayer2().getCurrentHand());
            node.putPOJO("output", handCopy);
        }

        output.add(node);
    }
}
