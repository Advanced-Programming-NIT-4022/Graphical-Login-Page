import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI extends JFrame {
    // JPanels
    private final JPanel loginPanel;
    private final JPanel registrationPanel;

    // JProgressBar
    private final JProgressBar jProgressBar;

    // register panel
    private final JButton registerButton;
    private final JLabel registerShowPassword;
    private final JTextField registerNameField;
    private final JPasswordField registerPasswordField;
    private final JTextField emailField;

    // login panel
    private final JTextField loginNameField;
    private final JPasswordField loginPasswordField;
    private final JButton loginButton;
    private final JLabel loginShowPassword;

    // icons
    private final Icon showIcon = new
            ImageIcon(getClass().getResource("icons/eye.png"));
    private final Icon showIconRole = new
            ImageIcon(getClass().getResource("icons/show.png"));
    private final Icon hideIcon = new
            ImageIcon(getClass().getResource("icons/hidden1.png"));
    private final Icon hideIconRole = new
            ImageIcon(getClass().getResource("icons/hidden2.png"));

    public LoginGUI() {
        super("Register and Login");

        // set up registration panel
        registrationPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // name label
        gbc.gridx = 0; // x-coordinate for name label
        gbc.gridy = 0; // y-coordinate for name label
        registrationPanel.add(new JLabel("Username: "), gbc);

        // name text box
        gbc.gridx = 1;
        registerNameField = new JTextField(20);
        registrationPanel.add(registerNameField, gbc);

        // password label
        gbc.gridx = 0;
        gbc.gridy = 1;
        registrationPanel.add(new JLabel("Password: "), gbc);

        // password field
        gbc.gridx = 1;
        registerPasswordField = new JPasswordField(20);
        registrationPanel.add(registerPasswordField, gbc);

        // show password button
        gbc.gridx = 2;
        registerShowPassword = new JLabel(showIcon);
        registerShowPassword.setVisible(false);
        registrationPanel.add(registerShowPassword, gbc);

        // email label
        gbc.gridx = 0;
        gbc.gridy = 2;
        registrationPanel.add(new JLabel("Email: "), gbc);

        // email field
        gbc.gridx = 1;
        emailField = new JTextField(20);
        registrationPanel.add(emailField, gbc);

        // register button
        gbc.gridx = 1;
        gbc.gridy = 3;
        registerButton = new JButton("Register");
        registerButton.setEnabled(false);
        registrationPanel.add(registerButton, gbc);

        add(BorderLayout.WEST, registrationPanel);

        // set up login panel
        loginPanel = new JPanel(new GridBagLayout());

        // name label
        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(new JLabel("Username: "), gbc);

        // name text box
        gbc.gridx = 1;
        loginNameField = new JTextField(20);
        loginPanel.add(loginNameField, gbc);

        // password label
        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(new JLabel("Password: "), gbc);

        // password field
        gbc.gridx = 1;
        loginPasswordField = new JPasswordField(20);
        loginPanel.add(loginPasswordField, gbc);

        // show password button
        gbc.gridx = 2;
        loginShowPassword = new JLabel(showIcon);
        loginShowPassword.setVisible(false);
        loginPanel.add(loginShowPassword, gbc);

        // login button
        gbc.gridx = 1;
        gbc.gridy = 2;
        loginButton = new JButton("Login");
        loginButton.setEnabled(false);
        loginPanel.add(loginButton, gbc);

        add(BorderLayout.CENTER, loginPanel);

        // add JProgressBar
        jProgressBar = new JProgressBar();
        jProgressBar.setValue(0);
        jProgressBar.setMinimum(0);
        jProgressBar.setMaximum(5);
        jProgressBar.setString("Password Strength 0%");
        jProgressBar.setStringPainted(true);
        add(jProgressBar, BorderLayout.SOUTH);

        // add event-listeners

        // add mouse listener for registerShowPassword
        registerShowPassword.addMouseListener(new
                handleMouseListener(registerShowPassword));

        // add mouse listener for loginShowPassword
        loginShowPassword.addMouseListener(new handleMouseListener(loginShowPassword));

        registerButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        registerButtonPress();
                    }
                }
        );

        registerButton.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        super.keyPressed(e);
                        if (e.getKeyCode() == KeyEvent.VK_ENTER)
                            registerButtonPress();
                    }
                }
        );

        loginButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        loginButtonPress();
                    }
                }
        );

        loginButton.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        super.keyPressed(e);
                        if (e.getKeyCode() == KeyEvent.VK_ENTER)
                            loginButtonPress();
                    }
                }
        );

        registerNameField.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        super.keyTyped(e);
                        if (registerPasswordField.getPassword().length > 0 &&
                                !emailField.getText().isEmpty())
                            registerButton.setEnabled(true);
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        super.keyReleased(e);
                        if (registerNameField.getText().isEmpty())
                            registerButton.setEnabled(false);
                    }
                }
        );

        loginNameField.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        super.keyTyped(e);
                        if (loginPasswordField.getPassword().length > 0)
                            loginButton.setEnabled(true);
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        super.keyReleased(e);
                        if (loginNameField.getText().isEmpty())
                            loginButton.setEnabled(false);
                    }
                }
        );

        registerPasswordField.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        super.keyTyped(e);
                        registerShowPassword.setVisible(true);

                        if (!registerNameField.getText().isEmpty() &&
                                !emailField.getText().isEmpty())
                            registerButton.setEnabled(true);
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        super.keyReleased(e);

                        // change value of progress bar
                        int strength = PasswordUtils.getPasswordStrength(
                                registerPasswordField.getPassword());
                        jProgressBar.setValue(strength);
                        jProgressBar.setString("PasswordStrength" + strength * 20 + "%");

                        if (strength == 0) {
                            registerShowPassword.setVisible(false);
                            registerButton.setEnabled(false);
                        }
                    }
                }
        );

        loginPasswordField.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        super.keyTyped(e);

                        loginShowPassword.setVisible(true);
                        if (!loginNameField.getText().isEmpty())
                            loginButton.setEnabled(true);
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        super.keyReleased(e);
                        if (loginPasswordField.getPassword().length == 0) {
                            loginShowPassword.setVisible(false);
                            loginButton.setEnabled(false);
                        }
                    }
                }
        );

        emailField.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        super.keyTyped(e);
                        if (!registerNameField.getText().isEmpty() &&
                                registerPasswordField.getPassword().length > 0)
                            registerButton.setEnabled(true);
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        super.keyReleased(e);
                        if (emailField.getText().isEmpty())
                            registerButton.setEnabled(false);
                    }
                }
        );
    }

    private void registerButtonPress() {
        // validate username
        String username = registerNameField.getText();
        if (username.length() < 6) {
            JOptionPane.showMessageDialog(LoginGUI.this,
                    "Username must be at least 6 characters.",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            registerNameField.requestFocus();
            return;
        } else if (username.contains(",")) {
            JOptionPane.showMessageDialog(LoginGUI.this,
                    "Username should not have comma.", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            registerNameField.requestFocus();
            registerNameField.selectAll();
            return;
        } else if (!UserStore.isAcceptedUsername(username)) {
            JOptionPane.showMessageDialog(LoginGUI.this,
                    "This username already exists!", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            registerNameField.requestFocus();
            return;
        }

        // validate password
        String password = new String(registerPasswordField.getPassword());
        if (password.length() < 4) {
            JOptionPane.showMessageDialog(LoginGUI.this,
                    "Password must be at least 4 characters.",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            registerPasswordField.requestFocus();
            return;
        }

        // validate email
        String email = emailField.getText();
        if (!EmailValidator.isValidEmailAddress(email)) {
            JOptionPane.showMessageDialog(LoginGUI.this,
                    "Invalid email. Try again.", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            emailField.requestFocus();
            emailField.selectAll();
            return;
        } else if (!UserStore.isAcceptedEmail(email)) {
            JOptionPane.showMessageDialog(LoginGUI.this,
                    "This email already exist!", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            emailField.requestFocus();
            emailField.selectAll();
            return;
        }

        // validate password strength
        int strength = PasswordUtils.getPasswordStrength(registerPasswordField.getPassword()) * 25;
        if (strength < 50) {
            int response = JOptionPane.showConfirmDialog(this,
                    "Your password is very weak. Do you want to change it?",
                    "Password", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                registerPasswordField.requestFocus();
                registerPasswordField.selectAll();
                return;
            }
        }

        // save user
        UserStore.saveUser(new User(username,
                PasswordUtils.hashPassword(password), email));

        // show message to user
        JOptionPane.showMessageDialog(LoginGUI.this,
                "You registered successfully!", "Register",
                JOptionPane.INFORMATION_MESSAGE);

        // delete all of fields
        registerNameField.setText("");
        registerPasswordField.setText("");
        emailField.setText("");
        loginNameField.setText("");
        loginPasswordField.setText("");
        registerShowPassword.setVisible(false);
        jProgressBar.setValue(0);
        jProgressBar.setString("Password Strength 0%");
        registerButton.setEnabled(false);
        registerNameField.requestFocus();
    }

    private void loginButtonPress() {
        User user = UserStore.retrieveUser(loginNameField.getText());

        // user not found
        if (user == null) {
            JOptionPane.showMessageDialog(this, "User with username " +
                            loginNameField.getText() + " not found!", "Not Found",
                    JOptionPane.INFORMATION_MESSAGE);
            // clear password field
            loginPasswordField.setText("");
            loginShowPassword.setVisible(false);
            // set focus on username field
            loginNameField.requestFocus();
            loginButton.setEnabled(false);
        }
        // password was wrong
        else if (!user.validateUser(new String(loginPasswordField.getPassword()))) {
            JOptionPane.showMessageDialog(this,
                    "Invalid password. Try again.", "Invalid Password",
                    JOptionPane.ERROR_MESSAGE);
            // clear password field and set focus on it
            loginPasswordField.setText("");
            loginShowPassword.setVisible(false);
            loginPasswordField.requestFocus();
            loginButton.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this,
                    "You logged in successfully\nwith this email: " + user.email(),
                    "Login", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    private class handleMouseListener extends MouseAdapter {
        JLabel source;
        JPasswordField passField;

        handleMouseListener(JLabel source) {
            this.source = source;
            passField = (source == loginShowPassword) ? loginPasswordField :
                    registerPasswordField;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            if (!e.isAltDown() && !e.isMetaDown()) {
                if (source.getIcon() == showIconRole) {
                    source.setIcon(hideIconRole);
                    passField.setEchoChar((char) 0);
                } else {
                    source.setIcon(showIconRole);
                    passField.setEchoChar('•');
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);

            if (source.getIcon() == hideIcon)
                source.setIcon(hideIconRole);
            else
                source.setIcon(showIconRole);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);

            if (source.getIcon() == hideIconRole)
                source.setIcon(hideIcon);
            else
                source.setIcon(showIcon);
        }
    }
}
