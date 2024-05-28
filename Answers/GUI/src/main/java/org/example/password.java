package org.example;

import javax.swing.*;
import java.security.SecureRandom;

public class password extends SignIn{

    private static final String SALT_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";


    password(){


        //----------------------password level--------------------

        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        String email = txtEmail.getText();

        if (emailValid(email)) {
            int passwordStrength = evaluatePasswordStrength(password);
            String strengthMessage = "Password strength level: " + passwordStrength;
            JOptionPane.showMessageDialog(frame, strengthMessage);

            if (passwordStrength < 3) {
                JOptionPane.showMessageDialog(frame, "Password is too weak!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                saveInFile();
                JOptionPane.showMessageDialog(frame, "Sign In Successful!");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid email format!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    //----------------------password level--------------------


    //----------------------password hashing----------------

    public static String getSaltChars(){
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {

        }
return sb.toString();
    }

    //----------------------password hashing----------------





}
