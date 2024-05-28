package org.example;


import java.util.ArrayList;

public class User {
    String userName, password, email;
    ArrayList<User> userInfo = new ArrayList<>();
    FileHandler fhObj = new FileHandler(userInfo);

    User(String userName, String password, String email){
        this.password = password;
        this.userName = userName;
        this.email = email;
        fhObj.filemaker();
        fhObj.fileupdater();

    }

    void adduser(){
            userInfo.add(new User(userName, password, email));
            fhObj.filewriter();
    }

    boolean passAuth() {

        for (User user : userInfo) {
            if (getUserName().equals(userName) && getPassword().equals(password))
                return true;
        }
        return false;
    }

    boolean usernameAuth() {
        for (User user : userInfo) {
            if (getUserName().equals(userName)) {
            return true;
            }
        }
        return false;
    }



    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
