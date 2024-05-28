public class User {
    private String username;
    private String hashedPassword;
    private String email;

    public User(String username, String hashedPassword, String email) {
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public boolean checkPassword(String password) {
        return this.hashedPassword.equals(PasswordUtils.hashPassword(password));
    }

    public boolean enter(String login, String password) {
        return this.username.equals(login) && checkPassword(password);
    }

    @Override
    public String toString() {
        return username + "," + hashedPassword + "," + email;
    }
}
