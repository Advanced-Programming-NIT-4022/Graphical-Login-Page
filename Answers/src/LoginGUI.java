import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class LoginGUI extends JFrame {
    // JPanels
    private final JPanel loginPanel;
    private final JPanel registrationPanel;

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
        registrationPanel.add(new JLabel("Name: "), gbc);

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
        registrationPanel.add(registerShowPassword, gbc);
        registerShowPassword.setVisible(false);

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
        registrationPanel.add(registerButton, gbc);

        add(BorderLayout.WEST, registrationPanel);

        // set up login panel
        loginPanel = new JPanel(new GridBagLayout());

        // name label
        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(new JLabel("Name: "), gbc);

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
        loginPanel.add(loginShowPassword, gbc);

        // login button
        gbc.gridx = 1;
        gbc.gridy = 2;
        loginButton = new JButton("Login");
        loginPanel.add(loginButton, gbc);

        add(BorderLayout.CENTER, loginPanel);

        // add JProgressBar
        JProgressBar jProgressBar = new JProgressBar();
        jProgressBar.setValue(0);
        jProgressBar.setMinimum(0);
        jProgressBar.setMaximum(5);
        jProgressBar.setString("Password Strength 0%");
        jProgressBar.setStringPainted(true);
        add(jProgressBar, BorderLayout.SOUTH);
        jProgressBar.setVisible(false);

        // add event-listeners

        // add mouse listener for registerShowPassword
        registerShowPassword.addMouseListener(new
                handleMouseListener(registerShowPassword));

        // add mouse listener for loginShowPassword
        loginShowPassword.addMouseListener(new handleMouseListener(loginShowPassword));

        // add action listener for register button
        registerButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    }
                }
        );

        // add key listener for JPasswordField
        registerPasswordField.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        super.keyTyped(e);

                        registerShowPassword.setVisible(true);
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        super.keyReleased(e);

                        // change value of progress bar
                        int strength = PasswordUtils.getPasswordStrength(
                                registerPasswordField.getPassword());
                        jProgressBar.setValue(strength);
                        jProgressBar.setString("PasswordStrength" + strength * 20 + "%");

                        if (strength == 0)
                            registerShowPassword.setVisible(false);
                    }
                }
        );

        // add focus listener for register password field
        registerPasswordField.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        super.focusGained(e);

                        jProgressBar.setVisible(true);
                    }
                }
        );
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
