package org.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        createFile();
        new ChoicePage();
    }

    public static void createFile(){
        File folder = new File("info");
        try {
            if(folder.mkdir()){
                File userID = new File("info\\UserID.txt");
                boolean a = userID.createNewFile();

                File userPass = new File("info\\UserPass.txt");
                a = userPass.createNewFile();

                File userEmail = new File("info\\UserEmail.txt");
                a = userEmail.createNewFile();
            }
        }catch (IOException e){
            System.out.println("Error");
        }
    }

}