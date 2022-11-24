package game.cards.specialMinion;

import fileio.CardInput;
import game.Board;
import game.cards.Minion;

public final class Miraj extends Minion {
    /**
     *
     * @param cardInput
     */
    public Miraj(final CardInput cardInput) {
        super(cardInput);
    }

    /**
     *
     * @param attacked
     * @param board
     */
    @Override
    public void useAbility(final Minion attacked, final Board board) {
        int auxHealth = getHealth();
        setHealth(attacked.getHealth());
        attacked.setHealth(auxHealth);
    }
}
