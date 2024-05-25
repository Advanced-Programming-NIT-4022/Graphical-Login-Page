import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UserStore {
    private static final String USERS_FILE = "users.txt";
    private List<User> userList;

    // متد برای ذخیره کردن کاربران در فایل
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
    public int findUser(String login, String password) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).enter(login, password)) {
                return i;
            }
        }
        return -1;
    }
}