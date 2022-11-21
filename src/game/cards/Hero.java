package game.cards;

import fileio.CardInput;
import game.cards.Card;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Hero extends Card {
    @Getter @Setter
    private int mana;
    @Getter @Setter
    private int health;

    public Hero(CardInput cardInput) {
        super(cardInput);
        this.health = 30;
        this.mana = cardInput.getMana();
    }

    public Hero() {
    }

    public void useHeroAbility() {
        // nothing, this is to be overridden
    }
}
