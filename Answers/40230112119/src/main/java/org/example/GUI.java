package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class GUI {
    public void firstPanel() {
        JFrame frame = new JFrame("User Entry");
        frame.setSize(500, 500);
//        frame.setIconImage(\C\Users\Asus\Downloads\silly.JFIF);

        JLabel welcome = new JLabel("Welcome. Please log in or sign up.");
        welcome.setBounds(90,10, 350, 250);
        welcome.setFont(new Font("Serif", Font.BOLD, 20));

        JButton login = new JButton("Log In");
        JButton signup = new JButton("Sign Up");
        login.setBounds(115, 180, 90, 30);
        signup.setBounds(250, 180, 90, 30);
        login.setBackground(Color.LIGHT_GRAY);
        signup.setBackground(Color.LIGHT_GRAY);

        frame.add(welcome);
        frame.add(login);
        frame.add(signup);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                loginpage();
            }
        });
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                signuppage();
            }
        });
        frame.setLayout(null);
        frame.setVisible(true);

    }
    public void loginpage() {
        JFrame f = new JFrame("Login Page");
        f.setSize(500, 500);
        JLabel l1, l2;
        l1 = new JLabel("Username: ");
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l2 = new JLabel("Password: ");
        l2.setFont(new Font("Serif", Font.BOLD, 20));

        l1.setBounds(30, 100, 150, 30);
        l2.setBounds(30, 150, 150, 30);

        JTextField t1 = new JTextField();
        t1.setBounds(190, 100, 150, 30);
        JPasswordField p = new JPasswordField();
        p.setBounds(190, 150, 150, 30);

        JButton b = new JButton("submit");
        b.setBounds(160, 230, 100, 40);
        JButton b2 = new JButton("I don't have an account");
        b2.setBounds(240, 200, 210, 15);
        b2.setBackground(Color.PINK);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = t1.getText();
                String pass = String.copyValueOf(p.getPassword());
                String hashed = null;
                boolean hasEmptyField = false;

                if (id.isEmpty() || pass.isEmpty() || id.equals(" ") || pass.equals(" ")) {
                    JLabel error = new JLabel("some fields are empty!");
                    error.setBounds(20, 330, 200, 40);
                    hasEmptyField = true;
                    f.add(error);
                    f.repaint();
                }
                if(!hasEmptyField) {

                    User u = new User();
                    try {
                        hashed = u.toHexString(u.getSHA(pass));
                    } catch (NoSuchAlgorithmException ex) {
                        throw new RuntimeException(ex);
                    }

                    boolean userExists = UserStore.readingInfo(id, hashed);
                    if(userExists) {
                        JFrame f2 = new JFrame("message");
                        f2.setBounds(160, 150, 200, 130);
                        f2.setLayout(null);
                        JLabel l1 = new JLabel("Successfully logged in");
                        l1.setBounds(20, 10, 150, 50);
                        f2.add(l1);
                        f2.setVisible(true);
                    }
                    else {
                        JFrame f2 = new JFrame("message");
                        f2.setBounds(160, 150, 200, 130);
                        f2.setLayout(null);
                        JLabel l1 = new JLabel("No user found");
                        l1.setBounds(20, 10, 150, 50);
                        f2.add(l1);
                        f2.setVisible(true);
                    }
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                signuppage();
            }
        });
        f.add(l1); f.add(l2);
        f.add(t1); f.add(p);
        f.add(b); f.add(b2);
        f.setLayout(null);
        f.setVisible(true);
    }
    public void signuppage() {
        JFrame f = new JFrame("SignUp Page");
        f.setSize(500, 500);
        JLabel l1, l2, l3;
        l1 = new JLabel("Username: ");
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l2 = new JLabel("Email: ");
        l2.setFont(new Font("Serif", Font.BOLD, 20));
        l3 = new JLabel("Password: ");
        l3.setFont(new Font("Serif", Font.BOLD, 20));

        l1.setBounds(30, 100, 150, 30);
        l2.setBounds(30, 150, 150, 30);
        l3.setBounds(30, 200, 150, 30);

        JTextField t1, t2;
        t1 = new JTextField();
        t1.setBounds(190, 100, 150, 30);
        t2 = new JTextField();
        t2.setBounds(190, 150, 150, 30);
        JPasswordField p = new JPasswordField();
        p.setBounds(190, 200, 150, 30);

        JButton b = new JButton("submit");
        b.setBounds(160, 280, 100, 40);
        JButton b2 = new JButton("I already have an account");
        b2.setBounds(240, 245, 210, 15);
        b2.setBackground(Color.PINK);

        f.add(l1); f.add(l2); f.add(l3);
        f.add(t1); f.add(t2); f.add(p);
        f.add(b); f.add(b2);
        f.setLayout(null);
        f.setVisible(true);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = t1.getText();
                String email = t2.getText();
                String pass = String.copyValueOf(p.getPassword());
                boolean hasEmptyField = false;

                if (id.isEmpty() || email.isEmpty() || pass.isEmpty() || id.equals(" ") || email.equals(" ") || pass.equals(" ")) {
                    JLabel error = new JLabel("some fields are empty!");
                    error.setBounds(20, 330, 200, 40);
                    hasEmptyField = true;
                    f.add(error);
                    f.repaint();
                }

                User u = new User();
                UserStore us = new UserStore();
                EmailValidator em = new EmailValidator();

                if(!hasEmptyField) {
                    String hashed = null;
                    boolean emailIsValid = true;
                    boolean emailExist = UserStore.readingEmails(email);
                    emailIsValid = em.emailChecker(email);
                    if (!emailIsValid) {
                        JLabel error = new JLabel("Invalid email. Try again.");
                        error.setBounds(20, 300, 200, 40);
                        f.add(error);
                        f.repaint();
                    }
                    if(emailExist) {
                        JLabel error = new JLabel("Email already signed up. Please log in.");
                        error.setBounds(20, 315, 220, 40);
                        f.add(error);
                        f.repaint();
                    }
                    int strength = u.passChecker(pass);
                    if(strength < 5) {
                        String text = null;
                        switch (strength) {
                            case 0:
                                text = "Password too weak. Try another one.";
                                break;
                            case 1:
                                text = "Password too weak. Try another one.";
                                break;
                            case 2:
                                text = "Password is weak. Try another one.";
                                break;
                            case 3:
                                text = "Try a stronger password.";
                                break;
                            case 4:
                                text = "Try a stronger password.";
                                break;
                        }
                        JLabel error = new JLabel(text);
                        error.setBounds(20, 350, 250, 40);
                        f.add(error);
                        f.repaint();
                    }
                    else {
                        try {
                            hashed = u.toHexString(u.getSHA(pass));
                        } catch (NoSuchAlgorithmException ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                    if(emailIsValid && strength == 5) {

                        UserStore.writingInfo(id, email, hashed);

                        JFrame f2 = new JFrame("message");
                        f2.setBounds(160, 150, 200, 130);
                        f2.setLayout(null);
                        JLabel l1 = new JLabel("Successfully signed up");
                        l1.setBounds(20, 10, 150, 50);
                        f2.add(l1);
                        f2.setVisible(true);

                    }
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                loginpage();
            }
        });

    }
}
