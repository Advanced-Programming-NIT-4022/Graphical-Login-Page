import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class User {
    public static void saveUserInfo(String username, String password , String email) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("project.txt",true));
            writer.write("Username: " + username + "\n");
            writer.write("Password: " + password + "\n");
            writer.write("Email: " + email + "\n");
            writer.close();
            BufferedWriter writer1 = new BufferedWriter(new FileWriter("login.txt",true));
            writer1.write(username + " ");
            writer1.write(password + "\n");
            writer1.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
