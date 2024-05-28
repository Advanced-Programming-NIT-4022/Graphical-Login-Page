import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginGUI {
    User user;
    PasswordUtils passwordUtils;
    RegisterGUI registerGUI = new RegisterGUI();

    public void login() {
        JFrame frame = new JFrame("Login");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel labelFont = new JLabel("LOGIN");
        labelFont.setBounds(200,10,150, 50);
        labelFont. setFont(new Font("Serif", Font.BOLD, 25));
        frame.add(labelFont);

        JLabel userLabel = new JLabel("Username ");
        userLabel.setBounds(10, 100, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 100, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 130, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(100, 130, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 210, 80, 25);
        panel.add(loginButton);

//        loginButton.addActionListener(e -> {
//            String usernameIn = userText.getText();
//            String passwordIn = new String(passwordText.getPassword());
//            user.setUsernameIn(usernameIn);
//            passwordUtils.setPasswordIn(passwordIn);
//            registerGUI.register();
//        });
        JButton signUpButton = new JButton("No account?");
        signUpButton.setBounds(200, 210, 140, 25);
        panel.add(signUpButton);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                registerGUI.register();
            }
        });

        JFrame errorFrame = new JFrame("Error");
        errorFrame.setSize(500,200);
        JLabel errorLabel = new JLabel();
        JButton errorButton = new JButton("Okay");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = User.
            }
        });


    }
}



