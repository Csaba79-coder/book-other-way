package com.csaba79coder.service;

import com.csaba79coder.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService implements BookServiceI{

    @Override
    public List<Book> addBook(Book addBbook, List<Book> existingBooks) {
        List<Book> resultList = new ArrayList<>(existingBooks);
        resultList.add(addBbook);
        return resultList;
    }

    @Override
    public List<Book> deleteBook(Book bookToDelete, List<Book> existingBooks) {
        List<Book> resultList = new ArrayList<>(existingBooks);
        for (int i = 0; i < resultList.size(); i++) {
            if (resultList.get(i).equals(bookToDelete)) {
                resultList.remove(i);
                // Decrease index after removal
                i--;
            }
        }
        return resultList;
    }

    @Override
    public List<Book> modifyBook(Book bookToModify, Book bookModification, List<Book> existingBooks) {
        List<Book> resultList = new ArrayList<>(existingBooks);
        for (int i = 0; i < resultList.size(); i++) {
            if (resultList.get(i).equals(bookToModify)) {
                resultList.set(i, bookModification);
            }
        }
        return resultList;
    }
}
