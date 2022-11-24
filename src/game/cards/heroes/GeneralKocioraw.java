package game.cards.heroes;

import fileio.CardInput;
import game.Board;
import game.cards.Hero;
import game.cards.Minion;

public class GeneralKocioraw extends Hero {
    public GeneralKocioraw(CardInput cardInput) {
        super(cardInput);
    }

    @Override
    public void useHeroAbility(int affectedRow, Board board) {
        for (Minion affectedCard : board.getCards().get(affectedRow)) {
            affectedCard.setAttackDamage(affectedCard.getAttackDamage() + 1);
        }
    }
}
