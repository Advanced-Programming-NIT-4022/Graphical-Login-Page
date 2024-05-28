import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

    //Handles the GUI components and events.

    public class LoginGUI {
        private JFrame frame;
        private JPanel panel;
        private JTextField usernameField;
        private JPasswordField passwordField;
        private JTextField emailField;
        private JButton loginButton;
        private JButton registerButton;

        public LoginGUI() {

            frame = new JFrame("Graphical User Login GUI");
            panel = new JPanel();

            usernameField = new JTextField(20);
            passwordField = new JPasswordField(20);
            loginButton = new JButton("Login");

            emailField = new JTextField(20);
            registerButton = new JButton("Register");

            panel.add(new JLabel("Username:"));
            panel.add(usernameField);
            panel.add(new JLabel("Password:"));
            panel.add(passwordField);
            panel.add(loginButton);


            panel.add(new JLabel("Email:"));
            panel.add(emailField);
            panel.add(registerButton);

            frame.add(panel);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String username = usernameField.getText();
                    String password = String.valueOf(passwordField.getPassword());

                    // Perform login authentication
                    boolean isAuthenticated = false;

                    isAuthenticated = UserStore.authenticate(username, password);

                    if (isAuthenticated) {
                        JOptionPane.showMessageDialog(frame, "Login successful!");
                        // Proceed to main application or dashboard
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid username or password. Please try again.");
                    }
                }
            });

            registerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String username = usernameField.getText();
                    String password = String.valueOf(passwordField.getPassword());
                    String email = emailField.getText();

                    if (!PasswordUtils.isStrongPassword(password)) {
                        JOptionPane.showMessageDialog(frame, "Password is not strong enough. Please try again.");
                        return;
                    }

                    if (!EmailValidator.EmailValid(email)) {
                        JOptionPane.showMessageDialog(frame, "Email is not valid. Please try again.");
                        return;
                    }


                    if (UserStore.isUsernameTaken(username)) {
                        JOptionPane.showMessageDialog(frame, "Username is already taken. Please choose another one.");
                        return;
                    }

                    if (UserStore.isEmailRegistered(email)) {
                        JOptionPane.showMessageDialog(frame, "Email is already registered. Please use another one.");
                        return;
                    }

                    User newUser = new User(username, password, email);
                    UserStore.saveUser(newUser);
                    JOptionPane.showMessageDialog(frame, "Registration successful! You can now log in.");
                }
            });
        }

        public static void main(String[] args) {
            new LoginGUI();
        }
    }
