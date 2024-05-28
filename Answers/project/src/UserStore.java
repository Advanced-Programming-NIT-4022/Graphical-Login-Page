import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserStore {
    private static final String file = "users.txt";
    private List<User> users;

    public UserStore() {
        users = new ArrayList<>();
        loadUsers();
    }

    private void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    users.add(new User(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean registerUser(String username, String password, String email) {
        if (isUsernameTaken(username)) {
            return false;
        }

        User user = new User(username, password, email);
        users.add(user);
        saveUser(user);
        return true;
    }

    private boolean isUsernameTaken(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean validateLogin(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getHashedPassword().equals(User.hashedPassword(password))) {
                return true;
            }
        }
        return false;
    }

    private void saveUser(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(user.getUsername() + "," + user.getHashedPassword() + "," + user.getEmail());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
