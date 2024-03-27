package com.csaba79coder.model;

import com.csaba79coder.value.Category;

import java.util.List;
import java.util.Objects;

public class Book {

    private static int counter = 0;
    private String title;
    private String category;
    private String publisher;
    private int publicationYear;
    private String articleNumber;
    private boolean isOnStock;
    private List<String> authors;

    public Book() {
        counter++;
    }

    public Book(String title, int categoryNumber, String publisher,
                int publicationYear, String articleNumber, List<String> authors) {
        this();
        this.title = title;
        this.category = Objects.requireNonNull(mapCategory(categoryNumber)).getHungarianName();
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.articleNumber = articleNumber;
        this.isOnStock = isOnStock(articleNumber);
        this.authors = authors;
    }

    private boolean isOnStock(String articleNumber) {
        return !articleNumber.endsWith("*");
    }

    private Category mapCategory(int categoryNumber) {
        switch (categoryNumber) {
            case 1:
                return Category.NOVEL;
            case 2:
                return Category.NON_FICTION;
            case 3:
                return Category.FAIRY_TALE;
            case 4:
                return Category.ADVENTURE_NOVEL;
            case 5:
                return Category.ROMANTIC;
            case 6:
                return Category.YOUTH_NON_FICTION;
            case 7:
                return Category.YOUTH_NOVEL;
            case 8:
                return Category.SCIENCE_FICTION;
            case 9:
                return Category.AUTOBIOGRAPHY;
            case 10:
                return Category.CRIME;
            default:
                return Category.UNKNOWN;
        }
    }

     /*private Category mapCategory(int categoryNumber) {
        return switch (categoryNumber) {
            case 1 -> Category.NOVEL;
            case 2 -> Category.NON_FICTION;
            case 3 -> Category.FAIRY_TALE;
            case 4 -> Category.ADVENTURE_NOVEL;
            case 5 -> Category.ROMANTIC;
            case 6 -> Category.YOUTH_NON_FICTION;
            case 7 -> Category.YOUTH_NOVEL;
            case 8 -> Category.SCIENCE_FICTION;
            case 9 -> Category.AUTOBIOGRAPHY;
            case 10 -> Category.CRIME;
            default -> Category.UNKNOWN;
        };
    }*/

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Book.counter = counter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public boolean isOnStock() {
        return isOnStock;
    }

    public void setOnStock(boolean onStock) {
        isOnStock = onStock;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", category=" + category +
                ", publisher='" + publisher + '\'' +
                ", publicationYear=" + publicationYear +
                ", articleNumber='" + articleNumber + '\'' +
                ", isOnStock=" + isOnStock +
                ", authors=" + authors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;

        if (getPublicationYear() != book.getPublicationYear()) return false;
        if (isOnStock() != book.isOnStock()) return false;
        if (!getTitle().equals(book.getTitle())) return false;
        if (!getCategory().equals(book.getCategory())) return false;
        if (!getPublisher().equals(book.getPublisher())) return false;
        if (!getArticleNumber().equals(book.getArticleNumber())) return false;
        return getAuthors().equals(book.getAuthors());
    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + getCategory().hashCode();
        result = 31 * result + getPublisher().hashCode();
        result = 31 * result + getPublicationYear();
        result = 31 * result + getArticleNumber().hashCode();
        result = 31 * result + (isOnStock() ? 1 : 0);
        result = 31 * result + getAuthors().hashCode();
        return result;
    }

    /*
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book other = (Book) obj;
        return Objects.equals(title, other.title) &&
                Objects.equals(category, other.category) &&
                Objects.equals(publisher, other.publisher) &&
                Objects.equals(publicationYear, other.publicationYear) &&
                Objects.equals(articleNumber, other.articleNumber) &&
                Objects.equals(authors, other.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getCategory(), getPublisher(),
                getPublicationYear(), getArticleNumber(), isOnStock(), getAuthors());
    }
    */
}
