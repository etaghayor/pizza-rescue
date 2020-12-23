package model;

public class Player {
    private String name;
    private GameBoard gameBoard;
    private int score, life, coin;

    public Player(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public int getLife() {
        return life;
    }

    public int getCoin() {
        return coin;
    }

    public String getName() {
        return name;
    }
}
