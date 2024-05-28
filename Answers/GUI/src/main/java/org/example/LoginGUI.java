package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class LoginGUI extends JFrame implements ActionListener {

        JFrame frame = new JFrame();

        JButton signInButton = new JButton("Sign in");
        JButton LogInButton = new JButton("Login");

        JLabel label;
        ImageIcon logoimage;

        LoginGUI(){

            //------------sigh in in button------------

            signInButton.setBounds(70, 350, 300, 100);
            signInButton.setFocusable(false);
            signInButton.addActionListener(this);
            signInButton.setFont(new Font(("PT serif"), Font.BOLD, 30));
            signInButton.setForeground(new Color(250, 150, 200));

            //------------sigh in in button------------

            //------------log in in button------------
            LogInButton.setBounds(400, 350, 300, 100);
            LogInButton.setFocusable(false);
            LogInButton.addActionListener(this);
            LogInButton.setFont(new Font(("PT serif"), Font.BOLD, 30));
            LogInButton.setForeground(new Color(250, 150, 200));

            //------------log in in button------------

            // ----------frame-----------


            frame.getContentPane().setBackground(new Color(123,50,100));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Graphical-Login-Page");
            frame.setSize(750, 500);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.add(signInButton);
            frame.add(LogInButton);
            frame.add(label);

            ImageIcon icon = new ImageIcon("img.png");
            frame.setIconImage(icon.getImage());
            // -----------frame------------



logoimage = new ImageIcon("/Users/mohammad/IdeaProjects/GUI/src/main/java/img_1.png");
label = new JLabel(logoimage);




        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == signInButton){
                SignIn signIn = new SignIn();
            }
            if(e.getSource() == LogInButton){
                Login login = new Login();
            }
        }
    }
