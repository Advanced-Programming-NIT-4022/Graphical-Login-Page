package backend;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

class PasswordUtils {

    protected Pattern password_whitespace_pattern = Pattern.compile("^( )*$");
    protected Pattern password_leve1_pattern = Pattern.compile("^(([a-z]+\\s*(?:[a-z])*)|([A-Z]+\\s*(?:[A-Z])*)|([0-9]+\\s*(?:[0-9])*))$");
    protected Pattern password_level2_pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])[a-zA-Z][a-zA-Z\\s]*$");
    protected Pattern password_level3_pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9][a-zA-Z0-9\\s]*$");
    protected Pattern password_level4_pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$-_.])[a-zA-Z0-9!@#$-_.][a-zA-Z0-9!@#$-_.\\s]*$");
    protected Pattern password_level5_pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$-_.])[a-zA-Z0-9!@#$-_.][a-zA-Z0-9!@#$-_.\\s]{7,}$");

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
