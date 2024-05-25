import javax.swing.*;

public class LoginGUI {
    String usernameIn;
    String passwordIn;
    User user;

    public void login(){
        JFrame frame = new JFrame("Login");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel userLabel = new JLabel("username ");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);



        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10,80,80,25);
        panel.add(loginButton);

        loginButton.addActionListener(e -> {
            usernameIn = userText.getText();
            passwordIn = new String(passwordText.getPassword());
           user.setUsernameIn(usernameIn);
           user.setPasswordIn(passwordIn);
        });
        frame.add(panel);
        frame.setVisible(true);
    }

}