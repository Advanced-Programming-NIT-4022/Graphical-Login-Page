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
        errorFrame.setLayout(null);
        errorFrame.setSize(300,250);
        JButton errorButton = new JButton("Okay");
        JPanel errorPanel = new JPanel();
        errorPanel.setLayout(null);
        errorFrame.add(errorPanel);
        JLabel errorLabel = new JLabel();

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(passwordText.getPassword());
                UserStore userStore = new UserStore();
                int i = userStore.read(userText.getText(),password);
                switch (i){
                    case 0:
                    {

                        errorLabel.setText("No such user found.");


                        errorLabel.setBackground(Color.RED);
                        errorLabel.setBounds(10, 100, 120, 25);
                        errorPanel.add(errorLabel);

                        errorFrame.setVisible(true);
                        errorButton.setBounds(100,150,80,30);
                        errorPanel.add(errorButton);
                        errorButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                errorFrame.dispose();
                            }
                        });
                        break;
                    }
                    case 1:{
                        errorLabel.setText("Wrong password.");
                        errorLabel.setBounds(10, 100, 120, 25);
                        errorButton.setBounds(100,150,80,30);
                        errorPanel.add(errorLabel);
                        errorPanel.add(errorButton);
                        errorButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                errorFrame.dispose();
                            }
                        });
                        errorFrame.setVisible(true);
                        break;
                    }
                    default:
                    {
                        JFrame successful = new JFrame("Logged in!");
                        errorLabel.setText("Successfully logged in!");
                        JButton Sbutton = new JButton("Hip hip, hooray!");
                        errorLabel.setBounds(5,30,300,30);
                        Sbutton.setBounds(200,120,70,25);
                        errorPanel.add(errorLabel);
                        errorPanel.add(Sbutton);
                        successful.add(errorPanel);
                        Sbutton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                successful.dispose();
                            }
                        });
                        break;


                    }
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}



