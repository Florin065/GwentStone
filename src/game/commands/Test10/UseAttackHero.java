package game.commands.Test10;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import game.Board;
import game.Match;
import game.cards.Hero;
import game.cards.Minion;

import java.util.ArrayList;

public class UseAttackHero {
    public void action(ArrayNode output, ActionsInput actionsInput, Board board, Match match) {
        int attackerX = actionsInput.getCardAttacker().getX();
        int attackerY = actionsInput.getCardAttacker().getY();

        Minion attacker = board.getCards().get(attackerX).get(attackerY);

        int attackerIdx = 0;

        if (attackerX == 0 || attackerX == 1) {
            attackerIdx = 2;
        }
        else if (attackerX == 2 || attackerX == 3) {
            attackerIdx = 1;
        }

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        node.put("command", "useAttackHero");
        node.putPOJO("cardAttacker", actionsInput.getCardAttacker());

        // Corner Case 1
        if (attacker.isUsedAction()) {
            node.put("error", "Attacker card has already attacked this turn.");
            output.add(node);
            return;
        }

        // Corner Case 2
        if (attacker.isFrozen()) {
            node.put("error", "Attacker card is frozen.");
            output.add(node);
            return;
        }

        // Corner Case 3
        if (board.enemyHasTank(attackerIdx)) {
            node.put("error", "Attacked card is not of type 'Tank'.");
            output.add(node);
            return;
        }

        Hero enemyHero = attackerIdx == 1 ? match.getPlayer2().getHero() : match.getPlayer1().getHero();
        attacker.useAttackHero(enemyHero);
        attacker.setUsedAction(true);

        if (enemyHero.getHealth() <= 0) {
            match.endMatch(attackerIdx);
        }
    }
}
