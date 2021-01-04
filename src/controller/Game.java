package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Timer;

import model.GameBoard;
import model.Level;
import model.Player;
import model.boxes.Animatable;
import model.boxes.Box;
import model.boxes.BoxType;
import view.GamePanel;
import view.MainPanel;

public class Game {
    private final GamePanel gamePanel;
    private final Level level;
    private Box[][] board;
    private GameBoard gameBoard;
    private Thread thread;
    private final Player player;
    private boolean botMode = false;
    private boolean allBoxesAreStill = true;
    boolean allBoxesReachedTarget;

    public Game(MainPanel mainPanel, int lNumber, Player player) {
        this.level = new Level(lNumber, this);
        this.gameBoard = level.getGameBoard();
        if (player == null) {
        	if (new File("user/player_data").exists()) 
        		this.player = Player.deserialize();
        	 else
        	this.player = new Player(); 
        }
        else {
        	this.player = player;
        	player.updateLife(player.getLife()-1);
        }
        this.gamePanel = new GamePanel(mainPanel, mainPanel.getDim(), this);
        mainPanel.add(gamePanel);

        initAnimationThread();
        thread.start();

    }

    synchronized private void initAnimationThread() {
        board = gameBoard.getBoard();
        System.out.println(player.getLife());
        
        thread = new Thread(() -> {
            while (true) {
//                synchronized (board) {
//                    update:

                allBoxesReachedTarget = true;
                allBoxesAreStill = true;
                for (Box[] boxes : board) {
                    for (int j = 0; j < board[0].length; j++) {
                        Animatable anim = boxes[j];
                        anim.getCloseToTarget();
                        if (botMode)
                            anim.move(0.0005);
                        else
                            anim.move(0.013);
                        if (anim.isMoving())
                            allBoxesAreStill = false;
                        if (!anim.reachedTarget()) {
                            allBoxesReachedTarget = false;
                        }
                    }
                }
                
                if (botMode && (allBoxesReachedTarget || allBoxesAreStill)) {
                    botPlay();
                }

                gamePanel.repaint();
                gamePanel.revalidate();

                if (gameBoard.hasWon()) {
                    gamePanel.showOptionWindow(true);
                    return;
                }
                if (gameBoard.hasLost()) {
                    gamePanel.showOptionWindow(false);
                    return;
                }
//                if (player.getLife() <=5) {
//                	Timer timer = new Timer();
//                	timer.schedule(player.new Life(), 5000, 5000);
//                	
//                } 
                try {
                    Thread.sleep(7);
                   
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                

            }
        });
    }

    public void botPlay() {
        int j = new Random().nextInt(gameBoard.getWidth());
        int i = new Random().nextInt(gameBoard.getHeight());
        while (board[i][j].getType() == BoxType.EMPTY) {
            j = new Random().nextInt(gameBoard.getWidth());
            i = new Random().nextInt(gameBoard.getHeight());
        }
        if (board[i][j].getType() == BoxType.FRUIT) {
            gameBoard.emptyPack(i, j);
        }
    }

    public GameBoard getBoard() {
        return level.getGameBoard();
    }

    public void deletePack() {

    }

    public void serializePlayerData() {
        File directory = new File("user");

        if (!directory.exists()) {
            directory.mkdir();
            System.out.println("user directory created");
        }
        try (FileOutputStream fos = new FileOutputStream("user/player_data");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(player);
            System.out.println("The file user/player_data has been serialized in user directory");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Level getLevel() {
        return level;
    }

    public void setBotMode(boolean mode) {
        botMode = mode;
    }

    public Player getPlayer() {
        return player;
    }


}
