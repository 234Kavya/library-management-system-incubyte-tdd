import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookTest {
    @Test
    public void testBookCreation() {

        Book book = new Book("1234567890", "Test Book", "Author Name", 2024);


        assertEquals("1234567890", book.getIsbn());
        assertEquals("Test Book", book.getTitle());
        assertEquals("Author Name", book.getAuthor());
        assertEquals(2024, book.getPublicationYear());
        assertTrue(book.isAvailable());
    }
}
