import java.util.List;
import java.util.stream.Collectors;

public class SearchManager {
    private Library library;

    public SearchManager(Library library) {
        this.library = library;
    }

    public List<Book> searchByAuthor(String author) {
        return library.getAllBooks().stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Book> searchByYear(int year) {
        return library.getAllBooks().stream()
                .filter(book -> book.getYear() == year)
                .collect(Collectors.toList());
    }
}
