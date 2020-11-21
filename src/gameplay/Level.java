package gameplay;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Level {
	private Box[][] board;
	
	public Level(Box[][] b) {
		board = b;
	}
	
	  public static Level Deserialize(String path) throws IllegalArgumentException {
	    Level l = null;
	    try {
	      FileInputStream fileIn = new FileInputStream(path);
	      ObjectInputStream in = new ObjectInputStream(fileIn);
	      l = (Level) in.readObject();
	      in.close();
	      fileIn.close();
	    } catch (IOException i) {
	      //throw new IllegalArgumentException(String.format("Couldn't read level at : %s", path), i);
	    } catch (ClassNotFoundException e) {
	      throw new IllegalArgumentException(
	          //"This litterally cannot happen. What have you done ???", e);
	    }

	    return l;
	  }

}
