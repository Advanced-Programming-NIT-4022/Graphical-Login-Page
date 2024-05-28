import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserStore {
    private static final String FILE_PATH = "users.txt";
    private static Map<String, User> users = new HashMap<>();

    static {
        loadUsers();
    }

    private static void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    users.put(parts[0], new User(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean addUser(User user) {
        if (users.containsKey(user.getUsername())) {
            return false;
        }
        users.put(user.getUsername(), user);
        saveUsers();
        return true;
    }

    private static void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User user : users.values()) {
                writer.write(String.format("%s,%s,%s%n", user.getUsername(), user.getHashedPassword(), user.getEmail()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean authenticateUser(String username, String hashedPassword) {
        User user = users.get(username);
        return user != null && user.getHashedPassword().equals(hashedPassword);
    }
}
