import java.io.*;
import java.util.ArrayList;

public class UserStore {

    static ArrayList<User> users = new ArrayList<>();

    public static boolean check(String username){
        try (BufferedReader reader = new BufferedReader(new FileReader("user.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] i = line.split(",");
                if (i.length == 3) {
                    User user = new User(i[0], i[1], i[2]);
                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(User user : users){
            if(user.getusername().equals(username)){
                return false;
            }
        }
        return true;
    }

    public static boolean registerUser(String username, String password , String email){
        User newUser = new User(username, password, email);
        users.add(newUser);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user.txt"))) {
            for (User user : users) {
                writer.write(user.getusername() + "," + user.getPassword() + "," + user.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public static String loginUser(String username , String password){
        String hashedpassword = PasswordUtils.hashingPassword(password);

        try (BufferedReader reader = new BufferedReader(new FileReader("user.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] i = line.split(",");
                if (i.length == 3) {
                    User user = new User(i[0], i[1], i[2]);
                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(User user : users){
            if(user.getusername().equals(username)){
                if(user.getPassword().equals(hashedpassword)){
                    return null;
                }
                return "wrong password";
            }
        }
        return "username not found";

    }
}
