import java.util.regex.Pattern;

public class EmailValidator {
    public boolean emailValidation(String email) {
        return Pattern.matches("/^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$/gm",email);
    }
}
