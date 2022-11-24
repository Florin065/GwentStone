package game.cards.specialMinion;

import fileio.CardInput;
import game.Board;
import game.cards.Minion;

public class Miraj extends Minion {
    public Miraj(CardInput cardInput) {
        super(cardInput);
    }

    public void useMirajAbility(Minion attacked, Minion attacker, Board board) {
        int health = attacked.getHealth();
        attacked.setHealth(attacker.getHealth());
        attacker.setHealth(health);
    }
}
