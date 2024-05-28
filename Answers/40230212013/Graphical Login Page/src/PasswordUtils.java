import java.util.regex.Pattern;

public class PasswordUtils {
  private static final Pattern specialChar = Pattern.compile("[@\\-_.]");
  private static final Pattern Lowercase = Pattern.compile("[a-z]");
  private static final Pattern Uppercase = Pattern.compile("[A-Z]");
  private static final Pattern Digit = Pattern.compile("\\d");
  public static int isStrong(String password)
  {
    int strength = 0;
    if(password.length()<= 8)
    {
      strength++;
    }
    boolean lower = Lowercase.matcher(password).find();
    boolean upper = Uppercase.matcher(password).find();
    boolean digit = Digit.matcher(password).find();
    boolean special = specialChar.matcher(password).find();
    if(lower || upper || digit)
    {
      strength++;
    }
    if(lower && upper)
    {
      strength++;
    }
    if(lower && upper && digit)
    {
      strength++;
    }
    if(special)
  {
    strength++;
  }
  return strength;
  }
}
