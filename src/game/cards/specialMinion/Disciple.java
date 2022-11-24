package game.cards.specialMinion;

import fileio.CardInput;
import game.Board;
import game.cards.Minion;

public class Disciple extends Minion {
    public Disciple(CardInput cardInput) {
        super(cardInput);
        setAttackDamage(0);
    }

    public void useDiscipleAbility(Minion attacked, Board board) {
        attacked.setHealth(attacked.getHealth() + 2);
    }
}
