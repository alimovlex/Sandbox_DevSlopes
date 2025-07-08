package com.example.playground;

public class Rectangle extends Shape {

    @Override
    public void calculateArea(int length, int width) {
        this.area = length * width;
        printArea();
    }
}
