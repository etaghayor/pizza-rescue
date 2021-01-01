package model;

public class Player {
    private String name;
    private GameBoard gameBoard;
    private int score, life = 5, coin;
    private int lastLevel;

    public Player(String name) {
        this.name = name;
    }

    public Player() {
        super();
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

    public int getLastLevel() {
        return lastLevel;
    }

    public void updateScore(int s) {
        this.score += s;
    }

    public void updateLife(int l) {
        this.life += l;
    }
}
