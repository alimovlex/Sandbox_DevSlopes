package com.example.playground;

public class Vehicle {
    private String make;
    private String model;
    protected int horsepower;

    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public void accelerate() {
        System.out.println("Accelerating vehicle");
    }

    public void printDetails() {
        System.out.println("Make: " + this.make + " Model: " + this.model);
    }
}
