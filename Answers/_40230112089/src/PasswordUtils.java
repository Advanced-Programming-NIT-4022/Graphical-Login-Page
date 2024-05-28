import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordUtils {

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


    public static String strong(String password) {
        String maessage ="" ;
        if (password.matches("^(?:\\d+|[A-Z]+|[a-z]+)$")){
            maessage="level 1 ـYour password must contain at least one uppercase letter, one lowercase letter and one number. The characters @_-.can be or not";
        }
        if (password.matches("^(?=.*[a-z])(?=.*[A-Z])[a-zA-Z]+$")){
            maessage="level 2 ـYour password must contain at least one uppercase letter, one lowercase letter and one number. The characters @_-.can be or not";

        }
        if ((password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{3,7}$"))){
            maessage="level 3 ـYour password is correct";

        }
        if ((password.matches("^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[_\\-@])[A-Za-z\\d_\\-@]{4,7}$"))){
            maessage="level 4 ـYour password is correct";

        }
        if ((password.matches("^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[_\\-@])[A-Za-z\\d_\\-@]{8,}$"))){
            maessage="level 5 ـYour password is correct";

        }


        return maessage;
    }
}

