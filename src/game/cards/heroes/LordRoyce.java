package game.cards.heroes;

import fileio.CardInput;
import game.Board;
import game.cards.Hero;
import game.cards.Minion;

public class LordRoyce extends Hero {
    public LordRoyce(CardInput cardInput) {
        super(cardInput);
    }

    @Override
    public void useHeroAbility(int affectedRow, Board board) {
        int cardMaxDamage = 0;
        Minion card = null;

        for (Minion affectedCard : board.getCards().get(affectedRow)) {
            if (affectedCard.getAttackDamage() > cardMaxDamage) {
                cardMaxDamage = affectedCard.getHealth();
                card = affectedCard;
            }
        }

        if (card != null)
            card.setFrozen(true);
    }
}
