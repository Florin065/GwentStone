package game;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Environment extends Card {
    @Getter @Setter
    private int mana;

    public Environment(String name, String description, ArrayList<String> colors, int mana) {
        super(name, description, colors);
        this.mana = mana;
    }

    public Environment() {
    }
}
