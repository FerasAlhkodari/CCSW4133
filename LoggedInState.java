public class LoggedInState implements SessionState {
    @Override
    public void login(SessionContext context) {
        System.out.println("User already logged in.");
    }

    @Override
    public void logout(SessionContext context) {
        System.out.println("User logging out...");
        context.setState(new LoggedOutState());
    }

    @Override
    public void expire(SessionContext context) {
        System.out.println("Session expired.");
        context.setState(new LoggedOutState());
    }
}