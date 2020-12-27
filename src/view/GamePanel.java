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
    private MainPanel mainPanel;
    private LevelsPanel levelsPanel;

    // TODO It'd be nice if we pass mainPanel to this constructor, right now I just
    // get a new instance, it's not convenient
    public GamePanel(MainPanel mainPanel, LevelsPanel levelsPanel, Dimension dim, int l) {
        super();
        this.dim = dim;
        this.mainPanel = mainPanel;
        this.levelsPanel = levelsPanel;
        init();
        System.out.println(l);
        Level level = new Level(l);
        board = level.getBoard();
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
                board.emptyPack(y, x); // TODO We should change this kind of parameters I fucked up actually

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