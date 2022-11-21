package game.commands_TOREMOVE;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import game.Match;
import game.cards.Card;
import game.cards.Hero;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class GetPlayerHero {
    @Getter
    @Setter
    private String command = "getPlayerHero";

    @Getter @Setter
    private int playerIdx;
    @Getter @Setter
    private Hero output;
    public void action(ArrayNode arrayNode, Match match, int playerIdx) {
        this.playerIdx = playerIdx;
        if (playerIdx == 1)
            this.output = (Hero) match.getPlayer1().getHero();
        else
            this.output = (Hero) match.getPlayer2().getHero();
        ObjectMapper mapper = new ObjectMapper();
        arrayNode.add(mapper.valueToTree(this));

    }
}
