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
        }

        public static void main(String[] args) {
            new LoginGUI();
        }
    }
