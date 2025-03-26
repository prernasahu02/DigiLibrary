package Repositories;

import Models.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryBookRepository implements BookRepository {
    // In-memory storage for books
    private final List<Book> books = new ArrayList<>();

    // Adds a new book to the collection
    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    // Finds book by ID or returns null
    @Override
    public Book getBookById(String id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Returns a copy of all books
    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    // Case-insensitive title search
    @Override
    public List<Book> searchByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Finds books by availability status
    @Override
    public List<Book> searchByStatus(String status) {
        return books.stream()
                .filter(book -> book.getAvailabilityStatus().toLowerCase().contains(status.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Updates existing book by ID
    @Override
    public void updateBook(Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(updatedBook.getId())) {
                books.set(i, updatedBook);
                return;
            }
        }
    }

    // Removes book by ID
    @Override
    public void deleteBook(String id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    // Checks if book exists by ID
    @Override
    public boolean existsById(String id) {
        return books.stream().anyMatch(book -> book.getId().equals(id));
    }
}
