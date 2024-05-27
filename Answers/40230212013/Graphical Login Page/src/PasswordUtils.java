import java.util.regex.Pattern;

public class PasswordUtils {
  private static final Pattern specialChar = Pattern.compile("[@\\-_.]");
  private static final Pattern Lowercase = Pattern.compile("[a-z]");
  private static final Pattern Uppercase = Pattern.compile("[A-Z]");
  private static final Pattern Digit = Pattern.compile("\\d");
  public static boolean isString(String password)
  {
    if(password.length()<= 8)
    {
      return false;
    }
    boolean lower = Lowercase.matcher(password).find();
    boolean upper = Uppercase.matcher(password).find();
    boolean digit = Digit.matcher(password).find();
    boolean special = specialChar.matcher(password).find();
    return lower && upper && digit && special;
  }
}
