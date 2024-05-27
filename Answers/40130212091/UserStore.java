import java.util.ArrayList;

public class UserStore {

    ArrayList<User> users = new ArrayList<>();

    public boolean registerUser(String username, String password , String email){
        for(User user : users){
            if(user.getusername().equals(username)){
                return false;
            }
        }
        User newUser = new User(username, password, email);
        users.add(newUser);
        return true;
    }

    public boolean loginUser(String username , String password){
        for(User user : users){
            if(user.getusername().equals(username)){
                if(user.getPassword().equals(password)){
                    return true;
                }
                System.out.println("wrong password");
                break;
            }
        }
        return false;
    }
}
