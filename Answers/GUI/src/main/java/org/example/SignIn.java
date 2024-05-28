package org.example;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.io.*;
    import java.util.regex.Pattern;

public class SignIn implements ActionListener {

    JFrame frame;
    JLabel lblUsername;
    JLabel lblPassword;
    JLabel lblEmail;
    JTextField txtUsername;
    JPasswordField txtPassword;
    JTextField txtEmail;
    JButton btnSignIn;




    public SignIn() {

        frame = new JFrame("Sign In");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(new Color(150, 100, 200));


        lblUsername = new JLabel("Username:");
        lblPassword = new JLabel("Password:");
        lblEmail = new JLabel("Email:");

        txtUsername = new JTextField(20);
        txtPassword = new JPasswordField(20);
        txtEmail = new JTextField(20);

        btnSignIn = new JButton("Sign In");
        btnSignIn.addActionListener(this);


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(lblUsername, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(txtUsername, gbc);


        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(lblPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(txtPassword, gbc);


        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(lblEmail, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(txtEmail, gbc);


        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(btnSignIn, gbc);



        /*public void actionPerformed (ActionEvent e){
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());
            String email = txtEmail.getText();

            if (emailValid(email)) {
                int passwordStrength = evaluatePasswordStrength(password);
                String strengthMessage = "Password strength level: " + passwordStrength;
                JOptionPane.showMessageDialog(frame, strengthMessage);

                if (passwordStrength < 3) {
                    JOptionPane.showMessageDialog(frame, "Password is too weak!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        saveInFile("user_data.txt", username, password, email);
                        JOptionPane.showMessageDialog(frame, "Sign In Successful!");
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(frame, "Error saving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid email format!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }*/
        frame.setVisible(true);
    }





//-------------------------save in file-----------------------
    void saveInFile() {


        try {
            String Username = txtUsername.getText();
            String Password = txtPassword.getText();
            String Email = txtEmail.getText();
            FileWriter fr = new FileWriter("store.txt", true);
            //BufferedWriter br = new BufferedWriter(fr);
            fr.append(Username).append("\n");
            fr.append(Password).append("\n");
            fr.append(Email).append("\n");
            fr.close();



        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
//-------------------------save in file-----------------------





//--------------------password strength---------------------

    int evaluatePasswordStrength(String password) {
        int strength = 0;

        if (password.length() > 0) {
            strength = 1; // Level 1: Contains at least one character
        }

        if (password.matches(".*[a-z].*") && password.matches(".*[A-Z].*")) {
            strength = 2; // Level 2: Contains both lowercase and uppercase characters
        }

        if (password.matches(".*[a-z].*") && password.matches(".*[A-Z].*") && password.matches(".*\\d.*")) {
            strength = 3; // Level 3: Contains uppercase, lowercase, and numbers
        }

        if (password.matches(".*[@\\-_\\.].*")) {
            strength = 4; // Level 4: Contains special characters (@, -, _, .)
        }

        if (password.length() > 8) {
            strength = 5; // Level 5: Longer than 8 characters
        }

        return strength;
    }
//--------------------password strength---------------------




//---------------------checking if the email is valid--------------------
    public boolean emailValid(String email) {
        if (Pattern.matches("^[a-zA-z0-9]{4,}@[a-zA-Z]+\\.[a-zA-Z]+$", email)) {
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Invalid email address", "title", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

//---------------------checking if the email is valid--------------------




//-------------------password hashing-----------------
//public String changeIntoHash(String password) {
    //   return DigestUtils
//}
//-------------------password hashing-----------------





    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSignIn) {
           String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());
            String email = txtEmail.getText();
            if (!username.isEmpty() && !password.isEmpty() && !email.isEmpty()) {
                if (emailValid(email)) {
                    int passwordStrength = evaluatePasswordStrength(password);
                    String strengthMessage = "Password strength level: " + passwordStrength;
                    JOptionPane.showMessageDialog(frame, strengthMessage);

                    if (passwordStrength < 3) {
                        JOptionPane.showMessageDialog(frame, "Password is too weak!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        saveInFile();
                        JOptionPane.showMessageDialog(frame, "Sign In Successful!");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid email format!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                txtUsername.setText("");
                txtPassword.setText("");
                txtEmail.setText("");

                JOptionPane.showMessageDialog(frame, "Entry added successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Please fill both fields.");
            }

        }
    }
}



