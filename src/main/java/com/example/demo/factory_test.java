package com.example.demo;

import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import org.junit.Test;

import static org.junit.Assert.*;

public class factory_test {

    @Test
    public void testCreateRectangle() {
        javafx.scene.shape.Shape shape = shapefactory.createShape("Rectangle");
        assertTrue(shape instanceof Rectangle);
    }

    @Test
    public void testCreateLine() {
        javafx.scene.shape.Shape shape = shapefactory.createShape("Line");
        assertTrue(shape instanceof Line);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidShapeType() {
        shapefactory.createShape("Circle");
    }
}