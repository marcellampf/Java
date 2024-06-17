package org.example.lab6;

import java.util.*;

public class Library {
    private Map<String, Book> booksByIsbn;
    private Set<Author> authors;
    private SortedSet<Book> booksByTitle;
    private Map<String, Borrower> borrowers;

    public Library() {
        booksByIsbn = new HashMap<>();
        authors = new HashSet<>();
        booksByTitle = new TreeSet<>(Comparator.comparing(Book::getTitle));
        borrowers = new TreeMap<>();
    }

    public void addBook(Book book) {
        booksByIsbn.put(book.getIsbn(), book);
        booksByTitle.add(book);
        book.getAuthor().addBook(book);
        authors.add(book.getAuthor());
    }

    public void listAllBooks() {
        for (Book book : booksByTitle) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor().getName() + ", ISBN: " + book.getIsbn());
        }
    }

    public Book searchBookByTitle(String title) {
        for (Book book : booksByTitle) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void registerBorrower(Borrower borrower) {
        borrowers.put(borrower.getName(), borrower);
    }

    public void lendBook(String isbn, String borrowerName) {
        Book book = booksByIsbn.get(isbn);
        Borrower borrower = borrowers.get(borrowerName);
        if (book != null && borrower != null) {
            borrower.borrowBook(book);
            booksByIsbn.remove(isbn);
            booksByTitle.remove(book);
        }
    }

    public void listBorrowedBooks() {
        for (Map.Entry<String, Borrower> entry : borrowers.entrySet()) {
            Borrower borrower = entry.getValue();
            System.out.println("Borrower: " + borrower.getName());
            for (Book book : borrower.getBorrowedBooks()) {
                System.out.println("  Title: " + book.getTitle() + ", Author: " + book.getAuthor().getName() + ", ISBN: " + book.getIsbn());
            }
        }
    }
}

