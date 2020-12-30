package model.boxes;

import java.io.Serializable;

public abstract class Box extends Animatable implements Cloneable, Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 8562337019128794835L;
    protected BoxType type;



    public abstract BoxType getType();

    @Override
    public Box clone() throws CloneNotSupportedException {
        return (Box) super.clone();
    }

}
