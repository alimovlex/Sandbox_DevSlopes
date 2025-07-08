package com.example.playground;

public class Car extends Vehicle {

    public Car(String make, String model) {
        super(make, model);
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerating the Car");
    }

    public void turnNOS() {
        this.horsepower += 100;
        System.out.println("Accelerated horsepower: " + horsepower);
    }
}
