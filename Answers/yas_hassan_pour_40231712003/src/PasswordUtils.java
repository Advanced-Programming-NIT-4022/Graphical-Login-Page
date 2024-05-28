import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.regex.Pattern;

public class PasswordUtils {
    public void setPasswordIn(String passwordIn) {
        this.passwordIn = passwordIn;
    }

    public String getPasswordIn() {
        return passwordIn;
    }

    private String passwordIn;
    public String SHA_256(String password) {
       
        String s = "";
        block2:
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            s = bytesToHex(encodedhash);
            break block2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    private static String bytesToHex(byte[] hash)
    {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
    public int checkpassword(String password)
    {
        int t=0;

        boolean s1 = Pattern.compile("[a-z]").matcher(password).find();
        boolean s2 = Pattern.compile("[A-Z]").matcher(password).find();
        boolean s3 = Pattern.compile("[0-9]").matcher(password).find();
        boolean s4 = Pattern.compile("[.@_-]").matcher(password).find();

        if (s1&&s2&&s3&&s4&&(password.length()>=8))
        {
            t=5;
        }
        else if(s1&&s2&&s3&&s4)
        {
            t=4;
        }
        else if(s1&&s2&&s3)
        {
            t=3;
        }
        else if((s1&&s2)||(s3&&s2)||(s1&&s3))
        {
            t=2;
        }
        else
        {
            t=1;
        }
        return t;
    }
}
