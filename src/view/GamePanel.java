package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import media.Images;
import model.BoxType;
import model.FruitBox;
import model.GameBoard;
import model.PizzaBox;


public class GamePanel extends JPanel {

    private MainPanel mainPanel;
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
        initBoard1(); // ce methode c'est juste pour tester
        // en gros on doit passer un model a ce panel.
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

    private void initBoard1() {
        board = new GameBoard(6, 7);
        board.getBoard()[0][1] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[0][0] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[1][0] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[1][1] = new FruitBox(FruitBox.Color.PINK);

        for (int i = 2; i < 5; i++) {
            board.getBoard()[0][i] = new FruitBox(FruitBox.Color.GREEN);
        }
        board.getBoard()[0][5] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[1][5] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[0][6] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[1][6] = new FruitBox(FruitBox.Color.YELLOW);

        for (int i = 1; i < 4; i++)
            for (int j = 2; j < 5; j++)
                board.getBoard()[i][j] = new FruitBox(FruitBox.Color.RED);

        board.getBoard()[2][0] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[3][0] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[2][1] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[3][1] = new FruitBox(FruitBox.Color.GREEN);

        board.getBoard()[2][5] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[2][6] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[3][5] = new FruitBox(FruitBox.Color.BLUE);
        board.getBoard()[3][6] = new FruitBox(FruitBox.Color.BLUE);

        board.getBoard()[4][0] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[5][0] = new FruitBox(FruitBox.Color.PINK);

        board.getBoard()[4][1] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[4][2] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[5][1] = new FruitBox(FruitBox.Color.YELLOW);
        board.getBoard()[5][2] = new FruitBox(FruitBox.Color.YELLOW);

        board.getBoard()[4][3] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[5][3] = new FruitBox(FruitBox.Color.GREEN);

        board.getBoard()[4][4] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[5][4] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[4][5] = new FruitBox(FruitBox.Color.PINK);
        board.getBoard()[5][5] = new FruitBox(FruitBox.Color.PINK);

        board.getBoard()[4][6] = new FruitBox(FruitBox.Color.GREEN);
        board.getBoard()[5][6] = new FruitBox(FruitBox.Color.GREEN);

    }

    private void initBoard0() {
        board = new GameBoard(10, 10);

        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getHeight(); j++) {
                if (i % 2 == 1)
                    board.getBoard()[i][j] = new FruitBox(FruitBox.Color.ORANGE);
                else
                    board.getBoard()[i][j] = new FruitBox(FruitBox.Color.BLUE);
            }
        }
//        board.getBoard()[0][2] = new PizzaBox();
//        board.getBoard()[0][4] = new PizzaBox();
//        board.getBoard()[0][6] = new PizzaBox();
//        board.getBoard()[0][8] = new PizzaBox();
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
//                        case RED ->
//                            g2.drawImage(redBox, startX + j * BOX_WIDTH, startY + i * BOX_WIDTH, null);
//                        case BLUE ->
//                            g2.drawImage(blueBox, startX + j * BOX_WIDTH, startY + i * BOX_WIDTH, null);
//                        case PINK ->
//                            g2.drawImage(pinkBoxImage, startX + j * BOX_WIDTH, startY + i * BOX_WIDTH, null);
//                          
//                        case GREEN ->
//                            g2.drawImage(greenBoxImage, startX + j * BOX_WIDTH, startY + i * BOX_WIDTH, null);
//                            
//                        case ORANGE ->
//                            g2.drawImage(orangeBoxImage, startX + j * BOX_WIDTH, startY + i * BOX_WIDTH, null);
//                            
//                        case YELLOW ->
//                            g2.drawImage(yellowBox, startX + j * BOX_WIDTH, startY + i * BOX_WIDTH, null);
                            
                    }
                }
            }
        }
    }
}
