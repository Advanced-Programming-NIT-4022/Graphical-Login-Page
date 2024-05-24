package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

public class LoginGUI {
    String buttonText;
    JFrame frame, frame1, frame2;
    JButton button, button1, button2, button3, button4, button5;
    JLabel label, label1, label2, label3, label4, label5, label6;
    JTextField text, text1, text2, text3, text4;

    public LoginGUI() {
        frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel("Hell,welcome.In to your user panel ");
        label.setBounds(50, 50, 300, 50);
        label1 = new JLabel("and introduce yourself before taking any action");
        label1.setBounds(50 , 70 , 300 , 50);
        button = new JButton("Login to the user panel");
        button1 = new JButton("Exit");
        button.setBounds(50, 150, 200, 30);
        button1.setBounds(250, 150, 60, 30);
        button.addActionListener(e13 -> {
            frame.dispose();
        });
        button1.addActionListener(e13 -> {
            frame.dispose(); // بستن پنجره پس از ورود موفق
            // ادامه کد بعد از ورود موفق
        });

        button.addActionListener(e -> {
            buttonText = button.getText();
            if (buttonText.equals("Login to the user panel")) {
                int condition = JOptionPane.showOptionDialog(null, null, "Application", 0, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Login", "register"}, null);
                switch (condition) {
                    case 0:
                        frame1 = new JFrame();
                        frame1.setSize(300, 300);
                        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        label2 = new JLabel("Username : ");
                        label2.setBounds(70, 50, 100, 30);
                        text = new JTextField();
                        text.setBounds(150, 50, 100, 30);
                        label3 = new JLabel("Password : ");
                        label3.setBounds(70, 100, 100, 30);
                        text1 = new JTextField();
                        text1.setBounds(150, 100, 100, 30);
                        button2 = new JButton("Ok");
                        button3 = new JButton("Cancle");
                        button2.setBounds(120, 200, 50, 30);
                        button3.setBounds(170, 200, 80, 30);
                        button2.addActionListener(e13 -> {

                            try {
                                if (!new UserStore(new User(text.getText()).username, new User(new PasswordUtils(text1.getText()).level, 2).newPassword).getStatus().isEmpty()) {
                                    frame1.dispose();
                                }
                            } catch (NoSuchAlgorithmException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        button3.addActionListener(e13 -> {
                            frame1.dispose();
                        });
                        frame1.add(label2);
                        frame1.add(label3);
                        frame1.add(text);
                        frame1.add(text1);
                        frame1.add(button2);
                        frame1.add(button3);
                        frame1.setLayout(null);
                        frame1.setVisible(true);

                        break;
                    case 1:
//                        while (true) {
                        frame2 = new JFrame();
                        frame2.setSize(300, 300);
                        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        label4 = new JLabel("Username : ");
                        label4.setBounds(70, 50, 100, 30);
                        text2 = new JTextField();
                        text2.setBounds(150, 50, 100, 30);
                        label5 = new JLabel("Password : ");
                        label5.setBounds(70, 100, 100, 30);
                        text3 = new JTextField();
                        text3.setBounds(150, 100, 100, 30);
                        label6 = new JLabel("Email : ");
                        label6.setBounds(70, 150, 100, 30);
                        text4 = new JTextField();
                        text4.setBounds(150, 150, 100, 30);
                        button4 = new JButton("Ok");
                        button4.setBounds(120, 200, 50, 30);
                        button5 = new JButton("Cancle");
                        button5.setBounds(170, 200, 80, 30);
                        button4.addActionListener(e13 -> {
                            try {
                                if (!new UserStore(new User(text2.getText()).username, new User(new PasswordUtils(text3.getText()).level, 2).newPassword, new EmailValidator(text4.getText()).email).getStatus().isEmpty()) {
                                    frame2.dispose();
                                }
                            } catch (NoSuchAlgorithmException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        button5.addActionListener(e13 -> {
                            frame2.dispose();
                        });
                        frame2.add(label4);
                        frame2.add(label5);
                        frame2.add(label6);
                        frame2.add(text2);
                        frame2.add(text3);
                        frame2.add(text4);
                        frame2.add(button4);
                        frame2.add(button5);
                        frame2.setLayout(null);
                        frame2.setVisible(true);
//                        }
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonText = button1.getText();
                if (buttonText.equals("Exit")) {
                    JOptionPane.showMessageDialog(null, "     Nice to meet you \n            Goodbye");
                }
            }
        });
        frame.add(label);
        frame.add(label1);
        frame.add(button);
        frame.add(button1);
        frame.setLayout(null);
        frame.setVisible(true);


    }
}

















