package game.cards.witchery;

import fileio.CardInput;
import game.Board;
import game.cards.Environment;
import game.cards.Minion;

public final class Winterfell extends Environment {
    /**
     *
     * @param cardInput
     */
    public Winterfell(final CardInput cardInput) {
        super(cardInput);
    }

    /**
     *
     * @param affectedRow
     * @param board
     */
    public void useWinterfellAbility(final int affectedRow, final Board board) {
        for (Minion affectedCard : board.getCards().get(affectedRow)) {
            affectedCard.setFrozen(true);
        }
    }
}
