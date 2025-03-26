package Views;

import java.util.Scanner;

public class LibraryView {
    private final Scanner scanner;

    // Initializes the view with system input scanner
    public LibraryView() {
        this.scanner = new Scanner(System.in);
    }

    // Displays the main menu options
    public void displayMenu() {
        System.out.println("\nDigital Library Management System");
        System.out.println("1. Add Book");
        System.out.println("2. View All Books");
        System.out.println("3. Search Book by ID");
        System.out.println("4. Search Book by Title");
        System.out.println("5. Search Book by Status");
        System.out.println("6. Update Book");
        System.out.println("7. Delete Book");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    // Gets and validates user's menu choice (-1 for invalid input)
    public int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Indicates invalid input
        }
    }

    // Prompts user and returns their input string
    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Displays a message to the user
    public void displayMessage(String message) {
        System.out.println(message);
    }

    // Closes the scanner resource
    public void close() {
        scanner.close();
    }
}