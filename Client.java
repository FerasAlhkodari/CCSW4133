public class Client {
    public static void main(String[] args) {
        Handler loginHandler = new LoginHandler();
        Handler logoutHandler = new LogoutHandler();

        loginHandler.setNext(logoutHandler);

        Request loginRequest = new Request("Login");
        loginHandler.handleRequest(loginRequest);

        Request logoutRequest = new Request("Logout");
        loginHandler.handleRequest(logoutRequest);
    }
}
