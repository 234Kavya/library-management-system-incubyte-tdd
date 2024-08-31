import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;


    public Library() {
        books = new ArrayList<>();
    }


    public void addBook(Book book) {
        if (book == null || isBookExists(book.getIsbn())) {
            throw new IllegalArgumentException("Invalid book or book already exists");
        }
        books.add(book);
    }


    public int getBooksCount() {
        return books.size();
    }

    public boolean borrowBook(String isbn) {
        Book book = findBookByIsbn(isbn);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            return true;
        }
        return false;
    }


    public boolean returnBook(String isbn) {
        Book book = findBookByIsbn(isbn);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            return true;
        }
        return false;
    }

    public List<Book> viewAvailableBooks() {
        return books.stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }

    private boolean isBookExists(String isbn) {
        return findBookByIsbn(isbn) != null;
    }

    private Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

}
