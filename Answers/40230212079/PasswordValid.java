import java.util.regex.*;
public class PasswordValid {
    public int passwordvalid(String password){
        boolean lowercase= false, uppercase = false, number = false, sign = false;
        int valid=0;
        Pattern plowercase = Pattern.compile("[a-z]{1,}");
        Pattern puppercase = Pattern.compile("[A-Z]{1,}");
        Pattern pnumber = Pattern.compile("[0-9]{1,}");
        Pattern psign = Pattern.compile("[//_@-]{1,}");
        Pattern plevel5 = Pattern.compile("([a-zA-Z0-9]){9,}");
        if(plowercase.matcher(password).find()){
            lowercase=true;
        }
        else if (puppercase.matcher(password).find()){
            uppercase=true;
        }
        else if (pnumber.matcher(password).find()){
            number=true;
        }
        else if (psign.matcher(password).find()){
            sign=true;
        }
        else if (plevel5.matcher(password).find()){
            return valid=5;
        }
        if (lowercase && uppercase && number){
            return valid=3;
        }
        else if (lowercase && uppercase && number && sign){
            return valid=4;
        }
        return valid ;
    }
}
