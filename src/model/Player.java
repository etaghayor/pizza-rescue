package model;

import model.boxes.Box;

import java.io.*;

public class Player implements Serializable {
    private int score, life = 5, coin;
    private int lastLevel = 1;


    public Player() {
        super();
        Player player = deserialize();
        if (player != null) {
            this.score = player.score;
            this.life = player.life;
            this.coin = player.coin;
            this.lastLevel = player.lastLevel;
        }
    }

    public static Player deserialize() {
        String path = "user/player_data";
        if (!(new File(path).exists())) {
            return null;
        }
//        Level deserializableLevel = null;
        Player deserializablePlayer = null;
        try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis)) {
            deserializablePlayer = (Player) ois.readObject();
            System.out.println("Player has been deserialize");
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
        return deserializablePlayer;
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


    public int getLastLevel() {
        return lastLevel;
    }

    public void setLastLevel(int lastLevel) {
        this.lastLevel = lastLevel;
    }

    public void updateScore(int s) {
        this.score += s;
    }

    public void updateLife(int l) {
        this.life += l;
    }
}
