package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UserStore {
    public static void writingInfo(String id, String email, String hashed) {
        try {
            FileWriter writer = new FileWriter("UserInfo.txt", true);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(id + "," + hashed + "," + email);
            buffer.newLine();
            buffer.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
