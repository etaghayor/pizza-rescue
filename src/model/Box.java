package model;

public abstract class Box implements Cloneable {
    protected int x, y;
    protected BoxType type;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract BoxType getType();

    @Override
    protected Box clone() throws CloneNotSupportedException {
        return (Box) super.clone();
    }
}
