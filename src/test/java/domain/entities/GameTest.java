package domain.entities;

import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testInitializeGame() {
        UUID player1Id = UUID.randomUUID();
        UUID player2Id = UUID.randomUUID();
        Game game = Game.initialize(player1Id, player2Id);
        assertEquals(player1Id, game.getPlayer1Id());
        assertEquals(player2Id, game.getPlayer2Id());
    }

    @Test
    void testSetPlayer1Id() {
        UUID player1Id = UUID.randomUUID();
        UUID player2Id = UUID.randomUUID();
        Game game = Game.initialize(player1Id, player2Id);

        UUID newPlayer1Id = UUID.randomUUID();
        game.setPlayer1Id(newPlayer1Id);

        assertEquals(newPlayer1Id, game.getPlayer1Id());
    }

    @Test
    void testSetPlayer2Id() {
        UUID player1Id = UUID.randomUUID();
        UUID player2Id = UUID.randomUUID();
        Game game = Game.initialize(player1Id, player2Id);

        UUID newPlayer2Id = UUID.randomUUID();
        game.setPlayer2Id(newPlayer2Id);

        assertEquals(newPlayer2Id, game.getPlayer2Id());
    }

}
