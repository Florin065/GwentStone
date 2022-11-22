package game.cards.specialMinion;

import fileio.CardInput;
import game.cards.Minion;

public class Disciple extends Minion {
    public Disciple(CardInput cardInput) { super(cardInput); }

    public Disciple() {
        setAttackDamage(0);
    }
}
