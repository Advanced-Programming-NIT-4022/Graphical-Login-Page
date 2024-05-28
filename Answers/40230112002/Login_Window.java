import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_Window {

    JFrame frame;
    JPanel panel;
    JButton LoginButton;
    JLabel UsernameLabel;
    JLabel PasswordLabel;

    JPasswordField PasswordField;
    JTextField UserNameField;
    Login_Window() {
        frame = new JFrame("Login page");
        panel = new JPanel();
        LoginButton = new JButton("Login");
        UsernameLabel = new JLabel("Username : ");
        PasswordLabel = new JLabel("Password : ");
        PasswordField = new JPasswordField(20);
        UserNameField = new JTextField(20);

        panel.add(UsernameLabel);
        panel.add(UserNameField);
        panel.add(PasswordLabel);
        panel.add(PasswordField);
        panel.add(LoginButton);

        frame.add(panel);



    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400 , 400);
    frame.pack();
    frame.setVisible(true);


        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = UserNameField.getText();
                String password = String.valueOf(PasswordField.getPassword());

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
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(Login_Window::new);
    }
}
