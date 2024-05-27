import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWorking {
    public static void copyUserOnFile() {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\MSI\\OneDrive\\Desktop\\Login\\Graphical-Login-Page\\Login\\src\\users.txt");
            for (int i=0 ; i< Users.usersArrayList.size(); i++){
                writer.write((Users.usersArrayList.get(i).gmail+","+(Users.usersArrayList.get(i).password)+"\n"));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("sorry");
            throw new RuntimeException(e);
        }


    }
    public static void  copyFileOnNormalUser() {
        try {
            File normalUsers = new File("C:\\Users\\MSI\\OneDrive\\Desktop\\Login\\Graphical-Login-Page\\Login\\src\\users.txt");
            normalUsers.createNewFile();
            Scanner reader = new Scanner(normalUsers);
            while (reader.hasNextLine()) {
                String[] copy = reader.nextLine().split(",");
                Users normalUser = new Users(copy[0],copy[1]);
                Users.usersArrayList.add(normalUser);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("sorry");
        }
    }
}
