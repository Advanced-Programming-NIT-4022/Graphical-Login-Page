package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Login implements ActionListener {

    JFrame frame;
    JLabel lblUsername;
    JLabel lblPassword;
    JTextField txtUsername;
    JPasswordField txtPassword;
    JButton btnLogin;
    ArrayList<String> myFile = new ArrayList<>();

    public Login() {
        // Initialize the frame
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(new Color(150, 100, 200));

        // Initialize components
        lblUsername = new JLabel("Username:");
        lblPassword = new JLabel("Password:");

        txtUsername = new JTextField(20);
        txtPassword = new JPasswordField(20);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(this);

        // Layout constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add Username label and text field
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(lblUsername, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(txtUsername, gbc);

        // Add Password label and text field
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(lblPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(txtPassword, gbc);

        // Add Login button
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(btnLogin, gbc);

        // Make the frame visible
        frame.setVisible(true);
    }
    void saveInArraylist(String Username, String Password){
        try{
            File file = new File("store.txt");
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()){
                myFile.add(scan.nextLine());
            }
            if(myFile.contains(Username)){
                if(myFile.contains(Password)){
                    JOptionPane.showMessageDialog(null, "You Logged in successfully", "Error", JOptionPane.INFORMATION_MESSAGE);


                }else {
                    JOptionPane.showMessageDialog(null, "Invalid Password", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }else {
                JOptionPane.showMessageDialog(null, "Invalid Email", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnLogin){
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            saveInArraylist(username, password);
        }
    }
}