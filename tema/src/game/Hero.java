package game;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Hero extends Card {
    @Getter @Setter
    private int mana;
    @Getter @Setter
    private int health;

    public Hero(String name, String description, ArrayList<String> colors, int mana) {
        super(name, description, colors);
        this.mana = mana;
        this.health = 30;
    }

    public Hero() {
    }
}
