import java.util.regex.Pattern;

public class PasswordUtils {
    static String validation(String password) {
        if(Pattern.matches("[A-Z]+|[a-z]+|[0-9]+",password)){
            return "so weak!";
        } else if (Pattern.matches("(?=.*[a-z])(?=.*[A-Z])[a-zA-Z]{2,}", password)) {
            return "not bad!";
        } else if (Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])[a-zA-Z\\d]{3,}$", password)) {
            return "Strong!";
        } else if (Pattern.matches("^(?=.*[!@#$%^&*_.-])[!@#$%^&*a-zA-Z-_.\\d]{1,7}$", password)) {
            return "Too strong";
        } else if (Pattern.matches("(?=.*[!@#$%^&*_.-])(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[!@#$%^&*a-zA-Z-_.\\d]{8,}$", password)){
            return "Unbreakable password";
        }
        return "invalid password";
    }
}
