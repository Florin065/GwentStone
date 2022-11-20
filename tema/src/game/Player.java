package game;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Player {
    @Getter @Setter
    private ArrayList<Card> currentDeck;
    @Setter @Getter
    private Card hero;
    @Setter @Getter
    private ArrayList<Card> currentHand;

    public void getCardInHand() {
        if (currentDeck.size() > 0) {
            currentHand.add(currentDeck.get(0));
        }
    }
}
