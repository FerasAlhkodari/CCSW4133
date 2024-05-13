 //State Design pattern
public interface SessionState {
    void login(SessionContext context);
    void logout(SessionContext context);
    void expire(SessionContext context);
}
