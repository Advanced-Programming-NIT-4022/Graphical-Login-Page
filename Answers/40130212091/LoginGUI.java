import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI {


    public void show(){
        JFrame frame = new JFrame("Graphical Login Page");
        frame.setSize(500,300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel firstPanel = new JPanel(new FlowLayout());
        JButton rButton = new JButton("Register");
        JButton lButton = new JButton("Login");
        firstPanel.add(rButton);
        firstPanel.add(lButton);

        JPanel register = new JPanel(new FlowLayout());
        JLabel emailLabel = new JLabel("Email Address");
        JTextField emailField = new JTextField(10);
        JLabel usernameLabel = new JLabel("Username");
        JTextField usernameField = new JTextField(10);
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField(10);
        JButton registerButton = new JButton("Register");
        register.add(emailLabel);
        register.add(emailField);
        register.add(usernameLabel);
        register.add(usernameField);
        register.add(passwordLabel);
        register.add(passwordField);
        register.add(registerButton);

        JPanel login = new JPanel(new FlowLayout());
        login.add(usernameLabel);
        login.add(usernameField);
        login.add(passwordLabel);
        login.add(passwordField);
        JButton loginButton = new JButton("Login");
        login.add(loginButton);

        JPanel page = new JPanel(new FlowLayout());
        JLabel welcome = new JLabel("WELCOME");
        page.add(welcome);

        frame.add(firstPanel);
        rButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(firstPanel);
                frame.add(register);
            }
        });

        lButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(firstPanel);
                frame.add(login);
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String email = emailField.getText();

                JLabel message = new JLabel();

                if(EmailValidator.emailValidation(email)){
                    if(UserStore.registerUser(username, password, email)){
                        if (PasswordUtils.passwordStrength(password) == null){
                            frame.remove(register);
                            frame.add(page);
                        }
                        message.setText(PasswordUtils.passwordStrength(password));
                    }
                    message.setText("username already exist");
                }
                message.setText("invalid email address");
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                JLabel message = new JLabel();

                if(UserStore.loginUser(username, password) == null){
                    frame.remove(login);
                    frame.add(page);
                }
                else {
                    message.setText(UserStore.loginUser(username, password));
                }
            }
        });




        frame.setVisible(true);

    }
}
