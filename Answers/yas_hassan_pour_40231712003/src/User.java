import java.util.HashMap;

public class User {

    public String getPasswordIn() {
        return passwordIn;
    }

    public void setPasswordIn(String passwordIn) {
        this.passwordIn = passwordIn;
    }

    public String getUsernameIn() {
        return usernameIn;
    }

    public void setUsernameIn(String usernameIn) {
        this.usernameIn = usernameIn;
    }

    private String passwordIn;
    private String usernameIn;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;
    public User(){};
public User(String username, String password)
{
    this.passwordIn = password;
    this.usernameIn = username;
}




}