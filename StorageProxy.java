import java.util.List;
    // Adding Proxy Design Pattern
public class StorageProxy implements StorageInterface {
    private Storage storage;  // This will hold the actual Storage instance

    public StorageProxy() {
        this.storage = Storage.getInstance();  // Obtain the singleton instance of Storage
    }

    @Override
    public void addBook(Book book) {
        // Log the action or perform other access control checks
        System.out.println("Proxy: Adding a book with ISBN " + book.getISBN());
        storage.addBook(book);  // Delegate the call to the real Storage class
    }

    @Override
    public void removeBook(String isbn) {
        // Log the action or perform other access control checks
        System.out.println("Proxy: Removing a book with ISBN " + isbn);
        storage.removeBook(isbn);  // Delegate the call to the real Storage class
    }

    @Override
    public List<Book> getAllBooks() {
        // You might add caching or other enhancements here
        System.out.println("Proxy: Retrieving all books");
        return storage.getAllBooks();  // Delegate the call to the real Storage class
    }
}
