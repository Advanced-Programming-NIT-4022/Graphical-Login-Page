import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static boolean passwordLevel(String password){
        Pattern patternLevel1 = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher matcher1 = patternLevel1.matcher(password);
        Pattern patternLevel2 = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z]).+$");
        Matcher matcher2 = patternLevel2.matcher(password);
        Pattern patternLevel3 = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).+$");
        Matcher matcher3 = patternLevel3.matcher(password);
        Pattern patternLevel4 = Pattern.compile("^[\\w@\\-\\.]+$");
        Matcher matcher4 = patternLevel4.matcher(password);
        Pattern patternLevel5 = Pattern.compile("^.{9,}$");
        Matcher matcher5 = patternLevel5.matcher(password);
        if (matcher1.find()){
            return false;
        } else if (matcher2.find()){
            return false;
        } else if (matcher3.find()){
            return true;
        } else if (matcher4.find()){
            return true;
        } else if (matcher5.find()){
            return true;
        } else {
            return false;
        }
    }

        //hashing password
        public static String hashPassword(String password) throws NoSuchAlgorithmException {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
    }
