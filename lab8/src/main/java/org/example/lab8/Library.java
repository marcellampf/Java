package org.example.lab8;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void populateLibrary() {
        // J.K. Rowling
        books.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997, 20.99, "Fantasy"));
        books.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998, 22.99, "Fantasy"));
        books.add(new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 1999, 24.99, "Fantasy"));
        books.add(new Book("Harry Potter and the Goblet of Fire", "J.K. Rowling", 2000, 26.99, "Fantasy"));
        books.add(new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling", 2003, 28.99, "Fantasy"));
        books.add(new Book("Harry Potter and the Half-Blood Prince", "J.K. Rowling", 2005, 29.99, "Fantasy"));
        books.add(new Book("Harry Potter and the Deathly Hallows", "J.K. Rowling", 2007, 32.99, "Fantasy"));

        // Tolkien
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, 25.99, "Fantasy"));
        books.add(new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 1954, 27.99, "Fantasy"));
        books.add(new Book("The Two Towers", "J.R.R. Tolkien", 1954, 27.99, "Fantasy"));
        books.add(new Book("The Return of the King", "J.R.R. Tolkien", 1955, 28.99, "Fantasy"));

        // Tolkien
        books.add(new Book("The Silmarillion", "J.R.R. Tolkien", 1977, 30.99, "Fantasy"));
        books.add(new Book("Unfinished Tales", "J.R.R. Tolkien", 1980, 33.99, "Fantasy"));
        books.add(new Book("The Children of Húrin", "J.R.R. Tolkien", 2007, 35.99, "Fantasy"));
    }


    public List<Book> searchByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Book> searchByYear(int year) {
        return books.stream()
                .filter(book -> book.getYearOfPublication() == year)
                .collect(Collectors.toList());
    }

    public List<Book> searchByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Book> searchByGenre(String genre) {
        return books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    public double averageBookPrice() {
        return books.stream()
                .mapToDouble(Book::getPrice)
                .average()
                .orElse(0.0);
    }

    public Book mostExpensiveBook() {
        return books.stream()
                .max(Comparator.comparingDouble(Book::getPrice))
                .orElse(null);
    }

    public Book cheapestBook() {
        return books.stream()
                .min(Comparator.comparingDouble(Book::getPrice))
                .orElse(null);
    }

    public Book oldestBook() {
        return books.stream()
                .min(Comparator.comparingInt(Book::getYearOfPublication))
                .orElse(null);
    }

    public List<Book> recentBooks(int years) {
        int currentYear = java.time.Year.now().getValue();
        return books.stream()
                .filter(book -> book.getYearOfPublication() >= (currentYear - years))
                .collect(Collectors.toList());
    }

    public void printBooksSortedByTitle() {
        books.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .forEach(System.out::println);
    }

    public void printBooksSortedByAuthor() {
        books.stream()
                .sorted(Comparator.comparing(Book::getAuthor))
                .forEach(System.out::println);
    }

    public void printBooksSortedByPublicationYear() {
        books.stream()
                .sorted(Comparator.comparingInt(Book::getYearOfPublication))
                .forEach(System.out::println);
    }

    public String authorWithMostBooks() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public String mostPopularGenre() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public int yearWithMostPublishedBooks() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getYearOfPublication, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(0);
    }
}
