import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class User {
    public  User(String username, String hashpassword, String email1) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("myFile.txt",true));
            writer.write(username + "/");
            writer.write(hashpassword + "/");
            writer.write(email1 + "\n");
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
