# Digital Library Management System

A console-based Java application for librarians to manage book inventory with full CRUD operations.

## Features

### 📚 Book Management
- Add, update, and delete books
- View the complete catalog
- Unique ID validation
- Availability tracking ("Available" / "Checked Out")

### 🔍 Search Capabilities
- Search by **Book ID** (exact match)
- Search by **Title**
- Search by **Availability Status**

## 📂 Project Structure
```plaintext
src/
├── Models/          # Book data structure and validation
├── Repositories/    # Data storage (InMemory implementation)
├── Services/        # Business logic layer
├── Controllers/     # Application workflow
├── Views/           # Console interface
└── org.example/     # Main application class
```

## 🚀 Getting Started

### Prerequisites:
- JDK 17 or later
- Git (optional)

### 📥 Clone the Repository:
```bash
git clone https://github.com/prernasahu02/digilibrary.git
```

### 📂 Import to IDE:
1. **IntelliJ IDEA**: Import as an existing Java project.
2. Set `src` as the source root.

### ▶️ Usage
Run `Main.java` from your IDE to start the console application.

#### **📜 Main Menu Preview:**
```plaintext
MAIN MENU
1. Add Book
2. View All Books
3. Search by ID
4. Search by Title
5. Search by Status
6. Update Book
7. Delete Book
8. Exit
```

## 🏗️ Design Patterns Used
- **MVC Architecture**: Separation of Model-View-Controller
- **Repository Pattern**: Abstracted data access layer
- **Service Layer**: Centralized business logic

## 🚀 Development Insights

### ⚡ Challenges
- Making sure user input was correct took a lot of trial and error.
- Managing book data in memory was tricky because of how Java handles objects.
- Keeping the project simple while following the MVC structure was a challenge.

### 🎯 Key Learnings
- Using a layered design made it easier to add new features.
- Writing defensive code helped prevent unexpected errors.
- A clear and simple console interface made the app easier to use.

### 🔮 Future Improvements
- **Save Data:** Store books in an SQLite database.
- **New Features:** Add a checkout system and manage library users.
- **Better UI:** Add colors and options to export data.

This project showed that good planning makes it easier to grow and improve an app over time.

## 📜 License
This project is licensed under the **MIT License**. See [LICENSE](LICENSE) for details.
