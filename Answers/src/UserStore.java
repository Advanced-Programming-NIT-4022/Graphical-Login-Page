import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class UserStore {
    private static final Path PATH = Paths.get(".users.txt");

    public static void saveUser(User user) {
        try (Formatter output = new Formatter(new FileWriter(PATH.toString(),true))) {
            output.format("%s,%s,%s%n", user.username(), user.hashedPassword(),
                    user.email());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(Main.login, "Error opening file. Terminating.",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1); // terminate the program
        } catch (FormatterClosedException formatterClosedException) {
            JOptionPane.showMessageDialog(Main.login, "Error writing to file. Terminating.",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1); // terminate the program
        }
    }

    public static User retrieveUser(String username) {
        try (Scanner input = new Scanner(PATH.toAbsolutePath())) {
            while (input.hasNext()) {
                // split inputs with comma
                String[] temp = input.nextLine().split(",");

                if (temp[0].equals(username)) {
                    return new User(temp[0], temp[1], temp[2]);
                }
            }
        } catch (NoSuchElementException elementException) {
            JOptionPane.showMessageDialog(Main.login,
                    "Application file was destroyed. Terminating...", "ERROR",
                    JOptionPane.ERROR_MESSAGE);

            System.exit(1); // terminate the program
        } catch (IOException e) {
            JOptionPane.showMessageDialog(Main.login, "Error opening file. Terminating.",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1); // terminate the program
        }

        return null;
    }

    public static boolean isAcceptedUsername(String username) {
        return retrieveUser(username) == null;
    }

    public static boolean isAcceptedEmail(String email) {
        try (Scanner input = new Scanner(PATH)){
            while (input.hasNext()) {
                // split inputs with comma
                String[] temp = input.nextLine().split(",");

                if (temp[2].equals(email)) {
                    return false;
                }
            }
        } catch (NoSuchElementException | IndexOutOfBoundsException elementException) {
            JOptionPane.showMessageDialog(Main.login,
                    "Application file was destroyed. Terminating...", "ERROR",
                    JOptionPane.ERROR_MESSAGE);

            System.exit(1); // terminate the program
        } catch (IOException e) {
            JOptionPane.showMessageDialog(Main.login, "Error opening file. Terminating.",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1); // terminate the program
        }
        return true;
    }

    static void createFile() {
        try {
            if (!Files.exists(PATH))
                Files.createFile(PATH);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(Main.login, "Unable to create file!",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1); // terminate the program
        }
    }
}
