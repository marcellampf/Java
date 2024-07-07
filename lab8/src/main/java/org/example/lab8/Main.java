package org.example.lab8;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.populateLibrary();

        System.out.println("Books by Author1:");
        library.searchByAuthor("Author1").forEach(System.out::println);

        System.out.println("\nBooks published in 2000:");
        library.searchByYear(2000).forEach(System.out::println);

        System.out.println("\nBooks with 'Title1' in the title:");
        library.searchByTitle("Title1").forEach(System.out::println);

        System.out.println("\nBooks in Genre1:");
        library.searchByGenre("Genre1").forEach(System.out::println);

        System.out.println("\nAverage book price:");
        System.out.println(library.averageBookPrice());

        System.out.println("\nMost expensive book:");
        System.out.println(library.mostExpensiveBook());

        System.out.println("\nCheapest book:");
        System.out.println(library.cheapestBook());

        System.out.println("\nOldest book:");
        System.out.println(library.oldestBook());

        System.out.println("\nRecent books (last 5 years):");
        library.recentBooks(5).forEach(System.out::println);

        System.out.println("\nBooks sorted by title:");
        library.printBooksSortedByTitle();

        System.out.println("\nBooks sorted by author:");
        library.printBooksSortedByAuthor();

        System.out.println("\nBooks sorted by publication year:");
        library.printBooksSortedByPublicationYear();

        System.out.println("\nAuthor with most books:");
        System.out.println(library.authorWithMostBooks());

        System.out.println("\nMost popular genre:");
        System.out.println(library.mostPopularGenre());

        System.out.println("\nYear with most published books:");
        System.out.println(library.yearWithMostPublishedBooks());
    }
}

