import domain.entities.Player.InvalidPlayerDetailsException;
import presentation.InitializeMagicalArena;

public class MagicalArenaGame {

    public static void main(String[] args) throws InvalidPlayerDetailsException {
        InitializeMagicalArena initializeMagicalArena = new InitializeMagicalArena();
        initializeMagicalArena.startGame();
    }

}
