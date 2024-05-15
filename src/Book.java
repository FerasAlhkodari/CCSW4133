public class Book {
    private String title;
    private String author;
    private String isbn;
    private int year;  // Adding year for publication year functionality

    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    // Setter for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter for ISBN
    public String getISBN() {
        return isbn;
    }

    // Getter for year
    public int getYear() {
        return year;
    }
}
