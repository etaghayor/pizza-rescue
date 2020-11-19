package gameplay;

public class GameBoard {
    private Box[][] board;
    private int width, height;

    // TODO : MAIN METHODS: rearrange() and emptyPack()
    // TODO : FIRST, IMPLEMENT emptyBox();
    //  should we have a type emptyBox or just work with null?

    public GameBoard(int w, int h) {
        board = new Box[w][h];
        this.width = w;
        this.height = h;
    }

    public boolean outOfRange(int x, int y) {
        return x < 1 || x >= width || y < 1 || y >= height;
    }

    public Box getBox(int x, int y) {
        try {
            return board[x][y].clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean emptyBox(int x, int y) {
        return (board[x][y] == null);
    }

    public void emptyPack(int x, int y) {
        // BIGGEST METHOD I THINK
        // EMPTY ALL BOXES IN A PACK WITH THE SAME COLOR AND REARANGE THE BOARD
        // ACTAULLY, IT SHOULDN'T BE BIG SO WE NEED A METHOD REARRANGE()

        while (!outOfRange(x, y) && board[x][y].getType() == 'c') {
            //TODO
            x++;
        }
        while (!outOfRange(x, y) && board[x][y].getType() == 'c') {
            //TODO
            y++;
        }
    }

    public void rearrange() {
        // THIS SHOULD MOVE THE BOXES SO THAT THERE'S NO EMPTY BOC LEFT

        //TODO
    }


    public Box[][] getBoard() {
        Box[][] copy = new Box[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                try {
                    copy[i][j] = board[i][j].clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }
        return copy;
    }


}
