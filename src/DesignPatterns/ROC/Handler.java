//Applying Responspility of chains Design pattern
public interface Handler {
    void setNext(Handler handler);
    void handleRequest(Request request);
}
