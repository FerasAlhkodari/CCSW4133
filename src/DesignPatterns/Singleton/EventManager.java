import java.util.ArrayList;
import java.util.List;
//Singleton Pattern
public class EventManager {
    private static EventManager instance;
    private List<String> events; // This will store the log of all events.

    private EventManager() {
        events = new ArrayList<>();
    }

    public static synchronized EventManager getInstance() {
        if (instance == null) {
            instance = new EventManager();
        }
        return instance;
    }

    public void logEvent(String event) {
        events.add(event);
    }

    public List<String> getAllEvents() {
        return new ArrayList<>(events); // Return a copy of the events to avoid external modification.
    }
}
