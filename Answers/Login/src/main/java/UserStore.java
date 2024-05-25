import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class UserStore {
    private final List<User> users = new ArrayList<>();
    private static final String User_File_Name = "users.txt";

    public void addUser(String userName,String password,String email){
        users.add(new User(userName,password,email));
        writeUser();
    }
    private void writeUser(){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(User_File_Name,true))){
        try {
            bufferedWriter.write(users.getLast().getUserName() + ",");
            bufferedWriter.write(hashPassword(users.getLast().getPassword()) + ",");
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
        try {
            password = hashPassword(password);
        } catch (NoSuchAlgorithmException ae){
            ae.getMessage();
        }
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

    //method for hashing password
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        StringBuilder hexString = new StringBuilder();
        for (byte b : digest) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
