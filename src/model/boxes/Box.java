package model.boxes;

import java.io.Serializable;

public abstract class Box implements Cloneable, Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 8562337019128794835L;
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
    public Box clone() throws CloneNotSupportedException {
        return (Box) super.clone();
    }
}
