package backend;

import java.util.regex.Pattern;

public class EmailValidator {

    private static final Pattern email_validator_pattern = Pattern.compile("^[a-zA-Z0-9]+@([a-zA-Z]+.)+[a-zA-Z]+$");

    protected static boolean emailValidatorFunc(String email) {
        return email_validator_pattern.matcher(email).find();
    }
}
