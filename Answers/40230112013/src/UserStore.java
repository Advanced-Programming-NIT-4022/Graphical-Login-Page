import java.io.*;
import java.util.*;

public class UserStore {
    public static void addUser(String name, String email, String password) throws IOException {
        try (FileWriter fw = new FileWriter("users.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(name + "," + email + "," + password);
        }
    }

    public static boolean validateUser(String usernameOrEmail, String password) throws IOException {
        try (Scanner scanner = new Scanner("users.txt")) {
            while (scanner.hasNextLine()) {
                String[] userData = scanner.nextLine().split(",");
                if ((userData[0].equals(usernameOrEmail) || userData[1].equals(usernameOrEmail)) && userData[2].equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}
