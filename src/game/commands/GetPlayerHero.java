package game.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import game.Match;
import game.cards.Hero;
import lombok.Getter;
import lombok.Setter;

public class GetPlayerHero {
    @Getter @Setter
    private int playerIdx;
    @Getter @Setter
    private Hero output;

    public void action(Match match, ArrayNode output, int playerIdx) {
        this.playerIdx = playerIdx;

        if (playerIdx == 1) {
            this.output = (Hero) match.getPlayer1().getHero();
        }
        else {
            this.output = (Hero) match.getPlayer2().getHero();
        }

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("command", "getPlayerHero");
        node.put("playerIdx", this.playerIdx);
        node.putPOJO("output", this.output);
        output.add(node);
    }
}
