package com.example.demo;

import javafx.scene.shape.Rectangle;

interface RectangleInterface {
    double calculateArea();

    double calculatePerimeter();
}


public class rectangle extends Rectangle implements RectangleInterface{
    private double width;
    private double height;

    public rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}

