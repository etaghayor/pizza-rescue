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
        YELLOW(0), ORANGE(1), RED(2), GREEN(3), BLUE(4), PINK(5);
        int value;

        Color(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    private Color color;

    public FruitBox(Color c) {
        this.color = c;
        updateImage(c);
    }

    private void updateImage(Color color) {
        switch (color) {
            case RED -> this.setImage(Images.getRedBoxImage());
            case BLUE -> this.setImage(Images.getBlueBoxImage());
            case PINK -> this.setImage(Images.getPinkBoxImage());
            case GREEN -> this.setImage(Images.getGreenBoxImage());
            case ORANGE -> this.setImage(Images.getOrangeBoxImage());
            case YELLOW -> this.setImage(Images.getYellowBoxImage());
        }
    }

    public void setColor(int i) {
        int tmp = (i + this.color.getValue()) % 6;
        for (Color c : Color.values()) {
            if (c.getValue() == tmp) {
                this.color = c;
                updateImage(c);
                break;
            }
        }
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
