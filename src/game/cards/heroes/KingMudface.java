package game.cards.heroes;

import fileio.CardInput;
import game.Board;
import game.cards.Hero;
import game.cards.Minion;

public final class KingMudface extends Hero {
    /**
     *
     * @param cardInput
     */
    public KingMudface(final CardInput cardInput) {
        super(cardInput);
    }

    /**
     *
     * @param affectedRow
     * @param board
     */
    @Override
    public void useHeroAbility(final int affectedRow, final Board board) {
        for (Minion affectedCard : board.getCards().get(affectedRow)) {
            affectedCard.setHealth(affectedCard.getHealth() + 1);
        }
    }
}
