package game.cards;

import fileio.CardInput;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Card {
    @Getter @Setter
    private int mana;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private ArrayList<String> colors;

    /**
     *
     * @param cardInput
     */
    public Card(final CardInput cardInput) {
        this.mana = cardInput.getMana();
        this.name = cardInput.getName();
        this.description = cardInput.getDescription();
        this.colors = cardInput.getColors();
    }

    /**
     *
     * @param mana
     * @param name
     * @param description
     * @param colors
     */
    public Card(final int mana, final String name,
                final String description, final ArrayList<String> colors) {
        this.mana = mana;
        this.name = name;
        this.description = description;
        this.colors = colors;
    }

    public Card() {
    }

    /**
     *
     * @param card
     */
    public Card(final Card card) {
        this.mana = card.mana;
        this.colors = card.colors;
        this.description = card.description;
        this.name = card.name;
    }
}
