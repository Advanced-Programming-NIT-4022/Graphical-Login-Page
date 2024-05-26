import javax.swing.*;
import java.awt.*;

public class LoginGUI extends JFrame {
    private final JPanel loginPanel;
    private final JPanel registrationPanel;
    private final JButton registerButton;
    private final JTextField registerNameField;
    private final JPasswordField registerPasswordField;
    private final JTextField emailField;
    private final JTextField loginNameField;
    private final JPasswordField loginPasswordField;
    private final JButton loginButton;

    public LoginGUI() {
        super("Register and Login");

        // set up registration panel
        registrationPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // name label
        gbc.gridx = 0; // x-coordinate for name label
        gbc.gridy = 0; // y-coordinate for name label
        registrationPanel.add(new JLabel("Name: "), gbc);

        // name text box
        gbc.gridx = 1;
        registerNameField = new JTextField(20);
        registrationPanel.add(registerNameField, gbc);

        // password label
        gbc.gridx = 0;
        gbc.gridy = 1;
        registrationPanel.add(new JLabel("Password: "), gbc);

        // password field
        gbc.gridx = 1;
        registerPasswordField = new JPasswordField(20);
        registrationPanel.add(registerPasswordField, gbc);

        // email label
        gbc.gridx = 0;
        gbc.gridy = 2;
        registrationPanel.add(new JLabel("Email: "), gbc);

        // email field
        gbc.gridx = 1;
        emailField = new JTextField(20);
        registrationPanel.add(emailField, gbc);

        // register button
        gbc.gridx = 1;
        gbc.gridy = 5;
        registerButton = new JButton("Register");
        registrationPanel.add(registerButton, gbc);

        add(BorderLayout.WEST, registrationPanel);

        // set up login panel
        loginPanel = new JPanel(new GridBagLayout());

        // name label
        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(new JLabel("Name: "), gbc);

        // name text box
        gbc.gridx = 1;
        loginNameField = new JTextField(20);
        loginPanel.add(loginNameField, gbc);

        // password label
        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(new JLabel("Password: "), gbc);

        // password field
        gbc.gridx = 1;
        loginPasswordField = new JPasswordField(20);
        loginPanel.add(loginPasswordField, gbc);

        // login button
        gbc.gridy = 2;
        loginButton = new JButton("Login");
        loginPanel.add(loginButton, gbc);

        add(BorderLayout.CENTER, loginPanel);
    }
}
