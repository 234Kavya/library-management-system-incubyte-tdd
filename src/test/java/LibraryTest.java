import org.junit.Test;

import java.util.List;

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

    @Test
    public void testReturnBook() {
        Library library = new Library();
        Book book = new Book("1234567890", "Atomic Habits", "James Clear ", 2018);
        library.addBook(book);
        library.borrowBook("1234567890");

        boolean returned = library.returnBook("1234567890"); // Return the book by ISBN
        assertTrue(returned);  // Check if returning was successful
        assertTrue(book.isAvailable());  // The book should be available again
    }

    @Test
    public void testViewAvailableBooks() {
        Library library = new Library();
        Book book1 = new Book("1111111111", "Programming in ANSI C", "E. Balagurusamy", 1998);
        Book book2 = new Book("2222222222", "Black Book", "Steven Holzner", 2000);
        library.addBook(book1);
        library.addBook(book2);
        library.borrowBook("1111111111"); // Borrow the first book

        List<Book> availableBooks = library.viewAvailableBooks();
        assertEquals(1, availableBooks.size()); // Only one book should be available
        assertEquals("2222222222", availableBooks.get(0).getIsbn()); // The available book's ISBN should match
    }

}
