package org.example;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class UserStore{


    public UserStore() {

        File file = new File("users.txt");
        try {
            boolean result = file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            FileWriter output = new FileWriter("users.txt");
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}