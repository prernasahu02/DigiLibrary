package org.example;

import Models.Book;
import Controllers.LibraryController;
import Repositories.InMemoryBookRepository;
import Services.BookService;
import Views.LibraryView;

/**
 * The main entry point for the Digital Library Management System application.
 * Initializes all components and handles the main application loop.
 */
public class Main {
    public static void main(String[] args) {
        // Initialize all application components
        InMemoryBookRepository repository = new InMemoryBookRepository();   // Creates in-memory book storage
        BookService service = new BookService(repository);  // Creates book service with repository
        LibraryController controller = new LibraryController(service);  // Creates controller with service
        LibraryView view = new LibraryView();   // Creates user interface handler

        boolean running = true;
        while (running) {
            view.displayMenu();  // Show main menu to user
            int choice = view.getUserChoice();

            switch (choice) {
                case 1: // Add new book
                    handleAddBook(controller, view);
                    break;
                case 2: // Show all books
                    controller.displayAllBooks();
                    break;
                case 3: // Search by ID
                    handleSearchById(controller, view);
                    break;
                case 4: // Search by title
                    handleSearchByTitle(controller, view);
                    break;
                case 5: // Search by status
                    handleSearchByStatus(controller, view);
                    break;
                case 6: // Update book
                    handleUpdateBook(controller, view);
                    break;
                case 7: // Delete book
                    handleDeleteBook(controller, view);
                    break;
                case 8: // Exit system
                    running = false;
                    view.displayMessage("Exiting the system. Goodbye!");
                    break;
                default:
                    view.displayMessage("Invalid choice. Please try again.");
            }
        }
        view.close();      // Clean up resources
    }

    // Handles the add book operation by collecting input and delegating to controller.
    private static void handleAddBook(LibraryController controller, LibraryView view) {
        view.displayMessage("\nAdd New Book");
        String id = view.getInput("Enter Book ID: ");
        String title = view.getInput("Enter Title: ");
        String author = view.getInput("Enter Author: ");
        String genre = view.getInput("Enter Genre: ");
        String status = view.getInput("Enter Availability Status (Available/Checked Out): ");
        controller.addBook(id, title, author, genre, status);
    }

    // Handles searching for a book by ID.
    private static void handleSearchById(LibraryController controller, LibraryView view) {
        view.displayMessage("\nSearch Book by ID");
        String id = view.getInput("Enter Book ID to search: ");
        controller.searchBookById(id);
    }

    //  Handles searching for books by title
    private static void handleSearchByTitle(LibraryController controller, LibraryView view) {
        view.displayMessage("\nSearch Book by Title");
        String title = view.getInput("Enter Title to search: ");
        controller.searchBooksByTitle(title);
    }

    // Handles searching for books by availability status.
    private static void handleSearchByStatus(LibraryController controller, LibraryView view) {
        view.displayMessage("\nSearch Book by Status");
        String status = view.getInput("Enter Status to search: ");
        controller.searchBooksByStatus(status);
    }

    /*
        Handles updating an existing book's information.
        Shows current values and allows partial updates (empty input keeps current value).
     */
    private static void handleUpdateBook(LibraryController controller, LibraryView view) {
        view.displayMessage("\nUpdate Book");
        String id = view.getInput("Enter Book ID to update: ");

        // Get current book details
        Book currentBook = controller.getBookById(id);
        if (currentBook == null) {
            view.displayMessage("Book not found with ID: " + id);
            return;
        }

        view.displayMessage("\nCurrent Book Details:");
        view.displayMessage(currentBook.toString());

        view.displayMessage("\nEnter new values (press Enter to keep current value)");

        // Get updated values (empty input keeps current value)
        String title = view.getInput(String.format("Title [%s]: ", currentBook.getTitle()));
        String author = view.getInput(String.format("Author [%s]: ", currentBook.getAuthor()));
        String genre = view.getInput(String.format("Genre [%s]: ", currentBook.getGenre()));
        String status = view.getInput(String.format("Status [%s]: ", currentBook.getAvailabilityStatus()));

        // Create updated book (keeping original values for empty inputs)
        Book updatedBook = new Book(
                id,
                title.isEmpty() ? currentBook.getTitle() : title,
                author.isEmpty() ? currentBook.getAuthor() : author,
                genre.isEmpty() ? currentBook.getGenre() : genre,
                status.isEmpty() ? currentBook.getAvailabilityStatus() : status
        );

        try {
            controller.updateBook(updatedBook);
            view.displayMessage("Book updated successfully!");
        } catch (IllegalArgumentException e) {
            view.displayMessage("Error: " + e.getMessage());
        }
    }

    // Handles deleting a book from the system.
    private static void handleDeleteBook(LibraryController controller, LibraryView view) {
        view.displayMessage("\nDelete Book");
        String id = view.getInput("Enter Book ID to delete: ");
        controller.deleteBook(id);
    }
}