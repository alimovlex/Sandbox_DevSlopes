package com.example.playground;

public class Triangle extends Shape {

    @Override
    public void calculateArea(int length, int width) {
        this.area = (length * width) / 2;
        printArea();
    }
}
