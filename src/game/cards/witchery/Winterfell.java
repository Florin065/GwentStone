package game.cards.witchery;

import fileio.CardInput;
import game.Board;
import game.cards.Environment;
import game.cards.Minion;

public class Winterfell extends Environment {
    public Winterfell(CardInput cardInput) {
        super(cardInput);
    }

    public void useWinterfellAbility(int affectedRow, Board board) {
        for (Minion affectedCard : board.getCards().get(affectedRow)) {
            affectedCard.setFrozen(true);
        }
    }
}
