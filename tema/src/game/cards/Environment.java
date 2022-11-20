package game.cards;

import fileio.CardInput;
import game.cards.Card;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Environment extends Card {
    @Getter @Setter
    private int mana;

    public Environment(CardInput cardInput) {
        super(cardInput);
        this.mana = cardInput.getMana();
    }

    public Environment() {
    }
}
