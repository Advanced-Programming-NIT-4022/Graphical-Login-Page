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
                    submitValidation.setText("hooray");
                    submitValidation.setForeground(pinkie);
                    
                } else {
                    submitValidation.setText("Wrong entry.");
                    submitValidation.setForeground(redie);
                }

            }
        });
    }}