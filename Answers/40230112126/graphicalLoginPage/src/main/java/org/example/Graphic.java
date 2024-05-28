package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Graphic {
    Graphic() {
        JFrame frame = new JFrame("VEZARATE ETELAAT");
        frame.setSize(400, 100);
        JPanel panel = new JPanel();

        JButton button1 = new JButton("SIGN IN");
        button1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                signup();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        JButton button2 = new JButton("LOG IN");

        button2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                login();

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        panel.add(button1);
        panel.add(button2);
        frame.add(panel);
        frame.setVisible(true);
    }

    void signup(){
        JFrame signupFrame = new JFrame("sign in");
        signupFrame.setSize(400, 600);
        JPanel signupPanel = new JPanel(new GridLayout(7,1));

        JLabel label1 = new JLabel("email: ");
        JTextField text1 = new JTextField();

        JLabel label2 = new JLabel("password: ");
        JTextField text2 = new JTextField();

        JLabel label3 = new JLabel("username: ");
        JTextField text3 = new JTextField();

        JButton button = new JButton("sign in");

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!new EmailValid().Validation(text1.getText())) {
                    JDialog dialog = new JDialog(signupFrame);
                    JLabel label = new JLabel("Email does not exist!!!");
                    dialog.add(label);
                    dialog.setSize(200,100);
                    dialog.setVisible(true);

                } else if (new User(text3.getText(), text2.getText(), text1.getText()).usernameAuth()) {
                    JDialog dialog = new JDialog(signupFrame);
                    JLabel label = new JLabel("Username is already taken!!!");
                    dialog.add(label);
                    dialog.setSize(200,200);
                    dialog.setVisible(true);
                }

                else if (!new PasswordUtils().passStrength(text2.getText())) {
                    JDialog dialog = new JDialog(signupFrame);
                    JLabel label = new JLabel("Password is not strong enough(your password must include" +
                            "1.lowercase and uppercase letters \n 2.numbers \n 3.symbols \n 4. must be at least 8 characters)");
                    dialog.add(label);
                    dialog.setSize(200,200);
                    dialog.setVisible(true);
                }

                else {
                    new User(text3.getText(), text2.getText(), text1.getText()).adduser();
                    JDialog dialog = new JDialog(signupFrame);
                    JLabel label = new JLabel("WELCOME!!");
                    dialog.add(label);
                    dialog.setSize(200,200);
                    dialog.setVisible(true);
           }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        signupPanel.add(label1);
        signupPanel.add(text1);
        signupPanel.add(label2);
        signupPanel.add(text2);
        signupPanel.add(label3);
        signupPanel.add(text3);
        signupPanel.add(button);
        signupFrame.add(signupPanel);
        signupFrame.setVisible(true);

    }

    void login(){
        JFrame loginFrame = new JFrame("login");
        loginFrame.setSize(300, 500);
        JPanel loginPanel = new JPanel(new GridLayout(5,1));

        JLabel label1 = new JLabel("username: ");
        JTextField text1 = new JTextField();

        JLabel label2 = new JLabel("password: ");
        JTextField text2 = new JTextField();

        JButton button = new JButton("login");
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PasswordUtils pObj = new PasswordUtils();
                if (new User(text1.getText(),pObj.unhashpass(pObj.passhash(text2.getText())), null).passAuth()) {
                    JDialog dialog = new JDialog(loginFrame);
                    JLabel label = new JLabel("WELCOME BACK!!");
                    dialog.add(label);
                    dialog.setSize(200,200);
                    dialog.setVisible(true);
                }
                else {
                    JDialog dialog = new JDialog(loginFrame);
                    JLabel label = new JLabel("incorrect password!!!");
                    dialog.add(label);
                    dialog.setSize(200,200);
                    dialog.setVisible(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        loginPanel.add(label1);
        loginPanel.add(text1);
        loginPanel.add(label2);
        loginPanel.add(text2);
        loginPanel.add(button);
        loginFrame.add(loginPanel);
        loginFrame.setVisible(true);
    }
}
