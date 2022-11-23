package game.commands.Test4;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import game.Board;
import game.Match;
import game.cards.Card;
import game.cards.Environment;

public class UseEnvironmentCard {
    public void action(Match match, ArrayNode output, ActionsInput actionsInput, Board board, int playerTurn) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        int affectedRow = actionsInput.getAffectedRow();

        node.put("command", "useEnvironmentCard");
        node.put("handIdx", actionsInput.getHandIdx());
        node.put("affectedRow", affectedRow);

        int manaPlayer1 = match.getPlayer1().getMana();
        int manaPlayer2 = match.getPlayer2().getMana();
        Card cardPlayer1 = match.getPlayer1().getCurrentHand().get(actionsInput.getHandIdx());
        Card cardPlayer2 = match.getPlayer2().getCurrentHand().get(actionsInput.getHandIdx());

        // Player 1
        if (playerTurn == 1) {
            // Corner Case 1
            if (!(cardPlayer1 instanceof Environment)) {
                node.put("error", "Chosen card is not of type environment.");
                output.add(node);
                return;
            }
            else {
                // Corner Case 2
                if (manaPlayer1 < cardPlayer1.getMana()) {
                    node.put("error", "Not enough mana to use environment card.");
                    output.add(node);
                    return;
                }
                // Corner Case 3
                else if (affectedRow == 2 || affectedRow == 3) {
                    node.put("error", "Chosen row does not belong to the enemy.");
                    output.add(node);
                    return;
                }
                // Corner Case 4
                else if (cardPlayer1.getName().equals("Heart Hound")) {
                    if (affectedRow == 0) {
                        if (board.getCards().get(3).size() == 5) {
                            node.put("error", "Cannot steal enemy card since the player's row is full.");
                            output.add(node);
                            return;
                        }
                    }
                    else if (affectedRow == 1) {
                        if (board.getCards().get(2).size() == 5) {
                            node.put("error", "Cannot steal enemy card since the player's row is full.");
                            output.add(node);
                            return;
                        }
                    }
                }
                // else if pentru Winterfell și pentru Firestorm

                ((Environment) cardPlayer1).useEnvironmentAbility();
                match.getPlayer1().getCurrentHand().remove(actionsInput.getHandIdx());
            }
        }

        // Player 2
        if (playerTurn == 2) {
            // Corner Case 1
            if (!(cardPlayer2 instanceof Environment)) {
                node.put("error", "Chosen card is not of type environment.");
                output.add(node);
            }
            else {
                // Corner Case 2
                if (manaPlayer2 < cardPlayer2.getMana()) {
                    node.put("error", "Not enough mana to use environment card.");
                    output.add(node);
                    return;
                }
                // Corner Case 3
                else if (affectedRow == 0 || affectedRow == 1) {
                    node.put("error", "Chosen row does not belong to the enemy.");
                    output.add(node);
                    return;
                }
                // Corner Case 4
                else if (cardPlayer1.getName().equals("Heart Hound")) {
                    if (affectedRow == 2) {
                        if (board.getCards().get(1).size() == 5) {
                            node.put("error", "Cannot steal enemy card since the player's row is full.");
                            output.add(node);
                            return;
                        }
                    }
                    else if (affectedRow == 3) {
                        if (board.getCards().get(0).size() == 5) {
                            node.put("error", "Cannot steal enemy card since the player's row is full.");
                            output.add(node);
                            return;
                        }
                    }
                }
                // else if pentru Winterfell și pentru Firestorm

                ((Environment) cardPlayer2).useEnvironmentAbility();
                match.getPlayer2().getCurrentHand().remove(actionsInput.getHandIdx());
            }
        }
    }
}
