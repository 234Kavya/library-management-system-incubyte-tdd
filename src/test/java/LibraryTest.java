import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {
    @Test
    public void testLibraryCreation() {

        Library library = new Library();


        assertEquals(0, library.getBooksCount());
    }

    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("1234567890", "Atomic Habits", "James Clear ", 2018);


        library.addBook(book);
        assertEquals(1, library.getBooksCount());
    }

    @Test
    public void testBorrowBook() {
        Library library = new Library();
        Book book = new Book("1234567890", "Atomic Habits", "James Clear ", 2018);
        library.addBook(book);

        boolean borrowed = library.borrowBook("1234567890");
        assertTrue(borrowed);
        assertFalse(book.isAvailable());
    }

    @Test
    public void testReturnBook() {
        Library library = new Library();
        Book book = new Book("1234567890", "Atomic Habits", "James Clear ", 2018);
        library.addBook(book);
        library.borrowBook("1234567890");

        boolean returned = library.returnBook("1234567890");
        assertTrue(returned);
        assertTrue(book.isAvailable());
    }

    @Test
    public void testViewAvailableBooks() {
        Library library = new Library();
        Book book1 = new Book("1111111111", "Programming in ANSI C", "E. Balagurusamy", 1998);
        Book book2 = new Book("2222222222", "Black Book", "Steven Holzner", 2000);
        library.addBook(book1);
        library.addBook(book2);
        library.borrowBook("1111111111");

        List<Book> availableBooks = library.viewAvailableBooks();
        assertEquals(1, availableBooks.size());
        assertEquals("2222222222", availableBooks.get(0).getIsbn());
    }

}
