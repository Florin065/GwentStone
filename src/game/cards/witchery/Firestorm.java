package game.cards.witchery;

import fileio.CardInput;
import game.Board;
import game.cards.Environment;
import game.cards.Minion;

public class Firestorm extends Environment {
    public Firestorm(CardInput cardInput) {
        super(cardInput);
    }

    public void useFirestormAbility(int affectedRow, Board board) {
        for (Minion affectedCard : board.getCards().get(affectedRow)) {
            affectedCard.setHealth(affectedCard.getHealth() - 1);
        }

        board.getCards().get(affectedRow).removeIf((card) -> card.getHealth() <= 0);
    }
}
