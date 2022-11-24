package game.cards.specialMinion;

import fileio.CardInput;
import game.Board;
import game.cards.Minion;

public class TheRipper extends Minion {
    public TheRipper(CardInput cardInput) {
        super(cardInput);
    }

    @Override
    public void useAbility(Minion attacked, Board board) {
        attacked.setAttackDamage(Math.max(0, attacked.getAttackDamage() - 2));
    }
}
