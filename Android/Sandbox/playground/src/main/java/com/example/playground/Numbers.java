package com.example.playground;

public class Numbers {
    public static void first_lesson() {
        int age = 25, myFavoriteSports = -50,
                sum = 5 + 5, num1 = 10, num2 = 12,
                difference = 100 - 20, product = 22 * 5,
                divide = 15 / 5, modulo = 20 % 3;
        float bankBalance = 432.23f;
        double thisIsADouble = 5678.3435;
        long donaldTrumpsBankAccount;
        Integer myInt = 550;
        String intStr = myInt.toString();

        System.out.println(sum);
        System.out.println(num1 + num2);
        System.out.println(difference);
        System.out.println(product);
        System.out.println(divide);
        System.out.println(modulo);
    }
    public static void main(String[] args) {
        Numbers.first_lesson();
    }
}
