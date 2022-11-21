package game.cards;

import fileio.CardInput;
import fileio.DecksInput;
import game.cards.heroes.EmpressThorina;
import game.cards.heroes.GeneralKocioraw;
import game.cards.heroes.KingMudface;
import game.cards.heroes.LordRoyce;
import game.cards.specialMinion.Disciple;
import game.cards.specialMinion.Miraj;
import game.cards.specialMinion.TheCursedOne;
import game.cards.specialMinion.TheRipper;
import game.cards.witchery.Firestorm;
import game.cards.witchery.HeartHound;
import game.cards.witchery.Winterfell;

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
        switch (cardInput.getName()) {
            // specialMinion
            case "The Ripper" -> {
                return new TheRipper(cardInput);
            }
            case "Miraj" -> {
                return new Miraj(cardInput);
            }
            case "The Cursed One" -> {
                return new TheCursedOne(cardInput);
            }
            case "Disciple" -> {
                return new Disciple(cardInput);
            }
            // Witchery
            case "Firestorm" -> {
                return new Firestorm(cardInput);
            }
            case "Winterfell" -> {
                return new Winterfell(cardInput);
            }
            case "Heart Hound" -> {
                return new HeartHound(cardInput);
            }
            // Heroes
            case "Lord Royce" -> {
                return new LordRoyce(cardInput);
            }
            case "Empress Thorina" -> {
                return new EmpressThorina(cardInput);
            }
            case "King Mudface" -> {
                return new KingMudface(cardInput);
            }
            case "General Kocioraw" -> {
                return new GeneralKocioraw(cardInput);
            }
            // Default Minions
            default -> {
                return new Minion(cardInput);
            }
        }
    }
}
