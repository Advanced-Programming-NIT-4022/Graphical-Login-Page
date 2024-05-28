import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JTextField usernameInput = new JTextField();
    private JPasswordField passwordInput = new JPasswordField();
    private JTextField emailInput = new JTextField();
    private JButton loginButton = new JButton("Login");
    private JButton registerButton = new JButton("Register");
    private JLabel messageLabel = new JLabel();
    private UserStore userStore;

    public LoginGUI() {
        userStore = new UserStore();
        createUI();
    }

    private void createUI() {
        setTitle("Login and Registeration");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("\tUsername:"));
        add(usernameInput);
        add(new JLabel("\tPassword:"));
        add(passwordInput);
        add(new JLabel("\tEmail (for registration):"));
        add(emailInput);
        add(loginButton);
        add(registerButton);
        add(messageLabel);

        loginButton.addActionListener(new LoginButtonListener());
        registerButton.addActionListener(new RegisterButtonListener());
    }

    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameInput.getText();
            String password = new String(passwordInput.getPassword());

            if (userStore.validateLogin(username, password)) {
                messageLabel.setText("Login successful!");
            } else {
                messageLabel.setText("Invalid username or password!");
            }
        }
    }

    private class RegisterButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameInput.getText();
            String password = new String(passwordInput.getPassword());
            String email = emailInput.getText();

            if (!EmailValidator.Validation(email)) {
                messageLabel.setText("Invalid email type!");
                return;
            }

            if (PasswordUtils.getPasswordComplexity(password)==0) {
                messageLabel.setText("Password is too weak!");
                return;
            }

            if (userStore.registerUser(username, password, email)) {
                messageLabel.setText("Registered successfully!");
            } else {
                messageLabel.setText("Username already exists!, try another one");
            }
        }
    }
}
