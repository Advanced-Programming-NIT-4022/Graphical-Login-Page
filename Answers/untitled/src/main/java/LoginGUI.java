import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JPanel loginPanel;
    private JPanel registerPanel;
    private JTextField loginUsernameField;
    private JPasswordField loginPasswordField;
    private JTextField registerUsernameField;
    private JPasswordField registerPasswordField;
    private JTextField registerEmailField;
    private JLabel messageLabel;
    private UserStore userStore;

    public LoginGUI() {
        userStore = new UserStore();

        setTitle("Login and Registration System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create panels
        loginPanel = new JPanel(new FlowLayout());
        registerPanel = new JPanel(new FlowLayout());
        messageLabel = new JLabel("", SwingConstants.CENTER);

        // Login Panel components
        loginPanel.add(new JLabel("Username:"));
        loginUsernameField = new JTextField(15);
        loginPanel.add(loginUsernameField);

        loginPanel.add(new JLabel("Password:"));
        loginPasswordField = new JPasswordField(15);
        loginPanel.add(loginPasswordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginButtonListener());
        loginPanel.add(loginButton);

        JButton switchToRegisterButton = new JButton("Register");
        switchToRegisterButton.addActionListener(e -> switchToRegisterPanel());
        loginPanel.add(switchToRegisterButton);

        // Register Panel components
        registerPanel.add(new JLabel("Username:"));
        registerUsernameField = new JTextField(15);
        registerPanel.add(registerUsernameField);

        registerPanel.add(new JLabel("Password:"));
        registerPasswordField = new JPasswordField(15);
        registerPanel.add(registerPasswordField);

        registerPanel.add(new JLabel("Email:"));
        registerEmailField = new JTextField(15);
        registerPanel.add(registerEmailField);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new RegisterButtonListener());
        registerPanel.add(registerButton);

        JButton switchToLoginButton = new JButton("Login");
        switchToLoginButton.addActionListener(e -> switchToLoginPanel());
        registerPanel.add(switchToLoginButton);

        // Add components to frame
        setLayout(new BorderLayout());
        add(messageLabel, BorderLayout.NORTH);
        add(loginPanel, BorderLayout.CENTER);
    }

    private void switchToRegisterPanel() {
        remove(loginPanel);
        add(registerPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void switchToLoginPanel() {
        remove(registerPanel);
        add(loginPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = loginUsernameField.getText();
            String password = new String(loginPasswordField.getPassword());

            if (userStore.verifyLogin(username, password)) {
                messageLabel.setText("Login successful!");
            } else {
                messageLabel.setText("Invalid username or password.");
            }
        }
    }

    private class RegisterButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = registerUsernameField.getText();
            String password = new String(registerPasswordField.getPassword());
            String email = registerEmailField.getText();

            if (!EmailValidator.isValid(email)) {
                messageLabel.setText("Invalid email format.");
                return;
            }

            String passwordStrengthMessage = PasswordUtils.evaluatePasswordStrength(password);
            if (passwordStrengthMessage != null) {
                messageLabel.setText(passwordStrengthMessage);
                return;
            }

            if (userStore.registerUser(username, password, email)) {
                messageLabel.setText("Registration successful!");
                switchToLoginPanel();
            } else {
                messageLabel.setText("Registration failed. Username may already exist.");
            }
        }
    }
}
