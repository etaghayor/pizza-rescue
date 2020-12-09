package model;

public class EmptyBox extends Box implements Cloneable {

    @Override
    public BoxType getType() {
        return BoxType.EMPTY;
    }
}
