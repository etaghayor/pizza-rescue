package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Random;

import controller.Game;
import media.Images;
import model.boxes.*;

public class Level implements Serializable {
    private static final long serialVersionUID = -6578584791683082932L;
    private GameBoard gameBoard;
    private int pizzas;
    private int number;
    private int bonuses;
    private Game game;
    

    public Level(GameBoard b) {
        setGameBoard(b);
    }
    public Box[][] getBoard() {
    	return this.gameBoard.getBoard();
    }
    //TODO : Don't remember we have to set the bonuses for the impossible levels
    // In this way the user won't lose the game until he hasn't used his bonuses
    public Level(int l, Game game) {
        this.game = game;
        this.number = l;
        switch (l) { // TODO read from File
            case 1 -> {
                gameBoard = new GameBoard(deserialize("Levels/level_1"), this);
                this.pizzas = 2;
            }
            case 2 -> {
                gameBoard = new GameBoard(deserialize("Levels/level_2"), this);
                this.pizzas = 5;
            }
            case 3 -> {
                gameBoard = new GameBoard(deserialize("Levels/level_3"), this);
                this.pizzas = 3;
            }
            case 4 -> {
                gameBoard = new GameBoard(deserialize("Levels/level_4"), this);
                this.pizzas = 4;
            }
            case 5 -> {
                gameBoard = new GameBoard(deserialize("Levels/level_5"), this);
                this.pizzas = 2;
            }
            case 6 -> {
                gameBoard = new GameBoard(deserialize("Levels/level_6"), this);
                this.pizzas = 6;
            }
            case 7 -> {
                gameBoard = new GameBoard(deserialize("Levels/level_7"), this);
                this.pizzas = 2;
            }
            case 8 -> {
                gameBoard = new GameBoard(deserialize("Levels/level_8"), this);
                this.pizzas = 5;
            }
            case 9 -> {
                gameBoard = new GameBoard(deserialize("Levels/level_9"), this);
                this.pizzas = 3;
            }
            case 10 -> {
                gameBoard = new GameBoard(deserialize("Levels/level_10"), this);
                this.pizzas = 5;
            }
        }
        updateImageAndColor();
        gameBoard.updateData();
    }
    


    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }


    // We will create many levels and add each of them in different
    // files and the only thing we would have to do is recover the
    // level and deserialize it
    public static Box[][] deserialize(String path) {
//        Level deserializableLevel = null;
        Box[][] deserializableBoard = null;
        try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis)) {
            deserializableBoard = (Box[][]) ois.readObject();
//            System.out.println("The level " + path.substring(13) + " has been deserialized");
        } catch (FileNotFoundException e) {
            System.err.println("The file : " + path + " cannot be found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("The file : " + path + " cannot be read.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("The object class you have tried to deserialize doesn't exist");
            e.printStackTrace();
        }
        return deserializableBoard;
    }

    public int getPizzas() {
        return pizzas;
    }

    public int getNumber() {
        return number;
    }

    public int getBonuses() {
        return bonuses;
    }

    private void updateImageAndColor() {
        int number = new Random().nextInt(6);
        for (int j = 0; j < gameBoard.getWidth(); j++) {
            for (int i = 0; i < gameBoard.getHeight(); i++) {
                if (gameBoard.getBoard()[i][j].getType() == BoxType.FRUIT) {
                    FruitBox tmp = new FruitBox(((FruitBox) gameBoard.getBoard()[i][j]).getColor());
                    tmp.setColor(number);
                    gameBoard.getBoard()[i][j] = tmp;
                }
                if (gameBoard.getBoard()[i][j].getType() == BoxType.PIZZA)
                    gameBoard.getBoard()[i][j].setImage(Images.getPizzaImage());
                if (gameBoard.getBoard()[i][j].getType() == BoxType.OBSTACLE)
                    gameBoard.getBoard()[i][j].setImage(Images.getObstacleImage());
            }
        }
    }

    public Game getGame() {
        return game;
    }


}
