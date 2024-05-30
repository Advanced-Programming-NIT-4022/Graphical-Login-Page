import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Register {

    public void registerPanel() {

        JFrame registerFrame = new JFrame("Register panel");
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerFrame.setSize(500, 500);
        registerFrame.setLayout(null);

        Color pinkie = new Color(249, 127, 204);
        Color redie = new Color(213, 77, 77);
        Color greenie = new Color(20, 161, 71);

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
        username.setBounds(110, 111, 300, 30);
        username.setFont(new Font("Georgia", Font.BOLD, 14));
        username.setForeground(Color.white);

        JLabel email = new JLabel("Email : ");
        email.setForeground(Color.white);
        email.setBounds(110, 161, 350, 30);
        email.setFont(new Font("Georgia", Font.BOLD, 14));

        JLabel password = new JLabel("Password : ");
        password.setForeground(Color.white);
        password.setBounds(110, 211, 350, 30);
        password.setFont(new Font("Georgia", Font.BOLD, 14));

        JLabel usernameValidation = new JLabel("");
        usernameValidation.setBounds(110, 135, 350, 30);
        usernameValidation.setFont(new Font("Georgia", Font.BOLD, 11));

        JLabel passwordValidation = new JLabel("");
        passwordValidation.setBounds(110, 235, 350, 30);
        passwordValidation.setFont(new Font("Georgia", Font.BOLD, 11));

        JLabel emailValidation = new JLabel("");
        emailValidation.setBounds(110, 185, 350, 30);
        emailValidation.setFont(new Font("Georgia", Font.BOLD, 11));

        JLabel submitValidation = new JLabel("");
        submitValidation.setBounds(110, 260, 350, 30);
        submitValidation.setFont(new Font("Georgia", Font.BOLD, 11));

        JTextField usernameField = new JTextField(20);
        usernameField.setBounds(230, 117, 105, 20);

        JTextField emailField = new JTextField(20);
        emailField.setBounds(230, 167, 105, 20);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(230, 217, 105, 20);

        JButton submit = new JButton("Submit");
        submit.setBounds(230, 267, 105, 20);
        submit.setForeground(pinkie);
        submit.setBackground(Color.white);
        submit.setFont(new Font("Georgia", Font.BOLD, 10));

        JButton LoginButton = new JButton("Login  Page");
        LoginButton.setBounds(230, 405, 105, 20);
        LoginButton.setForeground(pinkie);
        LoginButton.setBackground(Color.white);
        LoginButton.setFont(new Font("Georgia", Font.BOLD, 10));

        JLabel LoginLabel = new JLabel("Have an account?");
        LoginLabel.setForeground(pinkie);
        LoginLabel.setBounds(110,400,350,30);
        LoginLabel.setFont(new Font("Georgia", Font.BOLD, 11));

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
        backgroundPanel.add(LoginButton);
        backgroundPanel.add(LoginLabel);

        registerFrame.getContentPane().add(backgroundPanel);

        //frame jadid :

        JFrame registerDoneFrame = new JFrame("Registered");
        registerDoneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerDoneFrame.setSize(400, 250);
        registerDoneFrame.setLayout(null);

        ImageIcon backgroundDone = new ImageIcon("C:\\Users\\yekta\\Downloads\\Telegram Desktop\\IMG_6692.jpg");

        JPanel backgroundPanelDone = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanelDone.setLayout(null);
        backgroundPanelDone.setSize(registerDoneFrame.getWidth(), registerDoneFrame.getHeight());

        JLabel registerDoneLabel = new JLabel("You have successfully registered!");
        registerDoneLabel.setBounds(60,95,300,20);
        registerDoneLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        registerDoneLabel.setForeground(Color.WHITE);

        JLabel registerDoneBackToLoginPanel =  new JLabel("Wanna Login ?");
        registerDoneBackToLoginPanel.setBounds(60,160,100,30);
        registerDoneBackToLoginPanel.setFont(new Font("Georgia", Font.BOLD, 10));
        registerDoneBackToLoginPanel.setForeground(Color.WHITE);

        JButton registerDoneButton = new JButton("Login");
        registerDoneButton.setBounds(150,169,65,15);
        registerDoneButton.setFont(new Font("Georgia", Font.BOLD, 9));
        registerDoneButton.setForeground(pinkie);
        registerDoneButton.setBackground(Color.white);

        backgroundPanelDone.add(registerDoneLabel);
        backgroundPanelDone.add(registerDoneBackToLoginPanel);
        backgroundPanelDone.add(registerDoneButton);
        registerDoneFrame.getContentPane().add(backgroundPanelDone);


        registerFrame.setVisible(true);

        usernameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkUsername();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkUsername();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkUsername();
            }

            public void checkUsername() {
                String usernameInput = usernameField.getText();
                Pattern pr = Pattern.compile("[a-zA-Z0-9_.]+");
                Matcher mr = pr.matcher(usernameInput);
                if (mr.matches()) {
                    usernameValidation.setText("Valid username.");
                    usernameValidation.setForeground(greenie);
                } else {
                    usernameValidation.setText("Invalid username.");
                    usernameValidation.setForeground(redie);
                }
            }
        });
        passwordField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkPassword();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkPassword();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkPassword();
            }

            private void checkPassword() {
                String passwordInput = String.valueOf(passwordField.getPassword());
                Pattern pass1 = Pattern.compile("[A-Z]+|[a-z]+|[0-9]+");
                Pattern pass2 = Pattern.compile("[a-zA-Z]+");
                Pattern pass3 = Pattern.compile("[a-zA-Z0-9]+");
                Pattern pass4 = Pattern.compile("[a-zA-Z0-9!\"#$%&\'()*+,\\-\\./:;<>=?@\\[\\]^_{}|]{1,7}");
                Pattern pass5 = Pattern.compile("[a-zA-Z0-9!\"#$%&\'()*+,\\-\\./:;<>=?@\\[\\]^_{}|]{8,100}");
                Matcher mr1 = pass1.matcher(passwordInput);
                Matcher mr2 = pass2.matcher(passwordInput);
                Matcher mr3 = pass3.matcher(passwordInput);
                Matcher mr4 = pass4.matcher(passwordInput);
                Matcher mr5 = pass5.matcher(passwordInput);
                if (mr1.matches()) {
                    passwordValidation.setText("Level 1 password, not a good one :(");
                    passwordValidation.setForeground(redie);
                } else if (mr2.matches()) {
                    passwordValidation.setText("Level 2 password, not a good one :(");
                    passwordValidation.setForeground(redie);
                } else if (mr3.matches()) {
                    passwordValidation.setText("Ready to use but still guessable.");
                    passwordValidation.setForeground(greenie);
                } else if (mr4.matches()) {
                    passwordValidation.setText("Level 4 password, it's okay.");
                    passwordValidation.setForeground(greenie);
                } else if (mr5.matches()) {
                    passwordValidation.setText("Your password is excellent. You are good to go!");
                    passwordValidation.setForeground(greenie);
                } else {
                    passwordValidation.setText("Invalid password format.");
                    passwordValidation.setForeground(redie);
                }
            }
        });
        emailField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkEmail();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkEmail();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkEmail();
            }

            public void checkEmail() {
                String emailInput = emailField.getText();
                Pattern pr = Pattern.compile("(^[a-zA-Z0-9]+(?:[\\.\\-_]{1}[a-zA-Z0-9]+)*)@([a-zA-Z]+[0-9]*(?:[\\.\\-_]{1}[a-zA-Z0-9]+)*)\\.([a-zA-Z]{2,})");
                Matcher mr = pr.matcher(emailInput);
                if (mr.matches()) {
                    emailValidation.setText("Valid email input.");
                    emailValidation.setForeground(greenie);
                } else {
                    emailValidation.setText("Invalid email input.");
                    emailValidation.setForeground(redie);
                }
            }
        });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color passColor = passwordValidation.getForeground();
                Color emailColor = emailValidation.getForeground();
                Color usernameColor = usernameValidation.getForeground();
                if (e.getSource() == submit && usernameColor == greenie && emailColor == greenie && passColor == greenie) {
                    submitValidation.setText("you have registered successfully.");
                    submitValidation.setForeground(pinkie);
                    UserStore userAdding = new UserStore();
                    try {
                        userAdding.addMyUser(usernameField.getText(), emailField.getText(), String.valueOf(passwordField.getPassword()));
                        UserStore.toFile();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    registerDoneFrame.setVisible(true);
                    registerFrame.setVisible(false);
                } else {
                    submitValidation.setText("Wrong entry.");
                    submitValidation.setForeground(redie);
                }

            }
        });
        registerDoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == registerDoneButton){
                    registerDoneFrame.setVisible(false);
                    Login login = new Login();
                    login.loginPanel();
                }
            }
        });
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==LoginButton){
                    registerFrame.setVisible(false);
                    Login login = new Login();
                    login.loginPanel();
                }
            }
        });
    }}