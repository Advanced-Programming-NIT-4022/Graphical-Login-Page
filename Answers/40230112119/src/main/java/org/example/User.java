package org.example;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class User {
    public Integer passChecker(String password) {
        String a = "^.*[a-zA-Z0-9]*.*$";
        String b = "^(?=.*[a-z])(?=.*[A-Z]).*$";
        String c = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).*$";
        String d = "^.*[@\\-._]+.*$";
        String e = ".{8,}";
        int count = 0;

        if (Pattern.matches(a, password))
            count++;
        if (Pattern.matches(b, password))
            count++;
        if (Pattern.matches(c, password))
            count++;
        if (Pattern.matches(d, password))
            count++;
        if (Pattern.matches(e, password))
            count++;

        return count;
    }

    public byte[] getSHA(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
    public String toHexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 64)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

}
