import java.security.NoSuchAlgorithmException;

public class Signin {                      //ثبت نام
    public static int signin(String gmail,String pass ){
        if(!((Users.checkUsers(gmail))==-1)){
            // we have this gmail
            return -1;
        }
        if((Users.checkGmailFormat(gmail))&&(Password.checkPassPower(pass))){
            Users users = null;
            try {
                users = new Users(gmail,GFG2.toHexString(GFG2.getSHA(pass)));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
            Users.usersArrayList.add(users);
        return 0;
    }
        return -1;
    }

}
