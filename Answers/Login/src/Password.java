import java.util.regex.Pattern;

public class Password {
    public static boolean  checkPass(int userID, String userPass){
        if(Users.usersArrayList.get(userID).password.equals(userPass)) {
            return true;
        }
        return false;
    }
    public static boolean checkPassPower(String password){
        if(Pattern.matches(".*[a-z]+.*", password)){
            if(Pattern.matches(".*[A-Z]+.*", password)){
                if(Pattern.matches(".*[0-9]+.*", password)){
                    if(Pattern.matches(".*[@|.|_]+.*", password)){
                        if(password.length() >= 8){
                            return (true);
                        }
                        else{
                            return(false);
                        }
                    }
                    else{
                        return (false);
                    }
                }
                else{
                    return (false);
                }
            }
            else{
                return (false);
            }
        }
        else{
            return (false);
        }
    }
}
