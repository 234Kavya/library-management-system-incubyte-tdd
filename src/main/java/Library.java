import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    //  to initialize the library with an empty book list
    public Library() {
        books = new ArrayList<>();
    }

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to get the count of books in the library
    public int getBooksCount() {
        return books.size();
    }
    // Borrow book with isbn
    public boolean borrowBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && book.isAvailable()) {
                book.setAvailable(false); // Mark the book as unavailable
                return true; // Borrowing successful
            }
        }
        return false; // Book not available or does not exist
    }
}
