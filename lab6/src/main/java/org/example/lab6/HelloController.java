package org.example.lab6;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField titleField;
    @FXML
    private TextField authorField;
    @FXML
    private TextField isbnField;
    @FXML
    private Label resultLabel;

    private Library library;

    public HelloController() {
        library = new Library();
    }

    @FXML
    public void initialize() {
        Author author1 = new Author("George Orwell");
        Author author2 = new Author("Ernest Hemingway");
        Author author3 = new Author("Ayn Rand");

        Book book1 = new Book("1984", author1, "0008442614");
        Book book2 = new Book("PARIS EST UNE FÊTE", author1, "2070437442");
        Book book3 = new Book("Atlas Shrugged", author3, "9780451191144");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
    }

    @FXML
    public void addBook() {
        String title = titleField.getText();
        String authorName = authorField.getText();
        String isbn = isbnField.getText();

        Author author = new Author(authorName);
        Book book = new Book(title, author, isbn);
        library.addBook(book);
        resultLabel.setText("Book added: " + title);
    }

    @FXML
    public void listAllBooks() {
        library.listAllBooks();
    }

    @FXML
    public void searchBookByTitle() {
        String title = titleField.getText();
        Book book = library.searchBookByTitle(title);
        if (book != null) {
            resultLabel.setText("Found: " + book.getTitle() + " by " + book.getAuthor().getName());
        } else {
            resultLabel.setText("Book not found.");
        }
    }
}
