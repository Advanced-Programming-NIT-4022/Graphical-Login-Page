package backend;

import java.io.*;
import java.util.ArrayList;

class UserStore {

    ArrayList<User> userData = new ArrayList<>();
    void addUser(String password, String fullname, String username, String email){
        userData.add(new User(password, fullname, username, email));
    }

    void userDataInserter(){
        String data; // data = fullname,username,email,hashedPassword

        for(User iterator : userData){
            data = iterator.fullname.concat(",").concat(iterator.username).concat(",").concat(iterator.email).concat(",").concat(iterator.getPassword());

            try(BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt"))){
                writer.write(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void userDataRetivere(){
        String data;

        try(BufferedReader reader = new BufferedReader(new FileReader("users.txt"))){
            while((data = reader.readLine()) != null){
                String[] dataArray = data.split(",");
                userData.add(new User(dataArray[0],dataArray[1],dataArray[2],dataArray[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
