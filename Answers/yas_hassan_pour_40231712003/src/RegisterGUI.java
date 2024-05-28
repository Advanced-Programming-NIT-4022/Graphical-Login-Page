import javax.swing.*;
import java.awt.*;

public class RegisterGUI {
    User user;
    PasswordUtils passwordUtils;
    EmailValidator emailValidator;
    public void register()
    {
        JFrame frame = new JFrame("Sign Up");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelFont = new JLabel("REGISTER");
        labelFont.setBounds(150,10,150, 50);
        labelFont. setFont(new Font("Serif", Font.BOLD, 25));
        frame.add(labelFont);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(10,100,80,25);
        panel.add(userLabel);

        JTextField usernameText = new JTextField(20);
        usernameText.setBounds(100,100,165,25);
        panel.add(usernameText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,130,80,25);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(100,130,165,25);
        panel.add(passwordField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(10,160,80,25);
        panel.add(emailLabel);

        JTextField emailText = new JTextField(30);
        emailText.setBounds(100,160,165,25);
        panel.add(emailText);
        JButton registerationButton = new JButton("Register");
        registerationButton.setBounds(10, 210, 90, 25);
        panel.add(registerationButton);
        registerationButton.addActionListener(e -> {
            frame.dispose();
            String usernameIn = usernameText.getText();
            String passwordIn = new String(passwordField.getPassword());
            String emailIn = emailText.getText();
            user.setUsernameIn(usernameIn);
            passwordUtils.setPasswordIn(passwordIn);
            emailValidator.setEmailIn(emailIn);

        });

        frame.add(panel);
        frame.setVisible(true);

    }

}
