public class SessionContext {
    private SessionState currentState;

    public SessionContext() {
        currentState = new LoggedOutState();  // default state
    }

    public void setState(SessionState state) {
        this.currentState = state;
    }

    public void login() {
        currentState.login(this);
    }

    public void logout() {
        currentState.logout(this);
    }

    public void expire() {
        currentState.expire(this);
    }
}
