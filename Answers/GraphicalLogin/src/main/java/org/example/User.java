package org.example;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class User {
    ArrayList<String> userList = new ArrayList<>();

    public void registrate(String username , String password ,String email){
        userList.clear();
        try {
            BufferedReader userReader = new BufferedReader(new FileReader("users.txt"));
            String input;
            while ((input = userReader.readLine()) != null) {
                userList.add(input);
            }
            userReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            BufferedWriter userWriter = new BufferedWriter(new FileWriter("users.txt"));

            String hashedPassword;
            hashedPassword = DigestUtils.sha256Hex(password);
            userList.add(username + " " + hashedPassword + " " + email);
            for (String temp : userList)
            {
                userWriter.write(temp);
                userWriter.newLine();
            }
            userWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean userSearch(String username , String password) {
        userList.clear();
        boolean flag = false;
        String hashedPassword = DigestUtils.sha256Hex(password);
        try {
            BufferedReader userReader = new BufferedReader(new FileReader("users.txt"));
            String input;
            while ((input = userReader.readLine()) != null) {
                userList.add(input);
            }
            userReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < userList.size(); i++) {
            String[] list = userList.get(i).split(" ");
            if (Objects.equals(hashedPassword, list[1]) && Objects.equals(username, list[0])) {
                flag = true;
            }
        }
        return flag;
    }

}
