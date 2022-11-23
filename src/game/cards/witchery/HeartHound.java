package game.cards.witchery;

import fileio.CardInput;
import game.Board;
import game.cards.Environment;
import game.cards.Minion;

public class HeartHound extends Environment {
    public HeartHound(CardInput cardInput) {
        super(cardInput);
    }

    public void useHeartHoundAbility(int affectedRow, int toMoveRow, Board board) {
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
