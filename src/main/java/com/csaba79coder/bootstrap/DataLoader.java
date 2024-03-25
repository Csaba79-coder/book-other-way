package com.csaba79coder.bootstrap;

import com.csaba79coder.model.Book;
import com.csaba79coder.service.BookService;
import com.csaba79coder.service.BookServiceI;
import com.csaba79coder.util.FileHandler;
import com.csaba79coder.util.Printer;

import java.util.List;

public class DataLoader {

    BookServiceI bookService;

    public DataLoader() {
        this.bookService = new BookService();
    }

    /*
    A különbség a private List<Book> books és a private static List<Book> books között abban rejlik, hogy az előbbi
    esetben az books változó példányosítása történik minden egyes DataLoader objektum létrehozásakor, míg az utóbbi
    esetben az books változó egy osztályszintű változó, amely minden DataLoader objektum esetében ugyanarra a
    memóriaterületre mutat.

    Ha a books listát statikusként deklaráljuk (private static List<Book> books), akkor minden DataLoader objektum
    ugyanarra a books listára fog mutatni. Ez azt jelenti, hogy ha egy DataLoader objektum módosítja a listát
    (például hozzáad, töröl vagy módosít egy könyvet), akkor ez a változás az összes többi DataLoader objektum számára
    is látható lesz, mivel mindannyian ugyanarra a listára hivatkoznak.

    Ha a books listát nem statikusként deklaráljuk (private List<Book> books), akkor minden DataLoader objektum saját
    példányát fogja tartalmazni a books listának. Ez azt jelenti, hogy ha egy DataLoader objektum módosítja a listát,
    ez csak az adott objektum példányára vonatkozik, és más DataLoader objektumok számára nem lesz látható.

    Ezért a statikus books lista esetén, amikor módosítás történik, az összes DataLoader objektum módosításokat lát,
    míg a nem statikus books lista esetén a módosítások csak az adott objektum példányára korlátozódnak.
    */

    private static final String FILE_PATH = "src/main/resources/book_other.txt";
    private List<Book> books = FileHandler.readFileFromTxt(FILE_PATH);
    // private static List<Book> books = FileHandler.readFileFromTxt(FILE_PATH);

    public void loadData() {
        Printer.printList(books);
        System.out.println("--------------");
        List<Book> modifyBooks = deleteData();
        System.out.println(modifyBooks);
        System.out.println("--------------");
        modifyBooks = addData();
        System.out.println(modifyBooks);
        System.out.println("--------------");
        modifyBooks = modifyData();
        System.out.println(modifyBooks);
    }

    public List<Book> deleteData() {
        Book bookToDelete = new Book("Gyilkosság az Orient expresszen", 0, "Helikon Kiadó", 2020, "AC-1979", List.of("Agatha Christie"));
        return bookService.deleteBook(bookToDelete, getBooks());
    }

    public List<Book> addData() {
        Book bookToAdd = new Book("Gyilkosság az Orient expresszen", 0, "Helikon Kiadó", 2020, "AC-1979", List.of("Agatha Christie"));
        return bookService.addBook(bookToAdd, getBooks());
    }

    public List<Book> modifyData() {
        Book bookToModify = new Book("Gyilkosság az Orient expresszen", 0, "Helikon Kiadó", 2020, "AC-1979", List.of("Agatha Christie"));
        Book bookModification = new Book("Gyilkosság az Orient expresszen", 1, "Helikon Kiadó", 2020, "AC-1979", List.of("Agatha Christie"));
        return bookService.modifyBook(bookToModify, bookModification, getBooks());
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
