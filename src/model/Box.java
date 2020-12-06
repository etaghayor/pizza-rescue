package model;

public abstract class Box {
    private int x, y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getType() {
        if (this instanceof PetBox)
            return 'p';
        if (this instanceof ColorBox)
            return 'c';
        if (this instanceof Obstacle)
            return 'o';
        return 'x';
    }

    @Override
    protected Box clone() throws CloneNotSupportedException {
        return (Box) super.clone();
    }
}
