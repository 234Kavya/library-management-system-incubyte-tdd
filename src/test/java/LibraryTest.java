import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    @Test
    public void testLibraryCreation() {
        // Create a new library instance
        Library library = new Library();


        assertEquals(0, library.getBooksCount(), "Library should be initialized with zero books");
    }
}
