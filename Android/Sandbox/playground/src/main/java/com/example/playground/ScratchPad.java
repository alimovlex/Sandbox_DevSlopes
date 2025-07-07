package com.example.playground;

public class ScratchPad {
    public static void first_lesson() {
        String name = "John";
        int homeRuns = 55;
        float bankBalance = 100.44f;
        float finalBalance = bankBalance - 50;
        System.out.println(name + " has " + finalBalance + " in his account!\n");
    }

    public static void second_lesson() {
        String vehicle = "Truck";
        String make = "Chevy";
        String model = "Tahoe";

        String fullVehicleDetails = vehicle + " - " + make + " : " + model;
        System.out.println(fullVehicleDetails);

        String upper = "CRAZY BEAST!";
        String lower = upper.toLowerCase();
        System.out.println(lower);

        int accountBalance = 500;
        String printBalance = String.format("Your account balance is %d", accountBalance);
        System.out.println(printBalance);
    }
    public static void main(String[] args) {
        ScratchPad.first_lesson();
        ScratchPad.second_lesson();
    }
}