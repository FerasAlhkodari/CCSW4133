public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password, "admin");
    }

    public void addBook(Library library, Book book) {
        library.addBook(book);
    }

    public void removeBook(Library library, String isbn) {
        library.removeBook(isbn);
    }

    public void modifyBook(Library library, String isbn, String newTitle, String newAuthor) {
        library.modifyBook(isbn, newTitle, newAuthor);
    }
}
