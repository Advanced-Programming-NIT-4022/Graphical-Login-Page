import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserStore {
    private File file;
    private Map<String, User> users;

    public UserStore(String fileName) {
        file = new File(fileName);
        users = new HashMap<>();
        loadUsers();
    }

    public boolean addUser(User user) {
        if (users.containsKey(user.getUsername())) {
            return false;
        }
        users.put(user.getUsername(), user);
        saveUsers();
        return true;
    }

    public boolean authenticateUser(String username, String password) {
        User user = users.get(username);
        if (user == null) {
            return false;
        }
        String hashedPassword = PasswordUtils.hashPassword(password);
        return user.getHashedPassword().equals(hashedPassword);
    }

    private void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    User user = new User(parts[0], parts[1], parts[2]);
                    users.put(user.getUsername(), user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (User user : users.values()) {
                writer.write(user.getUsername() + "," + user.getHashedPassword() + "," + user.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}