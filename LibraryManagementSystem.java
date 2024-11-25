import java.util.ArrayList;
import java.util.List;

// Base class
class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;  
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

   
    public void displayInfo() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }
}

// Derived class
class ReferenceBook extends Book {
    private int edition;

    public ReferenceBook(int bookId, String title, String author, int edition) {
        super(bookId, title, author);
        this.edition = edition;
    }

   
    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    
    @Override
    public void displayInfo() {
        super.displayInfo();  
        System.out.println("Edition: " + edition);
    }
}

class FictionBook extends Book {
    private String genre;

    public FictionBook(int bookId, String title, String author, String genre) {
        super(bookId, title, author);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

   
    @Override
    public void displayInfo() {
        super.displayInfo();  // Display base class info
        System.out.println("Genre: " + genre);
    }
}

// Derived class
class Periodical extends ReferenceBook {
    private String issueFrequency;

    public Periodical(int bookId, String title, String author, int edition, String issueFrequency) {
        super(bookId, title, author, edition);
        this.issueFrequency = issueFrequency;
    }

    
    public String getIssueFrequency() {
        return issueFrequency;
    }

    public void setIssueFrequency(String issueFrequency) {
        this.issueFrequency = issueFrequency;
    }

   
    @Override
    public void displayInfo() {
        super.displayInfo(); 
        System.out.println("Issue Frequency: " + issueFrequency);
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    
    public void addBook(Book book) {
        books.add(book);
    }

  
    public boolean borrowBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId && book.isAvailable()) {
                book.setAvailable(false);
                return true;
            }
        }
        return false; ound
    }

  
    public boolean returnBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId && !book.isAvailable()) {
                book.setAvailable(true);
                return true;
            }
        }
        return false; 
    }

    
    public void displayAllBooks() {
        for (Book book : books) {
            book.displayInfo();
            System.out.println("----------");
        }
    }

   
    public int getAvailableBooks() {
        int availableCount = 0;
        for (Book book : books) {
            if (book.isAvailable()) {
                availableCount++;
            }
        }
        return availableCount;
    }

    public int getTotalBorrowedBooks() {
        int borrowedCount = 0;
        for (Book book : books) {
            if (!book.isAvailable()) {
                borrowedCount++;
            }
        }
        return borrowedCount;
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        
        Book book1 = new ReferenceBook(1001, "Java Programming", "John Doe", 3);
        Book book2 = new FictionBook(1002, "It Starts with a Friend Request", "Sandeep Nagarkar", "Rom-Com");
        Book book3 = new Periodical(1003, "Atomic Habits", "Pratiksha N", 1, "Weekly");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        
        library.displayAllBooks();

        
        System.out.println("Attempting to borrow book 1001: " + (library.borrowBook(1001) ? "Success" : "Failed"));

       
        System.out.println("Available Books: " + library.getAvailableBooks());

       
        System.out.println("Attempting to return book 1001: " + (library.returnBook(1001) ? "Success" : "Failed"));

        
        System.out.println("Available Books after return: " + library.getAvailableBooks());
    }
}
