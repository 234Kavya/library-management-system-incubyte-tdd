import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookTest {
    @Test
    public void testBookCreation() {

        Book book = new Book("1234567890111", "Test Book", "Author Name", 2024);

        assertEquals("1234567890111", book.getIsbn());
        assertEquals("Test Book", book.getTitle());
        assertEquals("Author Name", book.getAuthor());
        assertEquals(2024, book.getPublicationYear());
        assertTrue(book.isAvailable());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsbnLength(){
        new Book("11111111111111", "Test Book", "Author Name", 2024);

    }
}
