import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JLabel messageLabel;
    private JLabel passwordStrengthLabel;

    public LoginGUI() {
        // Frame setup
        setTitle("Login and Registration");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(123, 50, 250));
        ImageIcon icon = new ImageIcon("R.png");
        setIconImage(icon.getImage());

        // Custom font and colors
        Font labelFont = new Font("Arial", Font.BOLD, 15);
        Color backgroundColor = new Color(123, 50, 250);
        Color buttonColor = new Color(70, 130, 180);
        Color messageColor = Color.WHITE;
        Color fieldColor = new Color(123, 50, 250);

        // Create panels
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        inputPanel.setBackground(backgroundColor);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(backgroundColor);

        // Username field
        usernameField = new JTextField(20);
        inputPanel.add(createLabeledField("Username:", usernameField, labelFont));

        // Password field
        passwordField = new JPasswordField(20);
        inputPanel.add(createLabeledField("Password:", passwordField, labelFont));

        // Password strength label
        passwordStrengthLabel = new JLabel("Password strength: ");
        passwordStrengthLabel.setFont(labelFont);
        passwordStrengthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPanel.add(passwordStrengthLabel);

        // Add DocumentListener to password field
        passwordField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updatePasswordStrength();
            }

            public void removeUpdate(DocumentEvent e) {
                updatePasswordStrength();
            }

            public void changedUpdate(DocumentEvent e) {
                updatePasswordStrength();
            }
        });

        // Email field
        emailField = new JTextField(20);
        inputPanel.add(createLabeledField("Email:", emailField, labelFont));

        // Message label
        messageLabel = new JLabel("Welcome... Please enter your information.", SwingConstants.CENTER);
        messageLabel.setForeground(messageColor);
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 12));

        // Register button
        JButton registerButton = new JButton("Register");
        registerButton.setPreferredSize(new Dimension(100, 30));
        registerButton.setBackground(buttonColor);
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setFont(labelFont);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        buttonPanel.add(registerButton);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(100, 30));
        loginButton.setBackground(buttonColor);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setFont(labelFont);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });
        buttonPanel.add(loginButton);

        // Add components to frame
        add(messageLabel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Show the frame
        setVisible(true);
    }

    private JPanel createLabeledField(String labelText, JTextField textField, Font labelFont) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(123, 50, 250));
        JLabel label = new JLabel(labelText);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(labelFont);
        textField.setMaximumSize(textField.getPreferredSize());
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(textField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        return panel;
    }

    private void updatePasswordStrength() {
        String password = new String(passwordField.getPassword());
        int strength = PasswordUtils.evaluatePasswordStrength(password);
        String strengthText;
        Color strengthColor;

        switch (strength) {
            case 1:
                strengthText = "Very Weak";
                strengthColor = Color.RED;
                break;
            case 2:
                strengthText = "Weak";
                strengthColor = Color.ORANGE;
                break;
            case 3:
                strengthText = "Moderate";
                strengthColor = Color.YELLOW;
                break;
            case 4:
                strengthText = "Strong";
                strengthColor = Color.GREEN;
                break;
            case 5:
                strengthText = "Very Strong";
                strengthColor = Color.BLUE;
                break;
            default:
                strengthText = "Invalid";
                strengthColor = Color.GRAY;
                break;
        }

        passwordStrengthLabel.setText("Password strength: " + strengthText);
        passwordStrengthLabel.setForeground(strengthColor);
    }

    private void registerUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String email = emailField.getText();

        if (!EmailValidator.isValid(email)) {
            messageLabel.setText("Invalid email format");
            messageLabel.setForeground(Color.RED);
            return;
        }

        int passwordStrength = PasswordUtils.evaluatePasswordStrength(password);
        if (passwordStrength < 3) {
            messageLabel.setText("Password too weak");
            messageLabel.setForeground(Color.RED);
            return;
        }

        String hashedPassword = PasswordUtils.hashPassword(password);
        User newUser = new User(username, hashedPassword, email);
        if (UserStore.addUser(newUser)) {
            messageLabel.setText("Registration successful");
            messageLabel.setForeground(Color.GREEN);
        } else {
            messageLabel.setText("Username already exists");
            messageLabel.setForeground(Color.RED);
        }
    }

    private void loginUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String hashedPassword = PasswordUtils.hashPassword(password);

        if (UserStore.authenticateUser(username, hashedPassword)) {
            messageLabel.setText("Login successful");
            messageLabel.setForeground(Color.GREEN);
        } else {
            messageLabel.setText("Invalid username or password");
            messageLabel.setForeground(Color.RED);
        }
    }

}
