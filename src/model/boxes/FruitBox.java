package model.boxes;

import model.boxes.Box;
import model.boxes.BoxType;

public class FruitBox extends Box {

    /**
     *
     */
    private static final long serialVersionUID = 3331793081734295256L;

    public enum Color {
        YELLOW, ORANGE, RED, GREEN, BLUE, PINK
    }

    private Color color;

    public FruitBox(Color c) {
        this.color = c;
    }

    public void setColor(Color c) {
        color = c;
    }

    public Color getColor() {
        return this.color;
    }

    public String toString() {
        return "colorBox : " + this.getColor();
    }

    @Override
    public BoxType getType() {
        return BoxType.FRUIT;
    }

    @Override
    public Box clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
