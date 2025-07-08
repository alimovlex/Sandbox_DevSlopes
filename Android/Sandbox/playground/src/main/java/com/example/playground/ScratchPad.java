package com.example.playground;

public class ScratchPad {
    public static void first_lesson() {
        String name = "John";
        int homeRuns = 55;
        float bankBalance = 100.44f;
        float finalBalance = bankBalance - 50;
        System.out.println(name + " has " + finalBalance + " in his account!");
    }

    public static void second_lesson() {
        String vehicle = "Truck", make = "Chevy", model = "Tahoe";
        String fullVehicleDetails = vehicle + " - " + make + " : " + model;
        System.out.println(fullVehicleDetails);

        String upper = "CRAZY BEAST!";
        String lower = upper.toLowerCase();
        System.out.println(lower);

        int accountBalance = 500;
        String printBalance = String.format("Your account balance is %d", accountBalance);
        System.out.println(printBalance);
    }

    public static void third_lesson() {
        Person person = new Person("Jack", "Bauer", 45);
        person.speakName();

        Vehicle vehicle = new Vehicle("Honda", "Civic");
        vehicle.accelerate();

        Car car = new Car("Chevy", "Camaro");
        Bus bus = new Bus("Yellow", "Bus");

        car.accelerate();
        bus.accelerate();
        car.turnNOS();

        vehicle.printDetails();
        car.printDetails();
    }
    public static void main(String[] args) {
        first_lesson();
        second_lesson();
        third_lesson();
    }
}