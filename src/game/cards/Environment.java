package game.cards;

import fileio.CardInput;
import game.Board;

import java.util.ArrayList;

public class Environment extends Card {
    public Environment(CardInput cardInput) {
        super(cardInput);
    }

    public Environment() {
    }

    public void useFirestormAbility(int affectedRow, Board board) {
        for (Minion affectedCard : board.getCards().get(affectedRow)) {
            affectedCard.setHealth(affectedCard.getHealth() - 1);
        }

        board.getCards().get(affectedRow).removeIf((card) -> card.getHealth() <= 0);
    }

    public void useWinterfellAbility(int affectedRow, Board board) {
        for (Minion affectedCard : board.getCards().get(affectedRow)) {
            affectedCard.setFrozen(true);
        }
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

