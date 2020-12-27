package model;

import model.boxes.*;

import java.util.concurrent.TimeUnit;

public class GameBoard {
    private Box[][] board;
    private int height, width;
    private int savedPizza = 0;
    private Level level;

    // TODO : MAIN METHODS: rearrange() and emptyPack()
    // TODO : FIRST, IMPLEMENT emptyBox();
    // should we have a type emptyBox or just work with null?

    public GameBoard(int w, int h, Level l) {
        board = new Box[w][h];
        this.height = w;
        this.width = h;
        this.level = l;
    }

    public boolean outOfRange(int x, int y) {
        return x < 0 || x >= height || y < 0 || y >= width;
    }

    public Box getBox(int x, int y) {
//        try {
//            return board[x][y].clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        return null;
        return board[x][y];
    }

    public int getLevelNumber() {
        return level.getNumber();
    }

    public int getWidth() {
        return height;
    }

    public int getHeight() {
        return width;
    }

    public void emptyBox(int x, int y) {
        board[x][y] = new EmptyBox();
    }

    public void emptyPack(int x, int y) {
        if (board[x][y].getType() != BoxType.FRUIT)
            return;
        FruitBox clickedBox = (FruitBox) board[x][y];
        int count = 1;

        if (isDeletable(x + 1, y, clickedBox))
            count++;
        if (isDeletable(x - 1, y, clickedBox))
            count++;
        if (isDeletable(x, y + 1, clickedBox))
            count++;
        if (isDeletable(x, y - 1, clickedBox))
            count++;

        if (count < 2)
            return;
        emptyPackAux(x, y);
        rearrange();

    }

    private boolean isDeletable(int x, int y) {
        if (board[x][y].getType() != BoxType.FRUIT)
            return false;
        FruitBox clickedBox = (FruitBox) board[x][y];
        int count = 1;

        if (isDeletable(x + 1, y, clickedBox))
            count++;
        if (isDeletable(x - 1, y, clickedBox))
            count++;
        if (isDeletable(x, y + 1, clickedBox))
            count++;
        if (isDeletable(x, y - 1, clickedBox))
            count++;

        if (count < 2)
            return false;
        return true;
    }

    private void emptyPackAux(int x, int y) {

        // EMPTY ALL BOXES IN A PACK WITH THE SAME COLOR AND REARANGE THE BOARD
        FruitBox clickedBox = null;
        try {
            clickedBox = (FruitBox) board[x][y].clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        emptyBox(x, y);

        if (isDeletable(x + 1, y, clickedBox))
            emptyPackAux(x + 1, y);

        if (isDeletable(x - 1, y, clickedBox))
            emptyPackAux(x - 1, y);

        if (isDeletable(x, y + 1, clickedBox))
            emptyPackAux(x, y + 1);

        if (isDeletable(x, y - 1, clickedBox))
            emptyPackAux(x, y - 1);

    }

    private boolean isDeletable(int x, int y, FruitBox clickedBox) {
        if (!outOfRange(x, y) && board[x][y].getType() == BoxType.FRUIT) {
            FruitBox box = (FruitBox) board[x][y];
            return (box.getColor() == clickedBox.getColor());
        }
        return false;
    }

    // THIS SHOULD MOVE THE BOXES SO THAT THERE'S NO EMPTY BOX LEFT
    public void rearrange() {
        vertical_rearrange();
//        for (int i = 0; i < width - 1; i++) {
        horizontal_rearrange();
//        }
//
        // TODO Horizontal rearranging:

    }

    public void vertical_rearrange() {
        for (int j = 0; j < width; j++) {
            for (int i = height - 1; i >= 0; i--) {
                int index = i;
                while (!outOfRange(index, j) && board[index][j].getType() == BoxType.EMPTY) {
                    index--;
                }
                if (!outOfRange(index, j) && index != i)
                    if (board[index][j].getType() == BoxType.PIZZA || board[index][j].getType() == BoxType.FRUIT) {
                        board[i][j] = board[index][j];
                        board[index][j] = new EmptyBox();
                    }
            }
        }
        while (isPizzaDown()) {
//           TimeUnit.SECONDS.sleep(1);
            savePizza();
            rearrange();
        }
    }

    public void horizontal_rearrange() {
        boolean shouldMove, moved = false;
        for (int j = 1; j < width; j++) {
            shouldMove = false;
            for (int i = height - 1; i >= 0; i--) {
                while ((board[i][j] instanceof ObstacleBox /*|| i == height - 1*/)
                        && (board[i][j - 1] instanceof EmptyBox || board[i][j - 1] instanceof ObstacleBox)) {
                    i--;
                    shouldMove = true;
                }
                if (i == height - 1 && board[i][j - 1] instanceof EmptyBox)
                    shouldMove = true;
                if (shouldMove && (board[i][j] instanceof PizzaBox || board[i][j] instanceof FruitBox)) {
                    if (board[i][j - 1] instanceof EmptyBox) {
                        board[i][j - 1] = board[i][j];
                        board[i][j] = new EmptyBox();
                        moved = true;
                    } else
                        shouldMove = false;
                }
            }
            vertical_rearrange();
            if (moved && j > 1) {
                j -= 2;
                moved = false;
            }
        }
    }


    public void printBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j].getType() == BoxType.EMPTY)
                    System.out.print("n ");
                else {
                    FruitBox cb = (FruitBox) board[i][j];
                    System.out.print(cb.getColor().toString().charAt(0) + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean isPizzaDown() {
        for (int i = 0; i < getHeight(); i++) {
            if (board[getWidth() - 1][i] instanceof PizzaBox) {
                return true;
            }
        }
        return false;
    }

    public void savePizza() {
        for (int i = 0; i < getHeight(); i++) {
            if (board[getWidth() - 1][i] instanceof PizzaBox) {
                emptyBox(getWidth() - 1, i);
                savedPizza++;
            }
        }
    }

    public boolean hasWon() {
        return savedPizza >= level.getPizzas();
    }

    public boolean hasLost() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (isDeletable(i, j))
                    return false;
            }
        }
        return true;
    }

    public Box[][] getBoard() {
        return board;
    }
}