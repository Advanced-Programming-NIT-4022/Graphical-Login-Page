import com.sun.jdi.request.DuplicateRequestException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class UserHandler {
    private final String filename;
    private HashMap<String, User> users = new HashMap<>();

    UserHandler(String filename) throws IOException {
        this.filename = filename;
        readUsersFromFile();
    }

    void readUsersFromFile() throws IOException {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            String nextLine;
            HashMap<String, User> result = new HashMap<>();
            User newUser;
            while (scanner.hasNextLine()) {
                nextLine = scanner.nextLine();
                String[] nextLineSplit = nextLine.split(",");
                if (nextLineSplit.length == 3 && (newUser = User.getValidatedUser(nextLineSplit[0], nextLineSplit[1], nextLineSplit[2])) != null && !result.containsKey(nextLineSplit[0])) {
                    result.put(newUser.username, newUser);
                }
            }
            users = result;
        } catch (FileNotFoundException e) {
            file.createNewFile();
        }
    }

    void addUser(User newUser) throws IOException {
        if (users.containsKey(newUser.username)) throw new DuplicateRequestException();
        users.put(newUser.username, newUser);
        File createFile = new File(filename);
        createFile.createNewFile();

        try (FileWriter file = new FileWriter(filename, true)) {
            file.write(newUser.toString() + '\n');
        }
    }

    User getUser(String username) {
        return users.get(username);
    }
}
