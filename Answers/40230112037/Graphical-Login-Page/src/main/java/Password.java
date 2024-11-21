import org.apache.commons.codec.digest.DigestUtils;

import java.util.regex.Pattern;

enum PasswordLevel {
    VERY_WEAK(0),
    WEAK(1),
    INTERMEDIATE(2),
    NORMAL(3),
    STRONG(4),
    VERY_STRONG(5);
    int level;

    PasswordLevel(int level) {

    }
}

public class Password {
    private String hashedPassword;

    Password() {
    }

    Password(String password) {
        hashPassword(password);
    }

    static Password passwordByHash(String hashedPassword) {
        Password password = null;
        if (validateHashedPassword(hashedPassword)) {
            password = new Password();
            password.hashedPassword = hashedPassword;
        }
        return password;
    }

    static boolean validateHashedPassword(String hashedPassword) {
        return hashedPassword.matches("^[a-fA-F0-9]{64}$");
    }

    void hashPassword(String password) {
        hashedPassword = DigestUtils.sha256Hex(password);
    }

    String getHashedPassword() {
        return hashedPassword;
    }

    boolean verifyPassword(String password) {
        return hashedPassword.equals(DigestUtils.sha256Hex(password));
    }

    static String[] passwordLevelPatterns = {"^(?=.*[a-z]).*$", "^(?=.*[A-Z]).*$", "^(?=.*[0-9]).*$", "^(?=.*[^a-zA-Z0-9]).*$", "^.{8,}$"};


    @Override
    public String toString() {
        return hashedPassword;
    }

    static int passwordLevel(String password) {
        int level = 0;
        for (String pattern : passwordLevelPatterns) {
            if (Pattern.matches(pattern, password)) level++;
        }
        return level;
    }
}