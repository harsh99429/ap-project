package com.example.demo;


public class data{
    private double obstacleMinX;
    private double obstacleMaxX;

    public double getObstacleMinX() {
        return obstacleMinX;
    }

    public void setObstacleMinX(double obstacleMinX) {
        this.obstacleMinX = obstacleMinX;
    }

    public double getObstacleMaxX() {
        return obstacleMaxX;
    }

    public void setObstacleMaxX(double obstacleMaxX) {
        this.obstacleMaxX = obstacleMaxX;
    }

    public double getStick() {
        return stick;
    }

    public void setStick(double stick) {
        this.stick = stick;
    }

    public double getInitialMinX() {
        return initialMinX;
    }

    public void setInitialMinX(double initialMinX) {
        this.initialMinX = initialMinX;
    }

    public double getInitialMaxX() {
        return initialMaxX;
    }

    public void setInitialMaxX(double initialMaxX) {
        this.initialMaxX = initialMaxX;
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

    public data(double obstacleMinX, double obstacleMaxX, double stick, double initialMinX, double initialMaxX, int cherry, int score) {
        this.obstacleMinX = obstacleMinX;
        this.obstacleMaxX = obstacleMaxX;
        this.stick = stick;
        this.initialMinX = initialMinX;
        this.initialMaxX = initialMaxX;
        this.cherry = cherry;
        this.score = score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private double stick;
    private double initialMinX;
    private double initialMaxX;
    private int cherry;
    private int score;

}