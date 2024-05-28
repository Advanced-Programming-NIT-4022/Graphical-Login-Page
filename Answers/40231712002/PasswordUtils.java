import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {
    public static int getPasswordStrength(String password) {
        int strength = 0;

        if (password.length() >= 8) {
            strength++;
        }
        if (password.matches(".*[a-z].*")) {
            strength++;
        }
        if (password.matches(".*[A-Z].*")) {
            strength++;
        }
        if (password.matches(".*\\d.*")) {
            strength++;
        }
        if (password.matches(".*[@\\-_.].*")) {
            strength++;
        }

        return strength;
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}