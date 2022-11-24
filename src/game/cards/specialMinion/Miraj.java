package game.cards.specialMinion;

import fileio.CardInput;
import game.Board;
import game.cards.Minion;

public class Miraj extends Minion {
    public Miraj(CardInput cardInput) {
        super(cardInput);
    }

    @Override
    public void useAbility(Minion attacked, Board board) {
        int auxHealth = getHealth();
        setHealth(attacked.getHealth());
        attacked.setHealth(auxHealth);
    }
}
