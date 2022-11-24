package game.commands.Test12;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import game.Board;
import game.Match;
import game.Player;
import game.cards.Hero;

public class UseHeroAbility {
    public void action(ArrayNode output, ActionsInput actionsInput, Board board, Match match) {
        int attackerIdx = match.getPlayerTurn();

        Player attacker = attackerIdx == 1 ? match.getPlayer1() : match.getPlayer2();
        Hero hero = attacker.getHero();

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        node.put("command", "useHeroAbility");
        node.put("affectedRow", actionsInput.getAffectedRow());

        // Corner Case 1
        if (attacker.getMana() < hero.getMana()) {
            node.put("error", "Not enough mana to use hero's ability.");
            output.add(node);
            return;
        }

        // Corner Case 2
        if (hero.isUsedAction()) {
            node.put("error", "Hero has already attacked this turn.");
            output.add(node);
            return;
        }

        // Corner Case 3
        if (hero.getName().equals("Lord Royce") || hero.getName().equals("Empress Thorina")) {
            if (!board.rowBelongsToEnemy(actionsInput.getAffectedRow(), attackerIdx)) {
                node.put("error", "Selected row does not belong to the enemy.");
                output.add(node);
                return;
            }
        }

        // Corner Case 4
        if (hero.getName().equals("General Kocioraw") || hero.getName().equals("King Mudface")) {
            if (board.rowBelongsToEnemy(actionsInput.getAffectedRow(), attackerIdx)) {
                node.put("error", "Selected row does not belong to the current player.");
                output.add(node);
                return;
            }
        }

        hero.useHeroAbility(actionsInput.getAffectedRow(), board);
        attacker.setMana(attacker.getMana() - hero.getMana());
        hero.setUsedAction(true);
    }
}
