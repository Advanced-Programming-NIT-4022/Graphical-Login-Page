package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class StartUp extends JFrame {



   public class registerClicked implements ActionListener{
       @Override
       public void actionPerformed(ActionEvent e) {
           setVisible(false);
           new Registration();
       }
   }
    public class logInClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            new LogIn();
            setVisible(false);
        }
    }
    StartUp(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("Start up menu");
        JLabel Instructions = new JLabel("Hi and welcome! Register if you are new and log in if you are not!");
        JButton registerButton = new JButton("Register");
        JButton logInButton= new JButton("Log in");

        add(Instructions);
        add(registerButton);
        add(logInButton);
        setSize(600,600);
        Instructions.setBounds(100,50,600,20);
        registerButton.setBounds(125,100,300,50);
        logInButton.setBounds(125,150,300,50);
        registerButton.addActionListener(new registerClicked());
        logInButton.addActionListener(new logInClicked());
        setLayout(null);
        setVisible(true);

    }














}
