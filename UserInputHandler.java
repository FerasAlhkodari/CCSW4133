import java.util.Scanner;

public class UserInputHandler {
    private Library library;
    private Display display;
    private AccountManager accountManager;
    private LoanManager loanManager;

    public UserInputHandler(Library library, Display display, AccountManager accountManager, LoanManager loanManager) {
        this.library = library;
        this.display = display;
        this.accountManager = accountManager;
        this.loanManager = loanManager;
    }

    public void handleUserInput(Scanner scanner) {
        while (true) {
            display.printMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: // Add a book
                    display.print("Enter title: ");
                    String title = scanner.nextLine();
                    display.print("Enter author: ");
                    String author = scanner.nextLine();
                    display.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    display.print("Enter Year of Publication: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    library.addBook(new Book(title, author, isbn, year));
                    break;
                case 2: // Remove a book
                    display.print("Enter ISBN to remove: ");
                    isbn = scanner.nextLine();
                    library.removeBook(isbn);
                    break;
                case 3: // Search by title
                    display.print("Enter title to search: ");
                    title = scanner.nextLine();
                    display.displayBooks(library.searchByTitle(title));
                    break;
                case 4: // Display all books
                    display.displayBooks(library.getAllBooks());
                    break;
                case 5: // Exit
                    return;  // Break out of the loop to end the method
                default:
                    display.print("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
