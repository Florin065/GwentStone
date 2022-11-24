package game.cards.specialMinion;

import fileio.CardInput;
import game.Board;
import game.cards.Minion;

public class Disciple extends Minion {
    final static int HEAL = 2;
    public Disciple(CardInput cardInput) {
        super(cardInput);
    }

    @Override
    public void useAbility(Minion attacked, Board board) {
        attacked.setHealth(attacked.getHealth() + HEAL);
    }
}
