package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginGUI{
    LoginGUI(){

        JFrame frame = new JFrame();
        JFrame loginFrame = new JFrame();
        JFrame registerFrame = new JFrame();

        JPanel loginPanel = new JPanel();
        JPanel registerPanel = new JPanel();

        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("Login");

        JTextField registerEmail = new JTextField("email",35);
        JTextField registerUsername = new JTextField("username",35);
        JTextField registerPassword = new JTextField("password",35);

        JTextField loginUsername = new JTextField("username",35);
        JTextField loginPassword = new JTextField("password",35);

        JButton button1 = new JButton("Login");
        JButton button2 = new JButton("Register");

        GridLayout layout = new GridLayout(5,1);
        FlowLayout layout1 = new FlowLayout();

        loginPanel.add(loginUsername);
        loginPanel.add(loginPassword);
        loginPanel.add(loginButton);

        registerPanel.add(registerButton);
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
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                registerFrame.setVisible(true);
            }
        });

        frame.setVisible(true);
    }

}