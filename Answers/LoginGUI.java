package Answers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI
{
    public void UI()
    {
        JFrame myApp = new JFrame("Login or Registration page");
        myApp.setSize(400,600);
        myApp.setDefaultCloseOperation(myApp.EXIT_ON_CLOSE);
        myApp.setLocationRelativeTo(null); // باعث میشه بیاد در مرکز صفحه نمایشی قرار بگیره
        myApp.setLayout(new GridLayout(12,1,0,10));
        Container container = myApp.getContentPane();
        container.setBackground(Color.white);


        JLabel userNameLabel = new JLabel("Username : ");
        myApp.add(userNameLabel);

        JTextField userName = new JTextField();
        userName.setText("ex : Ali54");
        userName.setBorder(null);
        userName.setBackground(Color.decode("#F3F8FA"));
        myApp.add(userName);

        JLabel passwordLabel = new JLabel("Password : ");
        myApp.add(passwordLabel);

        JTextField Password = new JTextField();
        Password.setBorder(null);
        Password.setBackground(Color.decode("#F3F8FA"));
        myApp.add(Password);

        JLabel emailLabel = new JLabel("Email(only for registration) : ");
        myApp.add(emailLabel);

        JTextField email = new JTextField();
        email.setBorder(null);
        email.setBackground(Color.decode("#F3F8FA"));
        myApp.add(email);

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.decode("#1847A1"));
        loginButton.setForeground(Color.decode("#FFFFFF"));
        loginButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                loginButton.setBackground(Color.decode("#F3F8FA"));
                loginButton.setForeground(Color.decode("#1847A1"));
            }

            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                loginButton.setBackground(Color.decode("#1847A1"));
                loginButton.setForeground(Color.decode("#FFFFFF"));
            }
        });
        myApp.add(loginButton);

        JButton registrationButton =  new JButton("Register");
        registrationButton.setBackground(Color.decode("#1847A1"));
        registrationButton.setForeground(Color.decode("#FFFFFF"));
        registrationButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                registrationButton.setBackground(Color.decode("#F3F8FA"));
                registrationButton.setForeground(Color.decode("#1847A1"));
            }

            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                registrationButton.setBackground(Color.decode("#1847A1"));
                registrationButton.setForeground(Color.decode("#FFFFFF"));
            }
        });
        myApp.add(registrationButton);

        myApp.setVisible(true);
    }
}
