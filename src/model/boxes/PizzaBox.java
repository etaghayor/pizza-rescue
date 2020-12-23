package model.boxes;

import model.boxes.Box;
import model.boxes.BoxType;

public class PizzaBox extends Box {

   

	public String toString() {
        return "PizzaBox";
    }

    @Override
    public BoxType getType() {
        return BoxType.PIZZA;
    }
}
