package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.TimerTask;

public class Player implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5440700875333587811L;
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
    	if(l<=5 && l>=0) {
        this.life = l;
    	}
    }
    
    public class Life extends TimerTask {

    	@Override
    	public void run() {
    	getPlayer().updateLife(getLife()+1);
    	System.out.println(getPlayer().getLife());
    	}
    	public Player getPlayer() {
    		   return Player.this;
    		}
    }

}
