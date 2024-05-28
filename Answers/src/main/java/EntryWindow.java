import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntryWindow {

    public static void main(String[] args) {
        JFrame frame = new JFrame("User login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);

        Color forButton = new Color(141, 178, 252);

        // image pas zamine upload she
        ImageIcon background = new ImageIcon("C:\\Users\\yekta\\Downloads\\Telegram Desktop\\IMG_6689.jpg");

        JPanel backgroundPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null);
        backgroundPanel.setSize(frame.getWidth(), frame.getHeight());

        JLabel label = new JLabel("Welcome <3!");
        label.setForeground(Color.white);
        label.setBounds(210, 90, 300, 30);
        label.setFont(new Font("Georgia", Font.BOLD, 14));

        JLabel label2 = new JLabel("If you are a new user please register below :");
        label2.setForeground(Color.white);
        label2.setBounds(100,120,350,30);
        label2.setFont(new Font("Georgia", Font.BOLD, 14));

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(195, 220, 100, 30);
        loginButton.setForeground(forButton);
        loginButton.setFont(new Font("Times New Roman", Font.BOLD, 14));

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(195, 170, 100, 30);
        registerButton.setForeground(forButton);
        registerButton.setFont(new Font("Times New Roman", Font.BOLD, 14));

        backgroundPanel.add(label);
        backgroundPanel.add(label2);
        backgroundPanel.add(loginButton);
        backgroundPanel.add(registerButton);
        frame.getContentPane().add(backgroundPanel);

        frame.setVisible(true);
    }
}
