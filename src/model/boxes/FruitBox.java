package model.boxes;

import media.Images;
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
        switch (color) {
            case RED -> this.setImage(Images.getRedBoxImage());
            case BLUE -> this.setImage(Images.getBlueBoxImage());
            case PINK -> this.setImage(Images.getPinkBoxImage());
            case GREEN -> this.setImage(Images.getGreenBoxImage());
            case ORANGE -> this.setImage(Images.getOrangeBoxImage());
            case YELLOW -> this.setImage(Images.getYellowBoxImage());
        }
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
