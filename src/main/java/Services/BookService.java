package Services;

import Models.Book;
import Repositories.BookRepository;
import java.util.List;

public class BookService {
    private final BookRepository bookRepository;

    // Initializes the service with a book repository
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // // Validates and adds a new book to the repository
    public void addBook(Book book) throws IllegalArgumentException {
        if (!book.isValid()) {
            throw new IllegalArgumentException("Invalid book data");
        }
        if (bookRepository.existsById(book.getId())) {
            throw new IllegalArgumentException("Book ID already exists");
        }
        bookRepository.addBook(book);
    }

    // Returns all books in the repository
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    // Finds a book by its ID
    public Book getBookById(String id) {
        return bookRepository.getBookById(id);
    }

    // Searches books by title
    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.searchByTitle(title);
    }

    // Finds books by availability status
    public List<Book> searchBooksByStatus(String status) {
        return bookRepository.searchByStatus(status);
    }

    // Updates an existing book after validation
    public void updateBook(Book book) throws IllegalArgumentException {
        if (!book.isValid()) {
            throw new IllegalArgumentException("Invalid book data");
        }

        Book existingBook = bookRepository.getBookById(book.getId());
        if (existingBook == null) {
            throw new IllegalArgumentException("Book not found");
        }

        bookRepository.updateBook(book);
    }

    // Deletes a book after checking its existence
    public void deleteBook(String id) throws IllegalArgumentException {
        if (!bookRepository.existsById(id)) {
            throw new IllegalArgumentException("Book not found");
        }
        bookRepository.deleteBook(id);
    }
}