import java.util.regex.Pattern;

public class EmailValidator {
    static Pattern emailPattern = Pattern.compile("^(?!.*[.]{2})(?=(?:[a-zA-Z\\d]\\.?){6}.*@)[a-zA-Z\\d][\\da-zA-Z.]{4,}[a-zA-Z\\d]@(?:[\\da-zA-Z]+.)+[\\da-zA-Z]{2,}$");

    static boolean validate(String email) {
        return emailPattern.matcher(email).matches();
    }
}
