package com.example.playground;

public class Bus extends Vehicle {

    public Bus(String make, String model) {
        super(make, model);
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerating the Bus");
    }
}
