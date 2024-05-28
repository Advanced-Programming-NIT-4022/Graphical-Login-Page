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

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getEmail() {
        return email;
    }
}