package org.example;

import java.util.regex.Pattern;

public class EmailValidator {
    String regex = "^[a-zA-Z0-9]+\\.?[a-zA-Z0-9]+@.*\\.com$";
    public boolean emailChecker(String email) {
        return Pattern.matches(regex, email);
    }
}
