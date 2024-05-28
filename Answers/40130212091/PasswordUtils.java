import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordUtils {

    public static String passwordStrength(String password){
        if(password.length() < 8){
            return "at least 8 character";
        }
        Pattern p1 = Pattern.compile("[a-z]");
        Matcher m1 = p1.matcher(password);
        Pattern p2 = Pattern.compile("[A-Z]");
        Matcher m2 = p2.matcher(password);
        Pattern p3 = Pattern.compile(".*[!@#$%^&*(){}?<>].*");
        Matcher m3 = p3.matcher(password);
        if(m1.find() && m2.find() && m3.find()){
            return null;
        }
        return "password must contain lowercase, uppercase and special character";
    }

    public static String hashingPassword(String password){
        if(password == null){
            throw new IllegalArgumentException("password cannot be null");
        }

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());

            // Convert byte array to hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }
}
