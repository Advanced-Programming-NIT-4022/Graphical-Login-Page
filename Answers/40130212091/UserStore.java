import java.util.ArrayList;

public class UserStore {

    static ArrayList<User> users = new ArrayList<>();

    public static boolean registerUser(String username, String password , String email){
        for(User user : users){
            if(user.getusername().equals(username)){
                return false;
            }
        }
        User newUser = new User(username, password, email);
        users.add(newUser);
        return true;
    }

    public static String loginUser(String username , String password){
        for(User user : users){
            if(user.getusername().equals(username)){
                if(user.getPassword().equals(password)){
                    return null;
                }
                return "wrong password";
            }
        }
        return "username does not exist";
    }
}
