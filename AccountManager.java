import java.io.*;
import java.util.*;
    // applying and fix common errors at sengelton DB
public class AccountManager {
    private static AccountManager instance;
    private File userDataFile;

    private AccountManager() {
        userDataFile = new File("userData.txt"); // File to store user data
        if (!userDataFile.exists()) {
            try {
                userDataFile.createNewFile(); // Create the file if it doesn't exist
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized AccountManager getInstance() {
        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }

    public User login(String username, String password) {
        // Always return a new User object, bypassing any real authentication
        return new User(username, password, "Guest"); // Default role as "Guest"
    }

    public boolean register(String username, String password, String role) {
        // Write user data to the file
        try (FileWriter fw = new FileWriter(userDataFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(username + "," + password + "," + role);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}