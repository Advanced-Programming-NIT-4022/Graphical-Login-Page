import java.util.regex.Pattern;

public class UsernameValid {
    public int usernamevalid(String password){
        int valid=0;
        if(Pattern.matches("[a-zA-Z]{2,}",password)){
            valid =1 ;
            return valid;
        }
        return valid ;
    }
}
