import javax.swing.*;
import java.awt.*;


public class Register {

    public void registerPanel() {

        JFrame registerFrame = new JFrame("Register panel");
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerFrame.setSize(500, 500);
        registerFrame.setLayout(null);

        Color pinkie = new Color(249, 127, 204);
        Color redie = new Color(213, 77, 77);
        Color greenie = new Color(38, 186, 112);

        ImageIcon background = new ImageIcon("C:\\Users\\yekta\\Downloads\\Telegram Desktop\\IMG_6692.jpg");

        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null);
        backgroundPanel.setSize(registerFrame.getWidth(), registerFrame.getHeight());

        JLabel username = new JLabel("Username : ");
        username.setBounds(80, 90, 300, 30);
        username.setFont(new Font("Georgia", Font.BOLD, 14));
        username.setForeground(Color.white);

        JLabel email = new JLabel("Email : ");
        email.setForeground(Color.white);
        email.setBounds(80, 140, 350, 30);
        email.setFont(new Font("Georgia", Font.BOLD, 14));

        JLabel password = new JLabel("Password : ");
        password.setForeground(Color.white);
        password.setBounds(80, 190, 350, 30);
        password.setFont(new Font("Georgia", Font.BOLD, 14));

        JLabel usernameValidation = new JLabel("");
        usernameValidation.setBounds(80, 115, 350, 30);
        usernameValidation.setFont(new Font("Georgia", Font.BOLD, 10));

        JLabel passwordValidation = new JLabel("");
        passwordValidation.setBounds(80, 215, 350, 30);
        passwordValidation.setFont(new Font("Georgia", Font.BOLD, 10));

        JLabel emailValidation = new JLabel("");
        emailValidation.setBounds(80, 165, 350, 30);
        emailValidation.setFont(new Font("Georgia", Font.BOLD, 10));

        JLabel submitValidation = new JLabel("");
        submitValidation.setBounds(80, 230, 350, 30);
        submitValidation.setFont(new Font("Georgia", Font.BOLD, 10));

        JTextField usernameField = new JTextField(20);
        usernameField.setBounds(200, 97, 100, 20);

        JTextField emailField = new JTextField(20);
        emailField.setBounds(200, 147, 100, 20);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(200, 197, 100, 20);

        JButton submit = new JButton("Submit");
        submit.setBounds(200, 247, 100, 20);
        submit.setForeground(pinkie);
        submit.setFont(new Font("Georgia", Font.BOLD, 10));

        backgroundPanel.add(username);
        backgroundPanel.add(usernameField);
        backgroundPanel.add(usernameValidation);
        backgroundPanel.add(email);
        backgroundPanel.add(emailField);
        backgroundPanel.add(emailValidation);
        backgroundPanel.add(password);
        backgroundPanel.add(passwordField);
        backgroundPanel.add(passwordValidation);
        backgroundPanel.add(submit);
        backgroundPanel.add(submitValidation);

        registerFrame.getContentPane().add(backgroundPanel);
        registerFrame.setVisible(true);
    }