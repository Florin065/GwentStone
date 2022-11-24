package game.commands.Test2;

import com.fasterxml.jackson.databind.node.ArrayNode;
import game.Board;
import game.cards.Minion;

import java.util.ArrayList;

public final class GetCardsOnTable {
    /**
     *
     * @param output
     * @param board
     */
    public void action(final ArrayNode output, final Board board) {
        ArrayList<ArrayList<Minion>> temp = new ArrayList<>();

        for (int i = 0; i < 2 + 2; i++) {
            temp.add(new ArrayList<>());

            for (Minion minion : board.getCards().get(i)) {
                Minion deepCopy = new Minion(minion);
                temp.get(i).add(deepCopy);
            }
        }

        output.addObject().put("command", "getCardsOnTable").putPOJO("output", temp);
    }
}
