import javax.swing.*;
import java.awt.*;

public class GUI {
    GUI(){
        JFrame jFrame = new JFrame("Graphical Login page");

        // Sign up panel
        JPanel signUpPanel = new JPanel();
        signUpPanel.setBackground(Color.cyan);
        signUpPanel.setLayout(null); // Set layout to null for absolute positioning
        signUpPanel.setBounds(40, 80, 250, 200);

        // Sign Up label
        JLabel signUpLabel = new JLabel("Sign Up");
        signUpLabel.setBounds(10, 10, 80, 25);
        signUpPanel.add(signUpLabel);

        // Username label
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 50, 80, 25);
        signUpPanel.add(userLabel);

        // Username text field
        JTextField userNameTextField = new JTextField();
        userNameTextField.setBounds(100, 50, 140, 25);
        signUpPanel.add(userNameTextField);

        // Password label
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 90, 80, 25);
        signUpPanel.add(passwordLabel);

        // Password field
        JPasswordField passwordTextField = new JPasswordField();
        passwordTextField.setBounds(100, 90, 140, 25);
        signUpPanel.add(passwordTextField);

        // Email label
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 130, 80, 25);
        signUpPanel.add(emailLabel);

        // Email text field
        JTextField emailTextField = new JTextField();
        emailTextField.setBounds(100, 130, 140, 25);
        signUpPanel.add(emailTextField);

        //Register button
        JButton signupButton = new JButton("CONFIRM");
        signupButton.setBounds(110,170,100,20);
        signUpPanel.add(signupButton);

        // Login panel
        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(Color.green);
        loginPanel.setLayout(null); // Set layout to null for absolute positioning
        loginPanel.setBounds(300, 80, 250, 200);

        // Login label
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setBounds(10, 10, 80, 25);
        loginPanel.add(loginLabel);

        // Username label for login
        JLabel loginUsernameLabel = new JLabel("Username:");
        loginUsernameLabel.setBounds(10, 50, 80, 25);
        loginPanel.add(loginUsernameLabel);

        // Username text field for login
        JTextField loginUsernameTextField = new JTextField();
        loginUsernameTextField.setBounds(100, 50, 140, 25);
        loginPanel.add(loginUsernameTextField);

        // Password label for login
        JLabel loginPasswordLabel = new JLabel("Password:");
        loginPasswordLabel.setBounds(10, 90, 80, 25);
        loginPanel.add(loginPasswordLabel);

        // Password field for login
        JPasswordField loginPasswordTextField = new JPasswordField();
        loginPasswordTextField.setBounds(100, 90, 140, 25);
        loginPanel.add(loginPasswordTextField);

        //Entry button
        JButton loginButton = new JButton("ENTRY");
        loginButton.setBounds(110,170,100,20);
        loginPanel.add(loginButton);

        // Add panels to the frame
        jFrame.add(signUpPanel);
        jFrame.add(loginPanel);

        // Set frame properties
        jFrame.setSize(600, 350);
        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}
