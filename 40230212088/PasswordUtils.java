import javax.swing.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PasswordUtil {

    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static final String PASSWORD_PATTERN5 =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\\-_\\.]).{8,}$";
    private static final String PASSWORD_PATTERN4 =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[@\\-_.]+$";
    private static final String PASSWORD_PATTERN3 =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]+$";

    public static String isValidPassword(String password) {
        Pattern pattern5 = Pattern.compile(PASSWORD_PATTERN5);
        Pattern pattern4 = Pattern.compile(PASSWORD_PATTERN4);
        Pattern pattern3 = Pattern.compile(PASSWORD_PATTERN3);

        Matcher matcher5 = pattern5.matcher(password);
        Matcher matcher4 = pattern4.matcher(password);
        Matcher matcher3 = pattern3.matcher(password);

        if (matcher5.matches()) {
            JOptionPane.showMessageDialog(null, "Your password is on level 5",
                    "Password", JOptionPane.INFORMATION_MESSAGE);
            return "true Your password is on level 5";
        } else if (matcher4.matches()) {
            JOptionPane.showMessageDialog(null, "Your password is on level 4",
                    "Password", JOptionPane.INFORMATION_MESSAGE);
            return "true Your password is on level 4";
        } else if (matcher3.matches()) {
            JOptionPane.showMessageDialog(null, "Your password is on level 3",
                    "Password", JOptionPane.INFORMATION_MESSAGE);
            return "true Your password is on level 3";
        }

        return "false";
    }
}

