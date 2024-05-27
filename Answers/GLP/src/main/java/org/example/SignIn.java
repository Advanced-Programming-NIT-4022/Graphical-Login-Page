package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignIn implements ActionListener {
    static int countEmail;
    static int countID;
    JFrame frame;
    JPanel mainPanel;
    JLabel email;
    JTextField textFieldEmail;
    JLabel userID;
    JTextField textFieldID;
    JLabel password;
    JPasswordField passField;
    JLabel confirm;
    JPasswordField confirmField;
    JButton signIn;
    JButton back;
    SignIn(){
        countEmail = 0;
        countID = 0;

        back = new JButton();
        back.setText("Back");
        back.setFocusable(false);
        back.setBounds(75,250,100,50);
        back.setFont(new Font(null, Font.PLAIN, 30));
        back.setForeground(Color.white);
        back.setBackground(new Color(25, 134, 23));
        back.setBorder(BorderFactory.createLineBorder(Color.white,2));
        back.addActionListener(this);

        signIn = new JButton();
        signIn.setText("Sign In");
        signIn.setFocusable(false);
        signIn.setBounds(185,250,180,50);
        signIn.setFont(new Font(null,Font.PLAIN,30));
        signIn.setForeground(Color.white);
        signIn.setBackground(new Color(25, 134, 23));
        signIn.setBorder(BorderFactory.createLineBorder(Color.white,2));
        signIn.addActionListener(this);

        confirmField = new JPasswordField();
        confirmField.setBounds(120,185,300,50);
        confirmField.setBackground(new Color(88, 222, 128));
        confirmField.setCaretColor(Color.BLACK);
        confirmField.setFont(new Font(null,Font.PLAIN,30));
        confirmField.setBorder(BorderFactory.createLineBorder(Color.gray,2));

        confirm = new JLabel();
        confirm.setText("Again: ");
        confirm.setBounds(5,185,110,50);
        confirm.setFont(new Font(null,Font.PLAIN,28));
        confirm.setVerticalAlignment(JLabel.CENTER);
        confirm.setHorizontalAlignment(JLabel.CENTER);
        confirm.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        passField = new JPasswordField();
        passField.setBounds(120,130,300,50);
        passField.setBackground(new Color(88, 222, 128));
        passField.setCaretColor(Color.BLACK);
        passField.setFont(new Font(null,Font.PLAIN,30));
        passField.setBorder(BorderFactory.createLineBorder(Color.gray,2));

        password = new JLabel();
        password.setText("Pass: ");
        password.setBounds(5,130,110,50);
        password.setFont(new Font(null,Font.PLAIN,28));
        password.setVerticalAlignment(JLabel.CENTER);
        password.setHorizontalAlignment(JLabel.CENTER);
        password.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        textFieldID = new JTextField();
        textFieldID.setBounds(120,60,300,50);
        textFieldID.setBackground(new Color(10,140,50));
        textFieldID.setCaretColor(Color.white);
        textFieldID.setFont(new Font(null,Font.PLAIN,30));
        textFieldID.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        textFieldID.setText("user_1234");

        userID = new JLabel();
        userID.setText("ID: ");
        userID.setBounds(5,60,110,50);
        userID.setFont(new Font(null,Font.PLAIN,30));
        userID.setVerticalAlignment(JLabel.CENTER);
        userID.setHorizontalAlignment(JLabel.CENTER);
        userID.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(120,5,300,50);
        textFieldEmail.setBackground(new Color(10,140,50));
        textFieldEmail.setCaretColor(Color.white);
        textFieldEmail.setFont(new Font(null,Font.PLAIN,30));
        textFieldEmail.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        textFieldEmail.setText("example@test.com");

        email = new JLabel();
        email.setText("Email: ");
        email.setBounds(5,5,110,50);
        email.setFont(new Font(null,Font.PLAIN,30));
        email.setVerticalAlignment(JLabel.CENTER);
        email.setHorizontalAlignment(JLabel.CENTER);
        email.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        mainPanel = new JPanel();
        mainPanel.setBounds(40,30,425,310);
        mainPanel.setBackground(Color.white);

        ImageIcon icon = new ImageIcon("E:\\java\\GLP\\src\\main\\java\\org\\example\\icons\\S.png");

        frame = new JFrame();
        frame.setBounds(700,220,520,410);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(7, 110, 45));
        frame.setTitle("Sign In");
        frame.setIconImage(icon.getImage());

        mainPanel.add(back);
        mainPanel.add(signIn);
        mainPanel.add(confirmField);
        mainPanel.add(confirm);
        mainPanel.add(passField);
        mainPanel.add(password);
        mainPanel.add(textFieldID);
        mainPanel.add(userID);
        mainPanel.add(textFieldEmail);
        mainPanel.add(email);
        frame.add(mainPanel);
        mainPanel.setLayout(null);
        frame.setLayout(null);
        frame.setVisible(true);

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
        signIn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                signIn.setForeground(new Color(25, 134, 23));
                signIn.setBackground(Color.white);
                signIn.setBorder(BorderFactory.createLineBorder(new Color(25, 134, 23),2));
            }
            public void mouseExited(MouseEvent e){
                signIn.setBackground(new Color(25,134,23));
                signIn.setForeground(Color.white);
                signIn.setBorder(BorderFactory.createLineBorder(Color.white,2));
            }
        });
        textFieldEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(countEmail<1)
                    textFieldEmail.setText(""); // Clear the text field when clicked
                countEmail++;
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
        }else if(e.getSource()==signIn){
            if(new Validator().isEmail(textFieldEmail.getText())){
                if(new Validator().isID(textFieldID.getText())){
                    if(new Validator().strongPass(passField.getText())){
                        if(passField.getText().equals(confirmField.getText())){
                            JOptionPane.showMessageDialog(null,"Your Login Is Succesfull!","Information",JOptionPane.INFORMATION_MESSAGE);
                            new Saver(textFieldEmail.getText(),textFieldID.getText(),passField.getText());
                            frame.dispose();
                            new ChoicePage();
                        }else{
                            JOptionPane.showMessageDialog(null,"Passwords Are Not Same!","Error",JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            }
        }
    }
}
