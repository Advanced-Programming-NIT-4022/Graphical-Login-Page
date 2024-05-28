import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args){

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField Emailp = new JTextField();
        JFrame frame = new JFrame("Login GUI");
        JButton btn1 = new JButton("Login");
        JButton btn2 = new JButton("Sign up");
        JLabel lbl = new JLabel("Login/sign up your account ");

        lbl.setBounds(220,180,600,100);
        frame.setSize(650,600);
        btn1.setBounds(150,300,100,30);
        btn2.setBounds(350,300,100,30);

        lbl.setBackground(Color.pink);
        btn1.setBackground(Color.LIGHT_GRAY);
        btn2.setBackground(Color.LIGHT_GRAY);
        btn1.setForeground(Color.DARK_GRAY);
        btn2.setForeground(Color.DARK_GRAY);
        lbl.setForeground(Color.DARK_GRAY);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(btn1);
                frame.remove(btn2);
                JLabel usernameLabel = new JLabel("Username :");
                usernameLabel.setBounds(170, 270, 100, 30);
                frame.add(usernameLabel);

                usernameField.setBounds(240, 270, 150, 30);
                frame.add(usernameField);


                JLabel passwordLabel = new JLabel("Password :");
                passwordLabel.setBounds(170, 330, 100, 30);
                frame.add(passwordLabel);

                passwordField.setBounds(240, 330, 150, 30);
                frame.add(passwordField);

                JButton submitButton = new JButton("login");
                submitButton.setBounds(260, 400, 100, 30);
                submitButton.setBackground(Color.LIGHT_GRAY);
                submitButton.setForeground(Color.DARK_GRAY);

                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String enteredUsername = usernameField.getText();
                        String enteredPassword = new String(passwordField.getPassword());
                        LoginGUI lgns = new LoginGUI();
                        lgns.authenticateUser(enteredUsername, enteredPassword);
                    }
                });

                frame.add(submitButton);

                frame.revalidate();
                frame.repaint();
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(btn1);
                frame.remove(btn2);

                JLabel usernameLabel = new JLabel("Username :");
                usernameLabel.setBounds(170, 270, 100, 30);
                frame.add(usernameLabel);

                usernameField.setBounds(240, 270, 150, 30);
                frame.add(usernameField);


                JLabel passwordLabel = new JLabel("Password :");
                passwordLabel.setBounds(170, 330, 100, 30);
                frame.add(passwordLabel);

                passwordField.setBounds(240, 330, 150, 30);
                frame.add(passwordField);


                JLabel Email = new JLabel("Email :");
                Email.setBounds(170, 390, 100, 30);
                frame.add(Email);

                Emailp.setBounds(240, 390, 150, 30);
                frame.add(Emailp);


                JButton submitButton = new JButton("Submit");
                submitButton.setBounds(260, 440, 100, 30);
                submitButton.setBackground(Color.LIGHT_GRAY);
                submitButton.setForeground(Color.DARK_GRAY);


                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String password , hashpassword = null;

                        password = new String(passwordField.getPassword());
                        PasswordUtil psu = new PasswordUtil();
                        if (PasswordUtil.isValidPassword(password) == "true Your password is on level 5") {
                            System.out.println("Password meets the strength criteria.");
                            hashpassword = psu.hashPassword(password);
                        }else if (PasswordUtil.isValidPassword(password) == "true Your password is on level 4") {
                            System.out.println("Password meets the strength criteria.");
                            hashpassword = psu.hashPassword(password);
                        }else if (PasswordUtil.isValidPassword(password) == "true Your password is on level 3") {
                            System.out.println("Password meets the strength criteria.");
                            hashpassword = psu.hashPassword(password);
                        } else {
                            JOptionPane.showMessageDialog(null, "Password is not strong enough. " +
                                            "Please enter a stronger password.",
                                    "Password Strength", JOptionPane.ERROR_MESSAGE);
                            passwordField.setText("");
                            return;
                        }

                        String email = null;
                        String username = usernameField.getText();
                        EmailValidator emailValidator = new EmailValidator();
                        if(emailValidator.isValidEmail(Emailp.getText())){
                            email = Emailp.getText();
                            User lgn = new User();
                            lgn.saveUserInfo(username, hashpassword, email);
                        }else {
                            JOptionPane.showMessageDialog(null,
                                            "Please enter a right email.",
                                    "wrong email", JOptionPane.ERROR_MESSAGE);
                            Emailp.setText("");
                            return;
                        }

                        JFrame f = new JFrame("Login/Signup Page");
                        JPanel messagePanel = new JPanel();
                        JLabel messageLabel = new JLabel("User Added Successfully");
                        messagePanel.add(messageLabel);
                        Container contentPane = f.getContentPane();
                        contentPane.add(messagePanel);
                        f.setSize(200, 200);
                        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        f.setVisible(true);

                        usernameField.setText("");
                        passwordField.setText("");
                        Emailp.setText("");
                    }
                });

                frame.add(submitButton);

                frame.revalidate();
                frame.repaint();
            }
        });

        btn1.setEnabled(true);
        btn2.setEnabled(true);

        frame.add(lbl);
        frame.add(btn1);
        frame.add(btn2);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
