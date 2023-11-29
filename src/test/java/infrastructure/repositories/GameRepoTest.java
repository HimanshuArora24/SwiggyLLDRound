package infrastructure.repositories;

import domain.entities.Game;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class GameRepoTest {

    @Test
    void testSaveAndFetchGame() {
        Game game = Game.initialize(UUID.randomUUID(), UUID.randomUUID());
        UUID gameId = GameRepo.save(game);

        Game fetchedGame = GameRepo.fetchGame(gameId);

        assertNotNull(fetchedGame);
        assertEquals(game.getPlayer1Id(), fetchedGame.getPlayer1Id());
        assertEquals(game.getPlayer2Id(), fetchedGame.getPlayer2Id());
    }

    @Test
    void testSaveAndDeleteGame() {
        Game game = Game.initialize(UUID.randomUUID(), UUID.randomUUID());
        UUID gameId = GameRepo.save(game);

        Game deletedGame = GameRepo.deleteGame(gameId);

        assertNotNull(deletedGame);
        assertEquals(game.getPlayer1Id(), deletedGame.getPlayer1Id());
        assertEquals(game.getPlayer2Id(), deletedGame.getPlayer2Id());

        // Ensure the game is no longer in the repository
        assertNull(GameRepo.fetchGame(gameId));
    }

    @Test
    void testFetchNonExistentGame() {
        UUID nonExistentGameId = UUID.randomUUID();
        Game fetchedGame = GameRepo.fetchGame(nonExistentGameId);

        assertNull(fetchedGame);
    }

    @Test
    void testDeleteNonExistentGame() {
        UUID nonExistentGameId = UUID.randomUUID();
        Game deletedGame = GameRepo.deleteGame(nonExistentGameId);

        assertNull(deletedGame);
    }
}
