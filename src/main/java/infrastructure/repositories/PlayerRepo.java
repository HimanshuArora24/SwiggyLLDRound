package infrastructure.repositories;

import constants.ErrorMessages;
import domain.entities.Player;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerRepo {

    public static Map<UUID, Player> playerMap = new HashMap<>();

    public static UUID save(Player player) {
        UUID playerId = UUID.randomUUID();
        playerMap.put(playerId, player);

        return playerId;
    }

    public static void update(UUID playerId, Player player) {
        playerMap.put(playerId, player);
    }

    public static Player fetchPlayer(UUID playerId) {
        return playerMap.get(playerId);
    }

    public static Player deletePlayer(UUID playerId) {
        return playerMap.remove(playerId);
    }

    public static final class PlayerDoesntExistException extends Exception {

        public PlayerDoesntExistException(String name) {
            super(MessageFormat.format(ErrorMessages.PLAYER_DOESNT_EXIST_MSG, name));
        }
    }

}
