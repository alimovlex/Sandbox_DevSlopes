package com.example.playground;

public class Conditionals {
    public static void first_lesson() {
        int accountBalance = 100;
        int itemPrice = 25;
        while (accountBalance >= itemPrice) {
            System.out.println("You have purchased the item!");
            accountBalance -= itemPrice;
        }
        System.out.println("You don't have enough money! Get a job!");
    }
    public static void main(String[] args) {
        first_lesson();
    }
}
