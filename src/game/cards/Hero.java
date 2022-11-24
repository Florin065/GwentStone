package game.cards;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fileio.CardInput;
import game.cards.Card;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Hero extends Card {
    @Getter @Setter
    private int health;
    @Getter @Setter @JsonIgnore
    private boolean usedAction;

    public Hero(CardInput cardInput) {
        super(cardInput);
        this.health = 30;
        this.usedAction = false;
    }

    public Hero() {
    }

    public void useHeroAbility() {
    }
}
