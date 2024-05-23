import java.util.regex.Pattern;

public class EmailValidator
{
    public int validate(String email)
    {
        int t=0;
        if(Pattern.matches("", email))
        {
            t=1;
        }
        else
        {
            t=0;
        }
        return t;
    }
}
