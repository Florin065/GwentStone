package game.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import game.Match;
import game.cards.Card;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class GetPlayerDeck {
    @Getter @Setter
    private int playerIdx;
    @Getter @Setter
    private ArrayList<Card> output;

    public void action(Match match, ArrayNode output, int playerIdx) {
        this.playerIdx = playerIdx;

        if (playerIdx == 1) {
            this.output = match.getPlayer1().getCurrentDeck();
        }
        else {
            this.output = match.getPlayer2().getCurrentDeck();
        }

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("command", "getPlayerDeck");
        node.put("playerIdx", this.playerIdx);
        node.putPOJO("output", this.output);
        output.add(node);
    }
}
