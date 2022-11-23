package game.commands.Test4;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.CardInput;
import game.Match;
import game.cards.Card;
import game.cards.Environment;

import java.util.ArrayList;

public class GetEnvironmentCardsInHand {
    public void action(Match match, ArrayNode output, int playerIdx) {
        ArrayList<Card> envList = new ArrayList<>();
        ArrayList<Card> envListCopy;

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        node.put("command", "getEnvironmentCardsInHand");
        node.put("playerIdx", playerIdx);

        if (playerIdx == 1) {
            for (Card env : match.getPlayer1().getCurrentHand()) {
                if (env instanceof Environment) {
                    envList.add(env);
                }
            }

        }
        else {
            for (Card env : match.getPlayer2().getCurrentHand()) {
                if (env instanceof Environment) {
                    envList.add(env);
                }
            }

        }

        envListCopy = new ArrayList<>(envList);
        node.putPOJO("output", envListCopy);

        output.add(node);
    }
}
