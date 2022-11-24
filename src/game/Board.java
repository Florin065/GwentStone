package game;

import game.cards.Minion;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public final class Board {
    @Getter @Setter
    private ArrayList<ArrayList<Minion>> cards;

    public Board() {
        cards = new ArrayList<>();
        cards.add(new ArrayList<>());
        cards.add(new ArrayList<>());
        cards.add(new ArrayList<>());
        cards.add(new ArrayList<>());
    }

    /**
     *
     * @param card
     */
    public void removeMinionOnTable(final Minion card) {
        for (ArrayList<Minion> row : cards) {
            row.remove(card);
        }
    }

    /**
     *
     * @param rowIdx
     * @return
     */
    public boolean rowHasTank(final int rowIdx) {
        for (Minion minion : cards.get(rowIdx)) {
            if (minion.isTank()) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param rowIdx
     * @param friendlyIdx
     * @return
     */
    public boolean rowBelongsToEnemy(final int rowIdx, final int friendlyIdx) {
        if (friendlyIdx == 1) {
            return rowIdx == 0 || rowIdx == 1;
        }
        return rowIdx == 2 || rowIdx == 2 + 1;
    }

    /**
     *
     * @param currentPlayerIdx
     * @return
     */
    public boolean enemyHasTank(final int currentPlayerIdx) {
        if (currentPlayerIdx == 1) {
            return rowHasTank(0) || rowHasTank(1);
        } else {
            return rowHasTank(2) || rowHasTank(2 + 1);
        }
    }
}
