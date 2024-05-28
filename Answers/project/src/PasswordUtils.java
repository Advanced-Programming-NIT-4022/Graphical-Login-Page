import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordUtils {

    public static int getPasswordComplexity(String password) {
        int passwordLength =password.length();
        int passwordStrength=0;
        Pattern lowerPattern = Pattern.compile("[a-z]+");
        Matcher lowerMatcher = lowerPattern.matcher(password);
        Pattern upperPattern = Pattern.compile("[A-Z]+");
        Matcher upperMatcher = upperPattern.matcher(password);
        Pattern numberPattern = Pattern.compile("[0-9]+");
        Matcher numberMatcher = numberPattern.matcher(password);
        Pattern specialPattern = Pattern.compile("(@|-|_|.)");
        Matcher specialMatcher = specialPattern.matcher(password);
        if (passwordLength>8) {
            passwordStrength++;
        }
        if (specialMatcher.find()) {
            passwordStrength++;
        }
        if (numberMatcher.find()) {
            passwordStrength++;
        }
        if (upperMatcher.find()) {
            passwordStrength++;
        }
        if (lowerMatcher.find()) {
            passwordStrength++;
        }
        return passwordStrength;
    }
}