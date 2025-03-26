package Controllers;

import Models.Book;
import Services.BookService;
import java.util.List;

// The main controller for our library system - handles all the actual book operations needed by Librarian.
public class LibraryController {
    // Our helper that knows how to actually work with books
    private final BookService bookService;

    // Creates a new controller ready to manage your library.
    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }

    // Adds a brand-new book to our library collection.
    public void addBook(String id, String title, String author, String genre, String status) {
        Book book = new Book(id, title, author, genre, status);
        try {
            bookService.addBook(book);
            System.out.println("Book added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Shows all the books that are currently in the library. If no books are there then display appropriate message.
    public void displayAllBooks() {
        List<Book> books = bookService.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("\nList of all books:");
            books.forEach(System.out::println);
        }
    }

    // Find one specific book by looking up it's ID number
    public Book getBookById(String id) {
        return bookService.getBookById(id);
    }

    // Update the new details of existing Book
    public void updateBook(Book book) {
        try {
            bookService.updateBook(book);
            System.out.println("Book updated successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Looks for a book by its ID and displays it
    public void searchBookById(String id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            System.out.println("\nBook found:");
            System.out.println(book);
        } else {
            System.out.println("No book found with ID: " + id);
        }
    }

    // Searches for books by their title
    public void searchBooksByTitle(String title) {
        List<Book> books = bookService.searchBooksByTitle(title);
        if (books.isEmpty()) {
            System.out.println("No books found with title containing: " + title);
        } else {
            System.out.println("\nFound " + books.size() + " book(s):");
            books.forEach(System.out::println);
        }
    }

    // Shows books that are either available or checked out.
    public void searchBooksByStatus(String status) {
        List<Book> books = bookService.searchBooksByStatus(status);
        if (books.isEmpty()) {
            System.out.println("No books found which are: " + status);
        } else {
            System.out.println("\nFound " + books.size() + " book(s):");
            books.forEach(System.out::println);
        }
    }

    // Removes a book from our library completely.
    public void deleteBook(String id) {
        try {
            bookService.deleteBook(id);
            System.out.println("Book deleted successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
