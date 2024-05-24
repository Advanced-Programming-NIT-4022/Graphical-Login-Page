package org.example;

import org.apache.commons.codec.digest.DigestUtils;

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

    //String passwordLevel(String password){
        //if
   // }

}