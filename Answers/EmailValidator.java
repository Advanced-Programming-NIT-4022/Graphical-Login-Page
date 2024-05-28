package Answers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator
{
    public boolean isEmailValid(String email)
    {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        boolean matchFound = matcher.find();
        if (matchFound)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
