import java.util.regex.Pattern;

public class EmailValidator {

    public static boolean emailValidation(String email){
        String standardEmail = "^[a-zA-Z0-9_]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$";
        return Pattern.matches(standardEmail, email);
    }
}
