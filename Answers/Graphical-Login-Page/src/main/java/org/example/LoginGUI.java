package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LoginGUI {
    UserStore userStore = new UserStore();
    User user = new User();
    public void MainFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
//        frame.setResizable(false); // برای تغییر نکردن سایز frame
        JPanel panel = new JPanel();
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        ImageIcon signup = new ImageIcon("signup.png");
        ImageIcon signin = new ImageIcon("signin.jpg");
        button2.setToolTipText("Enter a username, password, and email");
        button1.setToolTipText("Enter your username and password");
        button2.setIcon(signup);
        button1.setIcon(signin);
        button1.setFocusable(false);
        button2.setFocusable(false);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                JFrame framesignin = SignInFrame();
                framesignin.setVisible(true);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                JFrame framesignup = SignUpFrame();
                framesignup.setVisible(true);
            }
        });
        panel.add(button1);
        panel.add(button2);
        frame.add(panel);
        frame.setVisible(true);
    }
    public JFrame SignInFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("Sign In");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        JButton button1 = new JButton();
        button1.setFocusable(false);
        button1.setText("UserName :");
        JButton button2 = new JButton();
        button2.setFocusable(false);
        button2.setText("Password :");
        JButton button4 = new JButton();
        button4.setFocusable(false);
        button4.setText("Enter");
        JTextField textField1 = new JTextField(40);
        JTextField textField2 = new JTextField(40);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField1.getText();
                JOptionPane.showMessageDialog(frame, input);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField2.getText();
                JOptionPane.showMessageDialog(frame, input);
            }
        });
        JButton returnmain = new JButton();
        ImageIcon imageIcon = new ImageIcon("exit.png");
        returnmain.setIcon(imageIcon);
        returnmain.setToolTipText("Menu");
        returnmain.setFocusable(true);
        panel.setLayout(new GridLayout(6, 1));
        returnmain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                MainFrame();
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input1 = textField1.getText();
                String input2 = textField2.getText();
                userStore.ReadFile();
                boolean flag = User.Checker(input1,input2);
                if (flag)
                {
                    System.out.println("successful");
                }
                else
                {
                    System.out.println("Try Again");
                }
                userStore.WriteFile();
            }
        });
        panel.add(returnmain);
        panel.add(button1);
        panel.add(textField1);
        panel.add(button2);
        panel.add(textField2);
        panel.add(button4);
        frame.setResizable(false);
        frame.add(panel);
        return frame;
    }
    public JFrame SignUpFrame() {
        userStore.ReadFile();
        String[] word = new String[3];
        JFrame frame = new JFrame();
        frame.setTitle("Sign In");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        JButton button1 = new JButton();
        button1.setFocusable(false);
        button1.setText("UserName :");
        JButton button2 = new JButton();
        button2.setFocusable(false);
        button2.setText("Password :");
        JButton button3 = new JButton();
        button3.setFocusable(false);
        button3.setText("email :");
        JButton button4 = new JButton();
        button4.setFocusable(false);
        button4.setText("Enter");
        JTextField textField1 = new JTextField(40);
        JTextField textField2 = new JTextField(40);
        JTextField textField3 = new JTextField(40);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField1.getText();
                JOptionPane.showMessageDialog(frame, input);
//                word[0] = input;
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField3.getText();
                JOptionPane.showMessageDialog(frame, input);
//                word[2] = input;
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField2.getText();
                JOptionPane.showMessageDialog(frame, input);
//                word[1] = input;
            }
        });
//        String sentense = word[0] + "," + "password" + "," + word[2];
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input1 = textField1.getText();
                String input2 = textField2.getText();
                String input3 = textField3.getText();
                String hashed = user.HashingCode(input2);
                String sentense = input1 + "," + hashed + "," + input3;
                userStore.ReadFile();
                userStore.getUser().add(sentense);
                System.out.println("successful");
                userStore.WriteFile();
            }
        });
        JButton returnmain = new JButton();
        ImageIcon imageIcon = new ImageIcon("exit.png");
        returnmain.setIcon(imageIcon);
        returnmain.setToolTipText("Menu");
        returnmain.setFocusable(true);
        panel.setLayout(new GridLayout(8, 1));
        returnmain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                MainFrame();
            }
        });
        panel.add(returnmain);
        panel.add(button1);
        panel.add(textField1);
        panel.add(button2);
        panel.add(textField2);
        panel.add(button3);
        panel.add(textField3);
        panel.add(button4);
        frame.setResizable(false);
        frame.add(panel);
        return frame;
    }
}
