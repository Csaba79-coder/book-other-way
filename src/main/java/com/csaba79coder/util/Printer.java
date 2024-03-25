package com.csaba79coder.util;

import java.util.List;

public class Printer {

    public static <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }

    private Printer() {

    }
}
