package game.cards;

import fileio.CardInput;
import game.Board;

public class Environment extends Card {
    /**
     *
     * @param cardInput
     */
    public Environment(final CardInput cardInput) {
        super(cardInput);
    }

    public Environment() {
    }

    /**
     *
     * @param card
     */
    public Environment(final Card card) {
        super(card);
    }

    /**
     *
     * @param affectedRow
     * @param board
     */
    public void useFirestormAbility(final int affectedRow, final Board board) {
    }

    /**
     *
     * @param affectedRow
     * @param board
     */
    public void useWinterfellAbility(final int affectedRow, final Board board) {
    }

    /**
     *
     * @param affectedRow
     * @param toMoveRow
     * @param board
     */
    public void useHeartHoundAbility(
            final int affectedRow, final int toMoveRow, final Board board) {
    }
}

