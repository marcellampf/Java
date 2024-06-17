package org.example.lab6;

import java.util.ArrayList;
import java.util.List;

public class Borrower {
    private String name;
    private List<Book> borrowedBooks;

    public Borrower(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }
}
