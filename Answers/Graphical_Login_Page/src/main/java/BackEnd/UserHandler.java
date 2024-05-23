// write package name :
package BackEnd;

// import needed things :

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;

// start of user handler class :
public class UserHandler implements AppMethods {
    // attributes :
    // an arrayList of users to handle them easier :
    ArrayList<User> users = new ArrayList<>();

    // constructor :
    public UserHandler() {
        checkFilesExistence();
        updateUserArrayListFromFile();
    }

    // methods :

    // this method receive information of new user and add it to the usersArrayList, then save changes in file :
    @Override
    public void registerNewUser(String userName, String hashedPassword, String email) {
        User newUser = new User(userName, hashedPassword, email);
        users.add(newUser);
        saveChangesToFile();
    }

    // this method check existence of a userName and validation of password :
    @Override
    public boolean loginUser(String userName, String hashedPassword) {
        return checkUserPassword(userName, hashedPassword);
    }

    // this method check email validation by regex :
    @Override
    public boolean checkEmailValidation(String email) {
        Pattern emailValidation = Pattern.compile("\\b^[a-zA-Z0-9.]{6,30}@[a-zA-Z0-9.]{3,5}\\.[a-z]{2,4}\\b");
        Matcher matcher = emailValidation.matcher(email);
        return matcher.find();
    }

    // this method return the complexity of password :
    @Override
    public int getPasswordComplexity(String password) {
        Pattern p1 = Pattern.compile("[a-z]+");                // contains small words?
        Matcher m1 = p1.matcher(password);
        Pattern p2 = Pattern.compile("[A-Z]+");                // contains capital words?
        Matcher m2 = p2.matcher(password);
        Pattern p3 = Pattern.compile("[0-9]+");                // contains numbers?
        Matcher m3 = p3.matcher(password);
        Pattern p4 = Pattern.compile("(@|-|_|.)");             // contains special characters?
        Matcher m4 = p4.matcher(password);
        Pattern p5 = Pattern.compile("[a-zA-z0-9@\\-_.]{8,}"); // length >= 8?
        Matcher m5 = p5.matcher(password);
        if (m5.find() && m4.find() && m3.find() && m2.find() && m1.find()) {
            return 5;
        } else if (m4.find() && m3.find() && m2.find() && m1.find()) {
            return 4;
        } else if (m3.find() && m2.find() && m1.find()) {
            return 3;
        } else if (m2.find() && m1.find()) {
            return 2;
        } else if (m1.find()) {
            return 1;
        } else {
            return 0;
        }
    }

    // this method check files existence and if files does not exist, creates files :
    @Override
    public void checkFilesExistence() {
        File userRepo = new File("UserRepo.txt");
        try {
            boolean create = userRepo.createNewFile();
        } catch (Exception ignored) {
        }
    }

    // this method save the users arrayList to the file :
    @Override
    public void saveChangesToFile() {
        try {
            FileWriter fw = new FileWriter("UserRepo.txt");
            for (User user : users) {
                fw.write(user.getUserName());
                fw.write("\n");
                fw.write(user.getHashedPassword());
                fw.write("\n");
                fw.write(user.getEmail());
                fw.write("\n");
            }
            fw.close();
        } catch (Exception ignored) {
        }
    }

    // this method read users information from file and add them to the users arraylist :
    @Override
    public void updateUserArrayListFromFile() {
        try {
            FileReader fr = new FileReader("UserRepo.txt");
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                User user = new User(sc.nextLine(), sc.nextLine(), sc.nextLine());
                users.add(user);
            }
            fr.close();
        } catch (Exception ignored) {
        }
    }

    // this method convert password to hash(SHA-256) :
    @Override
    public String passwordToHash(String password) {
        return DigestUtils.sha256Hex(password);
    }

    // this method check validation of a password :
    @Override
    public boolean checkUserPassword(String userName, String hashedPassword) {
        for (User user : users) {
            if (user.getUserName().equals(userName) && user.getHashedPassword().equals(hashedPassword)) {
                return true;
            }
        }
        return false;
    }

    // this method check existence of a userName :
    @Override
    public boolean checkUserNameExistence(String userName) {
        boolean isExist = false;
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }


}
