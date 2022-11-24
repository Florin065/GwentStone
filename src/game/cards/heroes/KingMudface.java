package game.cards.heroes;

import fileio.CardInput;
import game.Board;
import game.cards.Hero;
import game.cards.Minion;

public class KingMudface extends Hero {
    public KingMudface(CardInput cardInput) {
        super(cardInput);
    }

    @Override
    public void useHeroAbility(int affectedRow, Board board) {
        for (Minion affectedCard : board.getCards().get(affectedRow)) {
            affectedCard.setHealth(affectedCard.getHealth() + 1);
        }
    }
}
