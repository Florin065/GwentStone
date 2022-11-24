package game.commands.Test8;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import game.Board;
import game.Match;
import game.cards.Minion;

public final class CardUsesAbility {
    /**
     *
     * @param output
     * @param actionsInput
     * @param board
     * @param match
     */
    public void action(
            final ArrayNode output, final ActionsInput actionsInput,
             final Board board, final Match match) {
        int attackerX = actionsInput.getCardAttacker().getX();
        int attackerY = actionsInput.getCardAttacker().getY();
        int attackedX = actionsInput.getCardAttacked().getX();
        int attackedY = actionsInput.getCardAttacked().getY();

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        node.put("command", "cardUsesAbility");
        node.putPOJO("cardAttacker", actionsInput.getCardAttacker());
        node.putPOJO("cardAttacked", actionsInput.getCardAttacked());

        Minion attacker = board.getCards().get(attackerX).get(attackerY);
        Minion attacked = board.getCards().get(attackedX).get(attackedY);

        // Corner Case 1
        if (attacker.isFrozen()) {
            node.put("error", "Attacker card is frozen.");
            output.add(node);
            return;
        }

        // Corner Case 2
        if (attacker.isUsedAction()) {
            node.put("error", "Attacker card has already attacked this turn.");
            output.add(node);
            return;
        }

        boolean rowCurrent = (((attackerX == 0 || attackerX == 1)
                && (attackedX == 0 || attackedX == 1))
                || ((attackerX == 2 || attackerX == 2 + 1)
                && (attackedX == 2 || attackedX == 2 + 1)));

        // Corner Case 3 -> medic
        if (attacker.getName().equals("Disciple")) {
            if (!rowCurrent) {
                node.put("error", "Attacked card does not belong to the current player.");
                output.add(node);
                return;
            }
            // Corner Case 4
        } else {
            if (rowCurrent) {
                node.put("error", "Attacked card does not belong to the enemy.");
                output.add(node);
                return;
            }

            if (board.enemyHasTank(match.getPlayerTurn()) && !attacked.isTank()) {
                node.put("error", "Attacked card is not of type 'Tank'.");
                output.add(node);
                return;
            }
        }

        attacker.useAbility(attacked, board);

        attacker.setUsedAction(true);
    }
}
