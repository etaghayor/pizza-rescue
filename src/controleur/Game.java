package controleur;

import model.Level;
import model.boxes.Animatable;
import model.boxes.Box;
import model.boxes.EmptyBox;
import view.GamePanel;
import view.LevelsPanel;
import view.MainPanel;

public class Game {
    private GamePanel gamePanel;
    private MainPanel mainPanel;
    private LevelsPanel levelsPanel;
    private Level level;
    private Box[][] board;
    private Thread thread;

    public Game(MainPanel mainPanel, LevelsPanel levelsPanel, int lNumber) {
        this.level = new Level(lNumber);
        this.levelsPanel = levelsPanel;
        this.mainPanel = mainPanel;
        this.gamePanel = new GamePanel(mainPanel, levelsPanel, mainPanel.getDim(), level);
        mainPanel.add(gamePanel);
        initAnimationThread();
        thread.start();
    }

    synchronized private void initAnimationThread() {
        board = level.getGameBoard().getBoard();

        thread = new Thread(() -> {

            while (true) {
                synchronized (board) {
//                    update:

                    for (int i = 0; i < board.length; i++) {
                        for (int j = 0; j < board[0].length; j++) {
                            Animatable anim = board[i][j];
//                            System.out.print(board[i][j].getType() + " ");
//                            System.out.println("* " + anim.getPos().x + "<X +    y> " + board[i][j].getPos().y);
                            anim.getCloseToTarget();
                            anim.move(0.013);
                            if (anim.isMoving())
                                System.out.println("x " + anim.getLastX() + " y " + anim.getLastY());
//                            if (anim.reachedTarget()) {
//                                board[anim.getTargetI()][anim.getTargetJ()] = board[i][j];
//                                board[i][j] = new EmptyBox();
//                            }

                        }
//                        System.out.println();
                    }
//                    for (Animatable[] animLine : board)
//                        for (Animatable anim : animLine) {
//                            anim.move(0.007);
//                        }

                }
                gamePanel.repaint();
                gamePanel.revalidate();

                try {
                    Thread.sleep(7);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
