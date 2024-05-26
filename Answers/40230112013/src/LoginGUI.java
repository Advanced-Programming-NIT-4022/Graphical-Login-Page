import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI {
    private JFrame mainFrame;
    private JButton loginButton, registerButton, exitButton;

    public LoginGUI() {
        prepareGUI();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Registration/Login");
        mainFrame.setSize(500, 500);
        mainFrame.setLayout(new GridLayout(3, 1, 10, 10));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().setBackground(Color.decode("#ECEFF1")); // Set background color

        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        exitButton = new JButton("Exit");

        // Set button fonts and colors
        Font buttonFont = new Font( null, Font.BOLD, 16);
        loginButton.setFont(buttonFont);
        registerButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        loginButton.setBackground(Color.decode("#FAC107")); // Set button color
        registerButton.setBackground(Color.decode("#8025")); // Set button color
        exitButton.setBackground(Color.decode("#a52a2a")); // Set button color

        loginButton.setActionCommand("Login");
        registerButton.setActionCommand("Register");
        exitButton.setActionCommand("Exit");

        loginButton.addActionListener(new ButtonClickListener());
        registerButton.addActionListener(new ButtonClickListener());
        exitButton.addActionListener(new ButtonClickListener());

        mainFrame.add(loginButton);
        mainFrame.add(registerButton);
        mainFrame.add(exitButton);
        mainFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Login")) {
                handleLogin();
            } else if (command.equals("Register")) {
                handleRegistration();
            } else if (command.equals("Exit")) {
                mainFrame.dispose();
            }
        }
    }
    private void handleLogin(){

    }
    private void handleRegistration(){

    }
}
