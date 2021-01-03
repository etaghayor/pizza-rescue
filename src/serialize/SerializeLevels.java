package serialize;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.Level;

public class SerializeLevels {
    public static int num_file = 1;
    private LevelsResource serializable_levels;

    //TODO : after making sure that our both method to stock levels work
    //we should create a directory to stock them then not stock them in the
    //src
    public static void serialize(LevelsResource serializable_levels) {
        boolean allexist = true;
        for (int i = 0; i < 10; i++) {
            if (!(new File("Levels/level_" + i).exists()))
                allexist = false;
        }
        if (allexist)
            return;
        for (int i = 0; i < serializable_levels.getBoards().length; i++) {
            try (FileOutputStream fos = new FileOutputStream("Levels/level_" + num_file);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//                while(serializable_levels)
                oos.writeObject(serializable_levels.getBoards()[i]);
                System.out.println("The file " + "level_" + num_file + " has been serialize in Levels directory");
                num_file++;


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        LevelsResource levelsResource = new LevelsResource();
        serialize(levelsResource);
    }
}
