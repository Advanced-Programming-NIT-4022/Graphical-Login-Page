import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class LoginGUI {

    private JFrame frame;
    private JPanel panel;
    private JButton loginButton;
    private JButton registerButton;

    private JLabel label;

    public LoginGUI() {

        frame = new JFrame("Graphical User Login GUI");
        // Initialize frame and panel
        panel = new JPanel();

        // Initialize components for login
        loginButton = new JButton("Login");

        // Initialize components for registration
        registerButton = new JButton("Register");

        label = new JLabel("                                                                                Welcome                                                                                  " );

        panel.add(label);
        panel.add(loginButton);
        panel.add(registerButton);

        frame.add(panel);

        // Configure frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == loginButton){
                    //dispose gets rid of the extra windows that the user my open
                    frame.dispose();
                    Login_Window window = new Login_Window();
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == registerButton){
                    frame.dispose();
                    Register_Window window = new Register_Window();
                }
            }
        });
        // Add components to panel for login
//        panel.add(new JLabel("Username:"));
//        panel.add(usernameField);
//        panel.add(new JLabel("Password:"));
//        panel.add(passwordField);
//        panel.add(loginButton);

        // Add components to panel for registration
//        panel.add(new JLabel("Email:"));
//        panel.add(emailField);
//        panel.add(registerButton);

        // Add panel to frame

        // Add action listener to login button




        // Add action listener to register button

    }

    // Method to authenticate user credentials

    public static void main(String[] args) {
        // Create and display the login GUI
        SwingUtilities.invokeLater(LoginGUI::new);
    }
}

