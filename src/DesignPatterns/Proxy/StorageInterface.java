import java.util.List;
// Adding ProxyInterface
public interface StorageInterface {
    void addBook(Book book);
    void removeBook(String isbn);
    List<Book> getAllBooks();
}
