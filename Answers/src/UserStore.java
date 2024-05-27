import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class UserStore {
    private static final String PATH = ".users.txt";

    public static void saveUser(User user) {
        try (Formatter output = new Formatter(PATH)) {
            output.format("%s,%s,%s", user.getUsername(), user.getHashedPassword(),
                    user.getEmail());
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1); // terminate the program
        } catch (FormatterClosedException formatterClosedException) {
            System.err.println("Error writing to file. Terminating.");
            System.exit(1); // terminate the program
        }
    }

    public static User retrieveUser(String username) {
        try (Scanner input = new Scanner(PATH)){
            while (input.hasNext()) {
                // split inputs with comma
                String[] temp = input.nextLine().split(",");

                if (temp[0].equals(username)) {
                    return new User(temp[0], temp[1], temp[2]);
                }
            }
        } catch (NoSuchElementException elementException) {
            System.err.println("Application file was destroyed. Terminating...");
            System.exit(1); // terminate the program
        }

        return null;
    }

    private static boolean isAcceptedUsername(String username) {
        return retrieveUser(username) != null;
    }
}
