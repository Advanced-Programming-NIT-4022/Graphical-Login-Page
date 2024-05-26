import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class UserStore {
    public static void addUser(String name, String email, String password) throws IOException {
        try (FileWriter fw = new FileWriter("users.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.println(name + "," + email + "," + password);
        }
    }

    public static boolean validateUser(String usernameOrEmail, String password) throws IOException, NoSuchAlgorithmException {
        boolean isAuthenticated = false;
        String hashedInputPassword = PasswordUtils.hashPassword(password);

        try {
            File file = new File("users.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                if ((userDetails[0].equals(usernameOrEmail) || userDetails[1].equals(usernameOrEmail))
                        && userDetails[2].equals(hashedInputPassword)) {
                    isAuthenticated = true;
                    return true;
                }
            }
            reader.close();
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}