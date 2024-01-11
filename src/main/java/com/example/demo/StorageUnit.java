package com.example.demo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class StorageUnit {

    public int getStorageId() {
        return storageId;
    }

    public void setStorageId(int storageId) {
        this.storageId = storageId;
    }

    private int storageId;
    private double UserPositionX;
    private double UserPositionY;
    private int cherry;
    private int score;
    private Rectangle r;

    public double getUserPositionX() {
        return UserPositionX;
    }

    public void setUserPositionX(double userPositionX) {
        UserPositionX = userPositionX;
    }

    public double getUserPositionY() {
        return UserPositionY;
    }

    public void setUserPositionY(double userPositionY) {
        UserPositionY = userPositionY;
    }

    public int getCherry() {
        return cherry;
    }

    public void setCherry(int cherry) {
        this.cherry = cherry;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }




    public Rectangle createRectangle(double x, double y, double width, double height) {
        Rectangle rectangle = new Rectangle(x, y, width, height);
        rectangle.setFill(Color.BLACK);
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        r = rectangle;
    }

    public Rectangle getRectangle() {
        return r;
    }

}
