package game.commands.Test2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import fileio.GameInput;
import game.Board;
import game.Match;
import game.cards.Card;
import game.cards.Environment;
import game.cards.Minion;

import java.util.ArrayList;

public class PlaceCard {
    public void action(Match match, ArrayNode output, ActionsInput actionsInput, GameInput gameInput, Board board) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("command", "placeCard");
        node.put("handIdx", actionsInput.getHandIdx());
        // player 1 turn
        if (match.getPlayerTurn() == 1 && match.getPlayer1().getCurrentHand().size() > actionsInput.getHandIdx()) {
            Card card = match.getPlayer1().getCurrentHand().get(actionsInput.getHandIdx());

            if (card instanceof Environment) {
                node.put("error", "Cannot place environment card on table.");
                output.add(node);
                return;
            }

            int playerMana = match.getPlayer1().getMana();
            int cardMana = card.getMana();

            if (playerMana < cardMana) {
                node.put("error", "Not enough mana to place card on table.");
                output.add(node);
                return;
            }

            String cardName = card.getName();
            ArrayList<Card> currentHand = match.getPlayer1().getCurrentHand();

            if (cardName.equals("The Ripper") || cardName.equals("Miraj")
                    || cardName.equals("Goliath") || cardName.equals("Warden")) {
                if (board.getCards().get(2).size() == 5) {
                    node.put("error", "Cannot place card on table since row is full.");
                    output.add(node);
                    return;
                }

                board.getCards().get(2).add((Minion) currentHand.remove(actionsInput.getHandIdx()));
            }
            else if (cardName.equals("Sentinel") || cardName.equals("Berserker")
                    || cardName.equals("The Cursed One") || cardName.equals("Disciple")) {
                if (board.getCards().get(3).size() == 5) {
                    node.put("error", "Cannot place card on table since row is full.");
                    output.add(node);
                    return;
                }
                board.getCards().get(3).add((Minion) currentHand.remove(actionsInput.getHandIdx()));
            }

            match.getPlayer1().setMana(playerMana - cardMana);
        }
        // player 2 turn
        else if (match.getPlayerTurn() == 2 && match.getPlayer2().getCurrentHand().size() > actionsInput.getHandIdx()) {
            Card card = match.getPlayer2().getCurrentHand().get(actionsInput.getHandIdx());

            if (card instanceof Environment) {
                node.put("error", "Cannot place environment card on table.");
                output.add(node);
                return;
            }

            int playerMana = match.getPlayer2().getMana();
            int cardMana = card.getMana();

            if (playerMana < cardMana) {
                node.put("error", "Not enough mana to place card on table.");
                output.add(node);
                return;
            }

            String cardName = card.getName();
            ArrayList<Card> currentHand = match.getPlayer2().getCurrentHand();

            if (cardName.equals("The Ripper") || cardName.equals("Miraj")
                    || cardName.equals("Goliath") || cardName.equals("Warden")) {
                if (board.getCards().get(1).size() == 5) {
                    node.put("error", "Cannot place card on table since row is full.");
                    output.add(node);
                    return;
                }
                board.getCards().get(1).add((Minion) currentHand.remove(actionsInput.getHandIdx()));
            }
            else if (cardName.equals("Sentinel") || cardName.equals("Berserker")
                    || cardName.equals("The Cursed One") || cardName.equals("Disciple")) {
                if (board.getCards().get(0).size() == 5) {
                    node.put("error", "Cannot place card on table since row is full.");
                    output.add(node);
                    return;
                }
                board.getCards().get(0).add((Minion) currentHand.remove(actionsInput.getHandIdx()));
            }

            match.getPlayer2().setMana(playerMana - cardMana);
        }
    }
}
