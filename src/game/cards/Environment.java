package game.cards;

import fileio.CardInput;
import game.cards.Card;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Environment extends Card {
    public Environment(CardInput cardInput) {
        super(cardInput);
    }

    public Environment() {
    }

    public void useEnvironmentAbility() {
        // nothing, this is to be overridden
    }
}
