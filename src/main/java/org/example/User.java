package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class User {
    String username;
    String password;

    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return username + ',' + password + ',' + email;
    }
    public static boolean userValidator(String username) {
        Pattern pattern = Pattern.compile("^(?:[^0-9\\.])(?:(?:(?:[a-zA-Z0-9])(?:\\.)?)){6,}[^\\.]$");
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
}