import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public boolean emailValidator(String _email_)
    {
        Pattern pattern = Pattern.compile("^[^\\.][a-zA-Z0-9]+\\.?[^\\.][\\w]+@[^\\.][a-zA-Z]+\\.[a-z]{3,4}");
        return pattern.matcher(_email_).find();
    } // false : wrong email, true : correct email format



}
