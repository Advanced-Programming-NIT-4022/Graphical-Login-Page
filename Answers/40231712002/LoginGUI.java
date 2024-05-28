import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JLabel messageLabel;
    private UserStore userStore;

    public LoginGUI() {
        userStore = new UserStore("users.txt");

        setTitle("Login and Registration System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        add(registerButton);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });
        add(loginButton);

        messageLabel = new JLabel("");
        add(messageLabel);

        setVisible(true);
    }

    private void registerUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String email = emailField.getText();

        if (!Email.isValid(email)) {
            messageLabel.setText("Invalid email format.");
            return;
        }

        int passwordStrength = PasswordUtils.getPasswordStrength(password);
        if (passwordStrength < 5) {
            messageLabel.setText("Password is too weak.");
            return;
        }

        String hashedPassword = PasswordUtils.hashPassword(password);
        User user = new User(username, hashedPassword, email);

        if (userStore.addUser(user)) {
            messageLabel.setText("Registration successful.");
        } else {
            messageLabel.setText("User already exists.");
        }
    }

    private void loginUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (userStore.authenticateUser(username, password)) {
            messageLabel.setText("Login successful.");
        } else {
            messageLabel.setText("Invalid username or password.");
        }
    }
}