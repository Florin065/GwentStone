package game.commands.Test2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import game.Board;
import game.cards.Minion;

import java.util.ArrayList;

public class GetCardsOnTable {
    public void action(ArrayNode output, Board board) {
        ArrayList<ArrayList<Minion>> temp = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            temp.add(new ArrayList<>());

            for (Minion minion : board.getCards().get(i)) {
                Minion deepCopy = new Minion(minion);
                temp.get(i).add(deepCopy);
            }
        }

        output.addObject().put("command", "getCardsOnTable").putPOJO("output", temp);
    }
}