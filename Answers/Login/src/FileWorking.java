import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWorking {
    public static void copyUserOnFile() {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\MSI\\OneDrive\\Desktop\\swing\\Graphical-Login-Page\\Answers\\Login\\src\\users.txt");
            for (int i=0 ; i< Users.usersArrayList.size(); i++){
                writer.write((Users.usersArrayList.get(i).gmail+","+(Users.usersArrayList.get(i).password)+"\n"));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("sorry");
            throw new RuntimeException(e);
        }


    }
    public static void  copyFileOnUser() {
        try {
            File ser = new File("C:\\Users\\MSI\\OneDrive\\Desktop\\swing\\Graphical-Login-Page\\Answers\\Login\\src\\users.txt");
            ser.createNewFile();
            Scanner reader = new Scanner(ser);
            while (reader.hasNextLine()) {
                String[] copy = reader.nextLine().split(",");
                Users user = new Users(copy[0],copy[1]);
                Users.usersArrayList.add(user);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("sorry");
        }
    }
}
