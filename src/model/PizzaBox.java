package model;

public class PizzaBox extends Box {

   

	public String toString() {
        return "PizzaBox";
    }

    @Override
    public BoxType getType() {
        return BoxType.PIZZA;
    }
}
