package game.cards.witchery;

import fileio.CardInput;
import game.Board;
import game.cards.Environment;
import game.cards.Minion;

public final class HeartHound extends Environment {
    /**
     *
     * @param cardInput
     */
    public HeartHound(final CardInput cardInput) {
        super(cardInput);
    }

    /**
     *
     * @param affectedRow
     * @param toMoveRow
     * @param board
     */
    public void useHeartHoundAbility(
            final int affectedRow, final int toMoveRow, final Board board) {
        int cardMaxHealth = 0;

        for (Minion affectedCard : board.getCards().get(affectedRow)) {
            if (affectedCard.getHealth() > cardMaxHealth) {
                cardMaxHealth = affectedCard.getHealth();
            }
        }

        for (Minion affectedCard : board.getCards().get(affectedRow)) {
            if (cardMaxHealth == affectedCard.getHealth()) {
                board.getCards().get(toMoveRow).add(affectedCard);
                break;
            }
        }
    }
}
