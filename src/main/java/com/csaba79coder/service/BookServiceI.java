package com.csaba79coder.service;

import com.csaba79coder.model.Book;

import java.util.List;

public interface BookServiceI {

    List<Book> addBook(Book addBook, List<Book> existingBooks);
    List<Book> deleteBook(Book bookToDelete, List<Book> existingBooks);
    List<Book> modifyBook(Book bookToModify, Book bookModification, List<Book> existingBooks);
}
