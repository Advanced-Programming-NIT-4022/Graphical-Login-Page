import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends Validator {
    UserStore userRepo = new UserStore();
    GUI(){
        JFrame jFrame = new JFrame("Graphical Login page");

        // Sign up panel
        JPanel signUpPanel = new JPanel();
        signUpPanel.setBackground(Color.yellow);
        signUpPanel.setLayout(null); // Set layout to null for absolute positioning
        signUpPanel.setBounds(245, 200, 425, 340);

        // Sign Up label
        JLabel signUpLabel = new JLabel("Sign Up");
        signUpLabel.setBounds(10, 10, 140, 50);
        signUpPanel.add(signUpLabel);

        // Username label
        JLabel signupUserLabel = new JLabel("Username:");
        signupUserLabel.setBounds(10, 80, 140, 35);
        signUpPanel.add(signupUserLabel);

        // Username text field
        JTextField signupUserNameTextField = new JTextField();
        signupUserNameTextField.setBounds(100, 80, 250, 35);
        signUpPanel.add(signupUserNameTextField);

        // Password label
        JLabel signupPasswordLabel = new JLabel("Password:");
        signupPasswordLabel.setBounds(10, 150, 140, 35);
        signUpPanel.add(signupPasswordLabel);

        // Password field
        JPasswordField signupPasswordTextField = new JPasswordField();
        signupPasswordTextField.setBounds(100, 150, 250, 35);
        signUpPanel.add(signupPasswordTextField);

        // Email label
        JLabel signupEmailLabel = new JLabel("Email:");
        signupEmailLabel.setBounds(10, 220, 140, 35);
        signUpPanel.add(signupEmailLabel);

        // Email text field
        JTextField signupEmailTextField = new JTextField();
        signupEmailTextField.setBounds(100, 220, 250, 35);
        signUpPanel.add(signupEmailTextField);

        //Register button
        JButton signupButton = new JButton("CONFIRM");
        signupButton.setBounds(150,275,150,35);
        signUpPanel.add(signupButton);

        // Login panel
        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(Color.green);
        loginPanel.setLayout(null); // Set layout to null for absolute positioning
        loginPanel.setBounds(850, 200, 425, 340);

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
        //Add action listener to run the app
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = signupUserNameTextField.getText();
                String password = signupPasswordTextField.getText();
                String email = signupEmailTextField.getText();
                boolean nameValid = userNameIsValid(userName);
                boolean passwordValid = passwordIsValid(password);
                boolean emailValid = emailIsValid(email);
                if (!nameValid){
                    JOptionPane.showMessageDialog(jFrame,"Your name is invalid please try again.","Error",JOptionPane.ERROR_MESSAGE);
                } else if (!passwordValid) {
                    JOptionPane.showMessageDialog(jFrame,"Your password is too weak please try again.","Error",JOptionPane.ERROR_MESSAGE);
                } else if (!emailValid) {
                    JOptionPane.showMessageDialog(jFrame,"Your email is invalid please try again.","Error",JOptionPane.ERROR_MESSAGE);
                } else {
                    userRepo.addUser(userName,password,email);
                    JOptionPane.showMessageDialog(jFrame,"Signed up successfully.","Done",JOptionPane.INFORMATION_MESSAGE);
                    signupUserNameTextField.setText("");
                    signupPasswordTextField.setText("");
                    signupEmailTextField.setText("");

                }
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = loginUsernameTextField.getText();
                String password = loginPasswordTextField.getText();
                boolean found = userRepo.checkUser(userName,password);
                if (found){
                    JOptionPane.showMessageDialog(jFrame,"Logged in successfully.","Welcome",JOptionPane.INFORMATION_MESSAGE);
                    loginUsernameTextField.setText("");
                    loginPasswordTextField.setText("");
                } else {
                    JOptionPane.showMessageDialog(jFrame,"Wrong information please try again.","Error",JOptionPane.ERROR_MESSAGE);
                    loginUsernameTextField.setText("");
                    loginPasswordTextField.setText("");
                }
            }
        });
        //--------------------------------------------------------------------------
        // Set frame properties
        jFrame.getContentPane().setBackground(Color.darkGray);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

}
