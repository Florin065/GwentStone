package game;

import fileio.CardInput;
import fileio.DecksInput;

import java.util.ArrayList;

public class CardGen {
    public static ArrayList<Card> getDeck(DecksInput decksInput, int deckIdx) {
        ArrayList<Card> deck = new ArrayList<>();

        for (CardInput cardInput : decksInput.getDecks().get(deckIdx)) {
            deck.add(CardGen.getCard(cardInput));
        }
        return deck;
    }

    public static Card getCard(CardInput cardInput) {
        if (cardInput.getHealth() == 0) {
            if (cardInput.getName().equals("Firestorm") || cardInput.getName().equals("Winterfell") || cardInput.getName().equals("Heart Hound"))
                return new Environment(cardInput.getName(), cardInput.getDescription(), cardInput.getColors(), cardInput.getMana());
            else
                return new Hero(cardInput.getName(), cardInput.getDescription(), cardInput.getColors(), cardInput.getMana());
        }
        else
            return new Minion(cardInput.getName(), cardInput.getDescription(), cardInput.getColors(),
                    cardInput.getMana(), cardInput.getAttackDamage(), cardInput.getHealth());
    }
}
