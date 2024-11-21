import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Passlevel {
    public int paslvl(String p) {
        Pattern p1=Pattern.compile("[a-z]|[A-Z]|[0-9]");
        Matcher m1=p1.matcher(p);
        boolean f1=m1.find();
        Pattern pb2=Pattern.compile("[A-Z]");
        Matcher mb2= pb2.matcher(p);
        boolean fb2= mb2.find();
        Pattern pk2=Pattern.compile("[a-z]");
        Matcher mk2=pk2.matcher(p);
        boolean fk2= mk2.find();
        Pattern p3=Pattern.compile("[0-9]");
        Matcher m3=p3.matcher(p);
        boolean f3= m3.find();
        Pattern p4=Pattern.compile("[^[0-9][a-z][A-Z]]");
        Matcher m4= p4.matcher(p);
        boolean f4= m4.find();
        int l=p.length();
        if (l>8) {
            return 5;
        }
        if (f1 && (fb2==false || fk2==false) && f4==false) {
            return 1;
        }
        if (f1 && fk2 && fb2 && f3==false && f4==false) {
            return 2;
        }
        if (f1 && fk2 && fb2 && f3 && f4==false) {
            return 3;
        }
        if (f4) {
            return 4;
        }
        return 0;
    }
    public byte[] digesting(String b) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return md.digest(b.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("sth went wrong in digesting!");
            e.printStackTrace();
        }
        return new byte[0];
    }
    public String hashmaker(String st) {
        byte[] hash=digesting(st);
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