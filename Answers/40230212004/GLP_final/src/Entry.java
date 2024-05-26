import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Entry {
    TemporaryStorage tem = new TemporaryStorage();
    public boolean checkEmail(String email) {
        Pattern pt = Pattern.compile("^.{4,}@.{5,}\\.com");
        Matcher mt = pt.matcher(email);
        if (mt.matches()) {
            return true;
        } else {
            return false;
        }
    }
    public boolean checkPassword(String password) {
        boolean answear = true;
        for (int i=0 ; i<password.length() ; i++) {
            int a = password.charAt(i);
            if (97<=a && a<=122) {
                continue;
            }else if (65<=a && a<=90) {
                continue;
            }else if (49<=a && a<=57) {
                continue;
            }else if ((33 <= a && a <= 47) || (58 <= a && a <= 64)) {
                continue;
            }else {
                answear = false;
                break;
            }
        }
        return answear;
    }
    public boolean checkLowerCase(String password) {
        boolean answear = false;
        for (int i=0 ; i<password.length() ; i++) {
            int a = password.charAt(i);
            if (97<=a && a<=122) {
                answear = true;
            }
        }
        return answear;
    }
    public boolean checkUpperCase(String password) {
        boolean answear = false;
        for (int i=0 ; i<password.length() ; i++) {
            int a = password.charAt(i);
            if (65<=a && a<=90) {
                answear = true;
            }
        }
        return answear;
    }
    public boolean checkNum(String password) {
        boolean answear = false;
        for (int i=0 ; i<password.length() ; i++) {
            int a = password.charAt(i);
            if (49<=a && a<=57) {
                answear = true;
            }
        }
        return answear;
    }
    public boolean checkSpec(String password) {
        boolean answear = false;
        for (int i=0 ; i<password.length() ; i++) {
            int a = password.charAt(i);
            if ((33 <= a && a <= 47) || (58 <= a && a <= 64)) {
                answear = true;
                break;
            }
        }
        return answear;
    }
    public int evaluatePassword(String password) {
        int level = 1;
        if (password.length() > 8) {
            level = 5;
        } else if (checkSpec(password)) {
            level = 4;
        } else if (checkLowerCase(password) && checkUpperCase(password) && checkNum(password)) {
            level = 3;
        } else if (checkLowerCase(password) && checkUpperCase(password)) {
            level = 2;
        }
        return level;
    }
    public String passwordEncoder(String password) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        String encoded = "";
        for (byte i : encodedhash) {
            encoded = encoded + i;
        }
        return encoded;
    }
}
