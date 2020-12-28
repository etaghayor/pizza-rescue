package model.boxes;

import java.awt.*;

public abstract class Animatable implements Cloneable {
    private double xSpeed, ySpeed;
    //    private Position pos, lastPos;
    private Image image;
    private double x, y, lastX, lastY;
    private boolean isMovable = true, isMoving = false;


    public void move(double time) {
        this.isMoving = xSpeed != 0 || ySpeed != 0;

        if (xSpeed != 0)
            moveHorizontal(time);
        else
            moveVertical(time);
    }

    private void moveHorizontal(double time) {
        if (isMovable) {
            this.lastX += (xSpeed * time);
            if (Math.abs(x - lastX) < 5) {
                this.lastX = x;
                xSpeed = 0;
            }
        }
    }

    private void moveVertical(double time) {
        if (isMovable) {

            this.lastY += (ySpeed * time);
            if (Math.abs(y - lastY) < 5) {
                this.lastY = y;
                ySpeed = 0;
            }
        }
    }


    public void paint(Graphics2D g2, int startX, int startY) {

        g2.drawImage(image, startX + (int) this.lastX, startY + (int) this.lastY, null);
//        System.out.println("x: " + pos.x + " y : " + pos.y);
    }

    public void setMovable(boolean movable) {
        isMovable = movable;
    }

    public void getCloseToTarget() {
//        isMoving = true;

        if (isMovable && (x != lastX || y != lastY)) {
            double distanceX = x - lastX;
            double distanceY = y - lastY;
            if (distanceX == 0)
                xSpeed = 0;
            else
                this.xSpeed = distanceX / Math.abs(distanceX) * 100;
            if (distanceY == 0)
                ySpeed = 0;
            else
                this.ySpeed = distanceY / Math.abs(distanceY) * 300;
        }
    }

    public boolean isMoving() {
        return isMoving;
    }

    public boolean reachedTarget() {
        if (xSpeed == 0 && ySpeed == 0 && isMoving) {
            isMoving = false;
            return true;
        }
        return false;
    }


    public void setImage(Image image) {
        this.image = image;
    }

    public double getLastX() {
        return lastX;
    }

    public double getLastY() {
        return lastY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setPos(double x, double y) {

        this.x = x;
        this.y = y;
    }

    public void setLastPos(double x, double y) {
        this.lastX = x;
        this.lastY = y;
    }

    @Override
    public Animatable clone() throws CloneNotSupportedException {
        return (Animatable) super.clone();
    }
}
