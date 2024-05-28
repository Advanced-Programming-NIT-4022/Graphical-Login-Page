import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

public class UserStore {
    public static String hashingPass (String pass) throws Exception {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(pass.getBytes());

        BigInteger number = new BigInteger(1, hash);
        String hashText = number.toString(16);

        while (hashText.length() < 32) {
            hashText = "0" + hashText;
        }

        return hashText;
    }
    static ArrayList <User> myUsers = new ArrayList<User>();
    public void addMyUser(String name , String email , String password) throws Exception {
        User myUser = new User(name,email,hashingPass(password));
        myUsers.add(myUser);
    }

    public static void toFile(){
        for (User charkhande : myUsers){
            String userData = charkhande.user+","+charkhande.email+","+charkhande.password;
            File F = new File("UsersData.txt");
            try {
                FileWriter Fwriter = new FileWriter("UsersData.txt");
                Fwriter.write(userData);
                Fwriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
