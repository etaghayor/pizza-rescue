package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Random;

import controller.Game;
import model.boxes.BoxType;
import model.boxes.EmptyBox;
import model.boxes.FruitBox;
import model.boxes.ObstacleBox;
import model.boxes.PizzaBox;
import model.boxes.FruitBox.Color;

public class Level implements Serializable {
    private static final long serialVersionUID = -6578584791683082932L;
    private GameBoard board;
    private int pizzas;
    private int number;
    private int bonuses = 0;
    private Game game;

    public Level(GameBoard b) {
        setBoard(b);
    }

    public Level(int l, Game game) {
        this.game = game;
        this.number = l;
        switch (l) {
            case 0 -> initBoard0();
            case 1 -> initBoard1();
            case 2 -> initBoard2();
            case 3 -> initBoard3();
            case 4 -> initBoard4();
            case 5 -> initBoard5();
            case 6 -> initBoard6();
            case 7 -> initBoard7();
            case 8 -> initBoard8();
            case 9 -> initBoard9();
        }

        validateLevel();
        board.initLocations();
        // board.initLocations();
//        System.out.println("true");
//		changeColorRandomly();
    }

    private void initBoard9() {
        // TODO : implement ballon and explain how it works
        board = new GameBoard(8, 9, this);
        pizzas = 5;
        bonuses = 3;
        board.getBoard()[0][0] = new ObstacleBox();
        board.getBoard()[0][8] = new ObstacleBox();
        board.getBoard()[3][0] = new ObstacleBox();
        board.getBoard()[3][8] = new ObstacleBox();
        board.getBoard()[4][0] = new ObstacleBox();
        board.getBoard()[4][8] = new ObstacleBox();
        board.getBoard()[4][2] = new ObstacleBox();
        board.getBoard()[4][1] = new ObstacleBox();
        board.getBoard()[4][3] = new ObstacleBox();
        board.getBoard()[4][4] = new ObstacleBox();
        board.getBoard()[4][5] = new ObstacleBox();
        board.getBoard()[4][6] = new ObstacleBox();
        board.getBoard()[4][7] = new ObstacleBox();
        board.getBoard()[5][1] = new ObstacleBox();
        board.getBoard()[5][7] = new ObstacleBox();
        board.getBoard()[6][1] = new ObstacleBox();
        board.getBoard()[6][7] = new ObstacleBox();
        board.getBoard()[7][1] = new ObstacleBox();
        board.getBoard()[7][7] = new ObstacleBox();
        board.getBoard()[5][6] = new PizzaBox();
        board.getBoard()[5][5] = new PizzaBox();
        board.getBoard()[5][4] = new PizzaBox();
        board.getBoard()[5][3] = new PizzaBox();
        board.getBoard()[5][2] = new PizzaBox();
        board.getBoard()[0][2] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[0][6] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[1][8] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[1][0] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[1][1] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[1][2] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[3][1] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[3][2] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[3][6] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[1][7] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[2][6] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[3][3] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[6][2] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[6][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[6][6] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[7][3] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[7][5] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[0][1] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[0][3] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[0][4] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[0][5] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[1][3] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[1][4] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[2][4] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[2][0] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[2][7] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[6][3] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[6][5] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[7][2] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[7][4] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[7][6] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[0][7] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[1][6] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[1][5] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[2][8] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[2][5] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[2][3] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[2][2] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[2][1] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[3][7] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[3][5] = new FruitBox(FruitBox.Color.PINK);

    }

    private void initBoard8() {
        // Let the player use hammer
        board = new GameBoard(7, 7, this);
        pizzas = 3;
        bonuses = 1;
        board.getBoard()[0][3] = new PizzaBox();
        board.getBoard()[3][1] = new PizzaBox();
        board.getBoard()[3][5] = new PizzaBox();
        board.getBoard()[2][3] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[2][4] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[3][2] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[4][3] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[5][2] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[5][3] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[6][0] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[6][1] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[6][2] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[6][3] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[6][6] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[1][2] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[2][2] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[3][3] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[3][4] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[4][1] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[4][2] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[4][5] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[5][0] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[5][1] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[5][6] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[6][4] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[6][5] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[1][3] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[1][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[4][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[5][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[5][5] = new FruitBox(FruitBox.Color.GREEN);

    }

    private void initBoard7() {
        // Show the player how to use hammer
        board = new GameBoard(9, 9, this);
        pizzas = 5;
        bonuses = 1;
        board.getBoard()[0][8] = new PizzaBox();
        board.getBoard()[4][8] = new PizzaBox();
        board.getBoard()[2][2] = new PizzaBox();
        board.getBoard()[2][4] = new PizzaBox();
        board.getBoard()[2][6] = new PizzaBox();
        board.getBoard()[1][0] = new ObstacleBox();
        board.getBoard()[1][8] = new ObstacleBox();
        board.getBoard()[3][2] = new ObstacleBox();
        board.getBoard()[3][3] = new ObstacleBox();
        board.getBoard()[3][5] = new ObstacleBox();
        board.getBoard()[3][6] = new ObstacleBox();
        board.getBoard()[4][2] = new ObstacleBox();
        board.getBoard()[4][3] = new ObstacleBox();
        board.getBoard()[4][5] = new ObstacleBox();
        board.getBoard()[4][6] = new ObstacleBox();
        board.getBoard()[5][8] = new ObstacleBox();
        board.getBoard()[6][8] = new ObstacleBox();
        board.getBoard()[6][0] = new ObstacleBox();
        board.getBoard()[7][8] = new ObstacleBox();
        board.getBoard()[7][0] = new ObstacleBox();
        board.getBoard()[8][8] = new ObstacleBox();
        board.getBoard()[8][0] = new ObstacleBox();
        board.getBoard()[4][4] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[0][0] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[0][2] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[0][7] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[1][1] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[1][3] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[1][7] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[2][7] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[3][1] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[3][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[3][8] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[5][0] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[5][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[6][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[7][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[8][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[8][7] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[1][4] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[1][5] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[2][5] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[2][1] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[4][7] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[5][5] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[5][3] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[5][1] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[6][1] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[6][3] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[6][5] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[6][6] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[7][5] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[7][3] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[7][2] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[8][3] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[8][5] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[8][6] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[0][1] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[0][6] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[1][6] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[1][2] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[2][0] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[2][3] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[2][8] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[3][0] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[3][7] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[4][0] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[4][1] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[5][2] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[5][7] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[5][6] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[6][2] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[6][7] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[7][1] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[7][6] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[7][7] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[8][1] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[8][2] = new FruitBox(FruitBox.Color.PINK);

    }

    // Let the player use rocker
    private void initBoard6() {
        board = new GameBoard(8, 7, this);
        pizzas = 2;
        bonuses = 1;
        board.getBoard()[6][0] = new PizzaBox();
        board.getBoard()[6][6] = new PizzaBox();
        board.getBoard()[7][6] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[7][0] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[0][3] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[3][3] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[6][3] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[1][3] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[2][3] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[4][3] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[5][3] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[7][3] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[0][5] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[1][5] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[1][4] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[1][2] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[2][6] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[2][0] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[2][1] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[2][2] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[3][6] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[4][0] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[4][1] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[4][2] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[4][5] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[5][0] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[5][5] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[6][4] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[7][5] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[0][2] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[0][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[1][1] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[1][6] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[2][5] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[2][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[3][5] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[3][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[3][2] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[3][1] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[3][0] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[4][6] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[4][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[5][6] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[5][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[5][2] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[5][1] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[6][2] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[6][1] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[6][5] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[7][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[7][2] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[7][1] = new FruitBox(FruitBox.Color.GREEN);
    }

    // Show the player how to use rockets
    private void initBoard5() {
        board = new GameBoard(9, 9, this);
        pizzas = 6;
        bonuses = 1;
        board.getBoard()[0][7] = new ObstacleBox();
        board.getBoard()[1][7] = new ObstacleBox();
        board.getBoard()[2][7] = new ObstacleBox();
        board.getBoard()[3][7] = new ObstacleBox();
        board.getBoard()[3][7] = new ObstacleBox();
        board.getBoard()[3][6] = new ObstacleBox();
        board.getBoard()[3][5] = new ObstacleBox();
        board.getBoard()[3][4] = new ObstacleBox();
        board.getBoard()[3][3] = new ObstacleBox();
        board.getBoard()[3][2] = new ObstacleBox();
        board.getBoard()[3][1] = new ObstacleBox();
        board.getBoard()[4][1] = new ObstacleBox();
        board.getBoard()[4][3] = new ObstacleBox();
        board.getBoard()[5][1] = new ObstacleBox();
        board.getBoard()[5][3] = new ObstacleBox();
        board.getBoard()[6][1] = new ObstacleBox();
        board.getBoard()[6][3] = new ObstacleBox();
        board.getBoard()[7][1] = new ObstacleBox();
        board.getBoard()[7][3] = new ObstacleBox();
        board.getBoard()[8][1] = new ObstacleBox();
        board.getBoard()[8][3] = new ObstacleBox();
        board.getBoard()[0][6] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[0][5] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[1][2] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[1][0] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[2][1] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[2][3] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[2][4] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[0][4] = new PizzaBox();
        board.getBoard()[1][3] = new PizzaBox();
        board.getBoard()[2][2] = new PizzaBox();
        board.getBoard()[2][6] = new PizzaBox();
        board.getBoard()[4][0] = new PizzaBox();
        board.getBoard()[6][0] = new PizzaBox();
        board.getBoard()[0][3] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[0][2] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[0][0] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[1][6] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[2][5] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[3][0] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[8][0] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[0][1] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[1][1] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[1][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[1][5] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[2][0] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[5][0] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[7][0] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[2][8] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[4][6] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[5][6] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[5][8] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[6][7] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[6][6] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[7][4] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[7][6] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[8][5] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[8][6] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[8][4] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[8][7] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[0][8] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[1][8] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[3][8] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[4][8] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[4][7] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[5][7] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[6][8] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[7][8] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[7][7] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[8][8] = new FruitBox(FruitBox.Color.PINK);

    }

    private void initBoard4() {
        board = new GameBoard(8, 5, this);
        bonuses = 0;
        pizzas = 2;
        for (int j = 0; j < board.getWidth(); j++) {
            for (int i = 0; i < board.getHeight(); i++) {
                board.getBoard()[i][j] = new FruitBox(FruitBox.Color.YELLOW);
            }
        }
        board.getBoard()[0][1] = new PizzaBox();
        board.getBoard()[0][2] = new PizzaBox();
        board.getBoard()[1][1] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[2][1] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[3][1] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[0][0] = new EmptyBox();
        board.getBoard()[1][0] = new EmptyBox();
        board.getBoard()[2][0] = new EmptyBox();
        board.getBoard()[3][0] = new EmptyBox();
        board.getBoard()[0][3] = new EmptyBox();
        board.getBoard()[1][3] = new EmptyBox();
        board.getBoard()[2][3] = new EmptyBox();
        board.getBoard()[3][3] = new EmptyBox();
        board.getBoard()[0][4] = new EmptyBox();
        board.getBoard()[1][4] = new EmptyBox();
        board.getBoard()[2][4] = new EmptyBox();
        board.getBoard()[3][4] = new EmptyBox();

    }

    private void initBoard3() {
        board = new GameBoard(8, 8, this);
        pizzas = 4;
        board.getBoard()[0][7] = new PizzaBox();
        board.getBoard()[0][6] = new PizzaBox();
        board.getBoard()[0][5] = new PizzaBox();
        board.getBoard()[0][4] = new PizzaBox();
        board.getBoard()[1][7] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[2][7] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[4][5] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[5][5] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[3][5] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[2][3] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[3][3] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[5][0] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[7][0] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[6][1] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[7][1] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[5][2] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[4][2] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[7][3] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[6][3] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[6][0] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[4][0] = new FruitBox(FruitBox.Color.RED);
        board.getBoard()[1][6] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[2][6] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[1][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[1][3] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[2][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[2][2] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[3][1] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[3][2] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[5][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[6][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[6][2] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[7][0] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[7][2] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[1][5] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[2][5] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[3][7] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[3][6] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[3][4] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[4][6] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[4][4] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[4][3] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[4][1] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[5][3] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[5][1] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[5][0] = new FruitBox(FruitBox.Color.YELLOW);

        board.getBoard()[7][7] = new ObstacleBox();
        board.getBoard()[7][6] = new ObstacleBox();
        board.getBoard()[7][5] = new ObstacleBox();
        board.getBoard()[7][4] = new ObstacleBox();
        board.getBoard()[6][7] = new ObstacleBox();
        board.getBoard()[6][6] = new ObstacleBox();
        board.getBoard()[6][5] = new ObstacleBox();
        board.getBoard()[5][7] = new ObstacleBox();
        board.getBoard()[5][6] = new ObstacleBox();
        board.getBoard()[4][7] = new ObstacleBox();

    }

    public GameBoard getGameBoard() {
        return board;
    }

    public void setBoard(GameBoard board) {
        this.board = board;
    }

    private void initBoard2() {
        board = new GameBoard(9, 7, this);
        pizzas = 3;
        board.getBoard()[0][2] = new PizzaBox();
        board.getBoard()[0][4] = new PizzaBox();
        board.getBoard()[0][6] = new PizzaBox();

        board.getBoard()[1][2] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[2][2] = new FruitBox(FruitBox.Color.PINK);

        board.getBoard()[1][3] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[2][3] = new FruitBox(FruitBox.Color.YELLOW);

        board.getBoard()[1][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[2][4] = new FruitBox(FruitBox.Color.GREEN);

        board.getBoard()[1][5] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[2][5] = new FruitBox(FruitBox.Color.YELLOW);

        board.getBoard()[1][6] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[2][6] = new FruitBox(FruitBox.Color.GREEN);

        board.getBoard()[3][2] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[4][2] = new FruitBox(FruitBox.Color.YELLOW);

        board.getBoard()[3][3] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[4][3] = new FruitBox(FruitBox.Color.GREEN);

        board.getBoard()[3][4] = new ObstacleBox();
        board.getBoard()[4][4] = new ObstacleBox();

        board.getBoard()[3][5] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[4][5] = new FruitBox(FruitBox.Color.YELLOW);

        board.getBoard()[3][6] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[4][6] = new FruitBox(FruitBox.Color.PINK);

        board.getBoard()[4][0] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[4][1] = new FruitBox(FruitBox.Color.GREEN);

        board.getBoard()[5][0] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[6][0] = new FruitBox(FruitBox.Color.YELLOW);

        board.getBoard()[5][1] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[6][1] = new FruitBox(FruitBox.Color.PINK);

        board.getBoard()[5][2] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[6][2] = new FruitBox(FruitBox.Color.GREEN);

        board.getBoard()[5][3] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[6][3] = new FruitBox(FruitBox.Color.PINK);

        board.getBoard()[5][4] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[6][4] = new FruitBox(FruitBox.Color.GREEN);

        board.getBoard()[5][5] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[6][5] = new FruitBox(FruitBox.Color.PINK);

        board.getBoard()[5][6] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[6][6] = new FruitBox(FruitBox.Color.GREEN);

        board.getBoard()[7][0] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[8][0] = new FruitBox(FruitBox.Color.GREEN);

        board.getBoard()[7][1] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[8][1] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[7][2] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[8][2] = new FruitBox(FruitBox.Color.YELLOW);

        board.getBoard()[7][3] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[8][3] = new FruitBox(FruitBox.Color.GREEN);

        board.getBoard()[7][4] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[8][4] = new FruitBox(FruitBox.Color.YELLOW);

        board.getBoard()[7][5] = new ObstacleBox();
        board.getBoard()[8][5] = new ObstacleBox();
        board.getBoard()[7][6] = new ObstacleBox();
        board.getBoard()[8][6] = new ObstacleBox();

        validateLevel();
        board.initLocations();

    }

    private void initBoard1() {
        board = new GameBoard(8, 5, this);
        pizzas = 5;
        board.getBoard()[0][2] = new PizzaBox();
        board.getBoard()[1][2] = new PizzaBox();
        board.getBoard()[2][2] = new PizzaBox();
        board.getBoard()[1][0] = new PizzaBox();
        board.getBoard()[1][4] = new PizzaBox();

        board.getBoard()[0][1] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[1][1] = new FruitBox(FruitBox.Color.PINK);

        board.getBoard()[0][3] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[1][3] = new FruitBox(FruitBox.Color.PINK);

        board.getBoard()[2][0] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[3][0] = new FruitBox(FruitBox.Color.YELLOW);

        board.getBoard()[2][1] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[3][1] = new FruitBox(FruitBox.Color.BLUE);

        board.getBoard()[2][3] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[3][3] = new FruitBox(FruitBox.Color.BLUE);

        board.getBoard()[2][4] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[3][4] = new FruitBox(FruitBox.Color.YELLOW);

        for (int i = 3; i < board.getHeight(); i++)
            board.getBoard()[i][2] = new FruitBox(FruitBox.Color.YELLOW);

        board.getBoard()[4][0] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[5][0] = new FruitBox(FruitBox.Color.BLUE);

        board.getBoard()[4][1] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[5][1] = new FruitBox(FruitBox.Color.PINK);

        board.getBoard()[4][3] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[5][3] = new FruitBox(FruitBox.Color.PINK);

        board.getBoard()[4][4] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[5][4] = new FruitBox(FruitBox.Color.BLUE);

        board.getBoard()[6][0] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[7][0] = new FruitBox(FruitBox.Color.PINK);

        board.getBoard()[6][1] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[7][1] = new FruitBox(FruitBox.Color.BLUE);

        board.getBoard()[6][3] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[7][3] = new FruitBox(FruitBox.Color.BLUE);

        board.getBoard()[6][4] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[7][4] = new FruitBox(FruitBox.Color.PINK);

        validateLevel();
        board.initLocations();

    }

    private void initBoard0() {
        board = new GameBoard(7, 7, this);
        pizzas = 2;

        board.getBoard()[0][1] = new PizzaBox();
        board.getBoard()[0][5] = new PizzaBox();

        board.getBoard()[1][1] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[1][0] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[2][0] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[2][1] = new FruitBox(FruitBox.Color.PINK);

        for (int i = 2; i < 5; i++) {
            board.getBoard()[1][i] = new FruitBox(FruitBox.Color.GREEN);
        }
        board.getBoard()[1][5] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[2][5] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[1][6] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[2][6] = new FruitBox(FruitBox.Color.YELLOW);

        for (int i = 2; i < 5; i++)
            for (int j = 2; j < 5; j++)
                board.getBoard()[i][j] = new FruitBox(FruitBox.Color.RED);

        board.getBoard()[3][0] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[4][0] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[3][1] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[4][1] = new FruitBox(FruitBox.Color.GREEN);

        board.getBoard()[3][5] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[3][6] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[4][5] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[4][6] = new FruitBox(FruitBox.Color.BLUE);

        board.getBoard()[5][0] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[6][0] = new FruitBox(FruitBox.Color.PINK);

        board.getBoard()[5][1] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[5][2] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[6][1] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[6][2] = new FruitBox(FruitBox.Color.YELLOW);

        board.getBoard()[5][3] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[6][3] = new FruitBox(FruitBox.Color.GREEN);

        board.getBoard()[5][4] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[6][4] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[5][5] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[6][5] = new FruitBox(FruitBox.Color.PINK);

        board.getBoard()[5][6] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[6][6] = new FruitBox(FruitBox.Color.GREEN);

        validateLevel();

        board.initLocations();

    }

//    private void initBoard0() {
//        board = new GameBoard(11, 10, this);
//        pizzas = 4;
//
//        for (int i = 0; i < board.getHeight(); i++) {
//            for (int j = 0; j < board.getWidth(); j++) {
//                if (i == 0)
//                    if (j % 2 == 1 && j != 9)
//                        board.getBoard()[i][j] = new PizzaBox();
//                    else
//                        board.getBoard()[i][j] = new EmptyBox();
//                else if (i % 2 == 1)
//                    board.getBoard()[i][j] = new FruitBox(FruitBox.Color.YELLOW);
//                else
//                    board.getBoard()[i][j] = new FruitBox(FruitBox.Color.BLUE);
//            }
//        }
//        validateLevel();
//
//        board.initLocations();
//
//  }

    // This function is here to make sure there is no case null
// With emptyBox() instead, in that way, we never have to handle
// NullPointerException
    private void validateLevel() {
        for (int j = 0; j < board.getWidth(); j++) {
            for (int i = 0; i < board.getHeight(); i++) {
                if (board.getBoard()[i][j] == null)
                    board.getBoard()[i][j] = new EmptyBox();
            }
        }
    }

    // We will create many levels and add each of them in different
    // files and the only thing we would have to do is recover the
    // level and deserialize it
    public static Level Deserialize2(String path) {
        Level deserializableLevel = null;
        try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis)) {
            deserializableLevel = (Level) ois.readObject();
            System.out.println("The level " + path.charAt(5) + " has been deserialize");
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
        return deserializableLevel;
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

    private void changeColorRandomly() {
        int number = new Random().nextInt(5) + 1;
        for (int j = 0; j < board.getWidth(); j++) {
            for (int i = 0; i < board.getHeight(); i++) {
                if (board.getBoard()[i][j].getType() == BoxType.FRUIT) {
                    try {
//                        board.getBoard()[i][j]
                        FruitBox tmp = (FruitBox) board.getBoard()[i][j].clone();
//						tmp = new FruitBox(tmp.getColor().getValue());
//						board.getBoard()[i][j] = new 
                    } catch (CloneNotSupportedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public Game getGame() {
        return game;
    }
}
