import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI{

    private UserStore userStore;

    public LoginGUI(UserStore userStore) {
        this.userStore = userStore;

        JFrame frame = new JFrame("Login and Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(4, 1));

        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                int index = userStore.findUser(username, password);
                if (index != -1) {
                    JOptionPane.showMessageDialog(frame, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password!");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame registerFrame = new JFrame("Register");
                registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                registerFrame.setSize(400, 200);

                JPanel registerPanel = new JPanel();
                registerPanel.setLayout(new GridLayout(5, 1));

                JTextField newUsernameField = new JTextField(20);
                JPasswordField newPasswordField = new JPasswordField(20);
                JTextField newEmailField = new JTextField(20);
                JButton confirmButton = new JButton("Confirm");

                confirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String newUsername = newUsernameField.getText();
                        String newPassword = new String(newPasswordField.getPassword());
                        String newEmail = newEmailField.getText();


                        User newUser = new User(newUsername, PasswordUtils.hashPassword(newPassword), newEmail);
                        userStore.addUser(newUser);

                        JOptionPane.showMessageDialog(registerFrame, "Registration successful!");
                        registerFrame.dispose();
                    }
                });

                registerPanel.add(new JLabel("Username:"));
                registerPanel.add(newUsernameField);
                registerPanel.add(new JLabel("Password:"));
                registerPanel.add(newPasswordField);
                registerPanel.add(new JLabel("Email:"));
                registerPanel.add(newEmailField);
                registerPanel.add(confirmButton);

                registerFrame.add(registerPanel);
                registerFrame.setVisible(true);
            }
        });

        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(registerButton);

        frame.add(loginPanel);
        frame.setVisible(true);
    }
}
