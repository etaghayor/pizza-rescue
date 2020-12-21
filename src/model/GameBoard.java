package model;

public class GameBoard {
	private Box[][] board;
	private int width, height;

	// TODO : MAIN METHODS: rearrange() and emptyPack()
	// TODO : FIRST, IMPLEMENT emptyBox();
	// should we have a type emptyBox or just work with null?
 
	public GameBoard(int w, int h) {
		board = new Box[w][h];
		//level = l;
		this.width = w;
		this.height = h;
	}

	public boolean outOfRange(int x, int y) {
		return x < 0 || x >= width || y < 0 || y >= height;
	}

	public Box getBox(int x, int y) {
//        try {
//            return board[x][y].clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        return null;
		return board[x][y];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void emptyBox(int x, int y) {
		board[x][y] = new EmptyBox();
	}

	public void emptyPack(int x, int y) {
		if (board[x][y].getType() != BoxType.FRUIT)
			return;
		FruitBox clickedBox = (FruitBox) board[x][y];
		int count = 1;
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (!outOfRange(i, j) && board[i][j].getType() == BoxType.FRUIT) {
					FruitBox box = (FruitBox) board[i][j];
					if (!(i == x && j == y) && box.getColor() == clickedBox.getColor())
						count++;
				}
			}
		}
		if (count < 2)
			return;
		emptyPackAux(x, y);
		rearrange();

	}

	private void emptyPackAux(int x, int y) {
		// EMPTY ALL BOXES IN A PACK WITH THE SAME COLOR AND REARANGE THE BOARD
		FruitBox clickedBox = null;
		try {
			clickedBox = (FruitBox) board[x][y].clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		emptyBox(x, y);

		if (!outOfRange(x + 1, y) && board[x + 1][y].getType() == BoxType.FRUIT) {
			FruitBox box = (FruitBox) board[x + 1][y];
			if (box.getColor() == clickedBox.getColor())
				emptyPackAux(x + 1, y);
		}
		if (!outOfRange(x - 1, y) && board[x - 1][y].getType() == BoxType.FRUIT) {
			FruitBox box = (FruitBox) board[x - 1][y];
			if (box.getColor() == clickedBox.getColor())
				emptyPackAux(x - 1, y);
		}
		if (!outOfRange(x, y + 1) && board[x][y + 1].getType() == BoxType.FRUIT) {
			FruitBox box = (FruitBox) board[x][y + 1];
			if (box.getColor() == clickedBox.getColor())
				emptyPackAux(x, y + 1);
		}
		if (!outOfRange(x, y - 1) && board[x][y - 1].getType() == BoxType.FRUIT) {
			FruitBox box = (FruitBox) board[x][y - 1];
			if (box.getColor() == clickedBox.getColor())
				emptyPackAux(x, y - 1);
		}
		if (!outOfRange(x - 1, y) && board[x - 1][y].getType() == BoxType.FRUIT) {
			FruitBox box = (FruitBox) board[x - 1][y];
			if (box.getColor() == clickedBox.getColor())
				emptyPackAux(x - 1, y);
		}

	}

	public void rearrange() {
		// THIS SHOULD MOVE THE BOXES SO THAT THERE'S NO EMPTY BOX LEFT

		// Vertical rearranging:
		for (int j = 0; j < height; j++) {
			for (int i = width - 1; i >= 0; i--) {
				int index = i;
				while (!outOfRange(index, j) && board[index][j].getType() == BoxType.EMPTY) {
					index--;
				}
				if (!outOfRange(index, j) && index != i)
					if (board[index][j].getType() == BoxType.PIZZA || board[index][j].getType() == BoxType.FRUIT) {
						board[i][j] = board[index][j];
						board[index][j] = new EmptyBox();
					}
			}

		}
		// TODO : Horizontal rearranging :
		
	}

	public void printBoard() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (board[i][j].getType() == BoxType.EMPTY)
					System.out.print("n ");
				else {
					FruitBox cb = (FruitBox) board[i][j];
					System.out.print(cb.getColor().toString().charAt(0) + " ");
				}
			}
			System.out.println();
		}
	}

	public void isPizzaDown() {
		// TODO check if a Pizza is reached down the board
	}

	public void hasWon() {
		// TODO
	}

	public void hasLost() {
		// TODO
	}

	public Box[][] getBoard() {
//        Box[][] copy = new Box[width][height];
//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < height; j++) {
//                try {
//                    copy[i][j] = board[i][j].clone();
//                } catch (CloneNotSupportedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return copy;
		return board;
	}

	public void reset() {
		// TODO : restart the level
	}
}
