package org.example;

import java.io.File;
import java.io.IOException;


public class Main {


    public static void main(String[] args) {

        File userNameFile = new File("info\\UserName.txt");
        File emailFile = new File("info\\email.txt");
        File hashPassFile = new File("info\\hashPass.txt");
        File folder = new File("info");

        try {
            if (folder.mkdir()) {
                boolean a = userNameFile.createNewFile();
                a = emailFile.createNewFile();
                a = hashPassFile.createNewFile();
            }
        }catch (IOException e){
            System.out.println("error");
        }

        new FirstPage();


    }

}