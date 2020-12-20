package serialize_levels;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.FruitBox;
import model.Level;

public class Serialize {
	public static int num_file = 0;
	//TODO : after making sure that our both method to stock levels work 
		//we should create a directory to stock them then not stock them in the 
		//src
		public static void serialize(String path, Level serializable_level) {
			try(FileOutputStream fos = new FileOutputStream(path);
					ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(serializable_level);
				System.out.println("The file " + path + " has been serialize");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	public static void main(String[] args) {
	
	
	}
}
