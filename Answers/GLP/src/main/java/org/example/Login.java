package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login implements ActionListener {
    static int countID ;
    JFrame frame;
    JPanel mainPanel;
    JLabel userID;
    JTextField textFieldID;
    JLabel password;
    JPasswordField textFieldPass;
    JButton login;
    JButton back;
    Login(){
        countID = 0;
        back = new JButton();
        back.setText("Back");
        back.setFocusable(false);
        back.setBounds(75,130,100,50);
        back.setFont(new Font(null, Font.PLAIN, 30));
        back.setForeground(Color.white);
        back.setBackground(new Color(25, 134, 23));
        back.setBorder(BorderFactory.createLineBorder(new Color(25, 134, 23),2));
        back.addActionListener(this);

        //----need improve----
        login = new JButton();
        login.setText("Login");
        login.setFocusable(false);
        login.setBounds(185,130,180,50);
        login.setFont(new Font(null,Font.PLAIN,30));
        login.setForeground(Color.white);
        login.setBackground(new Color(25, 134, 23));
        login.setBorder(BorderFactory.createLineBorder(Color.white,2));
//        login.addActionListener(this);
        //----need improve----

        textFieldPass = new JPasswordField();
        textFieldPass.setBounds(120,60,300,50);
        textFieldPass.setBackground(new Color(10,140,50));
        textFieldPass.setCaretColor(Color.white);
        textFieldPass.setFont(new Font(null,Font.PLAIN,30));
        textFieldPass.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        password = new JLabel();
        password.setText("Pass: ");
        password.setBounds(5,60,110,50);
        password.setFont(new Font(null,Font.PLAIN,30));
        password.setVerticalAlignment(JLabel.CENTER);
        password.setHorizontalAlignment(JLabel.CENTER);
        password.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        textFieldID = new JTextField();
        textFieldID.setBounds(120,5,300,50);
        textFieldID.setBackground(new Color(10,140,50));
        textFieldID.setCaretColor(Color.white);
        textFieldID.setFont(new Font(null,Font.PLAIN,30));
        textFieldID.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        textFieldID.setText("user_1234");

        userID = new JLabel();
        userID.setText("ID: ");
        userID.setBounds(5,5,110,50);
        userID.setFont(new Font(null,Font.PLAIN,30));
        userID.setVerticalAlignment(JLabel.CENTER);
        userID.setHorizontalAlignment(JLabel.CENTER);
        userID.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        mainPanel = new JPanel();
        mainPanel.setBounds(40,30,425,190);
        mainPanel.setBackground(Color.white);

        ImageIcon icon = new ImageIcon("E:\\java\\GLP\\src\\main\\java\\org\\example\\icons\\L.png");

        frame = new JFrame();
        frame.setBounds(600,400,520,290);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(7, 110, 45));
        frame.setTitle("Login Page");
        frame.setIconImage(icon.getImage());

        mainPanel.add(back);
        mainPanel.add(login);
        mainPanel.add(textFieldPass);
        mainPanel.add(password);
        mainPanel.add(textFieldID);
        mainPanel.add(userID);
        frame.add(mainPanel);
        mainPanel.setLayout(null);
        frame.setLayout(null);
        frame.setVisible(true);

        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                login.setForeground(new Color(25, 134, 23));
                login.setBackground(Color.white);
                login.setBorder(BorderFactory.createLineBorder(new Color(25, 134, 23),2));
            }
            public void mouseExited(MouseEvent e){
                login.setBackground(new Color(25,134,23));
                login.setForeground(Color.white);
                login.setBorder(BorderFactory.createLineBorder(Color.white,2));
            }
        });
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                back.setForeground(new Color(25, 134, 23));
                back.setBackground(Color.white);
                back.setBorder(BorderFactory.createLineBorder(new Color(25, 134, 23),2));
            }
            public void mouseExited(MouseEvent e){
                back.setBackground(new Color(25,134,23));
                back.setForeground(Color.white);
                back.setBorder(BorderFactory.createLineBorder(Color.white,2));
            }
        });
        textFieldID.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(countID<1)
                    textFieldID.setText(""); // Clear the text field when clicked
                countID++;
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back){
            back.setEnabled(false);
            frame.dispose();
            new ChoicePage();
        } else if (e.getSource()==login) {
            if(new Validator().userExist(textFieldID.getText(),textFieldPass.getText())){
                JOptionPane.showMessageDialog(null,"Password can't contain just Space",
                        "Information",JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
                new ChoicePage();
            }
        }
    }
}
