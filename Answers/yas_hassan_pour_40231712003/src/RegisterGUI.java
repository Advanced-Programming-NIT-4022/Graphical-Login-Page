import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterGUI {
    User user;
    PasswordUtils passwordUtils;
    EmailValidator emailValidator;
    public void register()
    {
        JFrame frame = new JFrame("Sign Up");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelFont = new JLabel("REGISTER");
        labelFont.setBounds(150,10,150, 50);
        labelFont. setFont(new Font("Serif", Font.BOLD, 25));
        frame.add(labelFont);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(10,100,80,25);
        panel.add(userLabel);

        JTextField usernameText = new JTextField(20);
        usernameText.setBounds(100,100,165,25);
        panel.add(usernameText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,130,80,25);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(100,130,165,25);
        panel.add(passwordField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(10,160,80,25);
        panel.add(emailLabel);

        JTextField emailText = new JTextField(30);
        emailText.setBounds(100,160,165,25);
        panel.add(emailText);
        JButton registerationButton = new JButton("Register");
        registerationButton.setBounds(10, 210, 90, 25);
        panel.add(registerationButton);
        JLabel labelPass = new JLabel();
        JFrame error = new JFrame("idk");
        JLabel labelPass2 = new JLabel("the password must be atleast 8 characters long.");
        JLabel labelPass3= new JLabel("the password must contain uppercase ,lowercase ,number and special character.");
        JButton errorButton = new JButton("Ok");
        registerationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                EmailValidator check1 = new EmailValidator();
                String mail = new String(emailText.getText());
                if(check1.validate(mail)==1)
                {
                    String pass = new String(passwordField.getPassword());
                    PasswordUtils check2 = new PasswordUtils();
                    int t = check2.checkpassword(pass);
                    switch (t)
                    {
                        case 2:
                        {
                            labelPass.setText("low.");
                            labelPass.setForeground(Color.RED);
                            labelPass.setBounds(5, 10, 30, 30);
                            error.add( labelPass);
                            error.add(labelPass2);
                            error.add(labelPass3);
                            error.setVisible(true);
                            errorButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e)
                                {
                                    error.dispose();
                                }
                            });
                            break;
                        }
                        case 1:
                        {
                            labelPass.setText("very low.");
                            labelPass.setForeground(Color.RED);
                            labelPass.setBounds(5, 10, 50, 30);
                            error.add(labelPass);
                            error.add(labelPass2);
                            error.add(labelPass3);
                            error.setVisible(true);
                            errorButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e)
                                {
                                    error.dispose();
                                }
                            });
                            break;
                        }
                        default:
                        {
                            User user = new User(mail, usernameText.getText(), pass);
                            UserStore userstore = new UserStore();
                            userstore.saveData(user);
                            JFrame success = new JFrame("Notice");
                            JLabel huh = new JLabel("successfully Registered");
                            JButton hmm = new JButton("YAYY");
                            huh.setBounds(5, 30, 300, 30);
                            hmm.setBounds(200, 120, 70, 25);
                            success.add(huh);
                            success.add(hmm);
                            success.setSize(475, 200);
                            success.setLayout(null);
                            success.setResizable(false);
                            success.setVisible(true);
                            hmm.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e)
                                {
                                    success.dispose();
                                }
                            });
                            break;
                        }
                    }
                }
                else
                {
                    labelPass.setText("email is not valid.");
                    labelPass.setForeground(Color.RED);
                    labelPass.setBounds(5, 10, 100, 30);
                    error.add(labelPass);
                    error.setVisible(true);
                    errorButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            error.dispose();
                        }
                    });
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);

    }

}
