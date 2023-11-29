package infrastructure.repositories;

import domain.entities.Game;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GameRepo {

    private static final Map<UUID, Game> gameMap = new HashMap<>();

    public static UUID save(Game game) {
        UUID gameId = UUID.randomUUID();
        gameMap.put(gameId, game);

        return gameId;
    }

    public static Game fetchGame(UUID gameID) {
        return gameMap.get(gameID);
    }

    public static Game deleteGame(UUID gameID) {
        return gameMap.remove(gameID);
    }
}
