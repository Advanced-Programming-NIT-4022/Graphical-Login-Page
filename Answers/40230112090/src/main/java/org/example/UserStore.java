package org.example;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class UserStore {
    public String status;

    public UserStore(String username, String password) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("store.txt"));
            String line = reader.readLine();

            while (line != null) {
                int i = 0;
                String[] word;
                word = line.split("  ");
                while (i < word.length) {
                    arrayList.add(word[i]);
                    i++;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        String condition = "false";
        for (int i = 0; i < arrayList.toArray().length; i++) {
            if (username.equals(arrayList.get(i)) && password.equals(arrayList.get(i + 1))) {
                JOptionPane.showMessageDialog(null, "You have successfully logged in");
                condition = "true";
                this.status = "true";
                break;
            }
        }
        if (condition.equals("false")) {
            JOptionPane.showMessageDialog(null, "A user whit this profile has not registered");
        }
    }

    public String getStatus() {
        return this.status;
    }

    public UserStore(String username, String password, String email) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("store.txt"));
            String line = reader.readLine();
            while (line != null) {
                int i = 0;
                String[] word;
                word = line.split("  ");
                while (i < word.length) {
                    arrayList.add(word[i]);
                    i++;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String condition = "true";
        for (int i = 0; i < arrayList.toArray().length; i++) {
            if (username.equals(arrayList.get(i)) && password.equals(arrayList.get(i + 1)) && email.equals(arrayList.get(i + 2))) {
                JOptionPane.showMessageDialog(null, "A user has already registered with your profile", null, JOptionPane.ERROR_MESSAGE);
                condition = "false";
                break;
            }
        }
        if (condition.equals("true")) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("store.txt"));
                writer.write(username + "  " + password + "  " + email);
                writer.newLine();
                writer.close();
                JOptionPane.showMessageDialog(null , "You registration was successful");
                this.status = "true" ;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
