package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPage implements ActionListener {
     JButton b1 , b2;
     JFrame frame;
   public FirstPage(){
        frame = new JFrame();
        frame.setBounds(500 , 200 , 520,520);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Hello!!!");
        frame.getContentPane().setBackground(new Color(206, 185, 25));
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBounds(40, 40, 420 ,400);
        panel.setBackground(new Color(98, 11, 97));

        JLabel label = new JLabel();
        ImageIcon image = new ImageIcon("C:\\Users\\ASUS\\Desktop\\imm.jpg");
        label.setIcon(image);
        label.setBounds(80,20,300,300);
        label.setBorder(null);
        panel.add(label);


        b1 = new JButton();
        b1.setText("sign in");
        b1.setFont(new Font("MV Boli" , Font.BOLD , 20));
        b1.setForeground(new Color(98, 11, 97));
        b1.setBounds(280 , 300 , 100 , 50);
        b1.setBorder(BorderFactory.createLineBorder(Color.WHITE , 3));
        b1.setBackground(new Color(235, 246, 168));
        b1.setFocusable(false);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton();
        b2.setText("log in");
        b2.setFont(new Font("MV Boli" , Font.BOLD , 20));
        b2.setForeground(new Color(98, 11, 97));
        b2.setBounds(50, 300 , 100 , 50);
        b2.setBorder(BorderFactory.createLineBorder(Color.WHITE , 3));
        b2.setBackground(new Color(235, 246, 168));
        b2.setFocusable(false);
        b2.addActionListener(this);
        panel.add(b2);



        panel.setLayout(null);
        frame.add(panel);
        frame.setLayout(null);
        frame.setVisible(true);
    }

     @Override
     public void actionPerformed(ActionEvent e) {
          if(e.getSource() == b1){
               frame.dispose();
               MyFrame m = new MyFrame();

          }else if(e.getSource() == b2){
               frame.dispose();
               LogIn l = new LogIn();
          }
     }
}
