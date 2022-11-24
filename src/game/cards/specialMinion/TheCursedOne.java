package game.cards.specialMinion;

import fileio.CardInput;
import game.Board;
import game.cards.Minion;

public final class TheCursedOne extends Minion {
    /**
     *
     * @param cardInput
     */
    public TheCursedOne(final CardInput cardInput) {
        super(cardInput);
    }

    /**
     *
     * @param attacked
     * @param board
     */
    @Override
    public void useAbility(final Minion attacked, final Board board) {
        if (attacked.getAttackDamage() == 0) {
            board.removeMinionOnTable(attacked);
            return;
        }
        int auxValue = attacked.getAttackDamage();
        attacked.setAttackDamage(attacked.getHealth());
        attacked.setHealth(auxValue);
    }
}
