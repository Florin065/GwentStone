package game.cards.witchery;

import fileio.CardInput;
import game.Board;
import game.cards.Environment;
import game.cards.Minion;

public final class Firestorm extends Environment {
    /**
     *
     * @param cardInput
     */
    public Firestorm(final CardInput cardInput) {
        super(cardInput);
    }

    /**
     *
     * @param affectedRow
     * @param board
     */
    public void useFirestormAbility(final int affectedRow, final Board board) {
        for (Minion affectedCard : board.getCards().get(affectedRow)) {
            affectedCard.setHealth(affectedCard.getHealth() - 1);
        }

        board.getCards().get(affectedRow).removeIf((card) -> card.getHealth() <= 0);
    }
}
