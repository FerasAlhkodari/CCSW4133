import java.util.ArrayList;
import java.util.List;

public class NotificationManager {
    private List<String> notifications;

    public NotificationManager() {
        notifications = new ArrayList<>();
    }

    public void addNotification(String notification) {
        notifications.add(notification);
    }

    public List<String> getAllNotifications() {
        return notifications;
    }
}
