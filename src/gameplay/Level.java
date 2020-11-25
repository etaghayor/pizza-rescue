package gameplay;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Level implements Serializable{
	private static final long serialVersionUID = -6578584791683082932L;
	private Box[][] board;
	private static int serializableFile = 0;
	
	public Level(Box[][] b) {
		setBoard(b);
	}	
	public Box[][] getBoard() {
		return board;
	}
	public void setBoard(Box[][] board) {
		this.board = board;
	}
	//TODO : after making sure that our both method to stock levels work 
	//we should create a directory to stock them then not stock them in the 
	//src
	public static String Serializable(Level serializable_level) {
		String path = "level"+ serializableFile + ".ser";
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(serializable_level);
			oos.close();
			fos.close();
			serializableFile++;
			return path;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	  //We will create many levels and add each of them in different
	  //files and the only thing we would have to do is recover the
	  //level and deserialize it
	  public static Level Deserialize2(String path) {
		  Level deserializableLevel = null;
		  try {
			  FileInputStream fis = new FileInputStream(path);
			  ObjectInputStream ois = new ObjectInputStream(fis);
			  deserializableLevel = (Level) ois.readObject();
			  ois.close();
			  fis.close();
		  } catch (FileNotFoundException e) {
			  System.err.println("The file : " + path +" cannot be found.");
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
}
