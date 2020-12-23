package model.boxes;

import model.boxes.Box;
import model.boxes.BoxType;

public class ObstacleBox extends Box {


    public String toString() {
        return "Obstacle";
    }

    @Override
    public BoxType getType() {
        return BoxType.OBSTACLE;
    }
}
