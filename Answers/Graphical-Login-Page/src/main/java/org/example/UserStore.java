package org.example;

import java.io.*;
import java.util.*;

public class UserStore {
    private ArrayList<String> user = new ArrayList<>();
    public ArrayList<String> getUser() {
        return user;
    }
    public void setUser(ArrayList<String> user) {
        this.user = user;
    }
    public void ReadFile() {
    ArrayList<String> test = new ArrayList<>();
    try {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("users.txt"));
        String temp;
        while ((temp = bufferedReader.readLine()) != null )
        {
            test.add(temp);
        }
        bufferedReader.close();
    } catch (IOException e) {
        System.out.println("F@CK");
    }
    setUser(test);
    }
    public void WriteFile() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("users.txt"));
            for (String temp : getUser())
            {
                bufferedWriter.write(temp);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException r) {
            System.out.println("F$CK");
        }
    }
}
