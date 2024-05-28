package org.example;

import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;


public class MyFrame implements ActionListener {
    int count=0 , count1=0 , count2 = 0 , count3 = 0;
    JButton button1;
    JButton back;
    JFrame frame;
    JTextField txt2;
    JTextField txt;
    JPasswordField txt3;
    JTextField txt4;
    public MyFrame(){
        frame= new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500,200,650,400);
        frame.setResizable(false);
        frame.setTitle("Sign in Page");

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.pink);
        panel1.setBounds(0 , 0 , 150 , 75);

        JLabel label1 = new JLabel();
        label1.setText("Email");
        label1.setBounds(0,0,150 , 75);
        label1.setFont(new Font(null , Font.BOLD, 25));
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.CENTER);

        panel1.add(label1);
        panel1.setLayout(null);

        frame.add(panel1);


        txt = new JTextField();

        txt.setBounds(150 , 0 ,500 , 75);
        txt.setFont(new Font("MV Boli" , Font.PLAIN , 20));
        txt.setBorder(null);
        txt.setCaretColor(Color.white);
        txt.setBackground(Color.gray);
        txt.setText("Type Your Email...");


        txt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(count==0) {
                    txt.setText(null);
                    count++;
                }
            }
        });

        frame.add(txt);

        //another panel 1
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(99, 189, 173));
        panel2.setBounds(0 , 75 , 150 , 75);


        JLabel label2 = new JLabel();
        label2.setText("User Name");
        label2.setBounds(0 , 0, 150 , 75);
        label2.setFont(new Font(null , Font.BOLD, 20));
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setVerticalAlignment(JLabel.CENTER);


        panel2.add(label2);
        panel2.setLayout(null);

        frame.add(panel2);

        txt2= new JTextField();

        txt2.setText("Type UserName...");
        txt2.setBounds(150,75,500,75);
        txt2.setBorder(null);
        txt2.setBackground(new Color(182, 106, 83));
        txt2.setCaretColor(Color.black);
        txt2.setFont(new Font("MV Boli" , Font.PLAIN , 20));
        txt2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(count1==0) {
                    txt2.setText(null);
                    count1++;
                }
            }
        });

        frame.add(txt2);

        //another panel 2

        JPanel panel3 = new JPanel();
        panel3.setBackground(new Color(154, 155, 41));
        panel3.setBounds(0 , 150 , 150 , 75);


        JLabel label3 = new JLabel();
        label3.setText("Password");
        label3.setBounds(0 , 0, 150 , 75);
        label3.setFont(new Font(null , Font.BOLD, 20));
        label3.setHorizontalAlignment(JLabel.CENTER);
        label3.setVerticalAlignment(JLabel.CENTER);


        panel3.add(label3);
        panel3.setLayout(null);

        frame.add(panel3);

        txt3 = new JPasswordField();

        txt3.setText("........");
        txt3.setBounds(150,150,500,75);
        txt3.setBorder(null);
        txt3.setBackground(new Color(117, 71, 71));
        txt3.setCaretColor(Color.WHITE);
        txt3.setFont(new Font("MV Boli" , Font.PLAIN , 20));
        txt3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(count2==0) {
                    txt3.setText(null);
                    count2++;
                }
            }
        });


        frame.add(txt3);

        //another panel 3
        JPanel panel4 = new JPanel();
        panel4.setBackground(new Color(215, 80, 236));
        panel4.setBounds(0 , 225 , 150 , 75);


        JLabel label4 = new JLabel();
        label4.setText("Repeat Pass");
        label4.setBounds(0 , 0, 150 , 75);
        label4.setFont(new Font(null , Font.BOLD, 20));
        label4.setHorizontalAlignment(JLabel.CENTER);
        label4.setVerticalAlignment(JLabel.CENTER);


        panel4.add(label4);
        panel4.setLayout(null);

        frame.add(panel4);

        txt4 = new JTextField();

        txt4.setText("........");
        txt4.setBounds(150,225,500,75);
        txt4.setBorder(null);
        txt4.setBackground(new Color(154, 153, 204));
        txt4.setCaretColor(Color.black);
        txt4.setFont(new Font("MV Boli" , Font.PLAIN , 27));
        txt4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(count3==0) {
                    txt4.setText(null);
                    count3++;
                }
            }
        });

        frame.add(txt4);

        //buttons

        button1 = new JButton();
        button1.setText("sign in");
        button1.setFont(new Font("MV Boli" , Font.BOLD , 20));
        button1.setBorder(BorderFactory.createLineBorder(Color.black , 3));
        button1.setBounds(300,310,100,40);
        button1.setFocusable(false);
        button1.addActionListener(this);
        frame.add(button1);

        //back button
        back  = new JButton();
        back.setBounds(190,310,100,40);
        back.setBorder(BorderFactory.createLineBorder(Color.BLACK , 3));
        back.setText("Back");
        back.setFont(new Font("MV Boli" , Font.BOLD , 20));
        back.setFocusable(false);
        back.addActionListener(this);
        frame.add(back);


        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){

            if(new CheckOptions().CheckEmail(txt.getText())){
                if(new CheckOptions().checkUserName(txt2.getText())){
                    if(new CheckOptions().CheckPass(txt3.getText())){
                        if(txt4.getText().equals(txt3.getText())){
                            try{
                                FileWriter userNameWriter = new FileWriter("info\\email.txt" , true);
                                userNameWriter.append(txt.getText() + "\n");
                                userNameWriter.close();

                                FileWriter emailWriter = new FileWriter("info\\UserName.txt" , true);
                                emailWriter.append(txt2.getText() + "\n");
                                emailWriter.close();

                                FileWriter hashPassWriter = new FileWriter("info\\hashPass.txt" , true);
                                hashPassWriter.append(toHash(txt3.getText()) + "\n");
                                hashPassWriter.close();


                                JOptionPane.showMessageDialog(null , "Done Successfully!" , "Well Done!" , JOptionPane.INFORMATION_MESSAGE);


                            }catch (Exception w){
                                System.out.println("error");
                            }
                            button1.setEnabled(false);
                        }else {
                            JOptionPane.showMessageDialog(null , "Repeat Password Again!" , "Error" , JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        }else if(e.getSource() == back){
            frame.dispose();
            back.setEnabled(false);
            new FirstPage();
        }
    }
    public String toHash(String pass){
        return DigestUtils.sha256Hex(pass);
    }



}