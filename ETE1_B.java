import java.util.ArrayList;
import java.util.List;

// Base class: Book
class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;  // All books are available when added
    }

    // Getter and Setter methods
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Display basic book information
    public void displayInfo() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }
}

// Derived class: ReferenceBook
class ReferenceBook extends Book {
    private int edition;

    public ReferenceBook(int bookId, String title, String author, int edition) {
        super(bookId, title, author);
        this.edition = edition;
    }

    // Getter and Setter for edition
    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    // Override displayInfo to show additional information
    @Override
    public void displayInfo() {
        super.displayInfo();  // Display base class info
        System.out.println("Edition: " + edition);
    }
}

// Derived class: FictionBook
class FictionBook extends Book {
    private String genre;

    public FictionBook(int bookId, String title, String author, String genre) {
        super(bookId, title, author);
        this.genre = genre;
    }

    // Getter and Setter for genre
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Override displayInfo to show additional information
    @Override
    public void displayInfo() {
        super.displayInfo();  // Display base class info
        System.out.println("Genre: " + genre);
    }
}

// Derived class: Periodical
class Periodical extends ReferenceBook {
    private String issueFrequency;

    public Periodical(int bookId, String title, String author, int edition, String issueFrequency) {
        super(bookId, title, author, edition);
        this.issueFrequency = issueFrequency;
    }

    // Getter and Setter for issueFrequency
    public String getIssueFrequency() {
        return issueFrequency;
    }

    public void setIssueFrequency(String issueFrequency) {
        this.issueFrequency = issueFrequency;
    }

    // Override displayInfo to show additional information
    @Override
    public void displayInfo() {
        super.displayInfo();  // Display base class info
        System.out.println("Issue Frequency: " + issueFrequency);
    }
}

// Library management class
class Library {
    private List<Book> books;
    private int totalBooks;
    private int totalBorrowed;

    public Library() {
        books = new ArrayList<>();
        totalBooks = 0;
        totalBorrowed = 0;
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
        totalBooks++;
    }

    // Borrow a book from the library
    public boolean borrowBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId && book.isAvailable()) {
                book.setAvailable(false);
                totalBorrowed++;
                return true;
            }
        }
        return false;  // Book is not available
    }

    // Return a book to the library
    public boolean returnBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId && !book.isAvailable()) {
                book.setAvailable(true);
                totalBorrowed--;
                return true;
            }
        }
        return false;  // Book wasn't borrowed
    }

    // Display all books in the library
    public void displayAllBooks() {
        for (Book book : books) {
            book.displayInfo();
            System.out.println("----------");
        }
    }

    // Get the number of books available in the library
    public int getAvailableBooks() {
        int availableCount = 0;
        for (Book book : books) {
            if (book.isAvailable()) {
                availableCount++;
            }
        }
        return availableCount;
    }

    // Get the number of borrowed books
    public int getTotalBorrowedBooks() {
        return totalBorrowed;
    }

    // Method to calculate overdue fines (if any) - basic placeholder
    public double calculateOverdueFine(int daysLate) {
        double finePerDay = 2.0;  // Example fine rate
        return daysLate * finePerDay;
    }
}

// Main class to run the Library Management System
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Creating books
        Book book1 = new ReferenceBook(101, "Java Programming", "John Doe", 3);
        Book book2 = new FictionBook(102, "The Great Adventure", "Jane Smith", "Adventure");
        Book book3 = new Periodical(103, "Tech Monthly", "Alice Brown", 1, "Monthly");

        // Adding books to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Displaying all books
        library.displayAllBooks();

        // Borrowing a book
        System.out.println("Attempting to borrow book 101: " + (library.borrowBook(101) ? "Success" : "Failed"));

        // Displaying available books
        System.out.println("Available Books: " + library.getAvailableBooks());

        // Returning a book
        System.out.println("Attempting to return book 101: " + (library.returnBook(101) ? "Success" : "Failed"));

        // Calculate overdue fine
        System.out.println("Overdue fine for 5 days late: " + library.calculateOverdueFine(5));
    }
}
