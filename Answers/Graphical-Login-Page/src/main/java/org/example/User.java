package org.example;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Objects;

public class User {
    static UserStore userStore = new UserStore();
    public static String HashingCode(String password) {
        String hashedPassword;
        hashedPassword = DigestUtils.sha256Hex(password);
        return hashedPassword;
    }
    public  static boolean Checker(String username , String password) {
        boolean flag = false;
        userStore.ReadFile();
        for (int i = 0; i < userStore.getUser().size(); i++)
        {
            String[] list = userStore.getUser().get(i).split(",");
            String hashpassword = HashingCode(password);
            if (Objects.equals(list[0], username) && Objects.equals(list[1], hashpassword))
            {
                flag = true;
            }
        }
        userStore.WriteFile();
        return flag;
    }
}
