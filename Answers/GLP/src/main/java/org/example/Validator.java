package org.example;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public boolean userExist(String email, String pass){
        File userID = new File("info\\UserID.txt");
        try{
            boolean isUser = false;
            int index = 1;
            Scanner IDScanner = new Scanner(userID);
            while(IDScanner.hasNextLine()){
                if(IDScanner.nextLine().equals(email)){
                    isUser = true;
                    break;
                }
                index++;
            }
            IDScanner.close();
            if(isUser){
                File userPass = new File("info\\UserPass.txt");

                int tmpIndex = 1;
                Scanner passScanner = new Scanner(userPass);
                while(passScanner.hasNextLine()){
                    String tmpPass = passScanner.nextLine();
                    if(tmpIndex==index){
                        if(pass.equals(tmpPass)){
                            isUser = true;
                        }else{
                            isUser = false;
                        }
                        break;
                    }
                }
                passScanner.close();
                if(isUser){
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null,"Password Is Wrong!",
                            "Error",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }else{
                JOptionPane.showMessageDialog(null,"There's No Account With This Email!",
                        "Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (IOException e){
            System.out.println("Error");
        }
        return false;
    }
    public boolean strongPass(String password){
        if(!(Pattern.matches("[^\\s]+",password))){
            JOptionPane.showMessageDialog(null,"Password can't contain just Space",
                    "Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        int count = 0;
        Pattern a = Pattern.compile("[a-z]|[A-Z]|[0-9]");
        Matcher aMatcher = a.matcher(password);
        if(aMatcher.find()){
            count++;
        }
        Pattern b = Pattern.compile("[a-z][A-Z]|[A-Z][a-z]");
        Matcher bMatcher = b.matcher(password);
        if(bMatcher.find()){
            count++;
            Pattern c = Pattern.compile("\\d");
            Matcher cMatcher =c.matcher(password);
            if(cMatcher.find()){
                count++;
            }
        }
        Pattern d = Pattern.compile("(@|-|_|\\.)");
        Matcher dMatcher = d.matcher(password);
        if(dMatcher.find()){
            count++;
        }
        if(password.length()>8){
            count++;
        }
        if(count<4){
            JOptionPane.showMessageDialog(null,"Password Is Week",
                    "Error",JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null,"use special char or number or lower and uper case or longer password",
                    "Error",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }else{
            return true;
        }
    }
    public boolean isID(String id){
        if(id.contains(" ")){
            JOptionPane.showMessageDialog(null,"Email Shoud Not Contains Space!","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        boolean bool = false;
        File userID = new File("info\\UserID.txt");
        try {
            Scanner IDScanner = new Scanner(userID);
            while(IDScanner.hasNextLine()){
                if(id.equals(IDScanner.nextLine())){
                    bool = true;
                    break;
                }
            }
            IDScanner.close();
        }catch (IOException e){
            System.out.println("Error");
        }
        if(bool){
            JOptionPane.showMessageDialog(null, "This ID Has Already Exist!","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            return true;
        }
    }
    public boolean isEmail(String email){
        if(email.contains(" ")){
            JOptionPane.showMessageDialog(null,"Email Shoud Not Contains Space!","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        boolean bool = false;
        if(!(Pattern.matches("^[a-zA-Z0-9]{4,}@[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$",email))){
            JOptionPane.showMessageDialog(null,"The Email Format Is Wrong!","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        File userEmail = new File("info\\UserEmail.txt");
        try {
            Scanner emailScanner = new Scanner(userEmail);
            while(emailScanner.hasNextLine()){
                if(email.equals(emailScanner.nextLine())){
                    bool = true;
                    break;
                }
            }
            emailScanner.close();
        }catch (IOException e){
            System.out.println("Error");
        }
        if(bool){
            JOptionPane.showMessageDialog(null, "This Email Has Already An Account","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            return true;
        }
    }
}
