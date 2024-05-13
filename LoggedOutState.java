public class LoggedOutState implements SessionState {
    @Override
    public void login(SessionContext context) {
        System.out.println("User logging in...");
        context.setState(new LoggedInState());
    }

    @Override
    public void logout(SessionContext context) {
        System.out.println("No action. User already logged out.");
    }

    @Override
    public void expire(SessionContext context) {
        System.out.println("No action. User not logged in.");
    }
}

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
