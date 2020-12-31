package view;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import controleur.Game;
import media.Sounds;
import model.*;
import model.boxes.Animatable;

public class GamePanel extends JPanel {

    private Dimension dim;
    private GameBoard board;
    private int x, y;
    private static int startX, startY;
    private final static int BOX_WIDTH = 60;
    private MainPanel mainPanel;

    private LevelsPanel levelsPanel;

    // TODO It'd be nice if we pass mainPanel to this constructor, right now I just
    // get a new instance, it's not convenient
    public GamePanel(MainPanel mainPanel, LevelsPanel levelsPanel, Dimension dim, Level level) {
        super();
        this.dim = dim;
        this.mainPanel = mainPanel;
        this.levelsPanel = levelsPanel;
        init();
//        System.out.println(l);
        board = level.getGameBoard();
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
                if (!board.outOfRange(y, x) && board.fruitHasReachedTarget(y, x)) // to avoid deleting a fruit that hasn't reached its target
                    board.emptyPack(y, x);

                if (board.hasWon()) {
                    try {
                        Sounds.playWonSound();
                    } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                        e.printStackTrace();
                    }
                    String[] options = {"Next level", "Retry"};
                    int option = JOptionPane.showOptionDialog(null, "Level " + " completed ! What do you want to do ?",
                            "Finished level", 0, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                    if (option == 0) {
                        mainPanel.removeAll();
                        Game game = new Game(mainPanel, levelsPanel, board.getLevelNumber() + 1);
                        board = game.getBoard();
                        mainPanel.repaint();
                        mainPanel.revalidate();
                    }
                    if (option == 1) {
                        mainPanel.removeAll();
                        Game game = new Game(mainPanel, levelsPanel, board.getLevelNumber());
                        board = game.getBoard();
                        mainPanel.repaint();
                        mainPanel.revalidate();
                    }
                }
                if (board.hasLost()) {
                    repaint();
                    revalidate();
                    if (JOptionPane.showConfirmDialog(null, "You have lost, do you want to try again ?",
                            "Finished level", JOptionPane.YES_NO_OPTION) == 0) {
                        board = new Level(board.getLevelNumber()).getGameBoard();
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
        initOptionBar();
    }

    private void initOptionBar() {
        OptionPanel op = new OptionPanel();
        op.setBounds(0, 0, 250, 250);
        op.setVisible(true);
        op.getBackButton().addActionListener(actionEvent -> {
            mainPanel.removeAll();
            mainPanel.add(levelsPanel);
            mainPanel.repaint();
            mainPanel.revalidate();
        });
        this.add(op);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        startX = (dim.width - board.getWidth() * BOX_WIDTH) / 2;
        startY = (dim.height - board.getHeight() * BOX_WIDTH) / 2;
        g2.setColor(new Color(125, 125, 125, 150));
        g2.fillRoundRect(startX - 15, startY - 15, board.getWidth() * BOX_WIDTH + 30,
                board.getHeight() * BOX_WIDTH + 30, 100, 100);

        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard()[0].length; j++) {
                Animatable anim = board.getBoard()[i][j];
                anim.paint(g2, startX, startY);
            }
        }
    }
}