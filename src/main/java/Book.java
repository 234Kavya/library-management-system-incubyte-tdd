public class Book {
    private final  String isbn;
    private final String title;
    private final  String author;
    private final int publicationYear;
    private boolean isAvailable;


    public Book(String isbn, String title, String author, int publicationYear) {
        if (isbn == null || isbn.length() != 13) {
            throw new IllegalArgumentException("ISBN must be exactly 13 characters length");
        }

        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = true;
    }


    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }
    public boolean isAvailable() { return isAvailable; }


    public void setAvailable(boolean available) { isAvailable = available; }


}
