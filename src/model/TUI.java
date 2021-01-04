package model;

import java.util.Scanner;

import controller.Game;

public class TUI {
	private Game game;
	private GameBoard  board;
	private Scanner sc;
	
	public TUI(){
		System.out.println("Pizza Rescue Saga Game in textual interface");
//		Level l1 = new Level(0, new Game(null, 1, new Player()));
//		board = new GameBoard();
//		board = new Level(board.getLevelNumber(), game).getGameBoard();
//		board = new GameBoard(new Level(0, null)) ;
		
	}
	private void setGame(Game game) {
		this.game = game;
	}
	public void setLevel(int optionValue) {
//		board.setLevel(optionValue);
		//TODO setLevel in GameBoard hasn't been written
	}
}
