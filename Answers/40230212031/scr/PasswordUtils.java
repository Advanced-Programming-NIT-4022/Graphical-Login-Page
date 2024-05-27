import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordUtils {

    public static String hashPassword(String password) {
        return DigestUtils.sha256Hex(password);
    }

    public enum PasswordStatus {
        WEAK, MEDIUM, STRONG, VERY_STRONG, INVALID;
    }

    public static PasswordStatus evaluatePasswordStrength(String password) {
        if (password.length() <= 8) {
            return PasswordStatus.WEAK;
        }
        boolean hasLower = password.matches("^.*[a-z].*$");
        boolean hasUpper = password.matches("^.*[A-Z].*$");
        boolean hasDigit = password.matches("^.*\\d.*$");
        boolean hasSpecial = password.matches("^.*[@\\-_\\.].*$");
        boolean hasSpace = password.contains(" ");
        if (hasSpace) {
            return PasswordStatus.INVALID;
        }
        if (hasLower && hasUpper && hasDigit && hasSpecial) {
            return PasswordStatus.VERY_STRONG;
        } else if (hasLower && hasUpper && hasDigit) {
            return PasswordStatus.STRONG;
        } else if ((hasLower && hasDigit) || (hasUpper && hasDigit)) {
            return PasswordStatus.MEDIUM;
        } else {
            return PasswordStatus.WEAK;
        }
    }
}
