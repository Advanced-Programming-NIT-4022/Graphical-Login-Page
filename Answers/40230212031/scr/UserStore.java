import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserStore {
    private static final String USERS_FILE = "users.txt";
    private List<User> userList;

    public UserStore() {
        userList = new ArrayList<>();
        loadUsers();
    }

    private void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 3) {
                    userList.add(new User(userData[0], userData[1], userData[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE))) {
            for (User user : userList) {
                writer.write(user.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        userList.add(user);
        saveUsers();
    }

    public int findUser(String login, String password) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).enter(login, password)) {
                return i;
            }
        }
        return -1;
    }
}
