import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public static boolean emailIsValid(String email){
    Pattern emailPattern = Pattern.compile("\\b(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,4})\\b");
    Matcher matcher = emailPattern.matcher(email);
    return matcher.find();
    }
}
