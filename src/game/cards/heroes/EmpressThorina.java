package game.cards.heroes;

import fileio.CardInput;
import game.Board;
import game.cards.Hero;
import game.cards.Minion;

public class EmpressThorina extends Hero {
    public EmpressThorina(CardInput cardInput) { super(cardInput); }

    @Override
    public void useHeroAbility(int affectedRow, Board board) {
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
