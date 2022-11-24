package game.cards.heroes;

import fileio.CardInput;
import game.Board;
import game.cards.Hero;
import game.cards.Minion;

public final class LordRoyce extends Hero {
    /**
     *
     * @param cardInput
     */
    public LordRoyce(final CardInput cardInput) {
        super(cardInput);
    }

    /**
     *
     * @param affectedRow
     * @param board
     */
    @Override
    public void useHeroAbility(final int affectedRow, final Board board) {
        int cardMaxDamage = 0;
        Minion card = null;

        for (Minion affectedCard : board.getCards().get(affectedRow)) {
            if (affectedCard.getAttackDamage() > cardMaxDamage) {
                cardMaxDamage = affectedCard.getHealth();
                card = affectedCard;
            }
        }

        if (card != null) {
            card.setFrozen(true);
        }
    }
}
