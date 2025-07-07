package com.example.playground;
import java.util.ArrayList;

public class ArrayLists {
    public static void first_lesson() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Carl");
        names.add("Jimmy Neutron");
        names.add("That Yellow Dancing Banana From the Peanut Butter Jelly Song");
        System.out.println(names.get(0));

        names.remove("Carl");
        System.out.println(names.get(0));
        names.remove(0);
        System.out.println(names.get(0));
    }
    public static void main(String[] args) {
        first_lesson();
    }
}
