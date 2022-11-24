package game;

import game.cards.Minion;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Board {
    @Getter @Setter
    private ArrayList<ArrayList<Minion>> cards;

    public Board() {
        cards = new ArrayList<>();
        cards.add(new ArrayList<>());
        cards.add(new ArrayList<>());
        cards.add(new ArrayList<>());
        cards.add(new ArrayList<>());
    }

    public void removeMinionOnTable(Minion card) {
        for (ArrayList<Minion> row : cards) {
            row.remove(card);
        }
    }

    public boolean rowHasTank(int rowIdx) {
        for (Minion minion : cards.get(rowIdx)) {
            if (minion.isTank())
                return true;
        }
        return false;
    }

    public boolean enemyHasTank(int currentPlayerIdx) {
        if (currentPlayerIdx == 1)
            return rowHasTank(0) || rowHasTank(1);
        else
            return rowHasTank(2) || rowHasTank(3);
    }
}