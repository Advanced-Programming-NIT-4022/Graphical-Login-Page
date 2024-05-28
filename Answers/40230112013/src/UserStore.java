import java.io.*;
import java.security.NoSuchAlgorithmException;

public class UserStore {
    public static void addUser(String name, String email, String password) throws IOException {
        try (FileWriter fw = new FileWriter("users.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.println(name + "," + email + "," + password);
        }
    }

    public static boolean validateUser(String usernameOrEmail, String password) throws IOException, NoSuchAlgorithmException {
        String hashedInputPassword = PasswordUtils.hashPassword(password);

        try {
            File file = new File("users.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                if ((userDetails[0].equals(usernameOrEmail) || userDetails[1].equals(usernameOrEmail))
                        && userDetails[2].equals(hashedInputPassword)) {
                    return true;
                }
            }
            reader.close();
            return false;
        } catch (Exception e) {
            return false;
        }
        
    }

    public static boolean isUsernameUnique(String username) throws IOException {
        File file = new File("users.txt");
        if (!file.exists()) {
            return true; // No users registered yet
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] userDetails = line.split(",");
            if (userDetails[0].equals(username)) {
                reader.close();
                return false; // Username already exists
            }
        }
        reader.close();
        return true; // Username is unique
    }

}