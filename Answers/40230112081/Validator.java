import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public boolean passwordValidator(String _password_){
        Pattern p = Pattern.compile("[^@\\.\\-_A-Za-z0-9]");
        return !p.matcher(_password_).find();
    }
    public boolean emailValidator(String _email_)
    {
        Pattern pattern = Pattern.compile("^[^\\.][a-zA-Z0-9]+\\.?[^\\.][\\w]+@[^\\.][a-zA-Z]+\\.[a-z]{2,4}$");
        return pattern.matcher(_email_).find();
    } // false : wrong email, true : correct email format

    public String passwordStrengthLevel(String _password_){
        Pattern p1 = Pattern.compile("([a-z]+)");
        Pattern p2 = Pattern.compile("([A-Z]+)");
        Pattern p3 = Pattern.compile("([0-9]+)");
        Pattern p4 = Pattern.compile("([@\\.\\-_]+)");
        Pattern p5 = Pattern.compile("[a-zA-Z0-9@\\.\\-_]{9,}");
        boolean lower = false, upper = false, digit = false, special = false, longPass = false;
        if(passwordValidator(_password_))
        {
            if(p1.matcher(_password_).find())
                lower = true;
            if(p2.matcher(_password_).find())
                upper = true;
            if(p3.matcher(_password_).find())
                digit = true;
            if(p4.matcher(_password_).find())
                special = true;
            if(p5.matcher(_password_).find())
                longPass = true;
            if(longPass)
                return "Very hard";
            else{
                if(lower && !upper && !digit && !special)
                    return "easy";
                else if (lower && !upper && !digit && special)
                    return "hard";
                else if(lower && !upper && digit && !special)
                    return "intermediate";
                else if(lower && !upper && digit && special)
                    return "hard";
                else if(lower && upper && !digit && special)
                    return "intermediate";
                else if(lower && !upper && digit && special)
                    return "hard";
                else if(lower && upper && !digit && !special)
                    return "intermediate";
                else if(lower && upper && digit && !special)
                    return "medium";
                else if(lower && upper && digit && special)
                    return "hard";
                else if(!lower && !upper && !digit && special)
                    return "Wrong Format";
                else if(!lower && !upper && digit && !special)
                    return "easy";
                else if(!lower && !upper && digit && special)
                    return "hard";
                else if(!lower && upper && !digit && !special)
                    return "easy";
                else if(!lower && upper && !digit && special)
                    return "hard";
                else if(!lower && upper && digit && !special)
                    return "intermediate";
                else if(!lower && upper && digit && special)
                    return "hard";

            }
        }
        return "Wrong Format";
    }

    public String hashingPassword(String password) {
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Apply the SHA-256 algorithm on the password bytes
            byte[] hashBytes = digest.digest(password.getBytes());

            // Convert the resulting byte array into a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            // Return the hexadecimal string representation of the hash
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            // Handle the exception if the algorithm is not available in the environment
            throw new RuntimeException(e);
        }
    }

}

/*
if(p1.matcher(_password_).find() || !p2.matcher(_password_).find() || !p3.matcher(_password_).find()){
            return "easy";
        }
        else if(p2.matcher(_password_).find() || !p1.matcher(_password_).find() || !p3.matcher(_password_).find())
            return "easy";
        else if(p3.matcher(_password_).find() || !p2.matcher(_password_).find() || !p1.matcher(_password_).find())
            return "easy";
        else if(p1.matcher(_password_).find() && p2.matcher(_password_).find())
            return "intermediate";
        else if(p1.matcher(_password_).find() && p2.matcher(_password_).find() && p3.matcher(_password_).find())
            return "medium";
        else if((p1.matcher(_password_).find() || p2.matcher(_password_).find() || p3.matcher(_password_).find())&&p4.matcher(_password_).find())
            return "hard";
        else if(p5.matcher(_password_).find())
            return "most hard";
        else{
            return "Wrong password format, delete space from your password.";
        }
 */
