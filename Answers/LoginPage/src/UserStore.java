import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserStore {
    private static final String USER_FILE = "users.dat";

    private static Map<String, User> userDatabase;

    static {
        userDatabase = loadUsers();
    }

    private static Map<String, User> loadUsers() {
        Map<String, User> users = new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_FILE))) {
            users = (Map<String, User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {

        }
        return users;
    }

    private static void storeUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_FILE))) {
            oos.writeObject(userDatabase);
        } catch (IOException e) {
        }
    }

    public static boolean addUser(User user) {
        if (!userDatabase.containsKey(user.getUsername())) {
            userDatabase.put(user.getUsername(), user);
            storeUsers();
            return true;
        }
        return false;
    }

    public static User getUser(String username) {
        return userDatabase.get(username);
    }
}