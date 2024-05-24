package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator{
    String email;

    public static boolean emailValidator(String email) {
        Pattern pattern = Pattern.compile("^(?:(?:[a-zA-Z0-9])(?:\\.)?){6,}[^\\.]@(?:(?:[a-zA-Z0-9])(?:\\.)?)+[a-z-A-Z0-9]{2}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
