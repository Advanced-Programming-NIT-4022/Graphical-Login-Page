package org.example;
import java.io.*;
import java.util.ArrayList;

public class FileHandler{
    ArrayList<User> userInfo = new ArrayList<>();

    FileHandler(ArrayList userInfo) {
        this.userInfo = userInfo;
    }

    void filemaker(){

            try {
                File file = new File("FILE.txt");

                if (!file.exists()) {
                    file.createNewFile();
                }
            }
                catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



    void filewriter(){
        try {
            FileWriter writer = new FileWriter("FILE.txt", true);

            for (User user : userInfo) {
                writer.write("username:"+ user.getUserName() + "\n");

                writer.write("password:"+new PasswordUtils().passhash(user.getPassword()) + "\n");

                writer.write("email:" +user.getEmail() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ArrayList fileupdater() {
        try {
            RandomAccessFile reader = new RandomAccessFile("FILE.txt", "r");
            String username, password, email;

            for(int i = 0; i == (int) reader.length(); i += reader.readLine().length()) {

                    username = reader.readLine().replace("username:", "") ;
                    reader.seek(reader.readLine().length() + 00001010);

                    password = reader.readLine().replace("password:", "");
                    reader.seek(reader.readLine().length() + 00001010);

                    email = reader.readLine().replace("email:", "");
                    reader.seek(reader.readLine().length() + 00001010);

                User user = new User(username, password, email);
                userInfo.add(user);

            }



            reader.close();
        } catch (Exception ignored) {
        }

        return this.userInfo;
    }
}
