package game.commands.Test8;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import game.Board;
import game.cards.Minion;

import java.util.ArrayList;

public class CardUsesAbility {
    public void action(ArrayNode output, ActionsInput actionsInput, Board board) {
        int attackerX = actionsInput.getCardAttacker().getX();
        int attackerY = actionsInput.getCardAttacker().getY();
        int attackedX = actionsInput.getCardAttacked().getX();
        int attackedY = actionsInput.getCardAttacked().getY();

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
        // Corner Case 3

        switch (attacker.getName()) {
            case "Disciple" -> attacker.useDiscipleAbility(attacked, board);
            case "The Ripper" -> attacker.useTheRipperAbility(attacked, board);
            case "Miraj" -> attacker.useMirajAbility(attacked, attacker, board);
            case "The Cursed One" -> attacker.useTheCursedOneAbility(attacked, board);
        }

        attacker.setUsedAction(true);
    }
}
