import javax.swing.*;
import java.awt.*;

public class GUI extends Validator {
    GUI(){
        JFrame jFrame = new JFrame("Graphical Login page");

        // Sign up panel
        JPanel signUpPanel = new JPanel();
        signUpPanel.setBackground(Color.cyan);
        signUpPanel.setLayout(null); // Set layout to null for absolute positioning
        signUpPanel.setBounds(45, 200, 425, 340);

        // Sign Up label
        JLabel signUpLabel = new JLabel("Sign Up");
        signUpLabel.setBounds(10, 10, 140, 50);
        signUpPanel.add(signUpLabel);

        // Username label
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 80, 140, 35);
        signUpPanel.add(userLabel);

        // Username text field
        JTextField userNameTextField = new JTextField();
        userNameTextField.setBounds(100, 80, 250, 35);
        signUpPanel.add(userNameTextField);

        // Password label
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 150, 140, 35);
        signUpPanel.add(passwordLabel);

        // Password field
        JPasswordField passwordTextField = new JPasswordField();
        passwordTextField.setBounds(100, 150, 250, 35);
        signUpPanel.add(passwordTextField);

        // Email label
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 220, 140, 35);
        signUpPanel.add(emailLabel);

        // Email text field
        JTextField emailTextField = new JTextField();
        emailTextField.setBounds(100, 220, 250, 35);
        signUpPanel.add(emailTextField);

        //Register button
        JButton signupButton = new JButton("CONFIRM");
        signupButton.setBounds(150,275,150,35);
        signUpPanel.add(signupButton);

        // Login panel
        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(Color.green);
        loginPanel.setLayout(null); // Set layout to null for absolute positioning
        loginPanel.setBounds(650, 200, 425, 340);

        // Login label
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setBounds(10, 10, 140, 35);
        loginPanel.add(loginLabel);

        // Username label for login
        JLabel loginUsernameLabel = new JLabel("Username:");
        loginUsernameLabel.setBounds(10, 80, 140, 35);
        loginPanel.add(loginUsernameLabel);

        // Username text field for login
        JTextField loginUsernameTextField = new JTextField();
        loginUsernameTextField.setBounds(100, 80, 250, 35);
        loginPanel.add(loginUsernameTextField);

        // Password label for login
        JLabel loginPasswordLabel = new JLabel("Password:");
        loginPasswordLabel.setBounds(10, 150, 140, 35);
        loginPanel.add(loginPasswordLabel);

        // Password field for login
        JPasswordField loginPasswordTextField = new JPasswordField();
        loginPasswordTextField.setBounds(100, 150, 250, 35);
        loginPanel.add(loginPasswordTextField);

        //Entry button
        JButton loginButton = new JButton("ENTRY");
        loginButton.setBounds(150,275,150,35);
        loginPanel.add(loginButton);

        // Add panels to the frame
        jFrame.add(signUpPanel);
        jFrame.add(loginPanel);
        //-----------------------------------------------------------------------------





        //--------------------------------------------------------------------------
        // Set frame properties
        jFrame.getContentPane().setBackground(Color.darkGray);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

}
