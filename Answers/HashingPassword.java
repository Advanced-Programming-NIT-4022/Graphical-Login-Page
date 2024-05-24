package Answers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingPassword
{
    public String hashingPassword(String password)
    {
        StringBuilder hexString = null;
        try
        {
            // ایجاد یک شیء از MessageDigest با الگوریتم SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // تبدیل رمز عبور به آرایه بایت
            byte[] hash = digest.digest(password.getBytes());

            // تبدیل آرایه بایت به رشته هگزادسیمالی
            hexString = new StringBuilder();

            for (byte b : hash)
            {
                String hex = Integer.toHexString(0xff & b);

                if (hex.length() == 1) hexString.append('0');

                hexString.append(hex);
            }

        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return hexString.toString();
    }
}

