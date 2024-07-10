import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class signUpFrame extends JFrame implements Validator {

    public JButton backButton;
    public JButton signupButton;

    public signUpFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign up page");
        setSize(new Dimension(600, 900));
        JLabel email = new JLabel("Email");
        JLabel username = new JLabel("Username");
        JLabel password = new JLabel("Password");

        JTextField emailField = new JTextField(50);
        JTextField usernameField = new JTextField(50);
        JTextField passField = new JTextField(50); // Todo  you can Edit it and change it to JPasswordField

        backButton = new JButton("Back");
        signupButton = new JButton("Sign-up");

        // size and position
        email.setSize(100, 50);
        username.setSize(100, 50);
        password.setSize(100, 50);

        emailField.setSize(100, 50);
        usernameField.setSize(100, 50);
        passField.setSize(100, 50);

        backButton.setSize(100, 50);
        signupButton.setSize(100, 50);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(email, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(username, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(password, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(passField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(backButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(signupButton, gbc);

        emailField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                validateSignupButton();
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                validateSignupButton();
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                validateSignupButton();
            }

            private void validateSignupButton() {
                if (!emailValidator(emailField.getText())) {
                    signupButton.setEnabled(false);
                } else {
                    signupButton.setEnabled(true);
                }
            }
        });

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String username = usernameField.getText();
                String password = passField.getText();
                String hashedPassword = hashingPassword(password);

                // Write user data to file
                try (FileWriter writer = new FileWriter("users.txt", true)) {
                    writer.write(username + "," + hashedPassword + "," + email + "\n");
                    JOptionPane.showMessageDialog(null, "User signed up successfully!");
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(null, "Error saving user data.");
                    ioException.printStackTrace();
                }
            }
        });
    }

    @Override
    public String passwordLevel(String password) {
        Pattern numbers = Pattern.compile("[0-9]+");
        Pattern uppers = Pattern.compile("[A-Z]+");
        Pattern lowers = Pattern.compile("[a-z]+");
        Pattern specials = Pattern.compile("[@\\-_\\.]+");
        Pattern greaterThanEight = Pattern.compile("[a-zA-Z0-9@\\-\\._]{9,}");
        Pattern bannedCharacters = Pattern.compile("[^a-zA-Z0-9@\\-\\._]");

        boolean numFlag = numbers.matcher(password).find();
        boolean upperFlag = uppers.matcher(password).find();
        boolean lowerFlag = lowers.matcher(password).find();
        boolean specialFlag = specials.matcher(password).find();
        boolean greatFlag = greaterThanEight.matcher(password).find();
        boolean bannedFlag = bannedCharacters.matcher(password).find();
        if (!bannedFlag) {
            if (greatFlag)
                return "Very Hard";
            else {
                if (numFlag && !upperFlag && !lowerFlag && !specialFlag)
                    return "Very Easy";
                else if (numFlag && !upperFlag && !lowerFlag && specialFlag)
                    return "Hard";
                else if (numFlag && !upperFlag && lowerFlag && !specialFlag)
                    return "Medium";
                else if (numFlag && !upperFlag && lowerFlag && specialFlag)
                    return "Hard";
                else if (numFlag && upperFlag && !lowerFlag && !specialFlag)
                    return "Medium";
                else if (numFlag && upperFlag && !lowerFlag && specialFlag)
                    return "Hard";
                else if (numFlag && upperFlag && lowerFlag && !specialFlag)
                    return "Medium";
                else if (numFlag && upperFlag && lowerFlag && specialFlag)
                    return "Hard";

                else if (!numFlag && !upperFlag && !lowerFlag && !specialFlag)
                    return "Wrong Format :-|";
                else if (!numFlag && !upperFlag && !lowerFlag && specialFlag)
                    return "Hard";
                else if (!numFlag && !upperFlag && lowerFlag && !specialFlag)
                    return "Very Easy";
                else if (!numFlag && !upperFlag && lowerFlag && specialFlag)
                    return "Hard";
                else if (!numFlag && upperFlag && !lowerFlag && !specialFlag)
                    return "Very Easy";
                else if (!numFlag && upperFlag && !lowerFlag && specialFlag)
                    return "Hard";
                else if (!numFlag && upperFlag && lowerFlag && !specialFlag)
                    return "Easy";
                else if (!numFlag && upperFlag && lowerFlag && specialFlag)
                    return "Hard";
            }
        }

        return "wrong format";
    }

    @Override
    public boolean emailValidator(String email) {
        Pattern pattern = Pattern.compile("^[^\\.][a-zA-Z0-9]+\\.?[^\\.]\\w+@\\w+\\.[a-z]{2,4}$");
        return pattern.matcher(email).find();
    }

    @Override
    public String hashingPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
