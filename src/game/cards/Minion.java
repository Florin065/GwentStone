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

    /**
     *
     * @param cardInput
     */
    public Minion(final CardInput cardInput) {
        super(cardInput);
        this.attackDamage = cardInput.getAttackDamage();
        this.health = cardInput.getHealth();
        this.frozen = false;
        this.tank = getName().equals("Goliath") || getName().equals("Warden");
        this.usedAction = false;
    }

    /**
     *
     * @param minion
     */
    public Minion(final Minion minion) {
        super(minion.getMana(), minion.getName(), minion.getDescription(), minion.getColors());
        this.attackDamage = minion.getAttackDamage();
        this.health = minion.getHealth();
        this.frozen = false;
        this.tank = getName().equals("Goliath") || getName().equals("Warden");
        this.usedAction = false;
    }

    /**
     *
     * @param attacked
     */
    public void useAttack(final Minion attacked) {
        attacked.setHealth(attacked.getHealth() - getAttackDamage());
    }

    /**
     *
     * @param hero
     */
    public void useAttackHero(final Hero hero) {
        hero.setHealth(hero.getHealth() - getAttackDamage());
    }

    /**
     *
     * @param attacked
     * @param board
     */
    public void useAbility(final Minion attacked, final Board board) {
    }
}
