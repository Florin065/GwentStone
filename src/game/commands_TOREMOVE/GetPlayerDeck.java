package game.commands_TOREMOVE;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import game.Match;
import game.Player;
import game.cards.Card;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class GetPlayerDeck {
    @Getter @Setter
    private String command = "getPlayerDeck";

    @Getter @Setter
    private int playerIdx;
    @Getter @Setter
    private ArrayList<Card> output;
    public void action(ArrayNode arrayNode, Match match, int playerIdx) {
        this.playerIdx = playerIdx;
        if (playerIdx == 1)
            this.output = match.getPlayer1().getCurrentDeck();
        else
            this.output = match.getPlayer2().getCurrentDeck();
        ObjectMapper mapper = new ObjectMapper();
        arrayNode.add(mapper.valueToTree(this));

    }
}
