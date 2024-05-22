import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public boolean emailValidator(String _email_)
    {
        Pattern pattern = Pattern.compile("^[^\\.][a-zA-Z0-9]+\\.?[^\\.][\\w]+@[^\\.][a-zA-Z]+\\.[a-z]{3,4}");
        return pattern.matcher(_email_).find();
    } // false : wrong email, true : correct email format

    public String passwordStrengthLevel(String _password_){
        Pattern p1,p2,p3,p4,p5;
        p1 = Pattern.compile("[a-z]"); // lower case
        p2 = Pattern.compile("[A-Z]"); // upper case
        p3 = Pattern.compile("[0-9]"); // numbers
        p4 = Pattern.compile("[@\\-\\._]"); // special character
        p5 = Pattern.compile("[a-zA-Z0-9@\\-\\._]{8,}"); // more than 8 character
        if(p1.matcher(_password_).find() || !p2.matcher(_password_).find() || !p3.matcher(_password_).find()){
            return "easy";
        }
        else if(p2.matcher(_password_).find() || !p1.matcher(_password_).find() || !p3.matcher(_password_).find())
            return "easy";
        else if(p3.matcher(_password_).find() || !p2.matcher(_password_).find() || !p1.matcher(_password_).find())
            return "easy";
        else if(p1.matcher(_password_).find() && p2.matcher(_password_).find())
            return "intermediate";
        else if(p1.matcher(_password_).find() && p2.matcher(_password_).find() && p3.matcher(_password_).find())
            return "medium";
        else if((p1.matcher(_password_).find() || p2.matcher(_password_).find() || p3.matcher(_password_).find())&&p4.matcher(_password_).find())
            return "hard";
        else if(p5.matcher(_password_).find())
            return "most hard";
        else{
            return "Wrong password format, delete space from your password.";
        }
    }

}
