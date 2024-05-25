import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class UserStore {
    private final List<User> users = new ArrayList<>();
    private static final String User_File_Name = "users.txt";
    Password password = new Password();
    private void writeUser(){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(User_File_Name,true))){
        try {
            bufferedWriter.write(users.getLast().getUserName() + ",");
            bufferedWriter.write(password.hashPassword(users.getLast().getPassword()) + ",");
            bufferedWriter.write(users.getLast().getEmail() + "\n");
            System.out.println("User added successfully.");
        } catch (NoSuchAlgorithmException ae){
            System.out.println("Error while hashing the password: " + ae.getMessage());
        }
        } catch (IOException e){
            System.out.println("Error saving user!");
            e.getMessage();
        }
    }

    public boolean checkUser(String userName,String password){
        File file = new File(User_File_Name);
        boolean found = false;
        if (file.exists()){
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(User_File_Name))){
                String line = bufferedReader.readLine();
                while (line != null){
                    if (line.contains(userName + "," + password)){
                        found = true;
                        break;
                    }
                    line = bufferedReader.readLine();
                }
            } catch (IOException e) {
                System.out.println("Error checking user!");
                e.getMessage();
            }
        }
        return found;
    }

}
