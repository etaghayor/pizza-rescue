package model;

import media.Sounds;
import model.boxes.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameBoard {
    private final Box[][] board;
    private final int height;
    private final int width;
    private int savedPizza = 0;
    private int fruitCount = 0;
    private final Level level;
    private Player player;
    private static final int BOX_WIDTH = 60;

    // TODO : MAIN METHODS: rearrange() and emptyPack()
    // TODO : FIRST, IMPLEMENT emptyBox();
    // should we have a type emptyBox or just work with null?

    public GameBoard(int w, int h, Level l) {
        board = new Box[w][h];
        this.height = w;
        this.width = h;
        this.level = l;
//        initLocations();
    }

    public boolean outOfRange(int x, int y) {
        return x < 0 || x >= height || y < 0 || y >= width;
    }

    public Box getBox(int x, int y) {
        return board[x][y];
    }

    public void initLocations() {
        for (int j = 0; j < width; j++) {
            for (int i = 0; i < height; i++) {
                board[i][j].setPos(j * BOX_WIDTH, i * BOX_WIDTH);
                board[i][j].setLastPos(j * BOX_WIDTH, i * BOX_WIDTH);
            }
        }
    }

    public int getLevelNumber() {
        return level.getNumber();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public void emptyPack(int x, int y) {
        fruitCount = 0;
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

        try {
            if (Sounds.musicOn)
                Sounds.playPackRemovedSound();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        fruitCount = emptyPackAux(x, y, 1);
        player.updateScore((int) Math.min(Math.pow(2, fruitCount), 2000));
        rearrange();

    }


    private int emptyPackAux(int x, int y, int count) {

        // EMPTY ALL BOXES IN A PACK WITH THE SAME COLOR AND REARANGE THE BOARD
        FruitBox clickedBox = null;
        try {
            clickedBox = (FruitBox) board[x][y].clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        emptyBox(x, y);

        if (isDeletable(x + 1, y, clickedBox))
            count = emptyPackAux(x + 1, y, ++count);

        if (isDeletable(x - 1, y, clickedBox))
            count = emptyPackAux(x - 1, y, ++count);

        if (isDeletable(x, y + 1, clickedBox))
            count = emptyPackAux(x, y + 1, ++count);

        if (isDeletable(x, y - 1, clickedBox))
            count = emptyPackAux(x, y - 1, ++count);

        return count;
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

        return count >= 2;
    }

    private boolean isDeletable(int x, int y, FruitBox clickedBox) {
        if (!outOfRange(x, y) && board[x][y].getType() == BoxType.FRUIT) {
            FruitBox box = (FruitBox) board[x][y];
            return (box.getColor() == clickedBox.getColor());
        }
        return false;
    }


    public void emptyBox(int i, int j) {
        double xPos = board[i][j].getX();
        double yPos = board[i][j].getY();
        board[i][j] = new EmptyBox();
        board[i][j].setLastPos(xPos, yPos);
        board[i][j].setPos(xPos, yPos);
    }

    // THIS SHOULD MOVE THE BOXES SO THAT THERE'S NO EMPTY BOX LEFT
    public void rearrange() {
        vertical_rearrange();

//        for (int i = 0; i < width - 1; i++) {
        horizontal_rearrange();
//        vertical_rearrange();

        while (isPizzaDown()) {
            savePizza();
            rearrange();
        }
//        }
//
        // TODO Horizontal rearranging:

    }

    public void vertical_rearrange() {
        for (int j = 0; j < width; j++) {
            for (int i = height - 1; i >= 0; i--) {
//                System.out.println("* " + board[i][j].getPos().x + "<X +    y> " + board[i][j].getPos().y);

                int index = i;
                while (!outOfRange(index, j) && board[index][j].getType() == BoxType.EMPTY) {
                    index--;
                }
                if (!outOfRange(index, j) && index != i)
                    if (board[index][j].getType() == BoxType.PIZZA || board[index][j].getType() == BoxType.FRUIT) {
                        double x1 = board[index][j].getX();
                        double y1 = board[index][j].getY();
                        double x2 = board[i][j].getX();
                        double y2 = board[i][j].getY();


                        board[i][j] = board[index][j];
                        board[i][j].setLastPos(x1, y1);
                        board[i][j].setPos(x2, y2);

                        board[index][j] = new EmptyBox();
                        board[index][j].setPos(x1, y1);
                        board[index][j].setLastPos(x1, y1);
//                        emptyBox(index, j);
                    }
            }
        }

    }

    public void horizontal_rearrange() {
        boolean shouldMove, moved = false;
        for (int j = 1; j < width; j++) {
            shouldMove = false;
            for (int i = height - 1; i >= 0; i--) {
//                shouldMove = false;

                while ((board[i][j] instanceof ObstacleBox /*|| i == height - 1*/)
                        && (board[i][j - 1] instanceof EmptyBox || board[i][j - 1] instanceof ObstacleBox)) {
                    i--;
                    shouldMove = true;
                }
                if (i == height - 1 && board[i][j - 1] instanceof EmptyBox)
                    shouldMove = true;
                if (shouldMove && (board[i][j] instanceof PizzaBox || board[i][j] instanceof FruitBox)) {
                    if (board[i][j - 1] instanceof EmptyBox) {
                        double x1 = board[i][j].getX();
                        double y1 = board[i][j].getY();
                        double x2 = board[i][j - 1].getX();
                        double y2 = board[i][j - 1].getY();


                        board[i][j - 1] = board[i][j];
                        board[i][j - 1].setLastPos(x1, y1);
                        board[i][j - 1].setPos(x2, y2);


                        board[i][j] = new EmptyBox();
                        board[i][j].setPos(x1, y1);
                        board[i][j].setPos(x1, y1);
//                        emptyBox(i, j);

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

    public boolean boxHasReachedTarget(int i, int j) {
        return board[i][j].getXSpeed() == 0 && board[i][j].getYSpeed() == 0;
    }


    public boolean isPizzaDown() {
        for (int i = 0; i < getWidth(); i++) {
            if (board[getHeight() - 1][i] instanceof PizzaBox) {
                return true;
            }
        }
        return false;
    }

    public void savePizza() {
        for (int i = 0; i < getWidth(); i++) {
            if (board[getHeight() - 1][i] instanceof PizzaBox) {
                emptyBox(getHeight() - 1, i);
                savedPizza++;
            }
        }

    }

    public boolean hasWon() {
        return savedPizza >= level.getPizzas();
    }

    public boolean hasLost() {
        if (level.getBonuses() != 0) return false;
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

    long last = System.currentTimeMillis();

    public void botPlay() {
        int j = new Random().nextInt(width);
        int i = new Random().nextInt(height);
        long now = System.currentTimeMillis();
        if (board[i][j].getType() == BoxType.FRUIT && now - last > 50) {
            emptyPack(i, j);
            last = now;
//            botPlay();
        }
        if (!hasWon() && !hasWon()) {
//            synchronized (level.getGame().getThread()) { // TODO make this work
            try {
                wait(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            botPlay();
//            }
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

    public int getFruitCount() {
        return fruitCount;
    }

    public void setFruitCount(int fruitCount) {
        this.fruitCount = fruitCount;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}