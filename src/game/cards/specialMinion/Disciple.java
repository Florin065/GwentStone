package game.cards.specialMinion;

import fileio.CardInput;
import game.Board;
import game.cards.Minion;

public final class Disciple extends Minion {
    /**
     *
     * @param cardInput
     */
    public Disciple(final CardInput cardInput) {
        super(cardInput);
    }

    /**
     *
     * @param attacked
     * @param board
     */
    @Override
    public void useAbility(final Minion attacked, final Board board) {
        attacked.setHealth(attacked.getHealth() + 2);
    }
}
