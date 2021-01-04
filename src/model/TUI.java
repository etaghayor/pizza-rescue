package model;

import java.util.Scanner;

import controller.Game;

public class TUI {
    private Game game;
    private GameBoard board;
    private Scanner sc;
	
	public TUI(int level){
		Level l1 = new Level(level, null);
		board = l1.getGameBoard();
		System.out.println("Pizza Rescue Saga Game in textual interface");
		System.out.println("___________________________________________\n");
		initBoard();
//		System.out.println(board.getHeight());
    }
	private void initBoard(){
		System.out.println("******** Affichage du niveau "+board.getLevelNumber()+" ************\n");
		board.printBoard();
	}

   
}