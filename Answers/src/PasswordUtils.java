import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordUtils {
    public static int getPasswordStrength(char[] password) {
        if (password.length == 0)
            return 0;

        boolean hasLowercase = false,
                hasUppercase = false,
                hasDigit = false,
                hasSpecialCharacter = false;
        Pattern specialCharacter = Pattern.compile("[-@_.]");

        for (char c : password) {
            if (Character.isLowerCase(c))
                hasLowercase = true;
            else if (Character.isUpperCase(c))
                hasUppercase = true;
            else if (Character.isDigit(c))
                hasDigit = true;
            else {
                Matcher matcher = specialCharacter.matcher(Character.toString(c));
                if (matcher.find())
                    hasSpecialCharacter = true;
            }
        } // end foreach

        if (hasLowercase && hasUppercase && hasDigit && hasSpecialCharacter)
            if (password.length > 8)
                return 5;
            else
                return 4;
        else if (hasLowercase && hasUppercase && hasDigit)
            return 3;
        else if (hasLowercase && hasUppercase)
            return 2;
        return 1;
    }
}
