package org.example;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordUtils {
    public String level;

    public PasswordUtils(String password) {

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9@_.-]+$");
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {

            Pattern pattern1 = Pattern.compile("^[a-z]+|[A-Z]+|[0-9]+$");
            Matcher matcher1 = pattern1.matcher(matcher.group());
            if (matcher1.matches()) {
                level = "false";
            }

            Pattern pattern2 = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z]).{1,4}$");
            Matcher matcher2 = pattern2.matcher(matcher.group());
            if (matcher2.matches()) {
                level = "false";
            }

            Pattern pattern3 = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{5,}$");
            Matcher matcher3 = pattern3.matcher(matcher.group());
            if (matcher3.matches()) {
                level = matcher3.group();
            }

            Pattern pattern4 = Pattern.compile("^(?=.*[a-zA-Z0-9])(?=.*[._\\-@]).{5,}$");
            Matcher matcher4 = pattern4.matcher(matcher.group());
            if (matcher4.matches()){
                level = matcher4.group() ;
            }

            Pattern pattern5 = Pattern.compile("^(?=.*[a-zA-Z0-9@_.-]).{9,}$");
            Matcher matcher5 = pattern5.matcher(matcher.group());
            if (matcher5.matches()) {
                level = matcher5.group();
            }
        }
    }
}