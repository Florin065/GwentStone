package game.commands.Test5;

import com.fasterxml.jackson.databind.node.ArrayNode;
import game.Board;
import game.cards.Minion;

import java.util.ArrayList;

public class GetFrozenCardsOnTable {
    public void action(ArrayNode output, Board board) {
        ArrayList<ArrayList<Minion>> frozenList = new ArrayList<>();
        ArrayList<Minion> empty = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            frozenList.add(new ArrayList<>());

            for (Minion minion : board.getCards().get(i)) {
                if (minion.isFrozen()) {
                    Minion deepCopy = new Minion(minion);
                    frozenList.get(i).add(deepCopy);
                }
            }
        }

        boolean emptyCheck = true;

        for (int i = 0; i < 4; i++) {
            if (frozenList.get(i).size() != 0) {
                emptyCheck = false;
                break;
            }
        }

        if (emptyCheck) {
            output.addObject().put("command", "getFrozenCardsOnTable")
                    .putPOJO("output", empty);
        }
        else {
            output.addObject().put("command", "getFrozenCardsOnTable")
                    .putPOJO("output", frozenList);
        }
    }
}
