package model.boxes;

import media.Images;
import model.boxes.Box;
import model.boxes.BoxType;

public class PizzaBox extends Box {


    public PizzaBox() {
        this.setImage(Images.getPizzaImage());
    }

    public String toString() {
        return "PizzaBox";
    }

    @Override
    public BoxType getType() {
        return BoxType.PIZZA;
    }
}
