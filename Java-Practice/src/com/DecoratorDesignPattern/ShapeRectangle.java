package com.DecoratorDesignPattern;

public class ShapeRectangle implements Shape {

    // Overriding the method
    @Override public void draw()
    {
        System.out.println("Shape: Rectangle");
    }
}
