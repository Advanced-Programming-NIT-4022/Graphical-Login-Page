import java.util.regex.Pattern;

public class EmailValidator {
    public static boolean emailValidation(String email) {
        return Pattern.matches("^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",email);
    }
}
