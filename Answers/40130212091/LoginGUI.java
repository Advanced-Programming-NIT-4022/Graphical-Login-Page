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
        JPanel register = new JPanel(new FlowLayout());
        JPanel login = new JPanel(new FlowLayout());
        JPanel page = new JPanel(new FlowLayout());

        frame.add(firstPanel);

        //firstpanel
        JButton rButton = new JButton("Register");
        JButton lButton = new JButton("Login");
        firstPanel.add(rButton);
        firstPanel.add(lButton);

        rButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(firstPanel);
                frame.add(register);
                frame.revalidate();
                frame.repaint();
            }
        });

        lButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(firstPanel);
                frame.add(login);
                frame.revalidate();
                frame.repaint();
            }
        });


        //register panel
        JLabel emailLabel = new JLabel("Email Address", 10);
        register.add(emailLabel);
        JTextField emailField = new JTextField(20);
        register.add(emailField);
        JLabel usernameLabel = new JLabel("Username");
        register.add(usernameLabel);
        JTextField usernameField = new JTextField(20);
        register.add(usernameField);
        JLabel passwordLabel = new JLabel("Password");
        register.add(passwordLabel);
        JPasswordField passwordField = new JPasswordField(20);
        register.add(passwordField);
        JButton registerButton = new JButton("Register");
        register.add(registerButton);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String email = emailField.getText();

                JLabel message = new JLabel();

                if(EmailValidator.emailValidation(email)){
                    if(UserStore.check(username)){
                        if (PasswordUtils.passwordStrength(password) == null){
                            UserStore.registerUser(username, password, email);
                            frame.remove(register);
                            frame.add(page);
                            frame.revalidate();
                            frame.repaint();
                        }else{
                            JOptionPane.showMessageDialog(frame, PasswordUtils.passwordStrength(password));
                        }
                    }else {
                        JOptionPane.showMessageDialog(frame, "username already exist");
                    }
                }else {
                    JOptionPane.showMessageDialog(frame, "invalid email address");
                }
            }
        });

        //login panel
        JLabel usernameLabelLogin = new JLabel("Username");
        login.add(usernameLabelLogin);
        JTextField usernameFieldLogin = new JTextField(20);
        login.add(usernameFieldLogin);
        JLabel passwordLabelLogin = new JLabel("Password");
        login.add(passwordLabelLogin);
        JPasswordField passwordFieldLogin = new JPasswordField(20);
        login.add(passwordFieldLogin);
        JButton loginButton = new JButton("Login");
        login.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameFieldLogin.getText();
                String password = new String(passwordFieldLogin.getPassword());


                if(UserStore.loginUser(username, password) == null){
                    frame.remove(login);
                    frame.add(page);
                    frame.revalidate();
                    frame.repaint();
                }
                else {
                    JOptionPane.showMessageDialog(frame, UserStore.loginUser(username, password));
                }
            }
        });

        //page panel
        JLabel welcome = new JLabel("WELCOME");
        page.add(welcome);


        frame.setVisible(true);

    }
}
