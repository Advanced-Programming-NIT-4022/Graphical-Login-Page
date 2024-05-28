
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmailValidator {

    //Contains method for validating email addresses using regex

    // Method to validate email address
    public static boolean EmailValid(String email) {
        Pattern EmailRegex = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        //I Chose the simplest Regex for Email Pattern . It could have been Longer and more Precise
        if (email == null || email.isEmpty()) {
            return false;
        }
        Matcher matcher = EmailRegex.matcher(email);
        if(matcher.find()){
            return true;
        }
        else{
            return false;
        }
    }
}