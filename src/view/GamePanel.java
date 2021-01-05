package view;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import controller.Game;
import media.Colors;
import media.Fonts;
import media.Images;
import media.Sounds;
import model.*;
import model.boxes.Animatable;

public class GamePanel extends JPanel {

    private final Dimension dim;
    private GameBoard gameBoard;
    private final Player player;
    private boolean rocketChosen, rocketReady, rocketFired;
    private int x, y;
    private static int startX, startY;
    private final static int BOX_WIDTH = 60;
    private final MainPanel mainPanel;
    private Game game;
    private JButton botPlay;

    public GamePanel(MainPanel mainPanel, Game game) {
        super();
        this.dim = mainPanel.getDim();
        this.mainPanel = mainPanel;
        this.game = game;
        this.player = game.getPlayer();
        gameBoard = game.getBoard();
        init();

    }

    private void init() {
        this.setLayout(null);
        this.setSize(dim);
        this.setOpaque(false);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                x = (mouseEvent.getX() - startX) / BOX_WIDTH;
                y = (mouseEvent.getY() - startY) / BOX_WIDTH;
                if (!gameBoard.outOfRange(y, x) && gameBoard.boxHasReachedTarget(y, x)) // to avoid deleting a fruit that hasn't reached its target
                    gameBoard.emptyPack(y, x);


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

        botPlay = new JButton("PlayBot", Images.getSmallWoodIcon());
        botPlay.setContentAreaFilled(false);
        Border emptyBorder = BorderFactory.createEmptyBorder();
        botPlay.setBorder(emptyBorder);
        botPlay.setHorizontalTextPosition(SwingConstants.CENTER);
        botPlay.setVerticalTextPosition(SwingConstants.CENTER);
        botPlay.setFont(Fonts.getBlueberrySmallFont());
        botPlay.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                botPlay.setForeground(Color.BLACK);
                game.setBotMode(true);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                botPlay.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                botPlay.setForeground(Colors.B_GRAY);
            }
        });

        botPlay.setBounds(500, 20, 120, 120);
        this.add(botPlay);
        initOptionBar();
    }

    private void drawRocket() {
        JButton rocket = new JButton("rocket");
        if (rocketReady) {
            rocket.setIcon(Images.getRocketReady());

        }

    }

    public void showOptionWindow(boolean hasWon) {
        if (hasWon) {
            try {
                if (Sounds.musicOn)
                    Sounds.playWonSound();
            } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
            String[] options = {"Next level", "Retry"};
            int option = JOptionPane.showOptionDialog(null, "Level " + " completed ! What do you want to do ?",
                    "Finished level", 0, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (option == 0) {
                mainPanel.removeAll();
                if (game.getPlayer().getLastLevel() == game.getLevel().getNumber()) {
                    game.getPlayer().setLastLevel(game.getPlayer().getLastLevel() + 1);
//                game.serializePlayerData();
                }
                game = new Game(mainPanel, gameBoard.getLevelNumber() + 1, game.getPlayer());
                gameBoard = game.getBoard();
                mainPanel.repaint();
                mainPanel.revalidate();
            }
            if (option == 1) {
                mainPanel.removeAll();
                game = new Game(mainPanel, gameBoard.getLevelNumber(), game.getPlayer());
                gameBoard = game.getBoard();
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        } else {
            repaint();
            revalidate();

            String[] options = {"Yes!", "No"};
            int option = JOptionPane.showOptionDialog(null, "You have lost. Do you want to try again?",
                    "Lost", 0, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            if (option == 0) {
                mainPanel.removeAll();
                game = new Game(mainPanel, gameBoard.getLevelNumber(), game.getPlayer());
                gameBoard = game.getBoard();
            } else {
                game.serializePlayerData();
                mainPanel.removeAll();
                mainPanel.add(new LevelsPanel(mainPanel, player));
            }
            mainPanel.repaint();
            mainPanel.revalidate();
        }
        game.serializePlayerData();
    }

    private void initOptionBar() {
        OptionPanel op = new OptionPanel();
        op.setBounds(0, 0, 250, 250);
        op.setVisible(true);
        op.getBackButton().addActionListener(actionEvent -> {
            String[] options = {"Yes!", "Cancel"};
            int option = JOptionPane.showOptionDialog(null, "Are you sure you want to exit? Your game will be saved.",
                    "Exit Game", 0, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (option == 0) {
                game.serializePlayerData();
                mainPanel.removeAll();
                mainPanel.add(new LevelsPanel(mainPanel, player));
                mainPanel.repaint();
                mainPanel.revalidate();
            }

        });
        this.add(op);
    }

    @Override
    protected void paintComponent(Graphics g) {


        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        startX = (dim.width - gameBoard.getWidth() * BOX_WIDTH) / 2;
        startY = (dim.height - gameBoard.getHeight() * BOX_WIDTH) / 2;
        g2.drawImage(Images.getWoodImage(), 30, dim.height - 180, null);
        g2.setFont(Fonts.getCevicheFont());
        String score = "Score: " + player.getScore();
        g2.drawString(score, 70, dim.height - 130);
        g2.drawString("Life: " + player.getLife(), 300, dim.height - 130);
        g2.setColor(new Color(125, 125, 125, 150));
        g2.fillRoundRect(startX - 15, startY - 15, gameBoard.getWidth() * BOX_WIDTH + 30,
                gameBoard.getHeight() * BOX_WIDTH + 30, 100, 100);

        for (int i = 0; i < gameBoard.getBoard().length; i++) {
            for (int j = 0; j < gameBoard.getBoard()[0].length; j++) {
                Animatable anim = gameBoard.getBoard()[i][j];
                anim.paint(g2, startX, startY);
            }
        }
    }
}