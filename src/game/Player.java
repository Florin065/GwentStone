package game;

import game.cards.Card;
import game.cards.Hero;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Player {
    @Getter @Setter
    private ArrayList<Card> currentDeck;

    private Hero hero;
    @Getter @Setter
    private ArrayList<Card> currentHand;
    @Getter @Setter
    private int mana;

    @Getter @Setter
    private int wins;

    @Getter @Setter
    private int plays;

    public Player() {
        currentHand = new ArrayList<>();
        mana = 0;
    }

    public void getCardInHand() {
        if (currentDeck.size() > 0) {
            currentHand.add(currentDeck.remove(0));
        }
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setHero(Card hero) {
        this.hero = (Hero) hero;
    }
}
