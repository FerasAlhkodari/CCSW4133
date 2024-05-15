import java.util.List;

public class Display {
    // Display the general user menu
    public void printMenu() {
        System.out.println("\n1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Search by Title");
        System.out.println("4. List All Books");
        System.out.println("5. Exit");
    }

    // Display the admin-specific menu with more options
    public void printAdminMenu() {
        System.out.println("\n1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Modify Book");
        System.out.println("4. Manage Loans");
        System.out.println("5. View Logs");
        System.out.println("6. Send Notifications");
        System.out.println("7. Review Reports");
        System.out.println("8. Search by Title");
        System.out.println("9. List All Books");
        System.out.println("10. Exit");
    }

    // Print a generic message to the console
    public void print(String message) {
        System.out.println(message);
    }

    // Display a list of books in a formatted manner
    public void displayBooks(List<Book> books) {
        if (books.isEmpty()) {
            print("No books found.");
        } else {
            for (Book book : books) {
                print("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", ISBN: " + book.getISBN());
            }
        }
    }
}
