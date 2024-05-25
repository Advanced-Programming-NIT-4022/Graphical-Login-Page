import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI implements ActionListener {
    String usernameIn;
    String passwordIn;
    User user;

    public void login() {
        JFrame frame = new JFrame("Login");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username ");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);


        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 130, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(e -> {
            usernameIn = userText.getText();
            passwordIn = new String(passwordText.getPassword());
            user.setUsernameIn(usernameIn);
            user.setPasswordIn(passwordIn);
        });
        JButton signUpButton = new JButton("No account?");
        signUpButton.setBounds(200, 130, 140, 25);
        panel.add(signUpButton);
        signUpButton.addActionListener(new LoginGUI());


        frame.add(panel);
        frame.setVisible(true);
    }

    public void signUp()
    {
        JFrame frame = new JFrame("Sign Up");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        JTextField usernameText = new JTextField(20);
        usernameText.setBounds(100,20,165,25);
        panel.add(usernameText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(100,50,165,25);
        panel.add(passwordField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(10,80,80,25);
        panel.add(emailLabel);

        JTextField emailText = new JTextField(30);
        emailText.setBounds(100,80,165,25);
        panel.add(emailText);

        frame.add(panel);
        frame.setVisible(true);




    }


    @Override
    public void actionPerformed(ActionEvent e) {
        signUp();
    }
}