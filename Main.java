import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize components
        // *fix error new Storage*
        Storage storage = Storage.getInstance();
        Library library = new Library();
        Display display = new Display();
        AccountManager accountManager = AccountManager.getInstance();
        EventManager eventManager = EventManager.getInstance();
        LoanManager loanManager = new LoanManager(); 
        NotificationManager notificationManager = new NotificationManager();  // Initialize NotificationManager
        ReviewManager reviewManager = new ReviewManager();  // Initialize ReviewManager
        DisplayComponent basicDisplay = new BasicDisplay();
        
        // Populate the library with initial books
        library.addBook(new Book("1984", "George Orwell", "9780451524935", 1949));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "9780446310789", 1960));

        // Register initial users for demonstration
        accountManager.register("admin", "admin123", "admin");
        accountManager.register("user", "user123", "user");

        // User interface
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Book Management System!");
        basicDisplay.display("Display Moment!");
        // Attempt login
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        // Applying Factory Pattern
        User user = UserFactory.createUser(username, password, accountManager.login(username, password).getRole());
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful! Welcome, " + user.getUsername());
            if ("admin".equals(user.getRole())) {
                handleAdminInput((Admin) user, library, display, loanManager, eventManager, notificationManager, reviewManager, scanner);
            } else {
                UserInputHandler userInputHandler = new UserInputHandler(library, display, accountManager, loanManager);
                userInputHandler.handleUserInput(scanner);
            }
        } else {
            System.out.println("Login failed! Check your username and password.");
        }
        scanner.close();
    }

    private static void handleAdminInput(Admin admin, Library library, Display display, LoanManager loanManager, EventManager eventManager, NotificationManager notificationManager, ReviewManager reviewManager, Scanner scanner) {
        boolean running = true;
        while (running) {
            display.printAdminMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    display.print("Enter title: ");
                    String title = scanner.nextLine();
                    display.print("Enter author: ");
                    String author = scanner.nextLine();
                    display.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    display.print("Enter Year of Publication: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    admin.addBook(library, new Book(title, author, isbn, year));
                    break;
                case 2:
                    display.print("Enter ISBN to remove: ");
                    isbn = scanner.nextLine();
                    admin.removeBook(library, isbn);
                    break;
                case 3:
                    display.print("Enter ISBN of the book to modify: ");
                    isbn = scanner.nextLine();
                    display.print("Enter new title: ");
                    title = scanner.nextLine();
                    display.print("Enter new author: ");
                    author = scanner.nextLine();
                    admin.modifyBook(library, isbn, title, author);
                    break;
                case 4:
                    display.print("Enter ISBN to check out or return: ");
                    isbn = scanner.nextLine();
                    display.print("Enter user ID: ");
                    String userId = scanner.nextLine();
                    if (!loanManager.checkOutBook(isbn, userId)) {
                        display.print("Book already checked out or ISBN not found.");
                    } else {
                        display.print("Book checked out to user.");
                    }
                    break;
                case 5:
                    display.print("System Logs:");
                    for (String log : eventManager.getAllEvents()) {
                        display.print(log);
                    }
                    break;
                case 6:
                    display.print("Enter notification message: ");
                    String message = scanner.nextLine();
                    notificationManager.addNotification(message);
                    display.print("Notification sent.");
                    break;
                case 7:
                    display.print("Book Reviews:");
                        for (Map.Entry<String, String> entry : reviewManager.getAllReviews().entrySet()) {
                            display.print("ISBN: " + entry.getKey() + " - Review: " + entry.getValue());
                        }
                    break;
                case 8:
                    display.print("Enter title to search: ");
                    title = scanner.nextLine();
                    display.displayBooks(library.searchByTitle(title));
                    break;
                case 9:
                    display.displayBooks(library.getAllBooks());
                    break;
                case 10:
                    running = false;
                    break;
                default:
                    display.print("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void handleUserInput(UserInputHandler userInputHandler, Scanner scanner) {
        userInputHandler.handleUserInput(scanner);
    }
}
