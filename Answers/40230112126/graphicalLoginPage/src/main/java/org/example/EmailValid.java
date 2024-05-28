package org.example;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValid {
    public boolean Validation(String email) {
        Pattern pattern1 = Pattern.compile(".@");
        Pattern pattern2 = Pattern.compile("@.");
        Pattern pattern3 = Pattern.compile("^[0-9]");
        Matcher match1 = pattern1.matcher(email);
        Matcher match2 = pattern2.matcher(email);
        Matcher match3 = pattern3.matcher(email);

       // boolean b = "@".equals(email.charAt(email.length()-1));

        if (match3.find() && match2.find() && match1.find())
            return false;
        return true;
    }
}
