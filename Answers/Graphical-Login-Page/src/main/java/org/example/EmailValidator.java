package org.example;

import java.util.regex.*;

public class EmailValidator {
    // "([A-Za-z0-9]{4,}||[.-_%]{1})
    // "^([A-Za-z0-9]{4,}|[.-_%]{1}){5,}@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$"
    private static final String RegexEmail = "^[a-zA-Z0-9]*(?:\\.+)[a-zA-Z0-9]{2,}@(?:[a-zA-Z0-9-]+)\\.[a-zA-Z]{2,7}$" ;
    public static String getRegexEmail() {
        return RegexEmail;
    }
    public static boolean Validated(String email) {
        Pattern pattern = Pattern.compile(getRegexEmail());
        Matcher matcher = pattern.matcher(email);
        boolean flag = matcher.find();
        return  flag;
    }
}
