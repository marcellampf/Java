package org.example.lab6;

import java.util.HashSet;
import java.util.Set;

public class Author {
    private String name;
    private Set<Book> booksWritten;

    public Author(String name) {
        this.name = name;
        this.booksWritten = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooksWritten() {
        return booksWritten;
    }

    public void addBook(Book book) {
        booksWritten.add(book);
    }
}
