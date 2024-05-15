// Applying Chain of Responsibility Design Pattern

public class LoginHandler implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getType().equals("Login")) {
            System.out.println("Handling login request");
            // Process login request
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}

