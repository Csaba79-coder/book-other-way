package com.csaba79coder;

import com.csaba79coder.bootstrap.DataLoader;
import com.csaba79coder.model.Book;
import com.csaba79coder.service.BookService;
import com.csaba79coder.util.FileHandler;

import java.util.List;

public class BookApp {

    public static void main(String[] args) {
        new DataLoader().loadData();
    }
}
