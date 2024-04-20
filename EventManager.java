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
/*Explanation of Singleton Implementation
Private Constructor: The constructor for both AccountManager and EventManager is made private to prevent external instantiation.
Static Instance Variable: A static variable holds the instance of the class. It's initially set to null and created internally when required.
Public Static Method (getInstance()): Provides a global access point to the instance and ensures that only one instance of the class is created. The use of synchronized ensures thread safety, which is essential in a multi-threaded environment to prevent creating multiple instances. */