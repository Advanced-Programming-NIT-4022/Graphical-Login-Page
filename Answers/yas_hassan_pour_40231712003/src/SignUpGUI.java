import javax.swing.*;

public class SignUpGUI {
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
        passwordField.setBounds(100,20,165,25);
        panel.add(passwordField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(10,50,80,25);
        panel.add(emailLabel);

        JTextField emailText = new JTextField(30);
        emailText.setBounds(100,20,165,25);
        panel.add(emailText);

        frame.add(panel);
        frame.setVisible(true);
    }
}
