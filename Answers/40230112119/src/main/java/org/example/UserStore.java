package org.example;

import java.io.*;

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
    public static boolean readingInfo(String id, String hashed) {
        try {
            FileReader reader = new FileReader("UserInfo.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String line;
            while ((line = buffer.readLine()) != null) {
                String[] info = line.split(",");
                String savedId = info[0];
                String savedHashed = info[1];

                if(id.equalsIgnoreCase(savedId)) {
                    if(hashed.equals(savedHashed)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean readingEmails(String email) {
        try {
            FileReader reader = new FileReader("UserInfo.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String line;
            while ((line = buffer.readLine()) != null) {
                String[] info = line.split(",");
                String savedEmail = info[2];

                if(email.equalsIgnoreCase(savedEmail)) {
                    return true;
                }
            }
            return false;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
