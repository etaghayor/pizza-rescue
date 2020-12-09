package model;

public class ObstacleBox extends Box {


    public String toString() {
        return "Obstacle";
    }

    @Override
    public BoxType getType() {
        return BoxType.OBSTACLE;
    }
}
