package com.csaba79coder.util;

import com.csaba79coder.model.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandler {

    public static List<Book> readFileFromTxt(String filePath) {
        List<Book> books = new ArrayList<>();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim(); // Remove leading and trailing whitespace
                if (!line.isEmpty()) { // Skip empty lines
                    String[] parts = line.trim().split(";");
                    if (parts.length == 6) { // Check if the number of params is correct
                        String title = parts[2].trim();
                        int categoryNumber = Integer.parseInt(parts[0].trim());
                        String publisher = parts[3].trim();
                        int publicationYear = Integer.parseInt(parts[4].trim());
                        String articleNumber = parts[5].trim();
                        String[] authorsSplit = parts[1].split(",");
                        for (int i = 0; i < authorsSplit.length; i++) {
                            authorsSplit[i] = authorsSplit[i].trim();
                        }
                        List<String> authors = new ArrayList<>(Arrays.asList(authorsSplit));
                        // Create book and add to list
                        Book book = new Book(title, categoryNumber, publisher, publicationYear, articleNumber, authors);
                        books.add(book);
                    } else {
                        System.out.println("Invalid number of parameters in line: " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return books;
    }

    private FileHandler() {

    }
}
