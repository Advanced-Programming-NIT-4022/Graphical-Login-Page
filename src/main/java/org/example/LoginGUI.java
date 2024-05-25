package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

class LoginGUI{
    JTextField registerEmail;
    JTextField registerUsername;
    JTextField registerPassword;
    JTextField loginUsername;
    JTextField loginPassword;
    LoginGUI(){

        JFrame frame = new JFrame();
        JFrame loginFrame = new JFrame();
        JFrame registerFrame = new JFrame();

        JPanel loginPanel = new JPanel();
        JPanel registerPanel = new JPanel();

        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("Login");

         registerEmail = new JTextField("email",35);
         registerUsername = new JTextField("username",35);
         registerPassword = new JTextField("password",35);
         loginUsername = new JTextField("username",35);
         loginPassword = new JTextField("password",35);

        JButton button1 = new JButton("Login");
        JButton button2 = new JButton("Register");

        GridLayout layout = new GridLayout(5,1);
        FlowLayout layout1 = new FlowLayout();

        loginPanel.add(loginUsername);
        loginPanel.add(loginPassword);
        loginPanel.add(loginButton);// button

        registerPanel.add(registerButton);// button
        registerPanel.add(registerUsername);
        registerPanel.add(registerPassword);
        registerPanel.add(registerEmail);

        frame.add(button1);
        frame.add(button2);

        loginFrame.add(loginPanel);
        registerFrame.add(registerPanel);

        registerFrame.setSize(1000,500);
        loginFrame.setSize(500,500);
        frame.setSize(1000,500);

        frame.setLayout(layout1);
        loginFrame.setLayout(layout);
        registerFrame.setLayout(layout);

        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                loginFrame.setVisible(true);

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                registerFrame.setVisible(true);
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameText = registerUsername.getText(); // Access the JTextField and retrieve its text

                String passwordText = registerPassword.getText();

                String emailText = registerEmail.getText();

                if(!EmailValidator.emailValidator(emailText)){
                JOptionPane.showMessageDialog(null,"your email is wrong!");
                } else if (!User.userValidator(usernameText)) {
                    JOptionPane.showMessageDialog(null,"your username is wrong!");
                } //else if () {

                /*} else {
                    User user = new User(usernameText,usernameText,emailText);
                    new UserStore(user);
                    JOptionPane.showMessageDialog(null, "your registration was successful :) ");
                }*/

            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String usernameText = loginUsername.getText(); // Access the JTextField and retrieve its text
                System.out.println("Text retrieved: " + usernameText);

                String passwordText = loginPassword.getText();
                System.out.println("Text retrieved: " + passwordText);
            }
        });

        frame.setVisible(true);
    }

}

// that is a great code!!!! :)