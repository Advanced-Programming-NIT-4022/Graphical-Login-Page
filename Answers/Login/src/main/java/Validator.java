import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    //checking username validation
    public static boolean userNameIsValid(String userName){
        Pattern userNamePattern = Pattern.compile("^[A-Za-z0-9._-]{3,16}$");
        Matcher matcher = userNamePattern.matcher(userName);
        return matcher.find();
    }
    //checking password validation
    public static boolean passwordIsValid(String password){
        Pattern patternLevel1 = Pattern.compile("\\b[a-zA-Z0-9]+\\b");
        Matcher matcher1 = patternLevel1.matcher(password);
        Pattern patternLevel2 = Pattern.compile("\\b(?=.*[a-z])(?=.*[A-Z]).+\\b");
        Matcher matcher2 = patternLevel2.matcher(password);
        Pattern patternLevel3 = Pattern.compile("\\b(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).+\\b");
        Matcher matcher3 = patternLevel3.matcher(password);
        Pattern patternLevel4 = Pattern.compile("\\b[\\w@\\-\\.]+\\b");
        Matcher matcher4 = patternLevel4.matcher(password);
        Pattern patternLevel5 = Pattern.compile("\\b.{9,}\\b");
        Matcher matcher5 = patternLevel5.matcher(password);
        if (matcher1.find()){
            return false;
        } else if (matcher2.find()){
            return false;
        } else if (matcher3.find()){
            return true;
        } else if (matcher4.find()){
            return true;
        } else if (matcher5.find()){
            return true;
        } else {
            return false;
        }
    }
    //checking email validation
    public static boolean emailIsValid(String email){
    Pattern emailPattern = Pattern.compile("\\b(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,4})\\b");
    Matcher matcher = emailPattern.matcher(email);
    return matcher.find();
    }
}
