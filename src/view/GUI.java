package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import media.Images;
import media.Sounds;

public class GUI extends JFrame {
    private static final long serialVersionUID = 1L;


    public GUI() {
        init();

    }

    // Initialize the window and add the mainPanel to it
    private void init() {
        this.setTitle("Pizza Rescue Saga Game");
        Dimension dim = new Dimension(Images.getBackgroundImage().getWidth(null), Images.getBackgroundImage().getHeight(null));
        this.setPreferredSize(dim);
        this.setSize(dim);
        this.setUndecorated(true);
        this.setIconImage(((ImageIcon) Images.getAvocadoImage()).getImage());
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenDim.width / 2 - this.getSize().width / 2, screenDim.height / 2 - this.getSize().height / 2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        MainPanel mainPanel = new MainPanel(dim);
        this.getContentPane().add(mainPanel);
        this.pack();
        this.setResizable(false);
//        this.setVisible(true);
        try {
            Sounds.playMainSong();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }

    }
}

