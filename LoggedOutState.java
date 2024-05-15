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

