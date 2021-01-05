package model;

import java.io.File;
import java.util.Scanner;

import controller.Game;

public class TUI {
    private Game game;
    private GameBoard gameBoard;

    public TUI() {

        System.out.println("Pizza Rescue Saga Game in textual interface");
        System.out.println("___________________________________________\n");
        Scanner in = new Scanner(System.in);

        while (true) {
            Player player = new Player();
            System.out.println("What level do you want to play?");
            printAccessibleLevels(player.getLastLevel());
            System.out.println("|| If you want to exit the program type 9999 ||");
            System.out.println("|| If you want to reset your data, type 8888 ||");
            int n = in.nextInt();
            game = new Game(player);

            if (n == 9999) {
                System.out.println("Bye!");
                game.serializePlayerData();
                System.exit(0);
            } else if (n == 8888) {
                resetGame();
                // game.serializePlayerData();
                continue;
            }

            int lastAccessibleLevel = player.getLastLevel();
            if (!isLevelValid(lastAccessibleLevel, n))
                continue;

            game.respawnLife();
            game.serializePlayerData();
            Level level = new Level(n, game);
            gameBoard = level.getGameBoard();
            printGameBoardInit();

            while (true) {
                System.out.println("|| If you want to exit the program type 9999 ||");
                System.out.println("*** Score: " + player.getScore() + " *** Life: " + player.getLife());
                System.out.println("Give me the coordinates of the box you want to remove.");

                game.respawnLife();

                System.out.print("X: ");
                int x = in.nextInt();

                if (x == 9999) {
                    System.out.println("Bye!");
                    System.exit(0);
                }

                x--;


                System.out.print("Y: ");
                int y = in.nextInt() - 1;

                if (!gameBoard.outOfRange(y, x)) {
                    if (!gameBoard.emptyPack(y, x))
                        System.out.println("You can't delete this box!");
                } else {
                    System.out.println("Coordinates are out of range");
                }

                game.serializePlayerData();
                gameBoard.printBoard();

                if (gameBoard.hasWon()) {
                    System.out.println("Congratulations!");
                    player.setLastLevel(player.getLastLevel() + 1);
                    game.serializePlayerData();
                    break;
                }
                if (gameBoard.hasLost()) {
                    System.out.println("You've lost:(");
//                    Time.serializeTime();
                    player.updateLife(player.getLife() - 1);
                    game.serializePlayerData();
                    break;
                }
            }
            in.close();

        }
    }

    private void printGameBoardInit() {
        System.out.println("******** Affichage du niveau " + gameBoard.getLevelNumber() + " ************\n");
        gameBoard.printBoard();
    }

    private void resetGame() {

        File userData = new File("../user/player_data");
        if (userData.exists()) {
            if (userData.delete())
                System.out.println("game has been reset!");
            else
                System.out.println("can't reset");
        } else
            System.out.println("you don't have data to be reset!");
    }


//    Check if    the level    exists

    private boolean isLevelValid(int lastLevel, int lNumber) {
        if (lNumber <= lastLevel && lNumber > 0)
            return true;
        System.out.println("That level isn't accessible!");
        return false;
    }

    private void printAccessibleLevels(int lastLevel) {
        System.out.println("Accessible Levels:");
        for (int i = 1; i <= 10; i++) {
            if (i <= lastLevel) {
                System.out.print("|| Level " + i + " ");
            }
        }
        System.out.println("||");
    }


}