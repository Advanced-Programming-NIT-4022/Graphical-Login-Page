import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordUtils {
    public static int Strength(String Password){
        String regexPasswordlvl1="[a-z0-9A-Z]{2,}";
        String regexPasswordlvl2="^(?=.*[a-z])(?=.*[A-Z])[a-zA-Z]{4,}$";
        String regexPasswordlvl3="(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z0-9]{8,}";
        String regexPasswordlvl4= "/(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@_,.-])[a-zA-Z0-9!@#$%^&-_.]{8,}";
        if(Pattern.matches(regexPasswordlvl1,Password))
            return 1;
        if(Pattern.matches(regexPasswordlvl2,Password))
            return 2;
        if(Pattern.matches(regexPasswordlvl3,Password))
            return 3;
        if(Pattern.matches(regexPasswordlvl4,Password))
            return 4;
        return 0;
    }
    public static String hashing(String Password){
        try {
            MessageDigest md=MessageDigest.getInstance("SHA-256");
            md.update(Password.getBytes());
            byte[] result=md.digest();
            StringBuffer hexString=new StringBuffer();
            for(int i=0;i<result.length;i++){
                hexString.append(Integer.toHexString(0xFF & result[i]));
            }
            return hexString.toString();
        }
        catch (NoSuchAlgorithmException e){
            System.out.println(e);
        }
        return null;

    }

}
