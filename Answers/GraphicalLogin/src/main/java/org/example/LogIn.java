package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class LogIn extends JFrame {
    Pattern whiteSpaceFinder = Pattern.compile("\\s");

    JTextField usernameBox = new JTextField();
    JPasswordField passwordBox = new JPasswordField();
    JButton logInButton = new JButton("Log in");
    JLabel alternativeOption = new JLabel("I'm new");
    JButton registerButton = new JButton("Register");

    LogIn(){
        setSize(600, 600);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        add(usernameBox);
        add(usernameLabel);
        add(passwordBox);
        add(passwordLabel);
        add(registerButton);
        add(alternativeOption);
        add(logInButton);

        usernameBox.setBounds(100, 100, 200, 30);
        usernameBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameBox.getText();
                if(username.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"No field should remain empty","Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(whiteSpaceFinder.matcher(username).find()){
                    JOptionPane.showMessageDialog(null,"You can't use whitespace","Error",JOptionPane.ERROR_MESSAGE);
                }
                passwordBox.requestFocus();
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
                else if(whiteSpaceFinder.matcher(password).find()){
                    JOptionPane.showMessageDialog(null,"You can't use whitespace","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        passwordLabel.setBounds(25, 160, 200, 30);

        logInButton.setBounds(100, 260, 120, 20);
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameBox.getText();
                String password = passwordBox.getText();

                User logInUtil = new User();
                if(logInUtil.userSearch(username,password)){
                    JOptionPane.showMessageDialog(null,"Log in Successful","Logged in",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,"User or password is invalid","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        alternativeOption.setBounds(100, 290, 200, 20);
        registerButton.setBounds(100, 320, 120, 20);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Registration();
            }
        });

        setLayout(null);
        setVisible(true);

    }
}
