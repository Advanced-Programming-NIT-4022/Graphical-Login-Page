import java.util.regex.Pattern;

public class EmailValidator {
    private static Pattern pattern= Pattern.compile("[a-zA-Z0-9]+[a-zA-Z0-9.]{6,30}[a-zA-Z0-9]+@[a-zA-Z0-9]{3,5}\\.[a-z]{2,4}");
    public static boolean Validation(String email)
    {
        return pattern.matcher(email).matches();
    }
}
