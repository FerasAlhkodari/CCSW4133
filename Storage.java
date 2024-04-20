import java.util.ArrayList;
import java.util.List;
//Applying Singleton Pattern
public class Storage {
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

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String isbn) {
        books.removeIf(b -> b.getISBN().equals(isbn));
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}
