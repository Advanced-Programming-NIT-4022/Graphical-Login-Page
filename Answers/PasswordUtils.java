import java.util.regex.Pattern;

public class PasswordUtils
{

    public String SHA_256(String password)
    {
        return password;
    }

    public int checkpassword(String password)
    {
        int t=0;
        boolean a=Pattern.matches("([A-Z]{1,})?([a-z]{1,})?([0-9]{1,})?", password);
        boolean b=Pattern.matches(".*([a-z]{1,}.*)([A-Z]{1,}.*)", password);
        boolean b1=Pattern.matches("^(([a-z]{1,})([0-9]{1,}))?((.*[A-Z]{1,})([0-9]{1,}))?", password);
        boolean c=Pattern.matches(".*(.*[a-z]{1,})*(.*[A-Z]{1,})*(.*[0-9]{1,})", password);
        boolean d=Pattern.matches("^([a-z]{1,})([A-Z]{1,})([0-9]{1,})([@-_]{1,})", password);

        if(d&&(password.length()>=8))
        {
            t=5;
        }
        else if (d)
        {
            t=4;
        }
        else if(c)
        {
            t=3;
        }
        else if(b||b1)
        {
            t=2;
        }
        else if(a)
        {
            t=1;
        }
        return t;
    }
}
