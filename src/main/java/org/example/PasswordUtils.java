package org.example;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.example.UserStore.value2;

class PasswordUtils{
    private static String hashedPassword;

    public String getHashedPassword() {
        return hashedPassword;
    }

    void storePassword(String password){
        hashedPassword = DigestUtils.sha256Hex(password);
    }

     public  static boolean verifyPassword(String password){
        return DigestUtils.sha256Hex(password).equals(value2);
    }
    @Override
    public String toString() {
        return hashedPassword;
    }

    public static int checkPasswordLevel(String password){
        int level = 0;
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches())
            level++;
        Pattern pattern1 = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z]).+$");
        Matcher matcher1 = pattern.matcher(password);
        if(matcher1.matches())
            level++;
        Pattern pattern2 = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$\n");
        Matcher matcher2 = pattern.matcher(password);
        if(matcher2.matches())
            level++;
        Pattern pattern3 = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-@_.]).+$");
        Matcher matcher3 = pattern.matcher(password);
        if(matcher3.matches())
            level++;
        Pattern pattern4 = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-@_.]).+$");
        Matcher matcher4 = pattern.matcher(password);
        if(matcher4.matches())
            level++;

        return 5;

    }
}
