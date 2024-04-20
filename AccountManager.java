import java.util.HashMap;
import java.util.Map;
//Singleton pattern
public class AccountManager {
    private static AccountManager instance;
    private Map<String, User> users; // This holds the user details.

    private AccountManager() {
        users = new HashMap<>();
    }

    public static synchronized AccountManager getInstance() {
        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }

    public boolean register(String username, String password, String role) {
        if (!users.containsKey(username)) {
            users.put(username, new User(username, password, role));
            return true;
        }
        return false;
    }

    public User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}