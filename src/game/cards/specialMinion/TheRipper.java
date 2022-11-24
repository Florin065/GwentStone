package game.cards.specialMinion;

import fileio.CardInput;
import game.Board;
import game.cards.Minion;

public class TheRipper extends Minion {
    /**
     *
     * @param cardInput
     */
    public TheRipper(final CardInput cardInput) {
        super(cardInput);
    }

    /**
     *
     * @param attacked
     * @param board
     */
    @Override
    public void useAbility(final Minion attacked, final Board board) {
        attacked.setAttackDamage(Math.max(0, attacked.getAttackDamage() - 2));
    }
}
