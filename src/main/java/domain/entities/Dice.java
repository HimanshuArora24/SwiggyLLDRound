package domain.entities;

import java.util.Random;

public class Dice {

    private static final int SIZE = 6;
    private static final Random random = new Random();

    public static int roll() {
        return random.nextInt(SIZE) + 1;
    }
}

