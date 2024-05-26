import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class PasswordUtils {
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static int calculatePasswordStrength(String password) {
        if (password == null) {
            return 0;
        }
        int strengthPoints = 0;
        Pattern lowerPattern = Pattern.compile("[a-z]");
        Pattern upperPattern = Pattern.compile("[A-Z]");
        Pattern digitPattern = Pattern.compile("[0-9]");
        Pattern specialCharPattern = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]");
        if (upperPattern.matcher(password).find())
            strengthPoints++;
        if (lowerPattern.matcher(password).find())
            strengthPoints++;
        if (digitPattern.matcher(password).find())
            strengthPoints++;
        if (specialCharPattern.matcher(password).find())
            strengthPoints++;
        if (password.length() > 7)
            strengthPoints++;
        return strengthPoints;
    }
}
