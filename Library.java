import java.util.ArrayList;
import java.util.List;

public class Library {
    private Storage storage;

        //*fix error here new Storage(); */
    public Library() {
        this.storage = Storage.getInstance(); // Initializes the storage when a library object is created
    }

    // Adds a book to the storage
    public void addBook(Book book) {
        storage.addBook(book);
    }

    // Removes a book from the storage by ISBN
    public void removeBook(String isbn) {
        storage.removeBook(isbn);
    }

    // Searches for books by title and returns a list of books that match
    public List<Book> searchByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : storage.getAllBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    // Retrieves all books from the storage
    public List<Book> getAllBooks() {
        return storage.getAllBooks(); // Ensure Storage class has this method
    }
    public void modifyBook(String isbn, String newTitle, String newAuthor) {
        for (Book book : storage.getAllBooks()) {
            if (book.getISBN().equals(isbn)) {
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                break;
            }
        }
    }
}
