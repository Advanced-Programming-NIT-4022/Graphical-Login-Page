package BackEnd;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    ArrayList<User> users = new ArrayList<>();

    public FileHandler(ArrayList<User> users) {
        this.users = users;
    }

    // this method check files existence and if files does not exist, creates files :
    public void checkFilesExistence() {
        File userRepo = new File("UserRepo.txt");
        try {
            boolean create = userRepo.createNewFile();
        } catch (Exception ignored) {
        }
    }

    // this method save the users arrayList to the file :
    public void saveChangesToFile() {
        try {
            FileWriter fw = new FileWriter("UserRepo.txt");
            for (User user : users) {
                fw.write(user.getUserName());
                fw.write("\n");
                fw.write(user.getHashedPassword());
                fw.write("\n");
                fw.write(user.getEmail());
                fw.write("\n");
            }
            fw.close();
        } catch (Exception ignored) {
        }
    }

    // this method read users information from file and add them to the users arraylist :
    public ArrayList<User> updateUserArrayListFromFile() {
        try {
            FileReader fr = new FileReader("UserRepo.txt");
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                User user = new User(sc.nextLine(), sc.nextLine(), sc.nextLine());
                users.add(user);
            }
            fr.close();
        } catch (Exception ignored) {
        }
        return this.users;
    }
}
