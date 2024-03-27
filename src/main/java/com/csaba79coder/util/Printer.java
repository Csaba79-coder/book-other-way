package com.csaba79coder.util;

import java.util.List;

public class Printer {

    // https://docs.oracle.com/javase/tutorial/java/generics/types.html
    // https://www.geeksforgeeks.org/generics-in-java/

    public static <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }

    private Printer() {

    }
}
