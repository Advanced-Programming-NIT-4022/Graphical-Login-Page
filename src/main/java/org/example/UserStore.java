package org.example;
import java.io.File;
import java.io.IOException;

class UserStore{
    public UserStore() {

        File file = new File("users.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}