package game.commands.Test4;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import game.Board;
import game.Match;
import game.cards.Card;
import game.cards.Environment;

public final class UseEnvironmentCard {
    /**
     *
     * @param match
     * @param output
     * @param actionsInput
     * @param board
     * @param playerTurn
     */
    public void action(
            final Match match, final ArrayNode output,
                    final ActionsInput actionsInput, final Board board, final int playerTurn) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        int affectedRow = actionsInput.getAffectedRow();

        node.put("command", "useEnvironmentCard");
        node.put("handIdx", actionsInput.getHandIdx());
        node.put("affectedRow", affectedRow);

        int manaPlayer1 = match.getPlayer1().getMana();
        int manaPlayer2 = match.getPlayer2().getMana();

        // Player 1
        if (playerTurn == 1) {
            Card cardPlayer1 = match.getPlayer1().getCurrentHand().get(actionsInput.getHandIdx());

            // Corner Case 1
            if (!(cardPlayer1 instanceof Environment)) {
                node.put("error", "Chosen card is not of type environment.");
                output.add(node);
                return;
            } else {
                // Corner Case 2
                if (manaPlayer1 < cardPlayer1.getMana()) {
                    node.put("error", "Not enough mana to use environment card.");
                    output.add(node);
                    return;
                    // Corner Case 3
                } else if (affectedRow == 2 || affectedRow == 2 + 1) {
                    node.put("error", "Chosen row does not belong to the enemy.");
                    output.add(node);
                    return;
                    // Corner Case 4
                } else if (cardPlayer1.getName().equals("Heart Hound")) {
                    if (affectedRow == 0) {
                        if (board.getCards().get(2 + 1).size() == 2 + 2 + 1) {
                            node.put("error",
                                    "Cannot steal enemy card since the player's row is full.");
                            output.add(node);
                            return;
                        }
                    } else if (affectedRow == 1) {
                        if (board.getCards().get(2).size() == 2 + 2 + 1) {
                            node.put("error",
                                    "Cannot steal enemy card since the player's row is full.");
                            output.add(node);
                            return;
                        }
                    }
                }

                if (affectedRow == 0) {
                    if (cardPlayer1.getName().equals("Firestorm")) {
                        ((Environment) cardPlayer1).useFirestormAbility(affectedRow, board);
                    } else if (cardPlayer1.getName().equals("Winterfell")) {
                        ((Environment) cardPlayer1).useWinterfellAbility(affectedRow, board);
                    } else {
                        ((Environment) cardPlayer1).useHeartHoundAbility(affectedRow, 2 + 1, board);
                    }
                } else if (affectedRow == 1) {
                    if (cardPlayer1.getName().equals("Firestorm")) {
                        ((Environment) cardPlayer1).useFirestormAbility(affectedRow, board);
                    } else if (cardPlayer1.getName().equals("Winterfell")) {
                        ((Environment) cardPlayer1).useWinterfellAbility(affectedRow, board);
                    } else {
                        ((Environment) cardPlayer1).useHeartHoundAbility(affectedRow, 2, board);
                    }
                }

                match.getPlayer1().getCurrentHand().remove(actionsInput.getHandIdx());
                match.getPlayer1().setMana(manaPlayer1 - cardPlayer1.getMana());
            }
        }

        // Player 2
        if (playerTurn == 2) {
            Card cardPlayer2 = match.getPlayer2().getCurrentHand().get(actionsInput.getHandIdx());

            // Corner Case 1
            if (!(cardPlayer2 instanceof Environment)) {
                node.put("error", "Chosen card is not of type environment.");
                output.add(node);
            } else {
                // Corner Case 2
                if (manaPlayer2 < cardPlayer2.getMana()) {
                    node.put("error", "Not enough mana to use environment card.");
                    output.add(node);
                    return;
                    // Corner Case 3
                } else if (affectedRow == 0 || affectedRow == 1) {
                    node.put("error", "Chosen row does not belong to the enemy.");
                    output.add(node);
                    return;
                    // Corner Case 4
                } else if (cardPlayer2.getName().equals("Heart Hound")) {
                    if (affectedRow == 2) {
                        if (board.getCards().get(1).size() == 2 + 2 + 1) {
                            node.put("error",
                                    "Cannot steal enemy card since the player's row is full.");
                            output.add(node);
                            return;
                        }
                    } else if (affectedRow == 2 + 1) {
                        if (board.getCards().get(0).size() == 2 + 2 + 1) {
                            node.put("error",
                                    "Cannot steal enemy card since the player's row is full.");
                            output.add(node);
                            return;
                        }
                    }
                }

                if (affectedRow == 2) {
                    if (cardPlayer2.getName().equals("Firestorm")) {
                        ((Environment) cardPlayer2).useFirestormAbility(affectedRow, board);
                    } else if (cardPlayer2.getName().equals("Winterfell")) {
                        ((Environment) cardPlayer2).useWinterfellAbility(affectedRow, board);
                    } else {
                        ((Environment) cardPlayer2).useHeartHoundAbility(affectedRow, 1, board);
                    }
                } else if (affectedRow == 2 + 1) {
                    if (cardPlayer2.getName().equals("Firestorm")) {
                        ((Environment) cardPlayer2).useFirestormAbility(affectedRow, board);
                    } else if (cardPlayer2.getName().equals("Winterfell")) {
                        ((Environment) cardPlayer2).useWinterfellAbility(affectedRow, board);
                    } else {
                        ((Environment) cardPlayer2).useHeartHoundAbility(affectedRow, 0, board);
                    }
                }

                match.getPlayer2().getCurrentHand().remove(actionsInput.getHandIdx());
                match.getPlayer2().setMana(manaPlayer2 - cardPlayer2.getMana());
            }
        }
    }
}
