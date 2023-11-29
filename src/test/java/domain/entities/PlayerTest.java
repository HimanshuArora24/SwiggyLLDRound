package domain.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testValidPlayerCreation() throws Player.InvalidPlayerDetailsException {
        Player player = Player.create("John", 5, 3, 10);
        assertEquals("John", player.getName());
        assertEquals(5, player.getAttack());
        assertEquals(3, player.getStrength());
        assertEquals(10, player.getHealth());
    }

    @Test
    void testInvalidAttack() {
        assertThrows(Player.InvalidPlayerDetailsException.class, () -> {
            Player.create("Invalid", 0, 3, 10);
        });
    }

    @Test
    void testInvalidStrength() {
        assertThrows(Player.InvalidPlayerDetailsException.class, () -> {
            Player.create("Invalid", 5, 0, 10);
        });
    }

    @Test
    void testInvalidHealth() {
        assertThrows(Player.InvalidPlayerDetailsException.class, () -> {
            Player.create("Invalid", 5, 3, 0);
        });
    }

    @Test
    void testCheckIfLost() throws Player.InvalidPlayerDetailsException {
        Player player = Player.create("Player1", 5, 3, 10);
        assertFalse(player.checkIfLost());
        player.setHealth(0);
        assertTrue(player.checkIfLost());
    }

    @Test
    void testSetName() throws Player.InvalidPlayerDetailsException {
        Player player = Player.create("John", 5, 3, 10);
        assertEquals("John", player.getName());
        player.setName("NewName");
        assertEquals("NewName", player.getName());
    }

    @Test
    void testSetAttack() throws Player.InvalidPlayerDetailsException {
        Player player = Player.create("John", 5, 3, 10);
        assertEquals(5, player.getAttack());
        player.setAttack(8);
        assertEquals(8, player.getAttack());
    }

    @Test
    void testSetStrength() throws Player.InvalidPlayerDetailsException {
        Player player = Player.create("John", 5, 3, 10);
        assertEquals(3, player.getStrength());
        player.setStrength(6);
        assertEquals(6, player.getStrength());
    }

    @Test
    void testSetHealth() throws Player.InvalidPlayerDetailsException {
        Player player = Player.create("John", 5, 3, 10);
        assertEquals(10, player.getHealth());
        player.setHealth(15);
        assertEquals(15, player.getHealth());
    }
}
