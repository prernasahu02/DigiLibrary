package Repositories;

import Models.Book;
import java.util.List;

// Defines the contract for book data storage operations - all implementations must provide these capabilities
public interface BookRepository {

    // Stores a new book in the repository
    void addBook(Book book);

    // Retrieves a book by its unique identifier or null if not found
    Book getBookById(String id);

    // Returns all books currently stored in the repository
    List<Book> getAllBooks();

    // Finds books containing the given text in their title (case-insensitive
    List<Book> searchByTitle(String title);

    // Finds books matching the specified availability status
    List<Book> searchByStatus(String status);

    // Replaces an existing book's data with the updated version
    void updateBook(Book book);

    // Permanently removes a book from the repository by its ID
    void deleteBook(String id);

    // Checks whether a book with the given ID exists in the repository
    boolean existsById(String id);
}