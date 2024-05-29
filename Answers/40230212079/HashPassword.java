import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class HashPassword {
    public String SHA_256(String Password)
    {
        String s="";
        block2 : try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(Password.getBytes(StandardCharsets.UTF_8));
            s=bytesToHex(encodedhash);
            break block2;
        }
        catch (Exception e)
        {
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
}
