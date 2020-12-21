package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import media.Images;
import model.*;


public class GamePanel extends JPanel {

    private Dimension dim;
    private GameBoard board;
    private int x, y;
    private static int startX, startY;
    private final static int BOX_WIDTH = 60;


    // TODO It'd be nice if we pass mainPanel to this constructor, right now I just get a new instance, it's not convenient
    public GamePanel(Dimension dim) {
        super();
        this.dim = dim;
        init();
        Level level = new Level(0);
        board = level.getBoard();
    }


    private void init() {
        this.setLayout(null);
        this.setLayout(null);
        this.setSize(dim);
        this.setOpaque(false);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                x = (mouseEvent.getX() - startX) / BOX_WIDTH;
                y = (mouseEvent.getY() - startY) / BOX_WIDTH;
                board.emptyPack(y, x); // TODO We should change this kind of parameters I fucked up actually
                board.isPizzaDown();
                if (board.hasWon())
                    board = new Level(board.getLevelNumber() + 1).getBoard();
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
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Image redBox = Images.getRedBoxImage();
        Image blueBox = Images.getBlueBoxImage();
        Image yellowBox = Images.getYellowBoxImage();
        Image pinkBoxImage = Images.getPinkBoxImage();
        Image greenBoxImage = Images.getGreenBoxImage();
        Image orangeBoxImage = Images.getOrangeBoxImage();
        Image pizzaBoxImage = Images.getPizzaImage();
        startX = (dim.width - board.getHeight() * BOX_WIDTH) / 2;
        startY = (dim.height - board.getWidth() * BOX_WIDTH) / 2;
        g2.setColor(new Color(125, 125, 125, 150));
        g2.fillRoundRect(startX - 15, startY - 15, board.getHeight() * BOX_WIDTH + 30, board.getWidth() * BOX_WIDTH + 30, 100, 100);
        for (int j = 0; j < board.getHeight(); j++) {
            for (int i = 0; i < board.getWidth(); i++) {
                if (board.getBox(i, j) == null)
                    continue;
                if (board.getBox(i, j).getType() == BoxType.PIZZA) {
                    g2.drawImage(pizzaBoxImage, startX + j * BOX_WIDTH, startY + i * BOX_WIDTH, null);
                }
                if (board.getBox(i, j).getType() == BoxType.FRUIT) {
                    FruitBox box = (FruitBox) board.getBox(i, j);
                    switch (box.getColor()) {
                        case RED -> g2.drawImage(redBox, startX + j * BOX_WIDTH, startY + i * BOX_WIDTH, null);
                        case BLUE -> g2.drawImage(blueBox, startX + j * BOX_WIDTH, startY + i * BOX_WIDTH, null);
                        case PINK -> g2.drawImage(pinkBoxImage, startX + j * BOX_WIDTH, startY + i * BOX_WIDTH, null);
                        case GREEN -> g2.drawImage(greenBoxImage, startX + j * BOX_WIDTH, startY + i * BOX_WIDTH, null);
                        case ORANGE -> g2.drawImage(orangeBoxImage, startX + j * BOX_WIDTH, startY + i * BOX_WIDTH, null);
                        case YELLOW -> g2.drawImage(yellowBox, startX + j * BOX_WIDTH, startY + i * BOX_WIDTH, null);
                    }
                }
            }
        }
    }
}