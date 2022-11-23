package game.commands.check;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import game.Match;
import game.Player;
import game.cards.Card;

import java.util.ArrayList;

public class GetCardsInHand {
    private ArrayList<Card> playercopy;

    public void action(Match match, ArrayNode output, int playerIdx) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        node.put("command", "getCardsInHand");
        node.put("playerIdx", playerIdx);

        if (playerIdx == 1) {
            this.playercopy = new ArrayList<>(match.getPlayer1().getCurrentHand());
            node.putPOJO("output", this.playercopy);
        }
        else {
            this.playercopy = new ArrayList<>(match.getPlayer2().getCurrentHand());
            node.putPOJO("output", this.playercopy);
        }

        output.add(node);
    }
}
