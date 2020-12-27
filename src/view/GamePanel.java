package view;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import media.Colors;
import media.Fonts;
import media.Images;
import media.Sounds;
import model.*;
import model.boxes.BoxType;
import model.boxes.FruitBox;

public class GamePanel extends JPanel {

    private Dimension dim;
    private GameBoard board;
    private int x, y;
    private static int startX, startY;
    private final static int BOX_WIDTH = 60;
    private JButton gearButton, musicButton, backButton;
    private boolean gearClicked = false, musicCLicked = false;

    // TODO It'd be nice if we pass mainPanel to this constructor, right now I just
    // get a new instance, it's not convenient
    public GamePanel(Dimension dim) {
        super();
        this.dim = dim;
        init();
        Level level = new Level(0);
        board = level.getBoard();
    }

    private void init() {
//        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setLayout(null);
        this.setSize(dim);
        this.setOpaque(false);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                x = (mouseEvent.getX() - startX) / BOX_WIDTH;
                y = (mouseEvent.getY() - startY) / BOX_WIDTH;
                board.emptyPack(y, x); // TODO We should change this kind of parameters I fucked up actually

//                while (board.isPizzaDown()) {
//                    board.savePizza();
//                }
                repaint();
                revalidate();
                if (board.hasWon()) {
                    String options[] = {"Next level", "Retry"};
                    int option = JOptionPane.showOptionDialog(null, "Level " + " completed ! What do you want to do ?",
                            "Finished level", 0, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                    if (option == 0)
                        board = new Level(board.getLevelNumber() + 1).getBoard();
                    if (option == 1)
                        board = new Level(board.getLevelNumber()).getBoard();

                    repaint();
                    revalidate();
                }
                if (board.hasLost()) {
                    repaint();
                    revalidate();
                    if (JOptionPane.showConfirmDialog(null, "You have lost, do you want to try again ?",
                            "Finished level", JOptionPane.YES_NO_OPTION) == 0) {
                        board = new Level(board.getLevelNumber()).getBoard();
                    }
                }
                repaint();
                revalidate();
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });

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
//        this.add(Box.createRigidArea(new Dimension(5, 40)));

        musicButton = makeButton("music");
        musicButton.setBounds(100, 30, 60, 60);
        musicButton.setVisible(false);
        musicButton.addActionListener(actionEvent -> {
            if (!musicCLicked) {
                Sounds.stopSong();
                musicButton.setIcon(Images.getMusicOffImage());
            } else {
                try {
                    Sounds.playSong();
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        startX = (dim.width - board.getHeight() * BOX_WIDTH) / 2;
        startY = (dim.height - board.getWidth() * BOX_WIDTH) / 2;
        g2.setColor(new Color(125, 125, 125, 150));
        g2.fillRoundRect(startX - 15, startY - 15, board.getHeight() * BOX_WIDTH + 30,
                board.getWidth() * BOX_WIDTH + 30, 100, 100);
        for (int j = 0; j < board.getHeight(); j++) {
            for (int i = 0; i < board.getWidth(); i++) {
                if (board.getBox(i, j) == null)
                    continue;
//                g2.fillRect(startX + j * BOX_WIDTH, startY + i * BOX_WIDTH, BOX_WIDTH, BOX_WIDTH);
                if (board.getBox(i, j).getType() == BoxType.PIZZA) {
                    g2.drawImage(Images.getPizzaImage(), startX + j * BOX_WIDTH, startY + i * BOX_WIDTH, null);
                }
                if (board.getBox(i, j).getType() == BoxType.OBSTACLE) {
                    g2.drawImage(Images.getObstacleImage(), startX + j * BOX_WIDTH, startY + i * BOX_WIDTH, null);
                }
                if (board.getBox(i, j).getType() == BoxType.FRUIT) {
                    FruitBox box = (FruitBox) board.getBox(i, j);
                    switch (box.getColor()) {
                        case RED -> g2.drawImage(Images.getRedBoxImage(), startX + j * BOX_WIDTH, startY + i * BOX_WIDTH,
                                null);
                        case BLUE -> g2.drawImage(Images.getBlueBoxImage(), startX + j * BOX_WIDTH, startY + i * BOX_WIDTH,
                                null);
                        case PINK -> g2.drawImage(Images.getPinkBoxImage(), startX + j * BOX_WIDTH, startY + i * BOX_WIDTH,
                                null);
                        case GREEN -> g2.drawImage(Images.getGreenBoxImage(), startX + j * BOX_WIDTH,
                                startY + i * BOX_WIDTH, null);
                        case ORANGE -> g2.drawImage(Images.getOrangeBoxImage(), startX + j * BOX_WIDTH,
                                startY + i * BOX_WIDTH, null);
                        case YELLOW -> g2.drawImage(Images.getYellowBoxImage(), startX + j * BOX_WIDTH,
                                startY + i * BOX_WIDTH, null);
                    }
                }
            }
        }
    }
}