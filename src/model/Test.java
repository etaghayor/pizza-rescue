package model;

public class Test {
    static GameBoard board = new GameBoard(10, 10);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i % 2 == 1)
                    board.getBoard()[i][j] = new FruitBox(FruitBox.Color.ORANGE);
                else
                    board.getBoard()[i][j] = new FruitBox(FruitBox.Color.BLUE);
            }
        }
        board.emptyPack(5, 5);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board.getBox(i, j).getType() == BoxType.EMPTY)
                    System.out.print("n ");
                else {
                    FruitBox cb = (FruitBox) board.getBox(i, j);
                    System.out.print(cb.getColor().toString().charAt(0) + " ");
                }
            }
            System.out.println();
        }
    }

}
