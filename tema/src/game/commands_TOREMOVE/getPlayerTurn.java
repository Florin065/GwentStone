package game.commands_TOREMOVE;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import game.Match;
import lombok.Getter;
import lombok.Setter;

public class getPlayerTurn {
    @Getter @Setter
    private String command = "getPlayerTurn";

    @Getter @Setter
    private int playerIdx;

    public getPlayerTurn() {

    }

    public void execute(Match match, ArrayNode output) {
        // playerIdx = ...
        ObjectMapper mapper = new ObjectMapper();
        output.add(mapper.valueToTree(this));
    }
}
