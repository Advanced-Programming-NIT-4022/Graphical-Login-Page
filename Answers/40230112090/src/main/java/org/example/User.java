package org.example;

import javax.swing.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    public String username ;
    public String newPassword ;
    public User(String newPassword , int n)throws NoSuchAlgorithmException{

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(newPassword.getBytes());
        byte[] digest = md.digest();
        StringBuilder hexString = new StringBuilder();
        for (byte b : digest) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        this.newPassword = hexString.toString() ;
    }
    public User(String username) {
        if (username.isEmpty()) {
            this.username = "false";
        } else {
            username = username.trim();
            String[] words = username.split(" ");
            String condition = "true" ;
            for (String s : words) {
                if (s.isEmpty()) {
                    condition = "false";
                    break;
                }
            }
            if (condition.equals("false")) {
                JOptionPane.showMessageDialog(null, "Please enter your username correctly(use a space between first name and last name)", null, JOptionPane.ERROR_MESSAGE);
            }else {
                StringBuilder formatted = new StringBuilder();
                for (String word : words) {
                    formatted.append(Character.toUpperCase(word.charAt(0)))
                            .append(word.substring(1).toLowerCase())
                            .append(" ");
                }
                this.username = formatted.toString().trim();

            }
        }
    }
}
