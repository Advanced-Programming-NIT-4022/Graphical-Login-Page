// write package name :
package BackEnd;

// import needed things :

import java.util.ArrayList;

// start of user handler class :
public class UserHandler{
    // attributes :
    // an arrayList of users to handle them easier :
    ArrayList<User> users = new ArrayList<>();

    // constructor :
    public UserHandler() {
        new FileHandler(this.users).checkFilesExistence();
        this.users = new FileHandler(this.users).updateUserArrayListFromFile();
    }

    // methods :

    // this method receive information of new user and add it to the usersArrayList, then save changes in file :
    public void registerNewUser(String userName, String hashedPassword, String email) {
        User newUser = new User(userName, hashedPassword, email);
        users.add(newUser);
        new FileHandler(this.users).saveChangesToFile();
    }

    // this method check existence of a userName and validation of password :
    public boolean loginUser(String userName, String hashedPassword) {
        return checkUserPassword(userName, hashedPassword);
    }

    // this method check validation of a password :
    public boolean checkUserPassword(String userName, String hashedPassword) {
        for (User user : users) {
            if (user.getUserName().equals(userName) && user.getHashedPassword().equals(hashedPassword)) {
                return true;
            }
        }
        return false;
    }

    // this method check existence of a userName :
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
