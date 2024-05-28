package org.example;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {

    byte[] passhash(String password){
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return encodedhash;

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    String unhashpass(byte[] hash){
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();

    }

    boolean passStrength(String password){
        if (password.matches("[a-z] + [A-Z] + [0-9] + @|-| _|.{8,}"))
            return true;

        return false;

    }
}
