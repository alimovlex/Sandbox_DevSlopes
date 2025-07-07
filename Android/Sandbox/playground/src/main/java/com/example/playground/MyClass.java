package com.example.playground;

public class MyClass {
    public static void main(String[] args) {
        printName();

        int len = 10, wid = 5, area = getArea(len, wid);
        printArea(len, wid);
        System.out.println("Area: " + area);
    }

    public static void printName() {
        System.out.println("Hi, my name is Enrique, but my friends call me Henry");
    }

    public static void printArea(int length, int width) {
        System.out.println("Area: " + (length * width));
    }

    public static int getArea(int length, int width) {
        return length * width;
    }
}
