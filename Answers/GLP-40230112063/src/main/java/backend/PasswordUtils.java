package backend;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

class PasswordUtils {

    private static final Pattern password_whitespace_pattern = Pattern.compile("^( )*$");
    private static final Pattern password_leve1_pattern = Pattern.compile("^(([a-z]+\\s*(?:[a-z])*)|([A-Z]+\\s*(?:[A-Z])*)|([0-9]+\\s*(?:[0-9])*))$");
    private static final Pattern password_level2_pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])[a-zA-Z][a-zA-Z\\s]*$");
    private static final Pattern password_level3_pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9][a-zA-Z0-9\\s]*$");
    private static final Pattern password_level4_pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$-_.])[a-zA-Z0-9!@#$-_.][a-zA-Z0-9!@#$-_.\\s]*$");
    private static final Pattern password_level5_pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$-_.])[a-zA-Z0-9!@#$-_.][a-zA-Z0-9!@#$-_.\\s]{7,}$");

    protected static int passwordValidator(String password) {

        if (password_whitespace_pattern.matcher(password).find()) {
            return -1; //whitespace error
        } else if (password_leve1_pattern.matcher(password).find()) {
            return 1;
        } else if (password_level2_pattern.matcher(password).find()) {
            return 2;
        } else if (password_level3_pattern.matcher(password).find()) {
            return 3;
        } else if (password_level4_pattern.matcher(password).find()) {
            return 4;
        } else if (password_level5_pattern.matcher(password).find()) {
            return 5;
        } else return -2; //invalid password
    }


    private static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    private static String toHexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

    protected static String hashingPassword(String password) {
        try {
            password = toHexString(getSHA(password));
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
        return password;
    }


}
