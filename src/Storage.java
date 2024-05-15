
import java.util.ArrayList;
import java.util.List;


public class Storage implements StorageInterface {
    private static Storage instance;
    private List<Book> books;

    private Storage() {
        books = new ArrayList<>();
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(String isbn) {
        books.removeIf(b -> b.getISBN().equals(isbn));
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}
