import java.io.Serial;
import java.io.Serializable;
import java.util.regex.Pattern;

public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String userName;
    private String password;
    private String email;
    public User(String userName,String password,String email){
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
