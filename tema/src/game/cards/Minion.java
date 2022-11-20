package game.cards;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fileio.CardInput;
import game.cards.Card;
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

    @Getter @Setter @JsonIgnore
    private boolean frozen;

    @Getter @Setter @JsonIgnore
    private boolean tank;

    public Minion(CardInput cardInput) {
        super(cardInput);
        this.mana = cardInput.getMana();
        this.attackDamage = cardInput.getAttackDamage();
        this.health = cardInput.getHealth();
        this.frozen = false;
        this.tank = getName().equals("Goliath") || getName().equals("Warden");
    }

    public Minion() {
    }
}
