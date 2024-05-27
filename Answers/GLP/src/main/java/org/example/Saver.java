package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.codec.digest.DigestUtils;

public class Saver {
    Saver(String email,String id, String pass){
        File userEmail = new File("info\\UserEmail.txt");
        File userID = new File("info\\UserID.txt");
        File userPass = new File("info\\UserPass.txt");
        try{
            FileWriter emailWriter = new FileWriter(userEmail, true);
            emailWriter.append(email + '\n');
            emailWriter.close();

            FileWriter IDWriter = new FileWriter(userID, true);
            IDWriter.append(id + '\n');
            IDWriter.close();

            FileWriter passWriter = new FileWriter(userPass, true);
            passWriter.append(toHash(pass) + '\n');
            passWriter.close();

        }catch (IOException e){
            System.out.println("Error");
        }
    }
    static String toHash(String pass){
        return DigestUtils.sha256Hex(pass);
    }
}
