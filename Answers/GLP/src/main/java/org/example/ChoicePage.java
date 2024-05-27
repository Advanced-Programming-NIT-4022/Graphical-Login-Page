package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoicePage implements ActionListener{
    JFrame frame;
    JLabel top;
    JLabel down;
    JButton login;
    JButton signIn;
    ChoicePage(){

        top = new JLabel();
        top.setText("Welcome to The Shit");
        top.setForeground(new Color(247, 8, 8, 242));
        top.setBounds(0,0,400,150);
        top.setVerticalAlignment(JLabel.CENTER);
        top.setHorizontalAlignment(JLabel.CENTER);
        top.setFont(new Font("ROMAN_BASELINE",Font.BOLD,30));

        down = new JLabel();
        down.setBounds(0,150,400,150);

        login = new JButton();
        login.setText("Login");
        login.setBounds(90,30,100,50);
        login.setFocusable(false);
        login.setFont(new Font("MV boli",Font.BOLD,18));
        login.addActionListener(this);

        signIn = new JButton();
        signIn.setText("Sign In");
        signIn.setBounds(210,30,100,50);
        signIn.setFocusable(false);
        signIn.setFont(new Font("MV boli",Font.BOLD,18));
        signIn.addActionListener(this);

        ImageIcon icon = new ImageIcon("E:\\java\\GLP\\src\\main\\java\\org\\example\\icons\\C.png");
        frame = new JFrame();
        frame.setBounds(800,400,410,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(27, 130, 51));
        frame.setIconImage(icon.getImage());
        frame.setTitle("Choice");

        down.add(signIn);
        down.add(login);
        frame.add(down);
        frame.add(top);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==signIn) {
            frame.dispose();
            new SignIn();
        }else if(e.getSource()==login){
            frame.dispose();
            new Login();    }
    }
}
