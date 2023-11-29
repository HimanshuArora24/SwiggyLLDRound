package domain.entities;

import constants.ErrorMessages;
import java.text.MessageFormat;
import java.util.UUID;

public class Game {

    private UUID player1Id;
    private UUID player2Id;

    private Game(UUID player1Id, UUID player2Id) {
        this.player1Id = player1Id;
        this.player2Id = player2Id;
    }

    public static Game initialize(UUID player1Id, UUID player2Id) {
        validate();
        return new Game(player1Id, player2Id);
    }

    private static void validate() {
    }

    public UUID getPlayer1Id() {
        return player1Id;
    }

    public void setPlayer1Id(UUID player1Id) {
        this.player1Id = player1Id;
    }

    public UUID getPlayer2Id() {
        return player2Id;
    }

    public void setPlayer2Id(UUID player2Id) {
        this.player2Id = player2Id;
    }

    public static final class InvalidGameDetailsException extends Exception {

        public InvalidGameDetailsException(String value) {
            super(MessageFormat.format(ErrorMessages.INVALID_GAME_DETAILS_MSG, value));
        }
    }
}
