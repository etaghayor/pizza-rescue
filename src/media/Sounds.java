package media;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Sounds {
    private static Clip mainSong, packRemovedSound, wonSound;
    public static boolean musicOn = true;

    public static void playMainSong() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        if (mainSong == null) {
            File f = new File("resources/sounds/forest.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
            mainSong = AudioSystem.getClip();
            mainSong.open(audioIn);
        }
        mainSong.loop(100);
    }

    public static void stopAllSounds() {
        if (mainSong != null) mainSong.stop();
        musicOn = false;
    }

    public static void playPackRemovedSound() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        if (packRemovedSound == null) {
            File f = new File("resources/sounds/pack_removed.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
            packRemovedSound = AudioSystem.getClip();
            packRemovedSound.open(audioIn);
        }
        packRemovedSound.stop();
        packRemovedSound.setMicrosecondPosition(0);
        packRemovedSound.start();
        packRemovedSound.flush();
    }

    public static void playWonSound() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        if (wonSound == null) {
            File f = new File("resources/sounds/level_completed.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
            wonSound = AudioSystem.getClip();
            wonSound.open(audioIn);
        }
        wonSound.stop();
        wonSound.setMicrosecondPosition(0);
        wonSound.start();
        packRemovedSound.flush();
    }
}
