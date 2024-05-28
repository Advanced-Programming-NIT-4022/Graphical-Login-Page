import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
public class LoginGUI {
    public LoginGUI() {
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField email = new JTextField();
        JFrame frame = new JFrame("MyApp");
        JButton btn1 = new JButton("Login");
        JButton btn2 = new JButton("Sign up");

        frame.setSize(500, 500);
        btn1.setBounds(200, 100, 100, 100);
        btn2.setBounds(200, 300, 100, 100);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(btn1);
                frame.remove(btn2);
                JLabel usernameLabel = new JLabel("Username :");
                JLabel passwordLabel = new JLabel("Password :");
                JButton submitButton = new JButton("login");

                passwordField.setBounds(200, 200, 150, 30);
                passwordLabel.setBounds(90, 200, 100, 30);
                usernameField.setBounds(200, 150, 150, 30);
                usernameLabel.setBounds(90, 150, 100, 30);
                submitButton.setBounds(120, 250, 100, 30);

                frame.add(usernameLabel);
                frame.add(usernameField);
                frame.add(passwordLabel);
                frame.add(passwordField);

                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String enteredUsername = usernameField.getText();
                        String enteredPassword = new String(passwordField.getPassword());
                        authenticateUser(enteredUsername,enteredPassword);
                    }
                });

                frame.add(submitButton);
                frame.revalidate();
                frame.repaint();
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(btn1);
                frame.remove(btn2);

                JLabel usernamelbl = new JLabel("Username :");
                JLabel passwordlbl = new JLabel("Password :");
                JLabel Email = new JLabel("Email :");
                JButton submitButton = new JButton("Submit");

                usernamelbl.setBounds(90, 150, 100, 30);
                usernameField.setBounds(200, 150, 150, 30);
                passwordlbl.setBounds(90, 200, 100, 30);
                passwordField.setBounds(200, 200, 150, 30);
                Email.setBounds(90, 250, 100, 30);
                email.setBounds(200, 250, 150, 30);
                submitButton.setBounds(150, 300, 100, 30);

                frame.add(usernamelbl);
                frame.add(usernameField);
                frame.add(passwordlbl);
                frame.add(passwordField);
                frame.add(Email);
                frame.add(email);

                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username = usernameField.getText();
                        String hashpassword ="";
                        String password = new String(passwordField.getPassword());
                        PasswordUtils psu = new PasswordUtils();
                        String message=psu.strong(password);
                        if (message.equals("level 4 ـYour password is correct")||message.equals("level 3 ـYour password is correct")||message.equals("level 5 ـYour password is correct")) {
                            hashpassword = psu.hashPassword(password);
                        } else if(message.equals("level 1 ـYour password must contain at least one uppercase letter, one lowercase letter and one number. The characters @_-.can be or not")||message.equals("level 2 ـYour password must contain at least one uppercase letter, one lowercase letter and one number. The characters @_-.can be or not")){
                            JOptionPane.showMessageDialog(null, message,
                                    "Password Strength", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        String email1 = null;
                        EmailValidator emailValidator = new EmailValidator();
                        if (emailValidator.trueEmail(email.getText())) {
                            email1 = email.getText();
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Email is wrong",
                                    "Email", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        new User(username, hashpassword, email1);
                        JOptionPane.showMessageDialog(null,message,
                                "User",JOptionPane.INFORMATION_MESSAGE);
                        usernameField.setText("");
                        passwordField.setText("");
                        email.setText("");
                    }
                });

                frame.add(submitButton);
                frame.revalidate();
                frame.repaint();
            }
        });

        btn1.setEnabled(true);
        btn2.setEnabled(true);
        frame.add(btn1);
        frame.add(btn2);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    void authenticateUser(String enteredUsername, String enteredPassword) {
        try (BufferedReader reader = new BufferedReader(new FileReader("myFile.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("/");
                String storedUsername = parts[0];
                String storedHashedPassword = parts[1];

                if (storedUsername.equals(enteredUsername)) {
                    PasswordUtils pss = new PasswordUtils();
                    String hashedPassword = pss.hashPassword(enteredPassword);
                    if (storedHashedPassword.equals(hashedPassword)) {
                        JOptionPane.showMessageDialog(null, "Login is successful!");
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid password!");
                        return;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "User not found!");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

}


