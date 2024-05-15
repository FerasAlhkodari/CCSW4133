public class UserFactory {
    public static User createUser(String username, String password, String role) {
        if ("admin".equals(role)) {
            return new Admin(username, password);
        } else {
            return new User(username, password, role);
        }
    }
}