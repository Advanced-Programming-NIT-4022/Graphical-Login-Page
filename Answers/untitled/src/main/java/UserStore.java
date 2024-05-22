import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserStore {
    private static final String FILE_NAME = "users.txt";

    public boolean registerUser(String username, String password, String email) {
        List<User> users = loadUsers();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        User newUser = new User(username, password, email);
        users.add(newUser);
        saveUsers(users);
        return true;
    }

    public boolean verifyLogin(String username, String password) {
        List<User> users = loadUsers();
        String hashedPassword = PasswordUtils.hashPassword(password);
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getHashedPassword().equals(hashedPassword)) {
                return true;
            }
        }
        return false;
    }

    private List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    users.add(new User(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    private void saveUsers(List<User> users) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (User user : users) {
                bw.write(user.getUsername() + "," + user.getHashedPassword() + "," + user.getEmail());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
