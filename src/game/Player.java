package game;

import game.cards.Card;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Player {
    @Getter @Setter
    private ArrayList<Card> currentDeck;
    @Getter @Setter
    private Card hero;
    @Getter @Setter
    private ArrayList<Card> currentHand;
    @Getter @Setter
    private int mana;

    public Player() {
        currentHand = new ArrayList<>();
        mana = 0;
    }

    public void getCardInHand() {
        if (currentDeck.size() > 0) {
            currentHand.add(currentDeck.remove(0));
        }
    }
}
