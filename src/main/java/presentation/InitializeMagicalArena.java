package presentation;

import constants.ProcessingMessages;
import domain.entities.Dice;
import domain.entities.Game;
import domain.entities.Player;
import domain.entities.Player.InvalidPlayerDetailsException;
import infrastructure.repositories.GameRepo;
import infrastructure.repositories.PlayerRepo;
import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;
import utilities.Display;

public class InitializeMagicalArena {

    public InitializeMagicalArena() {
        Display.displayMessage("\n" + "Welcome to the game" + "\n");
    }

    public void startGame() throws InvalidPlayerDetailsException {
        Display.displayMessage("Enter the details of player 1");
        Player player1 = takeUserInputsAndCreatePlayer();
        System.out.println();

        Display.displayMessage("Enter the details of player 2");
        Player player2 = takeUserInputsAndCreatePlayer();
        System.out.println();

        savePlayerAndGame(player1, player2);

        startNewMatch(player1, player2);
    }

    private Player takeUserInputsAndCreatePlayer() throws InvalidPlayerDetailsException {
        Scanner sc = new Scanner(System.in);

        Display.displayMessage("Name: ");
        String player1Name = sc.nextLine();

        Display.displayMessage("Attack: ");
        int player1Attack = sc.nextInt();

        Display.displayMessage("Strength: ");
        int player1Strength = sc.nextInt();

        Display.displayMessage("Health: ");
        int player1Health = sc.nextInt();

        return Player.create(player1Name, player1Attack, player1Strength, player1Health);
    }

    private void savePlayerAndGame(Player player1, Player player2) {
        UUID player1Id = PlayerRepo.save(player1);
        UUID player2Id = PlayerRepo.save(player2);

        Game currentGame = Game.initialize(player1Id, player2Id);

        GameRepo.save(currentGame);
    }

    private void startNewMatch(Player player1, Player player2) {
        Player[] players = {player1, player2};
        int turn = 0;

        do {
            printPlayerTurnMessage(players[turn]);

            try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            int diceRollAttack = Dice.roll();
            printDiceRollMessage(players[turn], diceRollAttack);

            int diceRollDefend = Dice.roll();
            printDiceRollMessage(players[(turn + 1) % players.length], diceRollDefend);
            System.out.println();

            int attackDamage = calculateAttackDamage(players[turn], diceRollAttack);
            turn = (turn + 1) % players.length;

            int damageSavedDueToDefend = calculateDefendDamage(players[turn], diceRollDefend);

            updateHealth(players[turn], attackDamage, damageSavedDueToDefend);

            if (players[turn].checkIfLost()) {
                Display.displayMessage(players[turn].getName() + ProcessingMessages.LOSE_MSG);
                break;
            }
        } while (true);
    }

    private void printPlayerTurnMessage(Player player) {
        Display.displayMessage(player.getName() + ProcessingMessages.PLAYER_TURN_MSG);
    }

    private void printDiceRollMessage(Player player, int diceRoll) {
        Display.displayMessage(
            player.getName() + ProcessingMessages.NUMBER_RECEIVED_ON_DICE_MSG + diceRoll + " ");
    }

    private int calculateAttackDamage(Player player, int diceRoll) {
        return player.getAttack() * diceRoll;
    }

    private int calculateDefendDamage(Player player, int diceRoll) {
        return player.getStrength() * diceRoll;
    }

    private void updateHealth(Player player, int attackDamage, int damageSavedDueToDefend) {
        int totalDamage = attackDamage - damageSavedDueToDefend;

        player.setHealth(player.getHealth() - totalDamage);
    }
}
