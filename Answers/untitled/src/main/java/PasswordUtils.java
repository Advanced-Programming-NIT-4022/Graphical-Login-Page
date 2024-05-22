import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class PasswordUtils {
    public static String hashPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("SHA-256 algorithm not found: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static String evaluatePasswordStrength(String password) {
        if (password.length() < 8) {
            return "Password must be at least 8 characters long.";
        }
        if (Pattern.compile("[a-z]").matcher(password).find() ||
                Pattern.compile("[A-Z]").matcher(password).find() ||
                Pattern.compile("[0-9]").matcher(password).find() ||
                Pattern.compile(".*[!@#$%^&*(),.?\":{}|<>].*").matcher(password).find()) {
            return null;
        }
        return "Password must contain uppercase, lowercase, number, and special character.";
    }
}
