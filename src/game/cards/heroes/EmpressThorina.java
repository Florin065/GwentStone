package game.cards.heroes;

import fileio.CardInput;
import game.Board;
import game.cards.Hero;
import game.cards.Minion;

public final class EmpressThorina extends Hero {
    /**
     *
     * @param cardInput
     */
    public EmpressThorina(final CardInput cardInput) {
        super(cardInput);
    }

    /**
     *
     * @param affectedRow
     * @param board
     */
    @Override
    public void useHeroAbility(final int affectedRow, final Board board) {
        int cardMaxHealth = 0;
        Minion card = null;

        for (Minion affectedCard : board.getCards().get(affectedRow)) {
            if (affectedCard.getHealth() > cardMaxHealth) {
                cardMaxHealth = affectedCard.getHealth();
                card = affectedCard;
            }
        }

        board.getCards().get(affectedRow).remove(card);
    }
}
