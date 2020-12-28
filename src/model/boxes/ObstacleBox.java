package model.boxes;

import media.Images;
import model.boxes.Box;
import model.boxes.BoxType;

import java.awt.*;

public class ObstacleBox extends Box {


    public String toString() {
        return "Obstacle";
    }

    public ObstacleBox() {
        this.setMovable(false);
        this.setImage(Images.getObstacleImage());
    }


    @Override
    public BoxType getType() {
        return BoxType.OBSTACLE;
    }
}
