package org.example;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordUtils {
    public String level;
    public PasswordUtils(String password) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9@_.-]{9,}$");
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            Pattern pattern3 = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@_.-]).{9,}$");
            Matcher matcher3 = pattern3.matcher(matcher.group());
            if (matcher3.matches()) {
                level = matcher3.group();
            } else {
                JOptionPane.showMessageDialog(null, "Your password has a weak security level.\n Please use lowercase and uppercase letters,\nnumbers and special characters such as\n( @ , - , _ , . )in your password.", null, JOptionPane.ERROR_MESSAGE);
            }


        }
    }
}