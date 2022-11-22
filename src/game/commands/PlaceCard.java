package game.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import game.Board;
import game.Match;
import game.cards.Card;
import game.cards.Environment;
import game.cards.Minion;

public class PlaceCard {
    public void action(Match match, ArrayNode output, ActionsInput actionsInput, Board board) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("command", "placeCard");
        node.put("handIdx", actionsInput.getHandIdx());
        // player 1 turn
        if (actionsInput.getPlayerIdx() == 1 && match.getTurnCounter() % 2 == 1) {
            Card hand = match.getPlayer1().getCurrentHand().get(actionsInput.getHandIdx());
            if (hand instanceof Environment) {
                node.put("error", "Cannot place environment card on table.");
                output.add(node);
                return;
            }

            int manaPlayer = match.getPlayer1().getMana();
            int manaCard = match.getPlayer1().getCurrentHand().get(actionsInput.getHandIdx()).getMana();
            if (manaPlayer < manaCard) {
                node.put("error", "Not enough mana to place card on table.");
                output.add(node);
                return;
            }

            String cardName = match.getPlayer1().getCurrentHand().get(actionsInput.getHandIdx()).getName();
            Card cardadd = match.getPlayer1().getCurrentHand().get()
            if (cardName.equals("The Ripper") || cardName.equals("Miraj")
                    || cardName.equals("Goliath") || cardName.equals("Warden")) {
                if (board.getCards().get(2).size() == 5) {
                    node.put("error", "Cannot place card on table since row is full.");
                    output.add(node);
                    return;
                }

                board.getCards().get(2).add((Minion) hand);
            }
            else if (cardName.equals("Sentinel") || cardName.equals("Berserker")
                    || cardName.equals("The Cursed One") || cardName.equals("Disciple")) {
                if (board.getCards().get(3).size() == 5) {
                    node.put("error", "Cannot place card on table since row is full.");
                    output.add(node);
                    return;
                }
                board.getCards().get(3).add((Minion) hand);
            }
        }
        // player 2 turn
        else if (actionsInput.getPlayerIdx() == 1 && match.getTurnCounter() % 2 == 0) {
            Card card = match.getPlayer2().getCurrentHand().get(actionsInput.getHandIdx());
            if (card instanceof Environment) {
                node.put("error", "Cannot place environment card on table.");
                output.add(node);
                return;
            }

            int manaPlayer = match.getPlayer2().getMana();
            int manaCard = match.getPlayer2().getCurrentHand().get(actionsInput.getHandIdx()).getMana();
            if (manaPlayer < manaCard) {
                node.put("error", "Not enough mana to place card on table.");
                output.add(node);
                return;
            }

            String cardName = match.getPlayer2().getCurrentHand().get(actionsInput.getHandIdx()).getName();
            if (cardName.equals("The Ripper") || cardName.equals("Miraj")
                    || cardName.equals("Goliath") || cardName.equals("Warden")) {
                if (board.getCards().get(1).size() == 5) {
                    node.put("error", "Cannot place card on table since row is full.");
                    output.add(node);
                    return;
                }
                board.getCards().get(1).add((Minion) card);
            }
            else if (cardName.equals("Sentinel") || cardName.equals("Berserker")
                    || cardName.equals("The Cursed One") || cardName.equals("Disciple")) {
                if (board.getCards().get(0).size() == 5) {
                    node.put("error", "Cannot place card on table since row is full.");
                    output.add(node);
                    return;
                }
                board.getCards().get(0).add((Minion) card);
            }
        }
        // player 2 turn
        else if (actionsInput.getPlayerIdx() == 2 && match.getTurnCounter() % 2 == 1) {
            Card card = match.getPlayer2().getCurrentHand().get(actionsInput.getHandIdx());
            if (card instanceof Environment) {
                node.put("error", "Cannot place environment card on table.");
                output.add(node);
                return;
            }

            int manaPlayer = match.getPlayer2().getMana();
            int manaCard = match.getPlayer2().getCurrentHand().get(actionsInput.getHandIdx()).getMana();
            if (manaPlayer < manaCard) {
                node.put("error", "Not enough mana to place card on table.");
                output.add(node);
                return;
            }

            String cardName = match.getPlayer2().getCurrentHand().get(actionsInput.getHandIdx()).getName();
            if (cardName.equals("The Ripper") || cardName.equals("Miraj")
                    || cardName.equals("Goliath") || cardName.equals("Warden")) {
                if (board.getCards().get(1).size() == 5) {
                    node.put("error", "Cannot place card on table since row is full.");
                    output.add(node);
                    return;
                }
                board.getCards().get(1).add((Minion) card);
            }
            else if (cardName.equals("Sentinel") || cardName.equals("Berserker")
                    || cardName.equals("The Cursed One") || cardName.equals("Disciple")) {
                if (board.getCards().get(0).size() == 5) {
                    node.put("error", "Cannot place card on table since row is full.");
                    output.add(node);
                    return;
                }
                board.getCards().get(0).add((Minion) card);
            }
        }
        // player 1 turn
        else if (actionsInput.getPlayerIdx() == 2 && match.getTurnCounter() % 2 == 0) {
            Card card = match.getPlayer1().getCurrentHand().get(actionsInput.getHandIdx());
            if (card instanceof Environment) {
                node.put("error", "Cannot place environment card on table.");
                output.add(node);
                return;
            }

            int manaPlayer = match.getPlayer1().getMana();
            int manaCard = match.getPlayer1().getCurrentHand().get(actionsInput.getHandIdx()).getMana();
            if (manaPlayer < manaCard) {
                node.put("error", "Not enough mana to place card on table.");
                output.add(node);
                return;
            }

            String cardName = match.getPlayer1().getCurrentHand().get(actionsInput.getHandIdx()).getName();
            if (cardName.equals("The Ripper") || cardName.equals("Miraj")
                    || cardName.equals("Goliath") || cardName.equals("Warden")) {
                if (board.getCards().get(2).size() == 5) {
                    node.put("error", "Cannot place card on table since row is full.");
                    output.add(node);
                    return;
                }
                board.getCards().get(2).add((Minion) card);
            }
            else if (cardName.equals("Sentinel") || cardName.equals("Berserker")
                    || cardName.equals("The Cursed One") || cardName.equals("Disciple")) {
                if (board.getCards().get(3).size() == 5) {
                    node.put("error", "Cannot place card on table since row is full.");
                    output.add(node);
                    return;
                }
                board.getCards().get(3).add((Minion) card);
            }
        }
    }
}
