package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration extends JFrame {

     Pattern emailPattern = Pattern.compile("^.+@([a-z]|[A-Z])+\\.[a-z]+$");
     Pattern upperCaseFinder = Pattern.compile("[A-Z]");
     Pattern lowerCaseFinder = Pattern.compile("[a-z]");
     Pattern digitFinder = Pattern.compile("\\d");
     Pattern specialCharacterFinder = Pattern.compile("[!@#$%^&*()_+\\-=.`~><?;:]");


    Matcher usernameMatcher, passwordMatcher, emailMatcher;

    JTextField usernameBox = new JTextField();

    JPasswordField passwordBox = new JPasswordField();

    JTextField emailBox = new JTextField();

    //boolean isStrong = false;


    public String passwordValidator(String password) {
        boolean upperCaseFound = upperCaseFinder.matcher(password).find();
        boolean lowerCaseFound = lowerCaseFinder.matcher(password).find();
        boolean digitFound = digitFinder.matcher(password).find();
        boolean specialCharacterFound = specialCharacterFinder.matcher(password).find();

        int strengthLevel = 0;
        if (upperCaseFound || lowerCaseFound || digitFound) {
            strengthLevel++;
        }
        if (upperCaseFound && lowerCaseFound) {
            strengthLevel++;
        }
        if (upperCaseFound && lowerCaseFound && digitFound) {
            strengthLevel++;
        }
        if (specialCharacterFound) {
            strengthLevel++;
        }
        if (password.length() >= 8) {
            strengthLevel++;
        }
        if (strengthLevel == 1){
            return "Very Weak";
        }
        if (strengthLevel == 2){
            return "Weak";
        }
        if (strengthLevel == 3){
            return "Average";
        }
        if (strengthLevel == 4){
            return "Strong";
        }
        if (strengthLevel == 5){
            return "Very Strong";
        }
        return null;
    }

    JButton registerButton = new JButton("Register");
    JLabel alternativeOption = new JLabel("I already have an account:");
    JButton logInButton = new JButton("Log in");
    JLabel passwordStrengthMessage = new JLabel();
    Registration() {

        setSize(600, 600);
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel emailLabel = new JLabel("Email:");

        add(usernameBox);
        add(usernameLabel);
        add(passwordBox);
        add(passwordLabel);
        add(emailBox);
        add(emailLabel);
        add(registerButton);
        add(alternativeOption);
        add(logInButton);
        add(passwordStrengthMessage);

        usernameBox.setBounds(100, 100, 200, 30);
        usernameBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameBox.getText();
                if(username.isEmpty()){
                    JOptionPane.showMessageDialog(null,"No field should remain empty","Error",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    passwordBox.requestFocus();
                }
            }
        });
        usernameLabel.setBounds(25, 100, 200, 30);

        passwordBox.setBounds(100, 160, 200, 30);
        passwordBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String password = passwordBox.getText();
                if(password.isEmpty()){
                    JOptionPane.showMessageDialog(null,"No field should remain empty","Error",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    passwordStrengthMessage.setText(passwordValidator(password));
                    emailBox.requestFocus();
                }
            }
        });
        passwordLabel.setBounds(25, 160, 200, 30);
        passwordStrengthMessage.setBounds(180,128,200,30);

        emailBox.setBounds(100, 220, 200, 30);
        emailBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailBox.getText();
                if(email.isEmpty()){
                    JOptionPane.showMessageDialog(null,"No field should remain empty","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        emailLabel.setBounds(25, 220, 200, 30);

        registerButton.setBounds(100, 260, 120, 20);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameBox.getText();
                String password = passwordBox.getText();
                String email = emailBox.getText();



                //user registration



            }
        });
        alternativeOption.setBounds(100, 290, 200, 20);
        logInButton.setBounds(100, 320, 120, 20);
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });



        setLayout(null);
        setVisible(true);

    }


}
