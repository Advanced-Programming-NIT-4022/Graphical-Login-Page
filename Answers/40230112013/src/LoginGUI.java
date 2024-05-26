import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class LoginGUI {
    private JFrame mainFrame;
    private JButton loginButton, registerButton, exitButton;

    public LoginGUI() {
        prepareGUI();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Registration/Login");
        mainFrame.setSize(500, 500);
        mainFrame.setLayout(new GridLayout(3, 1, 10, 10));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().setBackground(Color.decode("#ECEFF1")); // Set background color

        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        exitButton = new JButton("Exit");

        // Set button fonts and colors
        Font buttonFont = new Font(null, Font.BOLD, 16);
        loginButton.setFont(buttonFont);
        registerButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        loginButton.setBackground(Color.decode("#FAC107")); // Set button color
        registerButton.setBackground(Color.decode("#8025")); // Set button color
        exitButton.setBackground(Color.decode("#a52a2a")); // Set button color

        loginButton.setActionCommand("Login");
        registerButton.setActionCommand("Register");
        exitButton.setActionCommand("Exit");

        loginButton.addActionListener(new ButtonClickListener());
        registerButton.addActionListener(new ButtonClickListener());
        exitButton.addActionListener(new ButtonClickListener());

        mainFrame.add(loginButton);
        mainFrame.add(registerButton);
        mainFrame.add(exitButton);
        mainFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Login")) {
                handleLogin();
            } else if (command.equals("Register")) {
                handleRegistration();
            } else if (command.equals("Exit")) {
                mainFrame.dispose();
            }
        }
    }

    private void handleLogin() {
        JDialog loginDialog = new JDialog(mainFrame, "Login");
        loginDialog.setSize(300, 200);

        JLabel userLabel = new JLabel("Username or Email:");
        JTextField userText = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usernameOrEmail = userText.getText();
                String password = new String(passwordField.getPassword());
                boolean isAuthenticated;
                try {
                    isAuthenticated = UserStore.validateUser(usernameOrEmail, password);
                } catch (IOException e1) {
                    isAuthenticated = false;
                }
                if (isAuthenticated) {
                    JOptionPane.showMessageDialog(loginDialog,
                            "Login Successful!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    loginDialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(loginDialog,
                            "Invalid username/email or password.",
                            "Login Failed",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        loginDialog.setLayout(new GridLayout(3, 2));
        loginDialog.add(userLabel);
        loginDialog.add(userText);
        loginDialog.add(passwordLabel);
        loginDialog.add(passwordField);
        loginDialog.add(new JLabel());
        loginDialog.add(loginButton);

        loginDialog.setVisible(true);
    }

    private void handleRegistration() {

    }
}
