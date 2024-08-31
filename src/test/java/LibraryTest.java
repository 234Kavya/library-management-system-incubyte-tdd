import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {
    @Test
    public void testLibraryCreation() {
        // Create a new library instance
        Library library = new Library();


        assertEquals(0, library.getBooksCount());
    }

    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("1234567890", "Atomic Habits", "James Clear ", 2018);


        library.addBook(book);  // Add the book to the library
        assertEquals(1, library.getBooksCount());  // Check the count of books in the library
    }

    @Test
    public void testBorrowBook() {
        Library library = new Library();
        Book book = new Book("1234567890", "Atomic Habits", "James Clear ", 2018);
        library.addBook(book);

        boolean borrowed = library.borrowBook("1234567890");  // Borrow the book by ISBN
        assertTrue(borrowed);  // Check if borrowing was successful
        assertFalse(book.isAvailable());  // The book should now be unavailable
    }

}
