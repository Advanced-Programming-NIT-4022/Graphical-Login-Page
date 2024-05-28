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
    PasswordUtils hashCode = new PasswordUtils();
    public User(){};
    public User(String email , String username , String password)
    {
        setEmail(email);
        setUsernameIn(username);
        this.passwordIn = hashCode.SHA_256(password);
    }




}
