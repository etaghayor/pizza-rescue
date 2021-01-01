package controller;

import model.GameBoard;
import model.Level;
import model.Player;
import model.boxes.Animatable;
import model.boxes.Box;
import view.GamePanel;
import view.LevelsPanel;
import view.MainPanel;

public class Game {
    private final GamePanel gamePanel;
    private final Level level;
    private Box[][] board;
    private Thread thread;
    private final Player player;

    public Game(MainPanel mainPanel, LevelsPanel levelsPanel, int lNumber, Player player) {
        this.level = new Level(lNumber, this);
        if (player == null)
            this.player = new Player(); //TODO read from file
        else
            this.player = player;
        this.gamePanel = new GamePanel(mainPanel, levelsPanel, mainPanel.getDim(), this);
        mainPanel.add(gamePanel);

        initAnimationThread();
        thread.start();
    }

    synchronized private void initAnimationThread() {
        board = level.getGameBoard().getBoard();

        thread = new Thread(() -> {

            while (true) {
//                synchronized (board) {
//                    update:

                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[0].length; j++) {
                        Animatable anim = board[i][j];
                        anim.getCloseToTarget();
                        anim.move(0.013);
                    }
                }

//                }
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

    public GameBoard getBoard() {
        return level.getGameBoard();
    }

    public void deletePack() {

    }

    public Thread getThread() {
        return thread;
    }

    public Level getLevel() {
        return level;
    }

    public Player getPlayer() {
        return player;
    }


}
