import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class loginFrame extends JFrame implements Validator {
    public JButton backButton;
    public JButton loginButton;

    public loginFrame() {
        setTitle("Login page");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(600, 900));
        // JLabels
        JLabel email = new JLabel("Email");
        email.setSize(100, 50);
        JLabel password = new JLabel("Password");
        password.setSize(100, 50);
        // text fields
        JTextField emailField = new JTextField(50);
        emailField.setSize(100, 50);
        JPasswordField passField = new JPasswordField(50); // Changed to JPasswordField
        passField.setSize(100, 50);

        backButton = new JButton("Back");
        backButton.setSize(100, 50);
        loginButton = new JButton("Login");
        loginButton.setSize(100, 50);
        loginButton.setEnabled(false); // Initially disabled

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
        add(password, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(passField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(backButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(loginButton, gbc);

        emailField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                checkInputFields(emailField, passField);
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                checkInputFields(emailField, passField);
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                checkInputFields(emailField, passField);
            }
        });

        passField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                checkInputFields(emailField, passField);
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                checkInputFields(emailField, passField);
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                checkInputFields(emailField, passField);
            }
        });

        loginButton.addActionListener(e -> {
            String inputEmail = emailField.getText();
            String inputPassword = new String(passField.getPassword());
            if (validateCredentials(inputEmail, inputPassword)) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email or password.");
            }
        });
    }

    private void checkInputFields(JTextField emailField, JPasswordField passField) {
        String email = emailField.getText();
        String password = new String(passField.getPassword());
        loginButton.setEnabled(emailValidator(email) && !password.isEmpty());
    }

    private boolean validateCredentials(String email, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("user.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length == 3) {
                    String storedUsername = userDetails[0];
                    String storedHashedPassword = userDetails[1];
                    String storedEmail = userDetails[2];

                    if (storedEmail.equals(email) && storedHashedPassword.equals(hashingPassword(password))) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
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
            if (greatFlag) return "Very Hard";
            else {
                if (numFlag && !upperFlag && !lowerFlag && !specialFlag) return "Very Easy";
                else if (numFlag && !upperFlag && !lowerFlag && specialFlag) return "Hard";
                else if (numFlag && !upperFlag && lowerFlag && !specialFlag) return "Medium";
                else if (numFlag && !upperFlag && lowerFlag && specialFlag) return "Hard";
                else if (numFlag && upperFlag && !lowerFlag && !specialFlag) return "Medium";
                else if (numFlag && upperFlag && !lowerFlag && specialFlag) return "Hard";
                else if (numFlag && upperFlag && lowerFlag && !specialFlag) return "Medium";
                else if (numFlag && upperFlag && lowerFlag && specialFlag) return "Hard";
                else if (!numFlag && !upperFlag && !lowerFlag && !specialFlag) return "Wrong Format :-|";
                else if (!numFlag && !upperFlag && !lowerFlag && specialFlag) return "Hard";
                else if (!numFlag && !upperFlag && lowerFlag && !specialFlag) return "Very Easy";
                else if (!numFlag && !upperFlag && lowerFlag && specialFlag) return "Hard";
                else if (!numFlag && upperFlag && !lowerFlag && !specialFlag) return "Very Easy";
                else if (!numFlag && upperFlag && !lowerFlag && specialFlag) return "Hard";
                else if (!numFlag && upperFlag && lowerFlag && !specialFlag) return "Easy";
                else if (!numFlag && upperFlag && lowerFlag && specialFlag) return "Hard";
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
