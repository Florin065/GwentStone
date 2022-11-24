package game.cards.specialMinion;

import fileio.CardInput;
import game.Board;
import game.cards.Minion;

public class TheCursedOne extends Minion {
    public TheCursedOne(CardInput cardInput) {
        super(cardInput);
        setAttackDamage(0);
    }

    public void useTheCursedOneAbility(Minion attacked, Board board) {
        int damage = attacked.getAttackDamage();
        int health = attacked.getHealth();

        attacked.setAttackDamage(health);
        attacked.setHealth(damage);

        if (attacked.getHealth() <= 0) {
//            board.getCards();
            return;
        }
        if (attacked.getAttackDamage() <= 0) {
            attacked.setAttackDamage(0);
        }
    }
}
