package Models;

/**
    Represents a book in the library system with all its metadata and availability status.
    Validates book data integrity and provides formatted string representation.
 */
public class Book {
    private String id;  // Unique identifier for the book
    private String title;   // Title of the book
    private String author;  // Author of the book
    private String genre;   // Genre/category of the book
    private String availabilityStatus;  // Current availability ("Available" or "Checked Out")

    //  Creates a new Book instance with all required properties.
    public Book(String id, String title, String author, String genre, String availabilityStatus) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = availabilityStatus;
    }

    //  Validates the book's data integrity.
    public boolean isValid() {
        return id != null && !id.isEmpty() &&
                title != null && !title.isEmpty() &&
                author != null && !author.isEmpty() &&
                ("Available".equals(availabilityStatus) || "Checked Out".equals(availabilityStatus));
    }

    //  // Standard Getters and Setters


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    // Provides a formatted string representation of the book.
    @Override
    public String toString() {
        return String.format("ID: %s, Title: %s, Author: %s, Genre: %s, Status: %s",
                id, title, author, genre, availabilityStatus);
    }
}