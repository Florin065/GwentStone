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
    ArrayList<String> colors;

    public Card(CardInput cardInput) {
        this.mana = cardInput.getMana();
        this.name = cardInput.getName();
        this.description = cardInput.getDescription();
        this.colors = cardInput.getColors();
    }

    public Card(int mana, String name, String description, ArrayList<String> colors) {
        this.mana = mana;
        this.name = name;
        this.description = description;
        this.colors = colors;
    }

    public Card() {
    }
}
