package org.example;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PasswordUtils{
    private String hashedPassword;

    public String getHashedPassword() {
        return hashedPassword;
    }

    void storePassword(String password){
        hashedPassword = DigestUtils.sha256Hex(password);
    }

    boolean verifyPassword(String password){
        return DigestUtils.sha256Hex(password).equals(hashedPassword);
    }

    @Override
    public String toString() {
        return hashedPassword;
    }


}
