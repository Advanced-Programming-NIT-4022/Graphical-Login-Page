import java.util.ArrayList;
import java.util.regex.Pattern;

public class Users {
    String password,gmail;
    public Users ( String uGmail, String pass ){
        password=pass;
        gmail=uGmail;
    }
    static ArrayList<Users> usersArrayList =new ArrayList<>();
    public static int checkUsers(String gamil){
        int i;
        if(usersArrayList.size()==0){
            return -1;
        }
        for( i=0; i<usersArrayList.size();i++){
            if(gamil.equals(usersArrayList.get(i).gmail)){
                return i;
            }
        }
        return -1;
    }
    public static boolean checkGmailFormat(String gmail){
        return (Pattern.matches("^[^0-9][[0-9]|[a-z]|[A-Z]].*@gmail.com$",gmail));
    }



}
