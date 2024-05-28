import java.util.Objects;

public class User {
    Password password;
    String username;
    String email;

    public User(String username, Password password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    static boolean verifyUserName(String username) {
        // Todo
        return true;
    }

    static User getValidatedUser(String username, String hashedPassword, String email) {
        User newUser = null;
        if (!verifyUserName(username) || !Password.validateHashedPassword(hashedPassword) || !EmailValidator.validate(email)) {
            newUser = new User(username, Password.passwordByHash(hashedPassword), email);
        }
        return newUser;
    }

    boolean login(String password){
        return this.password.verifyPassword(password);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);

    }

    @Override
    public String toString() {
        return username + ',' + password + ',' + email;
    }
}