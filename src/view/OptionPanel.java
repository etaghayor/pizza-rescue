package view;

import media.Images;
import media.Sounds;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class OptionPanel extends JPanel {

    private JButton gearButton, musicButton, backButton;
    private boolean gearClicked = false;
    public static boolean musicCLicked = false;

    public OptionPanel() {
        super();
        init();
    }

    private void init() {
        this.setLayout(null);
        this.setOpaque(false);
        this.setBounds(0, 0, 250, 250);

        gearButton = makeButton("gear");
        gearButton.setBounds(30, 30, 60, 60);
        gearButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                gearClicked = !gearClicked;
                musicButton.setVisible(gearClicked);
                backButton.setVisible(gearClicked);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                gearButton.setBounds(33, 33, 60, 60);

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                gearButton.setBounds(30, 30, 60, 60);
            }
        });

        musicButton = makeButton("music");
        musicButton.setBounds(100, 30, 60, 60);
        musicButton.setVisible(false);
        if (musicCLicked)
            musicButton.setIcon(Images.getMusicOffImage());
        else
            musicButton.setIcon(Images.getMusicImage());
        musicButton.addActionListener(actionEvent -> {
            if (!musicCLicked) {
                Sounds.stopAllSounds();
                musicButton.setIcon(Images.getMusicOffImage());
            } else {
                try {
                    Sounds.playMainSong();
                    Sounds.musicOn = true;
                    musicButton.setIcon(Images.getMusicImage());
                } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                    e.printStackTrace();
                }

            }
            musicCLicked = !musicCLicked;

        });

        backButton = makeButton("back");
        backButton.setBounds(35, 100, 60, 60);
        backButton.setVisible(false);

        this.add(musicButton);
        this.add(backButton);
        this.add(gearButton);
    }


    private JButton makeButton(String name) {
        JButton b;
        switch (name) {
            case "gear" -> b = new JButton(Images.getGearImage());
            case "music" -> b = new JButton(Images.getMusicImage());
            default -> b = new JButton(Images.getBackImage());

        }
        b.setContentAreaFilled(false);
        Border emptyBorder = BorderFactory.createEmptyBorder();
        b.setBorder(emptyBorder);
        return b;
    }

    public JButton getBackButton() {
        return backButton;
    }

}
