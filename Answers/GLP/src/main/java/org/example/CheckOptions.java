package org.example;
import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckOptions {

    // a function to check username

    boolean checkUserName(String UserName){
        boolean is_true = true ;

        if(Pattern.matches("[^\\s]+" , UserName)){
            is_true = true;
        }else {
            JOptionPane.showMessageDialog(null , "Wrong UserName! " , "Error" , JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //start

        try {

            File userNameFile = new File("info\\UserName.txt");
            Scanner userNameScan = new Scanner(userNameFile);
            ArrayList<String> userNameArray = new ArrayList<>();


            while ((userNameScan.hasNextLine())){
                userNameArray.add(userNameScan.nextLine());
            }
            if(userNameArray.contains(UserName)){
               is_true = false;
                JOptionPane.showMessageDialog(null , "This UserName Already Exist! " , "Error" , JOptionPane.ERROR_MESSAGE);
            }

            userNameScan.close();
            //end

            if(is_true){
                return true;
            }else {
                return false;
            }



        }catch (IOException e){
            System.out.println("error");
        }


        return is_true;
    }

    //a function to check email

    boolean CheckEmail(String email){
        boolean is_email = false;
        if(Pattern.matches("^[a-zA-Z0-9]{4,}@[a-zA-z]+\\.[a-zA-Z]+" , email)){
            is_email =  true;
        }else{
            JOptionPane.showMessageDialog(null , "Wrong Email!" , "Error" , JOptionPane.ERROR_MESSAGE);
            return false;
        }

        ArrayList<String> emailArray = new ArrayList<>();

        try{
            File emailFile = new File("info\\email.txt");
            Scanner emailScan = new Scanner(emailFile);

            while (emailScan.hasNextLine()){
                emailArray.add(emailScan.nextLine());
            }

            if(emailArray.contains(email)){
                is_email = false;
                JOptionPane.showMessageDialog(null, "This Email Already Exist! ", "Error", JOptionPane.ERROR_MESSAGE);
            }
            emailScan.close();

            if(is_email){
                return  true;
            }else {
                return false;
            }
        }catch (IOException e){
            System.out.println("error");
        }
        return is_email;
    }

    boolean CheckPass(String pass){
        boolean is_pass = false;
        if(Pattern.matches("[^\\s]+" , pass)){
            is_pass = true;
        }else {
            JOptionPane.showMessageDialog(null , "PassWord Is Weak!\nUse LowerCase And UpperCase And Number And \"@ or - or _ or .\" Together\nEnter 8 or More Character. " , "Error" , JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if(pass.length()<8){
            JOptionPane.showMessageDialog(null , "PassWord Is Weak!\nUse LowerCase And UpperCase And Number And \"@ or - or _ or .\" Together\nEnter 8 or More Character." , "Error" , JOptionPane.ERROR_MESSAGE);
            return false;
        }

        Pattern a = Pattern.compile("[a-z]");
        Matcher aa = a.matcher(pass);
        if(aa.find()){
            is_pass = true;
        }else {
            JOptionPane.showMessageDialog(null , "PassWord Is Weak!\nUse LowerCase And UpperCase And Number And \"@ or - or _ or .\" Together\nEnter 8 or More Character." , "Error" , JOptionPane.ERROR_MESSAGE);
            return false;
        }

        Pattern b = Pattern.compile("[A-Z]");
        Matcher bb = b.matcher(pass);
        if(bb.find()){
            is_pass = true;
        }else {
            JOptionPane.showMessageDialog(null , "PassWord Is Weak!\nUse LowerCase And UpperCase And Number And \"@ or - or _ or .\" Together\nEnter 8 or More Character." , "Error" , JOptionPane.ERROR_MESSAGE);
            return false;
        }

        Pattern c = Pattern.compile("[0-9]");
        Matcher cc = c.matcher(pass);
        if(cc.find()){
            is_pass = true;
        }else{
            JOptionPane.showMessageDialog(null , "PassWord Is Weak!\nUse LowerCase And UpperCase And Number And \"@ or - or _ or .\" Together\nEnter 8 or More Character." , "Error" , JOptionPane.ERROR_MESSAGE);
            return false;
        }

        Pattern d = Pattern.compile("@|-|_|\\.");
        Matcher dd = d.matcher(pass);
        if(dd.find()){
            is_pass = true;
        }else {
            JOptionPane.showMessageDialog(null , "PassWord Is Weak!\nUse LowerCase And UpperCase And Number And \"@ or - or _ or .\" Together\nEnter 8 or More Character." , "Error" , JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return is_pass;

    }

    public boolean checkLogInEmail(String email) {
        boolean isTrue = false;
        try {
            File emailFile = new File("info\\email.txt");
            Scanner logInEmailScan = new Scanner(emailFile);

            ArrayList<String> logInEmailArray = new ArrayList<>();

            while (logInEmailScan.hasNextLine()) {
                logInEmailArray.add(logInEmailScan.nextLine());
            }

            if (logInEmailArray.contains(email)) {
                isTrue =  true;
            } else {

                JOptionPane.showMessageDialog(null, "This Email Doesn\'t Exist!", "Error", JOptionPane.ERROR_MESSAGE);
                isTrue =  false;
            }

            logInEmailScan.close();

        } catch (IOException e) {
            System.out.println("error");
        }

        return isTrue;
    }

    public boolean checkLogInPass(String pass){
        boolean isTrue = false;
        try {
            File hashPassFile = new File("info\\hashPass.txt");
            Scanner passScanner = new Scanner(hashPassFile);
            ArrayList<String> passArray = new ArrayList<>();
            String hash =toHash(pass);

            while (passScanner.hasNextLine()){
                passArray.add(passScanner.nextLine());
            }

            if(passArray.contains(hash)){
                isTrue = true;
            }else {
                isTrue = false;
                JOptionPane.showMessageDialog(null , "Your Password Is Wrong!" , "Error" , JOptionPane.ERROR_MESSAGE);
            }
            passScanner.close();

        }catch (IOException e){
            System.out.println("error");
        }
        return isTrue;
    }

    public String toHash(String pass){
        return DigestUtils.sha256Hex(pass);
    }

}
