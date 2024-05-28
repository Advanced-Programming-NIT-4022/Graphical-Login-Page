package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LogIn implements ActionListener{
    int count =0 , count1=0;
    JButton b , back;
    JFrame frame;
    JTextField t1;
    JPasswordField t2;
    public LogIn(){
        frame= new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500,200,500,400);
        frame.setTitle("Log in page)");

        JLabel label = new JLabel();
        label.setText("Hi My Friend!");
        label.setFont(new Font("MV Boli" , Font.BOLD , 50));
        label.setBounds(70,0,500,100);
        label.setOpaque(true);
        frame.add(label);

        JPanel panel1 =new JPanel();
        panel1.setBackground(new Color(132, 210, 201));
        panel1.setBounds(0 , 150,110,60);

        JLabel l1 = new JLabel();
        l1.setText("Email");
        l1.setFont(new Font(null , Font.BOLD , 20));
        l1.setBounds(0,0,110,60);
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setVerticalAlignment(JLabel.CENTER);

        panel1.setLayout(null);
        panel1.add(l1);

        t1= new JTextField();
        t1.setBounds(110,150,390,60);
        t1.setText("Type Your Email...");
        t1.setFont(new Font("MV Boli" , Font.BOLD , 20));
        t1.setBorder(null);
        t1.setBackground(new Color(152, 57, 57));
        t1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(count==0) {
                    t1.setText(null);
                    count++;
                }
            }
        });
        frame.add(t1);
        frame.add(panel1);

        //another panel

        JPanel panel2 =new JPanel();
        panel2.setBackground(new Color(40, 133, 72));
        panel2.setBounds(0 , 210,110,60);

        JLabel l2 = new JLabel();
        l2.setText("Password");
        l2.setFont(new Font(null , Font.BOLD , 20));
        l2.setBounds(0,0,110,60);
        l2.setHorizontalAlignment(JLabel.CENTER);
        l2.setVerticalAlignment(JLabel.CENTER);

        panel2.setLayout(null);
        panel2.add(l2);

        t2= new JPasswordField();
        t2.setBounds(110,210,390,60);
        t2.setText("........");
        t2.setFont(new Font("MV Boli" , Font.BOLD , 25));
        t2.setBorder(null);
        t2.setBackground(new Color(202, 116, 220));
        t2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(count1==0) {
                    t2.setText(null);
                    count1++;
                }
            }
        });
        frame.add(t2);
        frame.add(panel2);


        b = new JButton();
        b.setText("log in");
        b.setBorder(BorderFactory.createLineBorder(Color.black , 3));
        b.setFont(new Font("MV Boli" , Font.BOLD , 20));
        b.setFocusable(false);
        b.setBounds(270 , 290 , 100 , 50);
        b.addActionListener(this);
        frame.add(b);


        back = new JButton();
        back.setText("Back");
        back.setFont(new Font("MV Boli" , Font.BOLD , 20));
        back.setBorder(BorderFactory.createLineBorder(Color.BLACK , 3));
        back.setFocusable(false);
        back.setBounds(150 , 290 , 100 , 50);
        back.addActionListener(this);
        frame.add(back);


        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b){
            if(new CheckOptions().checkLogInEmail(t1.getText())){
                if(new CheckOptions().checkLogInPass(t2.getText())){
                    JOptionPane.showMessageDialog(null , "Log In Successfully!" , "Well Done!" , JOptionPane.INFORMATION_MESSAGE);
                    b.setEnabled(false);
                }
            }

        }else if(e.getSource() == back){
            frame.dispose();
            back.setEnabled(false);
            new FirstPage();
        }
    }
}
