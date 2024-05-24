import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.util.regex.Pattern;

public class PasswordUtils {
    static String validation(String password) {
        if(Pattern.matches("[A-Z]+|[a-z]+|[0-9]+",password)){
            return "so weak!";
        } else if (Pattern.matches("(?=.*[a-z])(?=.*[A-Z])[a-zA-Z]{2,}", password)) {
            return "not bad!";
        } else if (Pattern.matches("(?=.*[a-z])(?=.*[0-9])[a-z0-9]{2,}", password) || Pattern.matches("(?=.*[0-9])(?=.*[A-Z])[0-9A-Z]{2,}", password)) {
            return "not bad!";
        } else if (Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])[a-zA-Z\\d]{3,}$", password)) {
            return "Strong!";
        } else if (Pattern.matches("^(?=.*[!@#$%^&*_.-])[!@#$%^&*a-zA-Z-_.\\d]{1,7}$", password)) {
            return "Too strong";
        } else if (Pattern.matches("(?=.*[!@#$%^&*_.-])(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[!@#$%^&*a-zA-Z-_.\\d]{8,}$", password)){
            return "Unbreakable password";
        }
        return "invalid password";
    }

    static void hashing(String password, String username, String Email) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] result = md.digest();

            //converting the byte array in to HexString format
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i< result.length; i++) {
                hexString.append(Integer.toHexString(0xFF & result[i]));
            }

            Connect.getConnectUpdate("INSERT INTO account (username, email, password) VALUES ('"+username+"','"+Email+"','"+hexString+"')");

        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
    }
}
