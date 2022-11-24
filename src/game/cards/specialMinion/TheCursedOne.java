package game.cards.specialMinion;

import fileio.CardInput;
import game.Board;
import game.cards.Minion;

public class TheCursedOne extends Minion {
    public TheCursedOne(CardInput cardInput) {
        super(cardInput);
        setAttackDamage(0);
    }

    @Override
    public void useAbility(Minion attacked, Board board) {
        if (attacked.getAttackDamage() == 0) {
            board.removeMinionOnTable(attacked);
            return;
        }
        int auxValue = attacked.getAttackDamage();
        attacked.setAttackDamage(attacked.getHealth());
        attacked.setHealth(auxValue);
    }
}
