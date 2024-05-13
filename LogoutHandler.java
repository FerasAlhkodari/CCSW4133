//Applying Responspility of chains Design pattern

public class LogoutHandler implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getType().equals("Logout")) {
            System.out.println("Handling logout request");
            // Here you would add the logic to handle the logout process
        } else if (next != null) {
            next.handleRequest(request);
        } else {
            System.out.println("No handler available for request type: " + request.getType());
        }
    }
}
