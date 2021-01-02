package serialize;

import model.GameBoard;
import model.boxes.*;

public class LevelsResource {
    //    Box[][][] boards = new Box[][][10];
    Box[][][] boards = new Box[10][][];

    public LevelsResource() {
        boards[0] = initBoard0();
        boards[1] = initBoard1();
        boards[2] = initBoard2();
        boards[3] = initBoard3();
        boards[4] = initBoard4();
        boards[5] = initBoard5();
        boards[6] = initBoard6();
        boards[7] = initBoard7();
        boards[8] = initBoard8();
        boards[9] = initBoard9();
        validateLevels();
    }

    public Box[][][] getBoards() {
        return boards;
    }

    //    public Box[][] getBoard(int i) {
//
//    }


    private void validateLevels() {
        for (int l = 0; l < 10; l++) {
            Box[][] board = boards[l];
            for (int j = 0; j < board[0].length; j++) {
                for (int i = 0; i < board.length; i++) {
                    if (board[i][j] == null)
                        board[i][j] = new EmptyBox();
                }
            }
        }
    }

    private Box[][] initBoard9() {
        // TODO : implement ballon and explain how it works
        Box[][] board = new Box[8][9];
//        pizzas = 5;
//        bonuses = 3;
        board[0][0] = new ObstacleBox();
        board[0][8] = new ObstacleBox();
        board[3][0] = new ObstacleBox();
        board[3][8] = new ObstacleBox();
        board[4][0] = new ObstacleBox();
        board[4][8] = new ObstacleBox();
        board[4][2] = new ObstacleBox();
        board[4][1] = new ObstacleBox();
        board[4][3] = new ObstacleBox();
        board[4][4] = new ObstacleBox();
        board[4][5] = new ObstacleBox();
        board[4][6] = new ObstacleBox();
        board[4][7] = new ObstacleBox();
        board[5][1] = new ObstacleBox();
        board[5][7] = new ObstacleBox();
        board[6][1] = new ObstacleBox();
        board[6][7] = new ObstacleBox();
        board[7][1] = new ObstacleBox();
        board[7][7] = new ObstacleBox();
        board[5][6] = new PizzaBox();
        board[5][5] = new PizzaBox();
        board[5][4] = new PizzaBox();
        board[5][3] = new PizzaBox();
        board[5][2] = new PizzaBox();
        board[0][2] = new FruitBox(FruitBox.Color.YELLOW);
        board[0][6] = new FruitBox(FruitBox.Color.YELLOW);
        board[1][8] = new FruitBox(FruitBox.Color.YELLOW);
        board[1][0] = new FruitBox(FruitBox.Color.YELLOW);
        board[1][1] = new FruitBox(FruitBox.Color.YELLOW);
        board[1][2] = new FruitBox(FruitBox.Color.YELLOW);
        board[3][1] = new FruitBox(FruitBox.Color.YELLOW);
        board[3][2] = new FruitBox(FruitBox.Color.YELLOW);
        board[3][6] = new FruitBox(FruitBox.Color.YELLOW);
        board[1][7] = new FruitBox(FruitBox.Color.GREEN);
        board[2][6] = new FruitBox(FruitBox.Color.GREEN);
        board[3][3] = new FruitBox(FruitBox.Color.GREEN);
        board[6][2] = new FruitBox(FruitBox.Color.GREEN);
        board[6][4] = new FruitBox(FruitBox.Color.GREEN);
        board[6][6] = new FruitBox(FruitBox.Color.GREEN);
        board[7][3] = new FruitBox(FruitBox.Color.GREEN);
        board[7][5] = new FruitBox(FruitBox.Color.GREEN);
        board[0][1] = new FruitBox(FruitBox.Color.RED);
        board[0][3] = new FruitBox(FruitBox.Color.RED);
        board[0][4] = new FruitBox(FruitBox.Color.RED);
        board[0][5] = new FruitBox(FruitBox.Color.RED);
        board[1][3] = new FruitBox(FruitBox.Color.RED);
        board[1][4] = new FruitBox(FruitBox.Color.RED);
        board[2][4] = new FruitBox(FruitBox.Color.RED);
        board[2][0] = new FruitBox(FruitBox.Color.RED);
        board[2][7] = new FruitBox(FruitBox.Color.RED);
        board[6][3] = new FruitBox(FruitBox.Color.RED);
        board[6][5] = new FruitBox(FruitBox.Color.RED);
        board[7][2] = new FruitBox(FruitBox.Color.RED);
        board[7][4] = new FruitBox(FruitBox.Color.RED);
        board[7][6] = new FruitBox(FruitBox.Color.RED);
        board[0][7] = new FruitBox(FruitBox.Color.PINK);
        board[1][6] = new FruitBox(FruitBox.Color.PINK);
        board[1][5] = new FruitBox(FruitBox.Color.PINK);
        board[2][8] = new FruitBox(FruitBox.Color.PINK);
        board[2][5] = new FruitBox(FruitBox.Color.PINK);
        board[2][3] = new FruitBox(FruitBox.Color.PINK);
        board[2][2] = new FruitBox(FruitBox.Color.PINK);
        board[2][1] = new FruitBox(FruitBox.Color.PINK);
        board[3][7] = new FruitBox(FruitBox.Color.PINK);
        board[3][5] = new FruitBox(FruitBox.Color.PINK);

        return board;

    }

    private Box[][] initBoard8() {
        // Let the player use hammer
        Box[][] board = new Box[7][7];
//        pizzas = 3;
//        bonuses = 1;
        board[0][3] = new PizzaBox();
        board[3][1] = new PizzaBox();
        board[3][5] = new PizzaBox();
        board[2][3] = new FruitBox(FruitBox.Color.RED);
        board[2][4] = new FruitBox(FruitBox.Color.RED);
        board[3][2] = new FruitBox(FruitBox.Color.RED);
        board[4][3] = new FruitBox(FruitBox.Color.RED);
        board[5][2] = new FruitBox(FruitBox.Color.RED);
        board[5][3] = new FruitBox(FruitBox.Color.RED);
        board[6][0] = new FruitBox(FruitBox.Color.RED);
        board[6][1] = new FruitBox(FruitBox.Color.RED);
        board[6][2] = new FruitBox(FruitBox.Color.RED);
        board[6][3] = new FruitBox(FruitBox.Color.RED);
        board[6][6] = new FruitBox(FruitBox.Color.RED);
        board[1][2] = new FruitBox(FruitBox.Color.BLUE);
        board[2][2] = new FruitBox(FruitBox.Color.BLUE);
        board[3][3] = new FruitBox(FruitBox.Color.BLUE);
        board[3][4] = new FruitBox(FruitBox.Color.BLUE);
        board[4][1] = new FruitBox(FruitBox.Color.BLUE);
        board[4][2] = new FruitBox(FruitBox.Color.BLUE);
        board[4][5] = new FruitBox(FruitBox.Color.BLUE);
        board[5][0] = new FruitBox(FruitBox.Color.BLUE);
        board[5][1] = new FruitBox(FruitBox.Color.BLUE);
        board[5][6] = new FruitBox(FruitBox.Color.BLUE);
        board[6][4] = new FruitBox(FruitBox.Color.BLUE);
        board[6][5] = new FruitBox(FruitBox.Color.BLUE);
        board[1][3] = new FruitBox(FruitBox.Color.YELLOW);
        board[1][4] = new FruitBox(FruitBox.Color.GREEN);
        board[4][4] = new FruitBox(FruitBox.Color.GREEN);
        board[5][4] = new FruitBox(FruitBox.Color.GREEN);
        board[5][5] = new FruitBox(FruitBox.Color.GREEN);

        return board;
    }

    private Box[][] initBoard7() {
        // Show the player how to use hammer
        Box[][] board = new Box[9][9];
//        pizzas = 5;
//        bonuses = 1;
        board[0][8] = new PizzaBox();
        board[4][8] = new PizzaBox();
        board[2][2] = new PizzaBox();
        board[2][4] = new PizzaBox();
        board[2][6] = new PizzaBox();
        board[1][0] = new ObstacleBox();
        board[1][8] = new ObstacleBox();
        board[3][2] = new ObstacleBox();
        board[3][3] = new ObstacleBox();
        board[3][5] = new ObstacleBox();
        board[3][6] = new ObstacleBox();
        board[4][2] = new ObstacleBox();
        board[4][3] = new ObstacleBox();
        board[4][5] = new ObstacleBox();
        board[4][6] = new ObstacleBox();
        board[5][8] = new ObstacleBox();
        board[6][8] = new ObstacleBox();
        board[6][0] = new ObstacleBox();
        board[7][8] = new ObstacleBox();
        board[7][0] = new ObstacleBox();
        board[8][8] = new ObstacleBox();
        board[8][0] = new ObstacleBox();
        board[4][4] = new FruitBox(FruitBox.Color.RED);
        board[0][0] = new FruitBox(FruitBox.Color.GREEN);
        board[0][2] = new FruitBox(FruitBox.Color.GREEN);
        board[0][7] = new FruitBox(FruitBox.Color.GREEN);
        board[1][1] = new FruitBox(FruitBox.Color.GREEN);
        board[1][3] = new FruitBox(FruitBox.Color.GREEN);
        board[1][7] = new FruitBox(FruitBox.Color.GREEN);
        board[2][7] = new FruitBox(FruitBox.Color.GREEN);
        board[3][1] = new FruitBox(FruitBox.Color.GREEN);
        board[3][4] = new FruitBox(FruitBox.Color.GREEN);
        board[3][8] = new FruitBox(FruitBox.Color.GREEN);
        board[5][0] = new FruitBox(FruitBox.Color.GREEN);
        board[5][4] = new FruitBox(FruitBox.Color.GREEN);
        board[6][4] = new FruitBox(FruitBox.Color.GREEN);
        board[7][4] = new FruitBox(FruitBox.Color.GREEN);
        board[8][4] = new FruitBox(FruitBox.Color.GREEN);
        board[8][7] = new FruitBox(FruitBox.Color.GREEN);
        board[1][4] = new FruitBox(FruitBox.Color.BLUE);
        board[1][5] = new FruitBox(FruitBox.Color.BLUE);
        board[2][5] = new FruitBox(FruitBox.Color.BLUE);
        board[2][1] = new FruitBox(FruitBox.Color.BLUE);
        board[4][7] = new FruitBox(FruitBox.Color.BLUE);
        board[5][5] = new FruitBox(FruitBox.Color.BLUE);
        board[5][3] = new FruitBox(FruitBox.Color.BLUE);
        board[5][1] = new FruitBox(FruitBox.Color.BLUE);
        board[6][1] = new FruitBox(FruitBox.Color.BLUE);
        board[6][3] = new FruitBox(FruitBox.Color.BLUE);
        board[6][5] = new FruitBox(FruitBox.Color.BLUE);
        board[6][6] = new FruitBox(FruitBox.Color.BLUE);
        board[7][5] = new FruitBox(FruitBox.Color.BLUE);
        board[7][3] = new FruitBox(FruitBox.Color.BLUE);
        board[7][2] = new FruitBox(FruitBox.Color.BLUE);
        board[8][3] = new FruitBox(FruitBox.Color.BLUE);
        board[8][5] = new FruitBox(FruitBox.Color.BLUE);
        board[8][6] = new FruitBox(FruitBox.Color.BLUE);
        board[0][1] = new FruitBox(FruitBox.Color.PINK);
        board[0][6] = new FruitBox(FruitBox.Color.PINK);
        board[1][6] = new FruitBox(FruitBox.Color.PINK);
        board[1][2] = new FruitBox(FruitBox.Color.PINK);
        board[2][0] = new FruitBox(FruitBox.Color.PINK);
        board[2][3] = new FruitBox(FruitBox.Color.PINK);
        board[2][8] = new FruitBox(FruitBox.Color.PINK);
        board[3][0] = new FruitBox(FruitBox.Color.PINK);
        board[3][7] = new FruitBox(FruitBox.Color.PINK);
        board[4][0] = new FruitBox(FruitBox.Color.PINK);
        board[4][1] = new FruitBox(FruitBox.Color.PINK);
        board[5][2] = new FruitBox(FruitBox.Color.PINK);
        board[5][7] = new FruitBox(FruitBox.Color.PINK);
        board[5][6] = new FruitBox(FruitBox.Color.PINK);
        board[6][2] = new FruitBox(FruitBox.Color.PINK);
        board[6][7] = new FruitBox(FruitBox.Color.PINK);
        board[7][1] = new FruitBox(FruitBox.Color.PINK);
        board[7][6] = new FruitBox(FruitBox.Color.PINK);
        board[7][7] = new FruitBox(FruitBox.Color.PINK);
        board[8][1] = new FruitBox(FruitBox.Color.PINK);
        board[8][2] = new FruitBox(FruitBox.Color.PINK);

        return board;

    }

    // Let the player use rocker
    private Box[][] initBoard6() {
        Box[][] board = new Box[8][7];
//        pizzas = 2;
//        bonuses = 1;
        board[6][0] = new PizzaBox();
        board[6][6] = new PizzaBox();
        board[7][6] = new FruitBox(FruitBox.Color.RED);
        board[7][0] = new FruitBox(FruitBox.Color.RED);
        board[0][3] = new FruitBox(FruitBox.Color.RED);
        board[3][3] = new FruitBox(FruitBox.Color.RED);
        board[6][3] = new FruitBox(FruitBox.Color.RED);
        board[1][3] = new FruitBox(FruitBox.Color.BLUE);
        board[2][3] = new FruitBox(FruitBox.Color.YELLOW);
        board[4][3] = new FruitBox(FruitBox.Color.BLUE);
        board[5][3] = new FruitBox(FruitBox.Color.YELLOW);
        board[7][3] = new FruitBox(FruitBox.Color.BLUE);
        board[0][5] = new FruitBox(FruitBox.Color.PINK);
        board[1][5] = new FruitBox(FruitBox.Color.PINK);
        board[1][4] = new FruitBox(FruitBox.Color.PINK);
        board[1][2] = new FruitBox(FruitBox.Color.PINK);
        board[2][6] = new FruitBox(FruitBox.Color.PINK);
        board[2][0] = new FruitBox(FruitBox.Color.PINK);
        board[2][1] = new FruitBox(FruitBox.Color.PINK);
        board[2][2] = new FruitBox(FruitBox.Color.PINK);
        board[3][6] = new FruitBox(FruitBox.Color.PINK);
        board[4][0] = new FruitBox(FruitBox.Color.PINK);
        board[4][1] = new FruitBox(FruitBox.Color.PINK);
        board[4][2] = new FruitBox(FruitBox.Color.PINK);
        board[4][5] = new FruitBox(FruitBox.Color.PINK);
        board[5][0] = new FruitBox(FruitBox.Color.PINK);
        board[5][5] = new FruitBox(FruitBox.Color.PINK);
        board[6][4] = new FruitBox(FruitBox.Color.PINK);
        board[7][5] = new FruitBox(FruitBox.Color.PINK);
        board[0][2] = new FruitBox(FruitBox.Color.GREEN);
        board[0][4] = new FruitBox(FruitBox.Color.GREEN);
        board[1][1] = new FruitBox(FruitBox.Color.GREEN);
        board[1][6] = new FruitBox(FruitBox.Color.GREEN);
        board[2][5] = new FruitBox(FruitBox.Color.GREEN);
        board[2][4] = new FruitBox(FruitBox.Color.GREEN);
        board[3][5] = new FruitBox(FruitBox.Color.GREEN);
        board[3][4] = new FruitBox(FruitBox.Color.GREEN);
        board[3][2] = new FruitBox(FruitBox.Color.GREEN);
        board[3][1] = new FruitBox(FruitBox.Color.GREEN);
        board[3][0] = new FruitBox(FruitBox.Color.GREEN);
        board[4][6] = new FruitBox(FruitBox.Color.GREEN);
        board[4][4] = new FruitBox(FruitBox.Color.GREEN);
        board[5][6] = new FruitBox(FruitBox.Color.GREEN);
        board[5][4] = new FruitBox(FruitBox.Color.GREEN);
        board[5][2] = new FruitBox(FruitBox.Color.GREEN);
        board[5][1] = new FruitBox(FruitBox.Color.GREEN);
        board[6][2] = new FruitBox(FruitBox.Color.GREEN);
        board[6][1] = new FruitBox(FruitBox.Color.GREEN);
        board[6][5] = new FruitBox(FruitBox.Color.GREEN);
        board[7][4] = new FruitBox(FruitBox.Color.GREEN);
        board[7][2] = new FruitBox(FruitBox.Color.GREEN);
        board[7][1] = new FruitBox(FruitBox.Color.GREEN);

        return board;

    }

    // Show the player how to use rockets
    private Box[][] initBoard5() {
        Box[][] board = new Box[9][9];
//        pizzas = 6;
//        bonuses = 1;
        board[0][7] = new ObstacleBox();
        board[1][7] = new ObstacleBox();
        board[2][7] = new ObstacleBox();
        board[3][7] = new ObstacleBox();
        board[3][7] = new ObstacleBox();
        board[3][6] = new ObstacleBox();
        board[3][5] = new ObstacleBox();
        board[3][4] = new ObstacleBox();
        board[3][3] = new ObstacleBox();
        board[3][2] = new ObstacleBox();
        board[3][1] = new ObstacleBox();
        board[4][1] = new ObstacleBox();
        board[4][3] = new ObstacleBox();
        board[5][1] = new ObstacleBox();
        board[5][3] = new ObstacleBox();
        board[6][1] = new ObstacleBox();
        board[6][3] = new ObstacleBox();
        board[7][1] = new ObstacleBox();
        board[7][3] = new ObstacleBox();
        board[8][1] = new ObstacleBox();
        board[8][3] = new ObstacleBox();
        board[0][6] = new FruitBox(FruitBox.Color.PINK);
        board[0][5] = new FruitBox(FruitBox.Color.PINK);
        board[1][2] = new FruitBox(FruitBox.Color.PINK);
        board[1][0] = new FruitBox(FruitBox.Color.PINK);
        board[2][1] = new FruitBox(FruitBox.Color.PINK);
        board[2][3] = new FruitBox(FruitBox.Color.PINK);
        board[2][4] = new FruitBox(FruitBox.Color.PINK);
        board[0][4] = new PizzaBox();
        board[1][3] = new PizzaBox();
        board[2][2] = new PizzaBox();
        board[2][6] = new PizzaBox();
        board[4][0] = new PizzaBox();
        board[6][0] = new PizzaBox();
        board[0][3] = new FruitBox(FruitBox.Color.YELLOW);
        board[0][2] = new FruitBox(FruitBox.Color.YELLOW);
        board[0][0] = new FruitBox(FruitBox.Color.YELLOW);
        board[1][6] = new FruitBox(FruitBox.Color.YELLOW);
        board[2][5] = new FruitBox(FruitBox.Color.YELLOW);
        board[3][0] = new FruitBox(FruitBox.Color.YELLOW);
        board[8][0] = new FruitBox(FruitBox.Color.YELLOW);
        board[0][1] = new FruitBox(FruitBox.Color.GREEN);
        board[1][1] = new FruitBox(FruitBox.Color.GREEN);
        board[1][4] = new FruitBox(FruitBox.Color.GREEN);
        board[1][5] = new FruitBox(FruitBox.Color.GREEN);
        board[2][0] = new FruitBox(FruitBox.Color.GREEN);
        board[5][0] = new FruitBox(FruitBox.Color.GREEN);
        board[7][0] = new FruitBox(FruitBox.Color.GREEN);
        board[2][8] = new FruitBox(FruitBox.Color.BLUE);
        board[4][6] = new FruitBox(FruitBox.Color.BLUE);
        board[5][6] = new FruitBox(FruitBox.Color.BLUE);
        board[5][8] = new FruitBox(FruitBox.Color.BLUE);
        board[6][7] = new FruitBox(FruitBox.Color.BLUE);
        board[6][6] = new FruitBox(FruitBox.Color.BLUE);
        board[7][4] = new FruitBox(FruitBox.Color.BLUE);
        board[7][6] = new FruitBox(FruitBox.Color.BLUE);
        board[8][5] = new FruitBox(FruitBox.Color.BLUE);
        board[8][6] = new FruitBox(FruitBox.Color.BLUE);
        board[8][4] = new FruitBox(FruitBox.Color.BLUE);
        board[8][7] = new FruitBox(FruitBox.Color.BLUE);
        board[0][8] = new FruitBox(FruitBox.Color.PINK);
        board[1][8] = new FruitBox(FruitBox.Color.PINK);
        board[3][8] = new FruitBox(FruitBox.Color.PINK);
        board[4][8] = new FruitBox(FruitBox.Color.PINK);
        board[4][7] = new FruitBox(FruitBox.Color.PINK);
        board[5][7] = new FruitBox(FruitBox.Color.PINK);
        board[6][8] = new FruitBox(FruitBox.Color.PINK);
        board[7][8] = new FruitBox(FruitBox.Color.PINK);
        board[7][7] = new FruitBox(FruitBox.Color.PINK);
        board[8][8] = new FruitBox(FruitBox.Color.PINK);

        return board;

    }

    private Box[][] initBoard4() {
        Box[][] board = new Box[8][5];
//        bonuses = 0;
//        pizzas = 2;
        for (int j = 0; j < board[0].length; j++) {
            for (int i = 0; i < board.length; i++) {
                board[i][j] = new FruitBox(FruitBox.Color.YELLOW);
            }
        }
        board[0][1] = new PizzaBox();
        board[0][2] = new PizzaBox();
        board[1][1] = new FruitBox(FruitBox.Color.BLUE);
        board[2][1] = new FruitBox(FruitBox.Color.GREEN);
        board[3][1] = new FruitBox(FruitBox.Color.BLUE);
        board[0][0] = new EmptyBox();
        board[1][0] = new EmptyBox();
        board[2][0] = new EmptyBox();
        board[3][0] = new EmptyBox();
        board[0][3] = new EmptyBox();
        board[1][3] = new EmptyBox();
        board[2][3] = new EmptyBox();
        board[3][3] = new EmptyBox();
        board[0][4] = new EmptyBox();
        board[1][4] = new EmptyBox();
        board[2][4] = new EmptyBox();
        board[3][4] = new EmptyBox();

        return board;

    }

    private Box[][] initBoard3() {
        Box[][] board = new Box[8][8];
//        pizzas = 4;
        board[0][7] = new PizzaBox();
        board[0][6] = new PizzaBox();
        board[0][5] = new PizzaBox();
        board[0][4] = new PizzaBox();
        board[1][7] = new FruitBox(FruitBox.Color.RED);
        board[2][7] = new FruitBox(FruitBox.Color.RED);
        board[4][5] = new FruitBox(FruitBox.Color.RED);
        board[5][5] = new FruitBox(FruitBox.Color.RED);
        board[3][5] = new FruitBox(FruitBox.Color.RED);
        board[2][3] = new FruitBox(FruitBox.Color.RED);
        board[3][3] = new FruitBox(FruitBox.Color.RED);
        board[5][0] = new FruitBox(FruitBox.Color.RED);
        board[7][0] = new FruitBox(FruitBox.Color.RED);
        board[6][1] = new FruitBox(FruitBox.Color.RED);
        board[7][1] = new FruitBox(FruitBox.Color.RED);
        board[5][2] = new FruitBox(FruitBox.Color.RED);
        board[4][2] = new FruitBox(FruitBox.Color.RED);
        board[7][3] = new FruitBox(FruitBox.Color.RED);
        board[6][3] = new FruitBox(FruitBox.Color.RED);
        board[6][0] = new FruitBox(FruitBox.Color.RED);
        board[4][0] = new FruitBox(FruitBox.Color.RED);
        board[1][6] = new FruitBox(FruitBox.Color.GREEN);
        board[2][6] = new FruitBox(FruitBox.Color.GREEN);
        board[1][4] = new FruitBox(FruitBox.Color.GREEN);
        board[1][3] = new FruitBox(FruitBox.Color.GREEN);
        board[2][4] = new FruitBox(FruitBox.Color.GREEN);
        board[2][2] = new FruitBox(FruitBox.Color.GREEN);
        board[3][1] = new FruitBox(FruitBox.Color.GREEN);
        board[3][2] = new FruitBox(FruitBox.Color.GREEN);
        board[5][4] = new FruitBox(FruitBox.Color.GREEN);
        board[6][4] = new FruitBox(FruitBox.Color.GREEN);
        board[6][2] = new FruitBox(FruitBox.Color.GREEN);
        board[7][0] = new FruitBox(FruitBox.Color.GREEN);
        board[7][2] = new FruitBox(FruitBox.Color.GREEN);
        board[1][5] = new FruitBox(FruitBox.Color.YELLOW);
        board[2][5] = new FruitBox(FruitBox.Color.YELLOW);
        board[3][7] = new FruitBox(FruitBox.Color.YELLOW);
        board[3][6] = new FruitBox(FruitBox.Color.YELLOW);
        board[3][4] = new FruitBox(FruitBox.Color.YELLOW);
        board[4][6] = new FruitBox(FruitBox.Color.YELLOW);
        board[4][4] = new FruitBox(FruitBox.Color.YELLOW);
        board[4][3] = new FruitBox(FruitBox.Color.YELLOW);
        board[4][1] = new FruitBox(FruitBox.Color.YELLOW);
        board[5][3] = new FruitBox(FruitBox.Color.YELLOW);
        board[5][1] = new FruitBox(FruitBox.Color.YELLOW);
        board[5][0] = new FruitBox(FruitBox.Color.YELLOW);

        board[7][7] = new ObstacleBox();
        board[7][6] = new ObstacleBox();
        board[7][5] = new ObstacleBox();
        board[7][4] = new ObstacleBox();
        board[6][7] = new ObstacleBox();
        board[6][6] = new ObstacleBox();
        board[6][5] = new ObstacleBox();
        board[5][7] = new ObstacleBox();
        board[5][6] = new ObstacleBox();
        board[4][7] = new ObstacleBox();

        return board;

    }

    private Box[][] initBoard2() {
        Box[][] board = new Box[9][7];
//        pizzas = 3;
        board[0][2] = new PizzaBox();
        board[0][4] = new PizzaBox();
        board[0][6] = new PizzaBox();

        board[1][2] = new FruitBox(FruitBox.Color.PINK);
        board[2][2] = new FruitBox(FruitBox.Color.PINK);

        board[1][3] = new FruitBox(FruitBox.Color.YELLOW);
        board[2][3] = new FruitBox(FruitBox.Color.YELLOW);

        board[1][4] = new FruitBox(FruitBox.Color.GREEN);
        board[2][4] = new FruitBox(FruitBox.Color.GREEN);

        board[1][5] = new FruitBox(FruitBox.Color.YELLOW);
        board[2][5] = new FruitBox(FruitBox.Color.YELLOW);

        board[1][6] = new FruitBox(FruitBox.Color.GREEN);
        board[2][6] = new FruitBox(FruitBox.Color.GREEN);

        board[3][2] = new FruitBox(FruitBox.Color.YELLOW);
        board[4][2] = new FruitBox(FruitBox.Color.YELLOW);

        board[3][3] = new FruitBox(FruitBox.Color.GREEN);
        board[4][3] = new FruitBox(FruitBox.Color.GREEN);

        board[3][4] = new ObstacleBox();
        board[4][4] = new ObstacleBox();

        board[3][5] = new FruitBox(FruitBox.Color.YELLOW);
        board[4][5] = new FruitBox(FruitBox.Color.YELLOW);

        board[3][6] = new FruitBox(FruitBox.Color.PINK);
        board[4][6] = new FruitBox(FruitBox.Color.PINK);

        board[4][0] = new FruitBox(FruitBox.Color.GREEN);
        board[4][1] = new FruitBox(FruitBox.Color.GREEN);

        board[5][0] = new FruitBox(FruitBox.Color.GREEN);
        board[6][0] = new FruitBox(FruitBox.Color.YELLOW);

        board[5][1] = new FruitBox(FruitBox.Color.PINK);
        board[6][1] = new FruitBox(FruitBox.Color.PINK);

        board[5][2] = new FruitBox(FruitBox.Color.GREEN);
        board[6][2] = new FruitBox(FruitBox.Color.GREEN);

        board[5][3] = new FruitBox(FruitBox.Color.PINK);
        board[6][3] = new FruitBox(FruitBox.Color.PINK);

        board[5][4] = new FruitBox(FruitBox.Color.GREEN);
        board[6][4] = new FruitBox(FruitBox.Color.GREEN);

        board[5][5] = new FruitBox(FruitBox.Color.PINK);
        board[6][5] = new FruitBox(FruitBox.Color.PINK);

        board[5][6] = new FruitBox(FruitBox.Color.GREEN);
        board[6][6] = new FruitBox(FruitBox.Color.GREEN);

        board[7][0] = new FruitBox(FruitBox.Color.GREEN);
        board[8][0] = new FruitBox(FruitBox.Color.GREEN);

        board[7][1] = new FruitBox(FruitBox.Color.YELLOW);
        board[8][1] = new FruitBox(FruitBox.Color.YELLOW);
        board[7][2] = new FruitBox(FruitBox.Color.YELLOW);
        board[8][2] = new FruitBox(FruitBox.Color.YELLOW);

        board[7][3] = new FruitBox(FruitBox.Color.GREEN);
        board[8][3] = new FruitBox(FruitBox.Color.GREEN);

        board[7][4] = new FruitBox(FruitBox.Color.YELLOW);
        board[8][4] = new FruitBox(FruitBox.Color.YELLOW);

        board[7][5] = new ObstacleBox();
        board[8][5] = new ObstacleBox();
        board[7][6] = new ObstacleBox();
        board[8][6] = new ObstacleBox();

        return board;

    }

    private Box[][] initBoard1() {
        Box[][] board = new Box[8][5];
//        pizzas = 5;
        board[0][2] = new PizzaBox();
        board[1][2] = new PizzaBox();
        board[2][2] = new PizzaBox();
        board[1][0] = new PizzaBox();
        board[1][4] = new PizzaBox();

        board[0][1] = new FruitBox(FruitBox.Color.PINK);
        board[1][1] = new FruitBox(FruitBox.Color.PINK);

        board[0][3] = new FruitBox(FruitBox.Color.PINK);
        board[1][3] = new FruitBox(FruitBox.Color.PINK);

        board[2][0] = new FruitBox(FruitBox.Color.YELLOW);
        board[3][0] = new FruitBox(FruitBox.Color.YELLOW);

        board[2][1] = new FruitBox(FruitBox.Color.BLUE);
        board[3][1] = new FruitBox(FruitBox.Color.BLUE);

        board[2][3] = new FruitBox(FruitBox.Color.BLUE);
        board[3][3] = new FruitBox(FruitBox.Color.BLUE);

        board[2][4] = new FruitBox(FruitBox.Color.YELLOW);
        board[3][4] = new FruitBox(FruitBox.Color.YELLOW);

        for (int i = 3; i < board.length; i++)
            board[i][2] = new FruitBox(FruitBox.Color.YELLOW);

        board[4][0] = new FruitBox(FruitBox.Color.BLUE);
        board[5][0] = new FruitBox(FruitBox.Color.BLUE);

        board[4][1] = new FruitBox(FruitBox.Color.PINK);
        board[5][1] = new FruitBox(FruitBox.Color.PINK);

        board[4][3] = new FruitBox(FruitBox.Color.PINK);
        board[5][3] = new FruitBox(FruitBox.Color.PINK);

        board[4][4] = new FruitBox(FruitBox.Color.BLUE);
        board[5][4] = new FruitBox(FruitBox.Color.BLUE);

        board[6][0] = new FruitBox(FruitBox.Color.PINK);
        board[7][0] = new FruitBox(FruitBox.Color.PINK);

        board[6][1] = new FruitBox(FruitBox.Color.BLUE);
        board[7][1] = new FruitBox(FruitBox.Color.BLUE);

        board[6][3] = new FruitBox(FruitBox.Color.BLUE);
        board[7][3] = new FruitBox(FruitBox.Color.BLUE);

        board[6][4] = new FruitBox(FruitBox.Color.PINK);
        board[7][4] = new FruitBox(FruitBox.Color.PINK);
        return board;

    }

    private Box[][] initBoard0() {
//        board = new GameBoard(7, 7);
        Box[][] board = new Box[7][7];
//        pizzas = 2;

        board[0][1] = new PizzaBox();
        board[0][5] = new PizzaBox();

        board[1][1] = new FruitBox(FruitBox.Color.PINK);
        board[1][0] = new FruitBox(FruitBox.Color.PINK);
        board[2][0] = new FruitBox(FruitBox.Color.PINK);
        board[2][1] = new FruitBox(FruitBox.Color.PINK);

        for (int i = 2; i < 5; i++) {
            board[1][i] = new FruitBox(FruitBox.Color.GREEN);
        }
        board[1][5] = new FruitBox(FruitBox.Color.YELLOW);
        board[2][5] = new FruitBox(FruitBox.Color.YELLOW);
        board[1][6] = new FruitBox(FruitBox.Color.YELLOW);
        board[2][6] = new FruitBox(FruitBox.Color.YELLOW);

        for (int i = 2; i < 5; i++)
            for (int j = 2; j < 5; j++)
                board[i][j] = new FruitBox(FruitBox.Color.RED);

        board[3][0] = new FruitBox(FruitBox.Color.GREEN);
        board[4][0] = new FruitBox(FruitBox.Color.GREEN);
        board[3][1] = new FruitBox(FruitBox.Color.GREEN);
        board[4][1] = new FruitBox(FruitBox.Color.GREEN);

        board[3][5] = new FruitBox(FruitBox.Color.BLUE);
        board[3][6] = new FruitBox(FruitBox.Color.BLUE);
        board[4][5] = new FruitBox(FruitBox.Color.BLUE);
        board[4][6] = new FruitBox(FruitBox.Color.BLUE);

        board[5][0] = new FruitBox(FruitBox.Color.PINK);
        board[6][0] = new FruitBox(FruitBox.Color.PINK);

        board[5][1] = new FruitBox(FruitBox.Color.YELLOW);
        board[5][2] = new FruitBox(FruitBox.Color.YELLOW);
        board[6][1] = new FruitBox(FruitBox.Color.YELLOW);
        board[6][2] = new FruitBox(FruitBox.Color.YELLOW);

        board[5][3] = new FruitBox(FruitBox.Color.GREEN);
        board[6][3] = new FruitBox(FruitBox.Color.GREEN);

        board[5][4] = new FruitBox(FruitBox.Color.PINK);
        board[6][4] = new FruitBox(FruitBox.Color.PINK);
        board[5][5] = new FruitBox(FruitBox.Color.PINK);
        board[6][5] = new FruitBox(FruitBox.Color.PINK);

        board[5][6] = new FruitBox(FruitBox.Color.GREEN);
        board[6][6] = new FruitBox(FruitBox.Color.GREEN);
        return board;
    }
}
