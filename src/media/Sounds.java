package media;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Sounds {
    private static Clip mainSong;

    public static void playSong() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        if (mainSong == null) {
            File f = new File("resources/sounds/forest.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
            mainSong = AudioSystem.getClip();
            mainSong.open(audioIn);
        }
//        mainSong.start();
        mainSong.loop(100);
    }

    public static void stopSong() {
        if (mainSong != null) mainSong.stop();
    }
}
