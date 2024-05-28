import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginGUI extends Component {
    void authenticateUser(String enteredUsername, String enteredPassword) {
        try (BufferedReader reader = new BufferedReader(new FileReader("login.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length >= 2) {
                    String storedUsername = parts[0];
                    String storedHashedPassword = parts[1];

                    if (storedUsername.equals(enteredUsername)) {
                        PasswordUtil pss = new PasswordUtil();
                        String hashedPassword = pss.hashPassword(enteredPassword);
                        if (storedHashedPassword.equals(hashedPassword)) {
                            JOptionPane.showMessageDialog(null, "Login is successful!");
                            return;
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid password!");
                            return;
                        }
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "User not found!");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}