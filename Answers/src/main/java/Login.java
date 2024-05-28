import javax.swing.*;
import java.awt.*;

public class Login {

    public void loginPanel() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginFrame.setSize(500, 500);
        loginFrame.setLayout(null);

        Color pinkie = new Color(249, 127, 204);
        Color redie = new Color(213,77,77);
        Color bluie = new Color(38,137,186);

        ImageIcon background = new ImageIcon("C:\\Users\\yekta\\Downloads\\Telegram Desktop\\IMG_6693.jpg");

        JPanel backgroundPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null);
        backgroundPanel.setSize(loginFrame.getWidth(), loginFrame.getHeight());

        JLabel usernameLabel = new JLabel("Username : ");
        usernameLabel.setBounds(80, 90, 300, 30);
        usernameLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        usernameLabel.setForeground(Color.white);

        JTextField usernameField = new JTextField(20);
        usernameField.setBounds(200,97,100,20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.white);
        passwordLabel.setBounds(80,140,350,30);
        passwordLabel.setFont(new Font("Georgia", Font.BOLD, 14));

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(200,147,100,20);

        JButton loginButton = new JButton("Submit");
        loginButton.setBounds(200,197,100,20);
        loginButton.setForeground(bluie);
        loginButton.setFont(new Font("Georgia", Font.BOLD, 10));

        backgroundPanel.add(usernameLabel);
        backgroundPanel.add(usernameField);
        backgroundPanel.add(passwordLabel);
        backgroundPanel.add(passwordField);
        backgroundPanel.add(loginButton);

        loginFrame.add(backgroundPanel);

        loginFrame.setVisible(true);
    }
}
