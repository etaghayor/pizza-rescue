package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Level implements Serializable {
	private static final long serialVersionUID = -6578584791683082932L;
	private GameBoard board;
	private int pizzas;
	private int number;

	public Level(GameBoard b) {
		setBoard(b);
	}

	public Level(int l) {
		this.number = l;
		switch (l) {
		case 0 -> {
			initBoard0();
			pizzas = 4;
		}
		case 1 -> {
			initBoard1();
			pizzas = 5;
		}
		}
	}

	public GameBoard getBoard() {
		return board;
	}

	public void setBoard(GameBoard board) {
		this.board = board;
	}

	private void initBoard2() {
		board = new GameBoard(6, 7, this);
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

	private void initBoard1() {
		board = new GameBoard(6, 7, this);
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
		board = new GameBoard(11, 10, this);

		for (int i = 0; i < board.getWidth(); i++) {
			for (int j = 0; j < board.getHeight(); j++) {
				if (i == 0)
					if (j % 2 == 1 && j != 9)
						board.getBoard()[i][j] = new PizzaBox();
					else
						board.getBoard()[i][j] = new EmptyBox();
				else if (i % 2 == 1)
					board.getBoard()[i][j] = new FruitBox(FruitBox.Color.YELLOW);
				else
					board.getBoard()[i][j] = new FruitBox(FruitBox.Color.BLUE);
			}
		}
	}

	// We will create many levels and add each of them in different
	// files and the only thing we would have to do is recover the
	// level and deserialize it
	public static Level Deserialize2(String path) {
		Level deserializableLevel = null;
		try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis)) {
			deserializableLevel = (Level) ois.readObject();
			System.out.println("The level " + path.charAt(5) + " has been deserialize");
		} catch (FileNotFoundException e) {
			System.err.println("The file : " + path + " cannot be found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("The file : " + path + " cannot be read.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("The object class you have tried to deserialize doesn't exist");
			e.printStackTrace();
		}
		return deserializableLevel;
	}

	public int getPizzas() {
		return pizzas;
	}

	public int getNumber() {
		return number;
	}
}
