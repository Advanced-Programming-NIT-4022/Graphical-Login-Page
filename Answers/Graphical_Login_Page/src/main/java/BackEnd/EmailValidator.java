package BackEnd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    // this method check email validation by regex :
    public boolean emailValidation(String email) {
        Pattern emailValidation = Pattern.compile("\\b^[a-zA-Z0-9.]{6,30}@[a-zA-Z0-9.]{3,5}\\.[a-z]{2,4}\\b");
        Matcher matcher = emailValidation.matcher(email);
        return matcher.find();
    }
}
