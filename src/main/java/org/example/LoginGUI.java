package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginGUI{
    LoginGUI(){
        JFrame frame = new JFrame();
        JButton button1 = new JButton("Login");
        JButton button2 = new JButton("Register");
        FlowLayout layout = new FlowLayout();
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ;
            }
        });
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ;
            }
        });
        frame.add(button1);
        frame.add(button2);
        frame.setSize(500,500);
        frame.setLayout(layout);
        frame.setVisible(true);
    }

}