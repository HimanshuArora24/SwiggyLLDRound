package domain.entities;

import constants.ErrorMessages;
import constants.StaticConstants;
import java.text.MessageFormat;

public class Player {

    private String name;
    private int attack;
    private int strength;
    private int health;

    private Player(String name, int attack, int strength, int health) {
        this.name = name;
        this.attack = attack;
        this.strength = strength;
        this.health = health;
    }

    public static Player create(String name, int attack, int strength, int health)
        throws InvalidPlayerDetailsException {
        validate(attack, strength, health);
        return new Player(name, attack, strength, health);
    }

    public static void validate(int attack, int strength, int health)
        throws InvalidPlayerDetailsException {
        if (attack <= 0) {
            throw new InvalidPlayerDetailsException(StaticConstants.ATTACK);
        }
        if (strength <= 0) {
            throw new InvalidPlayerDetailsException(StaticConstants.STRENGTH);
        }
        if (health <= 0) {
            throw new InvalidPlayerDetailsException(StaticConstants.HEALTH);
        }
    }

    public boolean checkIfLost() {
        return this.health <= 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public static final class InvalidPlayerDetailsException extends Exception {

        public InvalidPlayerDetailsException(String attribute) {
            super(MessageFormat.format(ErrorMessages.INVALID_PLAYER_DETAILS_MSG, attribute));
        }
    }

}
