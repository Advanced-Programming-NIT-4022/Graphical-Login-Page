package org.example;
import java.io.*;

class UserStore {
    static String value2 = "";

    public UserStore(User user) {

        File file = new File("users.txt");
        try {
            boolean result = file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            FileWriter output = new FileWriter("users.txt", true);
            output.write(user.toString() + "\n");
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean userLogin(String usernameText, String passwordText) {
        String value1 = "";
        //static String value2 = "";
        String value3 = "";
        try {
            String filePath = "users.txt"; // Provide the path to your file
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                value1 = values[0];
                value2 = values[1];
                value3 = values[2];

            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(value1.equals(usernameText) && PasswordUtils.verifyPassword(passwordText))
        return true;
        else return false;    }
}