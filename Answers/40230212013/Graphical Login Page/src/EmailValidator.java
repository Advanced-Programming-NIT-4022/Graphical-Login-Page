import java.util.regex.Pattern;

public class EmailValidator {
  private static final Pattern emailpat = Pattern.compile("[^A-Za-z0-9.-]+@[A-Za-z0-9.-]+$");
  public static boolean isValid(String email)
  {
    return emailpat.matcher(email).matches();
  }
}
