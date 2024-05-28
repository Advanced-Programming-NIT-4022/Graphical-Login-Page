import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserStore {
    //Handles storing and retrieving user data from files

    // Method to save user data to the file

    // Method to retrieve user data from the file

    public static void saveUser(User user) {
        try (FileWriter writer = new FileWriter("DataStorage.txt", true)) {
            String userData = user.getUserName() + "," + user.getPassword() + "," + user.getEmail() + "\n";
            writer.write(userData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Method to retrieve user data from the file
    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("DataStorage.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 3) {
                    if (isHashedPassword(userData[1])) {
                        users.add(new User(userData[0], userData[1], userData[2], true)); // Use the hashed password directly
                    } else {
                        users.add(new User(userData[0], userData[1], userData[2])); // Hash the password
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Helper method to check if a password is hashed
    private static boolean isHashedPassword(String password) {
        // Very basic check for hashed password (assuming hexadecimal characters)
        return password.matches("[0-9a-fA-F]+");
    }

    // Method to check if a username already exists in the file
    public static boolean isUsernameTaken(String username) {
        List<User> users = getUsers();
        for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    // Method to check if an email is already registered
    public static boolean isEmailRegistered(String email) {
        List<User> users = getUsers();
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public static boolean authenticate(String username, String password) {
        List<User> users = UserStore.getUsers();
        String enteredHashedPassword = PasswordUtils.hashPassword(password); // Hash the entered password
        for (User user : users) {
            if (user.getUserName().equals(username) && user.getPassword().equals(enteredHashedPassword)) {
                return true;
            }
        }
        return false;
    }
}
