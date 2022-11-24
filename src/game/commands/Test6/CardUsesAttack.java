package game.commands.Test6;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import fileio.Coordinates;
import game.Board;
import game.cards.Minion;

import java.util.ArrayList;

public class CardUsesAttack {
    public void action(ArrayNode output, ActionsInput actionsInput, Board board) {
        int attackerX = actionsInput.getCardAttacker().getX();
        int attackerY = actionsInput.getCardAttacker().getY();
        int attackedX = actionsInput.getCardAttacked().getX();
        int attackedY = actionsInput.getCardAttacked().getY();

        ArrayList<ArrayList<Minion>> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            list.add(new ArrayList<>());

            for (Minion minion : board.getCards().get(i)) {
                Minion deepCopy = new Minion(minion);
                list.get(i).add(deepCopy);
            }
        }
        
        int attackerIdx = 0;

        if (attackerX == 0 || attackerX == 1) {
            attackerIdx = 2;
        }
        else if (attackerX == 2 || attackerX == 3) {
            attackerIdx = 1;

        }

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        node.put("command", "cardUsesAttack");
        node.putPOJO("cardAttacker", actionsInput.getCardAttacker());
        node.putPOJO("cardAttacked", actionsInput.getCardAttacked());



        // Corner Case 1
        if (attackerX == attackedX) {
            node.put("error", "Attacked card does not belong to the enemy.");
            output.add(node);
            return;
        }

        Minion attacker = list.get(attackerX).get(attackerY);
        Minion attacked = list.get(attackedX).get(attackedY);
        // Corner Case 2
        if (attacker.isUsedAction()) {
            node.put("error", "Attacker card has already attacked this turn.");
            output.add(node);
            return;
        }
        // Corner Case 3
        if (attacker.isFrozen()) {
            node.put("error", "Attacker card is frozen.");
            output.add(node);
            return;
        }
        // Corner Case 4
        int rowToCheckIdx;

        if (attackerIdx == 2) {
            rowToCheckIdx = 2;
        }
        else {
            rowToCheckIdx = 1;
        }

        boolean tank = false;

        ArrayList<Minion> rowToCheck = board.getCards().get(rowToCheckIdx);

        if (!attacked.isTank()) {
            for (Minion minion : rowToCheck) {
                if (minion.isTank() && minion != attacked) {
                    tank = true;
                    break;
                }
            }
        }

        if (tank) {
            node.put("error", "Attacked card is not of type 'Tank'");
            output.add(node);
            return;
        }

        attacker.useAttack(attacked, attacker, board);
        board.getCards().get(attackedX).get(attackedY).setHealth(attacked.getHealth());
        if (attacked.getHealth() <= 0) {
            board.getCards().remove(attacked);
        }
        board.getCards().get(attackerX).get(attackerY).setUsedAction(true);
    }
}
