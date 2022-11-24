package game.cards;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fileio.CardInput;
import game.Board;
import lombok.Getter;
import lombok.Setter;

public class Hero extends Card {
    @Getter @Setter
    private int health;
    @Getter @Setter @JsonIgnore
    private boolean usedAction;

    /**
     *
     * @param cardInput
     */
    public Hero(final CardInput cardInput) {
        super(cardInput);
        this.health = 30;
        this.usedAction = false;
    }

    public Hero() {
    }

    /**
     *
     * @param hero
     */
    public Hero(final Hero hero) {
        super(hero);
        this.health = hero.getHealth();
    }

    /**
     *
     * @param affectedRow
     * @param board
     */
    public void useHeroAbility(final int affectedRow, final Board board) {
    }
}
