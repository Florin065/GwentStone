package game.cards;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fileio.CardInput;
import game.Board;
import lombok.Getter;
import lombok.Setter;

public class Minion extends Card {
    @Getter @Setter
    private int attackDamage;
    @Getter @Setter
    private int health;
    @Getter @Setter @JsonIgnore
    private boolean frozen;
    @Getter @Setter @JsonIgnore
    private boolean tank;
    @Getter @Setter @JsonIgnore
    private boolean usedAction;

    public Minion(CardInput cardInput) {
        super(cardInput);
        this.attackDamage = cardInput.getAttackDamage();
        this.health = cardInput.getHealth();
        this.frozen = false;
        this.tank = getName().equals("Goliath") || getName().equals("Warden");
        this.usedAction = false;
    }

    public Minion(Minion minion) {
        super(minion.getMana(), minion.getName(), minion.getDescription(), minion.getColors());
        this.attackDamage = minion.getAttackDamage();
        this.health = minion.getHealth();
        this.frozen = false;
        this.tank = getName().equals("Goliath") || getName().equals("Warden");
        this.usedAction = false;
    }

    public void useAttack(Minion attacked) {
        attacked.setHealth(attacked.getHealth() - getAttackDamage());
    }

    public void useDiscipleAbility(Minion attacked, Board board) {
    }

    public void useMirajAbility(Minion attacked, Minion attacker, Board board) {
    }

    public void useTheCursedOneAbility(Minion attacked, Board board) {
    }

    public void useTheRipperAbility(Minion attacked, Board board) {
    }
}
