import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {
    public static int evaluatePasswordStrength(String password) {
        int strength = 0;
        if (password.matches(".*[a-zA-Z0-9].*")) strength++;
        if (password.matches(".*[a-z].*") && password.matches(".*[A-Z].*")) strength++;
        if (password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*[0-9].*")) strength++;
        if (password.matches(".*[@\\-_.].*")) strength++;
        if (password.length() > 8) strength++;
        return strength;
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
