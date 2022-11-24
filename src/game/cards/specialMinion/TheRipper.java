package game.cards.specialMinion;

import fileio.CardInput;
import game.Board;
import game.cards.Minion;

public class TheRipper extends Minion {
    public TheRipper(CardInput cardInput) {
        super(cardInput);
    }

    public void useTheRipperAbility(Minion attacked, Board board) {
        attacked.setAttackDamage(attacked.getAttackDamage() - 2);

        if (attacked.getAttackDamage() <= 0) {
            attacked.setAttackDamage(0);
        }
    }
}
