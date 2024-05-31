package org.example;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static boolean emailcheck(String s){
        Pattern pr1 = Pattern.compile("^([a-zA-Z0-9]+(?:[\\.\\-\\_]{1}[a-zA-Z0-9]+)*)@([a-zA-Z0-9]+\\.)+[a-zA-Z]+$");
        Matcher m1 = pr1.matcher(s);

        if(m1.matches()){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean usernamecheck(String S){
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].trim().equals(S)) {
                    return false;
                }
            }
        } catch (FileNotFoundException ex) {
            // If the file doesn't exist, we consider the name unique (first entry)
            return true;
        } catch (IOException ex) {
            System.err.println("Error reading file: " + ex.getMessage());
        }
        return true;
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    // Method to hash password using SHA-256
    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(encodedhash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        JFrame frame= new JFrame("Registration Panel:");
        frame.setBounds(500,200,500,500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel label4= new JLabel("SIGN IN");
        label4.setBounds(155 ,65,160 ,30 );
        label4.setFont(new Font("Garamond", Font.BOLD,39 ));

        JTextField textField1 = new JTextField("");
        textField1.setBounds(260, 150 , 150 ,20  );
        JLabel label1= new JLabel("Username :   ");
        label1.setBounds(100 ,150,120 ,20 );
        label1.setFont(new Font("Garamond", Font.BOLD, 21));

        JTextField textField4 = new JTextField("");
        textField4.setBounds(260, 150 , 150 ,20  );
        JLabel label6= new JLabel("Username :   ");
        label6.setBounds(100 ,150,120 ,20 );
        label6.setFont(new Font("Garamond", Font.BOLD, 21));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(260, 200 , 130 ,20  );
        JLabel label2= new JLabel("Password :   ");
        label2.setBounds(100 ,200,120 ,20 );
        label2.setFont(new Font("Garamond", Font.BOLD, 21));

        JPasswordField passwordField1 = new JPasswordField();
        passwordField1.setBounds(260, 200 , 130 ,20  );

        JTextField textField = new JTextField();
        textField.setBounds(260, 200 , 130 ,20 );
        textField.setVisible(false); // Initially, it is not visible

        JTextField showpassword = new JTextField();
        showpassword.setBounds(260, 200 , 130 ,20 );
        showpassword.setVisible(false); // Initially, it is not visible

        JCheckBox showPasswordCheckBox = new JCheckBox("");
        showPasswordCheckBox.setBounds(390, 200 , 20 ,20);

        JCheckBox showPasswordCheckBox1 = new JCheckBox("");
        showPasswordCheckBox1.setBounds(390, 200 , 20 ,20);

        JLabel label7= new JLabel("Password :   ");
        label7.setBounds(100 ,200,120 ,20 );
        label7.setFont(new Font("Garamond", Font.BOLD, 21));

        JTextField textField3 = new JTextField(20);
        textField3.setBounds(260, 250 , 150 ,20  );
        JLabel label3= new JLabel("Email address :   ");
        label3.setBounds(100 ,250,160 ,20 );
        label3.setFont(new Font("Garamond", Font.BOLD, 21));

        JButton Button1 = new JButton("sign in");
        Button1.setBounds(188  ,300, 93 ,34 );
        Button1.setFont(new Font("Garamond", Font.BOLD,  20));

        JLabel label5= new JLabel(" already have an account? ");
        label5.setBounds(130 ,425,170 ,20 );
        label5.setFont(new Font("Garamond", Font.BOLD, 14));

        JLabel label12= new JLabel(" Don't have an account? ");
        label12.setBounds(130 ,425,170 ,20 );
        label12.setFont(new Font("Garamond", Font.BOLD, 14));

        JLabel label8= new JLabel("Login");
        label8.setBounds(185 ,60,100 ,40 );
        label8.setFont(new Font("Garamond", Font.BOLD,35 ));

        JButton Button2 = new JButton("Login");
        Button2.setBounds(290  ,427, 60 ,18 );
        Button2.setFont(new Font("Garamond", Font.BOLD, 10));
        frame.setLayout(null);
        //------------------
        JFrame frame1= new JFrame("Login Panel");
        frame1.setBounds(500,200,500,500);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setLayout(null);

        JButton Button3 = new JButton("click me");
        Button3.setBounds(188  ,300, 93 ,35 );
        Button3.setFont(new Font("Garamond", Font.BOLD, 16));

        JButton Button4 = new JButton("Back");
        Button4.setBounds(290  ,427, 60 ,18 );
        Button4.setFont(new Font("Garamond", Font.BOLD, 10));

        JLabel label10= new JLabel();
        label10.setBounds(412, 250 , 130 ,20  );
        frame.add(label10);

        JLabel label11= new JLabel();
        label11.setBounds(412, 200 , 130 ,20  );
        frame.add(label11);

        JLabel label13= new JLabel();
        label13.setBounds(412, 200 , 130 ,20  );
        frame1.add(label13);
        //---------------------------------

        ImageIcon background = new ImageIcon("C:\\Users\\ASUS\\Downloads\\Telegram Desktop\\photo_2024-05-28_00-41-17.jpg");

        JPanel backgroundPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null);
        backgroundPanel.setSize(frame.getWidth(), frame.getHeight());


        ImageIcon background1 = new ImageIcon("C:\\Users\\ASUS\\Downloads\\Telegram Desktop\\photo_2024-05-28_00-41-17.jpg");

        JPanel backgroundPanel1 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel1.setLayout(null);
        backgroundPanel1.setSize(frame.getWidth(), frame.getHeight());

        Color customColor6 = new Color(00, 100, 140); // Blue
        label4.setBackground(customColor6);
        Color customColor5 = new Color(5, 30, 100); // Blue
        Color customColor4 = new Color(200, 220, 200); // Custom Purple
        Color customColor3 = new Color(70, 140, 130); // Custom Purple
        Color customColor2 = new Color(150, 220, 200); // Blue

        label1.setBackground(customColor2);
        label2.setBackground(customColor2);
        label3.setBackground(customColor2);
        label4.setBackground(customColor2);
        label5.setBackground(customColor4);
        label6.setBackground(customColor2);
        label7.setBackground(customColor2);
        label8.setBackground(customColor2);

        Button1.setBackground(customColor4);
        Button2.setBackground(customColor4);
        Button3.setBackground(customColor4);
        Button4.setBackground(customColor4);

        //------------------

        frame.add(textField1);
        frame.add(label1);
        frame.add(label2);
        frame.add(textField3);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(Button1);
        frame.add(Button2);

        frame1.add(textField4);
        frame1.add(label6);
        frame1.add(label7);
        frame1.add(label8);
        frame1.add(Button3);
        frame1.add(label12);
        // Add the components to the frame
        frame.add(passwordField);
        frame1.add(passwordField1);
        frame.add(textField);
        frame1.add(showpassword);
        frame.add(showPasswordCheckBox);
        frame1.add(showPasswordCheckBox1);
        frame1.add(Button4);
        //---------------------
        //backgroundPanel.add(label1);
        frame.getContentPane().add(backgroundPanel);
        frame1.getContentPane().add(backgroundPanel1);

        frame.setVisible(true);
        //----------------------------------------------
        //checking box for showing password
        showPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckBox.isSelected()) {
                    // Show the password in plain text
                    textField.setText(new String(passwordField.getPassword()));
                    textField.setVisible(true);
                    passwordField.setVisible(false);
                } else {
                    // Mask the password
                    passwordField.setText(textField.getText());
                    passwordField.setVisible(true);
                    textField.setVisible(false);
                }
                // Revalidate the frame to update the layout
                frame.revalidate();
                frame.repaint();
            }
        });

        // Add a DocumentListener to synchronize the content of both fields
        passwordField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                if (!textField.isVisible()) {
                    textField.setText(new String(passwordField.getPassword()));
                }
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                if (!textField.isVisible()) {
                    textField.setText(new String(passwordField.getPassword()));
                }
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                // Not needed for plain text fields
            }
        });

        textField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                if (!passwordField.isVisible()) {
                    passwordField.setText(textField.getText());
                }
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                if (!passwordField.isVisible()) {
                    passwordField.setText(textField.getText());
                }
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                // Not needed for plain text fields
            }
        });
        //-----------------------------------------------
        showPasswordCheckBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckBox1.isSelected()) {
                    // Show the password in plain text
                    showpassword.setText(new String(passwordField1.getPassword()));
                    showpassword.setVisible(true);
                    passwordField1.setVisible(false);
                } else {
                    // Mask the password
                    passwordField1.setText(showpassword.getText());
                    passwordField1.setVisible(true);
                    showpassword.setVisible(false);
                }
                // Revalidate the frame to update the layout
                frame1.revalidate();
                frame1.repaint();
            }
        });

        // Add a DocumentListener to synchronize the content of both fields
        passwordField1.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                if (!showpassword.isVisible()) {
                    showpassword.setText(new String(passwordField1.getPassword()));
                }
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                if (!showpassword.isVisible()) {
                    showpassword.setText(new String(passwordField1.getPassword()));
                }
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                // Not needed for plain text fields
            }
        });

        showpassword.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                if (!passwordField1.isVisible()) {
                    passwordField1.setText(showpassword.getText());
                }
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                if (!passwordField1.isVisible()) {
                    passwordField1.setText(showpassword.getText());
                }
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                // Not needed for plain text fields
            }
        });
        //----------------------------------------------------------
        passwordField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handleDocumentEvent1();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                handleDocumentEvent1();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                handleDocumentEvent1();
            }

            private void handleDocumentEvent1() {
                String password = passwordField.getText();
                Pattern pr1 = Pattern.compile("([a-z]+)");
                Pattern pr2 = Pattern.compile("([A-Z]+)");
                Pattern pr3 = Pattern.compile("([0-9]+)");
                Pattern pr4 = Pattern.compile("([@\\-._]+)");

                Matcher m1 = pr1.matcher(password);
                Matcher m2 = pr2.matcher(password);
                Matcher m3 = pr3.matcher(password);
                Matcher m4 = pr4.matcher(password);
                //LEVEL 5
                if(password.length()>=8){
                    label11.setText("5");
                }
                //LEVEL 4
                else if(m4.find() ){
                    label11.setText("4");

                }
                //LEVEL 3
                else if(m1.find() && m2.find() && m3.find()){
                    label11.setText("3");

                }
                //LEVEL 2
                else if(m3.find() && m2.find()){
                    label11.setText("2");

                }
                //LEVEL 1
                else if(m2.find()){
                    label11.setText("1");

                }
                else {
                    label11.setText("1");
                }

            }
        });

        passwordField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handleDocumentEvent1();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                handleDocumentEvent1();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                handleDocumentEvent1();
            }
            private void handleDocumentEvent1() {
                String password = passwordField1.getText();
                Pattern pr1 = Pattern.compile("([a-z]+)");
                Pattern pr2 = Pattern.compile("([A-Z]+)");
                Pattern pr3 = Pattern.compile("([0-9]+)");
                Pattern pr4 = Pattern.compile("([@\\-._]+)");

                Matcher m1 = pr1.matcher(password);
                Matcher m2 = pr2.matcher(password);
                Matcher m3 = pr3.matcher(password);
                Matcher m4 = pr4.matcher(password);
                //LEVEL 5
                if(password.length()>=8){
                    label13.setText("5");
                }
                //LEVEL 4
                else if(m4.find() ){
                    label13.setText("4");

                }
                //LEVEL 3
                else if(m1.find() && m2.find() && m3.find()){
                    label13.setText("3");

                }
                //LEVEL 2
                else if(m3.find() && m2.find()){
                    label13.setText("2");

                }
                //LEVEL 1
                else if(m2.find()){
                    label13.setText("1");

                }
                else {
                    label13.setText("1");
                }

            }
        });

        textField3.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handleDocumentEvent();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                handleDocumentEvent();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                handleDocumentEvent();
            }


            private void handleDocumentEvent() {
                String email = textField3.getText();
                Pattern pr1 = Pattern.compile("^([a-zA-Z0-9]+(?:[\\.\\-\\_]{1}[a-zA-Z0-9]+)*)@([a-zA-Z0-9]+\\.)+[a-zA-Z]+$");
                Matcher m1 = pr1.matcher(email);

                if(m1.matches()){
                    label10.setText("✅");
                    //echeck=true;
                }
                else{
                    label10.setText("❌");
                    // echeck=false;
                }
            }
        });

        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent s) {
                boolean usertekrari=false;
                String username = textField1.getText();
                username = username.trim();
                if (!usernamecheck(username)) {
                    System.out.println("This username is already taken. please choose another one");
                    usertekrari = true;
                } else {
                    String password = passwordField.getText();
                    password = password.trim();
                    String hashedPassword = hashPassword(password);
                    String email = textField3.getText();
                    email = email.trim();
                    if (emailcheck(email)) {
                        Member M = new Member(username, hashedPassword, email);
                        Memberarray.members.add(M);
                        System.out.println("Dear " + username + "! You have been successfully registered.");
                        try {
                            FileWriter writer = new FileWriter("file.txt", true);
                            String f = username + "," + hashedPassword + "," + email + "\n";
                            writer.write(f);
                            writer.close();
                        } catch (IOException e) {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Wrong entry please check out your email address");
                    }
                }
            }
        });


        Button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = textField4.getText();
                username=username.trim();
                String password = passwordField1.getText();
                password=password.trim();
                String hashedPassword = hashPassword(password);
                String searchfor= username +","+ hashedPassword;
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader("file.txt"));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                String line;
                int lineNumber = 0;
                boolean found = false;

                while (true) {
                    try {
                        if ((line = reader.readLine()) == null) break;
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    lineNumber++;
                    if (line.contains(searchfor)) {
                        found = true;
                        System.out.println("Found the member \"" + username + "\" at line " + lineNumber + ": " + line);
                    }
                }

                if (!found) {
                    System.out.println("The member \"" + username + "\" was not found in the file.");
                }

                try {
                    reader.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

//                for (Member M : Memberarray.members) {
//                    if(username.equals(M.getname()) && hashedPassword.equals(M.getpassword()))
//                }
            }
        });

        Button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
                frame.setVisible(true);
            }
        });

    }
}