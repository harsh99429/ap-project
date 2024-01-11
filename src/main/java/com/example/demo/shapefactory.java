package com.example.demo;

import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class shapefactory {
    // Factory method to create shapes based on input
    public static javafx.scene.shape.Shape createShape(String shapeType) {
        if ("Rectangle".equalsIgnoreCase(shapeType)) {
            return new Rectangle();
        } else if ("Line".equalsIgnoreCase(shapeType)) {
            return new Line();
        } else {
            throw new IllegalArgumentException("Invalid shape type: " + shapeType);
        }
    }

}