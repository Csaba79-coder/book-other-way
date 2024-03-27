package com.csaba79coder;

import com.csaba79coder.bootstrap.DataLoader;
import com.csaba79coder.service.BookService;

public class BookApp {

    public static void main(String[] args) {
        new DataLoader(new BookService()).loadData();
    }
}
