public class User {
    private String username;
    private String hashedPassword;
    private String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.hashedPassword = PasswordUtils.hashPassword(password);
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getEmail() {
        return email;
    }
}
