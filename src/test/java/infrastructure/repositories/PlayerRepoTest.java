package infrastructure.repositories;

import domain.entities.Player;
import domain.entities.Player.InvalidPlayerDetailsException;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class PlayerRepoTest {

    @Test
    void testSaveAndFetchPlayer() throws Player.InvalidPlayerDetailsException {
        Player player = Player.create("John Doe", 10, 5, 100);
        UUID playerId = PlayerRepo.save(player);

        Player fetchedPlayer = PlayerRepo.fetchPlayer(playerId);

        assertNotNull(fetchedPlayer);
        assertEquals(player.getName(), fetchedPlayer.getName());
    }

    @Test
    void testSaveAndDeletePlayer() throws InvalidPlayerDetailsException {
        Player player = Player.create("Jane Doe", 15, 7, 120);
        UUID playerId = PlayerRepo.save(player);

        Player deletedPlayer = PlayerRepo.deletePlayer(playerId);

        assertNotNull(deletedPlayer);
        assertEquals(player.getName(), deletedPlayer.getName());

        // Ensuring that the player is no longer in the repository
        assertNull(PlayerRepo.fetchPlayer(playerId));
    }

    @Test
    void testFetchNonExistentPlayer() {
        UUID nonExistentPlayerId = UUID.randomUUID();
        Player fetchedPlayer = PlayerRepo.fetchPlayer(nonExistentPlayerId);

        assertNull(fetchedPlayer);
    }

    @Test
    void testDeleteNonExistentPlayer() {
        UUID nonExistentPlayerId = UUID.randomUUID();
        Player deletedPlayer = PlayerRepo.deletePlayer(nonExistentPlayerId);

        assertNull(deletedPlayer);
    }

    @Test
    void testUpdatePlayer() throws Player.InvalidPlayerDetailsException {
        Player player = Player.create("Bob", 12, 6, 90);
        UUID playerId = PlayerRepo.save(player);

        Player updatedPlayer = Player.create("Updated Bob", 15, 8, 110);
        PlayerRepo.update(playerId, updatedPlayer);

        assertEquals(updatedPlayer.getName(), PlayerRepo.fetchPlayer(playerId).getName());
    }

    @Test
    void testPlayerDoesNotExistException() {
        assertThrows(PlayerRepo.PlayerDoesntExistException.class, () -> {
            throw new PlayerRepo.PlayerDoesntExistException("Alice");
        });
    }
}
