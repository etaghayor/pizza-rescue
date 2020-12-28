package model.boxes;

import java.awt.*;

public abstract class Animatable {
    private double xSpeed, ySpeed, targetX, targetY;
    private Position pos, lastPos;
    private int targetI, targetJ;
    private Image image;
    private boolean isMovable = true, isMoving = false;


    public void move(double time) {
        //TODO        moveX, moveY
        if (isMovable) {

            this.lastPos.x += (xSpeed * time);
            this.lastPos.y += (ySpeed * time);
            if (Math.abs(pos.x - lastPos.x) < 10) {
                this.lastPos.x = this.pos.x;
                xSpeed = 0;
            }
            if (Math.abs(pos.y - lastPos.x) < 10) {
                this.lastPos.y = this.pos.y;
                ySpeed = 0;
            }
        }
    }


    public double getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void paint(Graphics2D g2, int startX, int startY) {

        g2.drawImage(image, startX + (int) this.lastPos.x, startY + (int) this.lastPos.y, null);
//        System.out.println("x: " + pos.x + " y : " + pos.y);
    }

    public void setMovable(boolean movable) {
        isMovable = movable;
    }

    public void getCloseToTarget() {
        isMoving = true;
//        this.targetI = i;
//        this.targetJ = j;
        if (isMovable && pos.x != lastPos.x && pos.y != lastPos.y) {

            double distanceX = this.pos.x - this.lastPos.x;
            double distanceY = this.pos.y - this.lastPos.y;
            double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

            this.xSpeed = distanceX / distance * 30;
            this.ySpeed = distanceY / distance * 30;
        }
    }


    public boolean reachedTarget() {
        if (xSpeed == 0 && ySpeed == 0 && isMoving) {
            isMoving = false;
            return true;
        }
        return false;
    }

    public double getTargetY() {
        return targetY;
    }

    public void setTargetY(double targetY) {
        this.targetY = targetY;
    }

    public double getTargetX() {
        return targetX;
    }

    public void setTargetX(double targetX) {
        this.targetX = targetX;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getTargetI() {
        return targetI;
    }

    public int getTargetJ() {
        return targetJ;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(double x, double y) {
        if (pos == null) {
            pos = new Position(x, y);
        } else {
            this.pos.x = x;
            this.pos.y = y;
        }
    }

    public void setLastPos(double x, double y) {
        if (lastPos == null) {
            lastPos = new Position(x, y);
        } else {
            this.lastPos.x = x;
            this.lastPos.y = y;
        }
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public Position getLastPos() {
        return lastPos;
    }

    public void setLastPos(Position lastPos) {
        this.lastPos = lastPos;
    }


    public class Position {
        public double x, y;

        Position(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
