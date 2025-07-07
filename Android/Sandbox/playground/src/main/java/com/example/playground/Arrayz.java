package com.example.playground;

public class Arrayz {

    public static void arrayPrint(String[]... z) {
        for (String str[] : z) {           // for each loop
            for (String i : str) {
                System.out.println(i);
            }
        }
    }
    public static void first_lesson() {
        //Tom (plays baseball)
        int game1 = 250, game2 = 400, game3 = 600;
        String name1 = "John", name2 = "Jacob", name3 = "Jingle",
                name4 = "Heimer", name5 = "Smith",
        top5Cars[] = {"GTR", "Aston Martin", "Chevy Pinto", "Jaguar", "BMW"};
        int tomsAverages[] = new int[3];
        String names[] = new String[5];
        names[0] = name1;
        names[1] = name2;
        names[2] = name3;
        names[3] = name4;
        names[4] = name5;

        tomsAverages[0] = game1;
        tomsAverages[1] = game2;
        tomsAverages[2] = game3;
        System.out.println("Toms results: ");
        for (int game: tomsAverages) {
            System.out.println(game);
        }
        System.out.println("The list of names: ");
        arrayPrint(names);
        System.out.println("The list of cars: ");
        arrayPrint(top5Cars);

    }
    public static void main(String[] args) {
        first_lesson();
    }
}
