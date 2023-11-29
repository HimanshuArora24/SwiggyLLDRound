package domain.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiceTest {

    @Test
    void testRollInRange() {
        int result = Dice.roll();
        assertTrue(result >= 1 && result <= 6, "Dice roll should be in the range [1, 6]");
    }

    @Test
    void testRollConsistency() {
        // Test to ensure that multiple rolls produce different results
        int roll1 = Dice.roll();
        int roll2 = Dice.roll();
        assertNotEquals(roll1, roll2, "Two consecutive dice rolls should be different");
    }

    @Test
    void testRollValidity() {
        // Testing a large number of rolls to ensure they are all valid
        for (int i = 0; i < 1000; i++) {
            int result = Dice.roll();
            assertTrue(result >= 1 && result <= 6, "Dice roll should be in the range [1, 6]");
        }
    }
}
