import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Scanner;

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

    public static void toFile() {
        File file = new File("UsersData.txt");
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            for (User user : myUsers) {
                String userData = user.user + "," + user.email + "," + user.password + "\n";
                fileWriter.write(userData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(){
        File f = new File("C:\\Users\\yekta\\OneDrive\\Desktop\\uni\\swingExe\\UsersData.txt");
        try {
            Scanner reader = new Scanner(f);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] dataSplit =data.split(",");
                myUsers.add(new User(dataSplit[0],dataSplit[1],dataSplit[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
