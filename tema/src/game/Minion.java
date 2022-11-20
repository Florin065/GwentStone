package game;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Minion extends Card {
    @Getter @Setter
    private int mana;
    @Getter @Setter
    private int attackDamage;
    @Getter @Setter
    private int health;

    public Minion(String name, String description, ArrayList<String> colors, int mana, int attackDamage, int health) {
        super(name, description, colors);
        this.mana = mana;
        this.attackDamage = attackDamage;
        this.health = health;
    }

    public Minion() {
    }
}
